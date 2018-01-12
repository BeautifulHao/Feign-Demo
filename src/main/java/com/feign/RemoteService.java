package com.feign;

import feign.Headers;
import feign.RequestLine;

public interface RemoteService {

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @RequestLine("POST /user")
    User getUser();

}
