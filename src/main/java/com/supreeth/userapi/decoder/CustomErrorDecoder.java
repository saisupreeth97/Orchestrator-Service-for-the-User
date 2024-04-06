package com.supreeth.userapi.decoder;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

public class CustomErrorDecoder implements ErrorDecoder {

    private static final String CLIENT_ERROR = "SRV_CLIENT_SERVER_DOWN";
    private static final String SERVER_ERROR = "SRV_ERROR_SERVER_DOWN";

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() >= 400 && response.status() <= 499) {
            log.info("----------------- {} , {} , {}", methodKey, response.status(), response.reason());
            throw new HttpClientErrorException(HttpStatus.resolve(response.status()),CLIENT_ERROR);
        }
        if (response.status() >= 500 && response.status() <= 599) {
            log.info("----------------- {} , {} , {}", methodKey, response.status(), response.reason());
            throw new HttpServerErrorException(HttpStatus.resolve(response.status()),SERVER_ERROR);
        }
        return defaultErrorDecoder.decode(methodKey,response);
    }
}
