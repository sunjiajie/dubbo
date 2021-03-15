package com.alibaba.dubbo.rpc.sjj;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;

/**
 * @author sunjiajie
 * @date 2021/3/12
 */
public class ExtensionLoaderTest {
    public static void main(String[] args) throws InterruptedException {
        ExtensionLoader<Protocol> extensionLoader = ExtensionLoader.getExtensionLoader(Protocol.class);
        //Protocol sjjProtocol = extensionLoader.getExtension("sjjProtocol");
        //System.out.println("extension: " + sjjProtocol + ", " + sjjProtocol.getDefaultPort());
        Protocol adaptiveExtension = extensionLoader.getAdaptiveExtension();
        System.out.println(adaptiveExtension.getDefaultPort());
    }
}
