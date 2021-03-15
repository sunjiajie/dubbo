package com.alibaba.dubbo.rpc.sjj;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;

/**
 * @author sunjiajie
 * @date 2021/3/12
 */
public class SjjProtocol  implements Protocol {

    private DubboProtocol dubboProtocol;

    public void setDubboProtocol(DubboProtocol dubboProtocol) {
        this.dubboProtocol = dubboProtocol;
    }

    @Override
    public int getDefaultPort() {
        return 333;
    }

    @Override
    public <T> Exporter<T> export(Invoker<T> invoker) throws RpcException {
        return null;
    }

    @Override
    public <T> Invoker<T> refer(Class<T> type, URL url) throws RpcException {
        return null;
    }

    @Override
    public void destroy() {

    }
}
