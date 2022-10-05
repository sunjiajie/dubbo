package org.apache.dubbo.demo.spi;

public class HttpProtocol implements IProtocol{
    @Override
    public void sendRequest(String message) {
        System.out.println("http protocol, msg: " + message);
    }
}
