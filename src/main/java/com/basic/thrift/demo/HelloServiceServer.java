package com.basic.thrift.demo;

import com.basic.thrift.beans.Hello;
import com.basic.thrift.service.HelloServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author taomee
 */

public class HelloServiceServer {
    public static Logger log = LoggerFactory.getLogger(HelloServiceServer.class);
    public static void main(String[] args) {
        try {
            int port = 7911;
            TServerSocket serverTransport = new TServerSocket(7911);
            //设置协议工厂为 TBinaryProtocol.Factory
            TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();
            // 关联处理器与 Hello 服务的实现
            Hello.Processor processor = new Hello.Processor(new HelloServiceImpl());
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor).protocolFactory(factory));
            log.info("Server start on port 7911...");
            server.serve();
        } catch (TTransportException e) {
            log.error(e.getMessage());
        }
    }
}
