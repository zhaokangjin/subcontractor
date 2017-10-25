package com.accenture.subcontractor.job.common.util.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: FileUtil
 * @Description: TODO
 * @author: kangjin.zhao
 * @date:2017年9月2日 下午4:58:38
 */
public class FileUtil {
	private final static Logger logger = LoggerFactory.getLogger(FileUtil.class);
	private final static String SEPARATOR = File.separator;

	// 给文件加密
	public static String fileMD5(String inputFile) throws IOException {
		// 缓冲区大小（这个可以抽出一个参数）
		int bufferSize = 256 * 1024;
		FileInputStream fileInputStream = null;
		DigestInputStream digestInputStream = null;
		try {
			// 拿到一个MD5转换器（同样，这里可以换成SHA1）
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			// 使用DigestInputStream
			fileInputStream = new FileInputStream(inputFile);
			digestInputStream = new DigestInputStream(fileInputStream, messageDigest);
			// read的过程中进行MD5处理，直到读完文件
			byte[] buffer = new byte[bufferSize];
			while (digestInputStream.read(buffer) > 0)
				;
			// 获取最终的MessageDigest
			messageDigest = digestInputStream.getMessageDigest();
			// 拿到结果，也是字节数组，包含16个元素
			byte[] resultByteArray = messageDigest.digest();
			// 同样，把字节数组转换成字符串
			return byteArrayToHex(resultByteArray);
		} catch (NoSuchAlgorithmException e) {
			return null;
		} finally {
			try {
				digestInputStream.close();
			} catch (Exception e) {
				throw e;
			}
			try {
				fileInputStream.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
	// 下面这个函数用于将字节数组换成成16进制的字符串

	public static String byteArrayToHex(byte[] byteArray) {
		// 首先初始化一个字符数组，用来存放每个16进制字符
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		// new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
		char[] resultCharArray = new char[byteArray.length * 2];
		// 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
		int index = 0;
		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
			resultCharArray[index++] = hexDigits[b & 0xf];
		}
		// 字符数组组合成字符串返回
		return new String(resultCharArray);
	}

	/**
	 * @Title: getExtensionName
	 * @Description: TODO
	 * @param filename
	 * @return
	 */
	public static String getExtensionName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	}

	/**
	 * @Title: getFileNameNoEx
	 * @Description: TODO
	 * @param filename
	 * @return
	 */
	public static String getFileNameNoEx(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length()))) {
				return filename.substring(0, dot);
			}
		}
		return filename;
	}

	public static boolean createFile(String destFileName) {
		File file = new File(destFileName);
		if (file.exists()) {
			logger.info("FileUtil>>>createFile>>>创建单个文件" + destFileName + "失败，目标文件已存在！");
			return false;
		}
		if (destFileName.endsWith(File.separator)) {
			logger.info("FileUtil>>>createFile>>>创建单个文件" + destFileName + "失败，目标文件不能为目录！");
			return false;
		}
		// 判断目标文件所在的目录是否存在
		if (!file.getParentFile().exists()) {
			// 如果目标文件所在的目录不存在，则创建父目录
			System.out.println("目标文件所在目录不存在，准备创建它！");
			if (!file.getParentFile().mkdirs()) {
				logger.info("FileUtil>>>createFile>>>创建目标文件所在目录失败！");
				return false;
			}
		}
		// 创建目标文件
		try {
			if (file.createNewFile()) {
				logger.info("FileUtil>>>createFile>>>创建单个文件" + destFileName + "成功！");
				return true;
			} else {
				logger.info("FileUtil>>>createFile>>>创建单个文件" + destFileName + "失败！");
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("FileUtil>>>createFile>>>error创建单个文件" + destFileName + "失败！" + e.getMessage());
			return false;
		}
	}

	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {
			logger.info("FileUtil>>>createDir>>>创建目录" + destDirName + "失败，目标目录已经存在");
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		// 创建目录
		try {
			dir.mkdirs();
			logger.info("FileUtil>>>createDir>>>创建目录" + destDirName + "成功！");
			return true;
		} catch (Exception e) {
			logger.info("FileUtil>>>createDir>>>error:" + e );
			throw e;
		}
	}

	public static String createTempFile(String prefix, String suffix, String dirName) {
		File tempFile = null;
		if (dirName == null) {
			try {
				// 在默认文件夹下创建临时文件
				tempFile = File.createTempFile(prefix, suffix);
				// 返回临时文件的路径
				return tempFile.getCanonicalPath();
			} catch (IOException e) {
				e.printStackTrace();
				logger.info("FileUtil>>>createTempFile>>>创建临时文件失败！" + e.getMessage());
				return null;
			}
		} else {
			File dir = new File(dirName);
			// 如果临时文件所在目录不存在，首先创建
			if (!dir.exists()) {
				if (!FileUtil.createDir(dirName)) {
					logger.info("FileUtil>>>createTempFile>>>创建临时文件失败，不能创建临时文件所在的目录！");
					return null;
				}
			}
			try {
				// 在指定目录下创建临时文件
				tempFile = File.createTempFile(prefix, suffix, dir);
				return tempFile.getCanonicalPath();
			} catch (IOException e) {
				e.printStackTrace();
				logger.info("FileUtil>>>createTempFile>>>创建临时文件失败！" + e.getMessage());
				return null;
			}
		}
	}
	/**
	 * 相对应用程序的根路径的平级路径
	 * @Title: systemRelativePath   
	 * @Description: TODO  
	 * @return path
	 */
	public static String getAbsolutelyPath(String fileDir){
		String userDir=System.getProperty("user.dir");
		int fileLastSep=userDir.lastIndexOf(SEPARATOR);
		if(fileLastSep>0){
			userDir=userDir.substring(0, fileLastSep);
		}
		return userDir+SEPARATOR+  fileDir;
	}
}
