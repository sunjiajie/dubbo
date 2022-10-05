package org.apache.dubbo.demo.spi;

public class TcpProtocol implements IProtocol{
    @Override
    public void sendRequest(String message) {
        System.out.println("tcp protocol, msg: " + message);
    }
}
