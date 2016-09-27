package com.domain.http;

import org.springframework.stereotype.Component;

/**
 * @author zhanghao
 * @date 2016/7/20.
 */

@Component
public class TransformerRequest {

    public HttpRequest trans(HttpRequest request){
    //,String productCode,String business,String process){
    //    request.setProductCode(productCode);
    //    request.setBusiness(business);
    //    request.setProcess(process);
        return request;
    }
}
