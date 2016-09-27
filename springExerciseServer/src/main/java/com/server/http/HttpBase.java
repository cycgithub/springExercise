package com.server.http;


import com.domain.http.HttpResponse;

/**
 * http服务端
 * @author zhanghao
 * @date 2016/7/21.
 */
public interface HttpBase<T>{

    /**
     * 接受http请求
     * @param object
     * @return
     */
    HttpResponse accept(T object);
}
