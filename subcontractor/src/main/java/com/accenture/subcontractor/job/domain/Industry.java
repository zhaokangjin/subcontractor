package com.accenture.subcontractor.job.domain;

public class Industry {
    // 行业ID >>>表字段 : TRADE_ID
    private String tradeId;

    // 父行业 >>>表字段 : PARENT_TRADE
    private String parentTrade;

    // 行业名称 >>>表字段 : TRADE_NAME
    private String tradeName;

    // 行业首字母 >>>表字段 : TRADE_FIRST_LETTER
    private String tradeFirstLetter;

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getParentTrade() {
        return parentTrade;
    }

    public void setParentTrade(String parentTrade) {
        this.parentTrade = parentTrade;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getTradeFirstLetter() {
        return tradeFirstLetter;
    }

    public void setTradeFirstLetter(String tradeFirstLetter) {
        this.tradeFirstLetter = tradeFirstLetter;
    }
}