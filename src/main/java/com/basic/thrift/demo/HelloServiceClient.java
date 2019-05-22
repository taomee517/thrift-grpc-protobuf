package com.basic.thrift.demo;

import com.basic.thrift.beans.Hello;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class HelloServiceClient {
    public static void main(String[] args) {
        try {
            String ip = "127.0.0.1";
            int port = 7911;
            TTransport transport = new TSocket(ip,port);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);
            client.helloVoid();

            String resp = client.helloString("你好！");
            System.out.println("服务器回复：" + resp);
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        }catch (TException ex){
            ex.printStackTrace();
        }
    }
}
