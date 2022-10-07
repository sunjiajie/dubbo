package org.apache.dubbo.demo;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.demo.spi.IProtocol;

public class SpiMain {
    public static void main(String[] args) {
        ExtensionLoader<IProtocol> extensionLoader = ExtensionLoader.getExtensionLoader(IProtocol.class);
//        IProtocol tcp = extensionLoader.getExtension("tcp");
//        tcp.sendRequest("tcp test");

//        IProtocol http = extensionLoader.getExtension("http");
//        http.sendRequest("http test");


        IProtocol adaptiveExtension = extensionLoader.getAdaptiveExtension();
        adaptiveExtension.sendRequest("ad");
    }
}
