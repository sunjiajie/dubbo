package org.apache.dubbo.demo.spi;

import org.apache.dubbo.common.extension.Adaptive;

//@Adaptive
public class HttpProtocol implements IProtocol{

    @Override
    public void sendRequest(String message) {
        System.out.println("http protocol, msg: " + message);
    }
}
