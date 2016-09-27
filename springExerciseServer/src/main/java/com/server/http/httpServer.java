package com.server.http;


import com.domain.http.HttpResponse;
import org.springframework.stereotype.Service;

/**
 * Created by chenyuchao on 2016/9/24.
 */
@Service("httpServer")
public class HttpServer implements HttpBase<String>{

    @Override
    public HttpResponse accept(String request){

        System.out.println("接收到的信息："+request);
        HttpResponse response = new HttpResponse();
        return response;
    }
}
