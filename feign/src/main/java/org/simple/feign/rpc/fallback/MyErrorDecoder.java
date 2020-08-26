package org.simple.feign.rpc.fallback;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.simple.feign.rpc.exception.MyFeignException;

public class MyErrorDecoder implements ErrorDecoder{
    @Override
    public Exception decode(String methodKey, Response response) {
        return new MyFeignException(methodKey,response);
    }
}
