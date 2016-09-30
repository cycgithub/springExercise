package com.domain.http;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * @author zhanghao
 * @date 2016/8/2.
 */
public class ClientWrapperTransformer {

//    private static final Logger LOGGER = LoggerFactory.getLogger(ClientWrapperTransformer.class);

    public HttpRequest transfer(String body) {
            HttpRequest request = new HttpRequest();
            request.setData(body);
            return request;
    }
}
