package com.core;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * Created by chenyuchao on 2016/9/29.
 */
public class ResponseErrorChannel implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
//        LOGGER.info("异常状态：{}",response.getStatusCode().value());
        System.out.println("异常："+response.getStatusCode().value());
        // LOGGER.info("异常信息：{}",response.getBody());
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        System.out.println("异常："+response.getStatusCode().value());
//        LOGGER.info("异常状态：{}",response.getStatusCode().value());
        //  LOGGER.info("异常信息：{}",response.getBody());
    }
}
