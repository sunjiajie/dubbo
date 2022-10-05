package org.apache.dubbo.demo.spi;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface IProtocol {
    void sendRequest(String message);
}
