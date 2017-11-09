package com.accenture.subcontractor.job.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * 静态资源启动类，加载首页设置可以加载的页面.此处设置加载移动应用和电脑客户端应用的接口
 * @ClassName: DefaultView   
 * @Description: 首页index通过此也加载 
 * @author: kangjin.zhao  
 * @date:2017年8月13日 下午10:03:29
 */
@Configuration
public class DefaultView extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController( "/" ).setViewName( "forward:/" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        super.addViewControllers( registry );
    } 
}