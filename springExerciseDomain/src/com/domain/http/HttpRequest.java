package com.domain.http;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * http请求domain
 * @author zhanghao
 * @date 2016/7/20.
 */
public class HttpRequest {

    /**
     * 加密秘钥
     */
    private String token;

    /**
     * 加密后数据
     */
    private String data;

    /**
     * 解密token后的json串
     */
    @JsonIgnore
    private String dataJson;
    /**
     * 产品编码
     */
    @JsonIgnore
    private String productCode;

    /**
     * 业务
     */
    @JsonIgnore
    private String business;

    /**
     * 处理器
     */
    @JsonIgnore
    private String process;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDataJson() {
        return dataJson;
    }

    public void setDataJson(String dataJson) {
        this.dataJson = dataJson;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}
