package com.basic.thrift.service;

import com.basic.thrift.beans.Hello;
import org.apache.thrift.TException;

public class HelloServiceImpl implements Hello.Iface {
    @Override
    public String helloString(String para) throws TException {
        return para;
    }

    @Override
    public int helloInt(int para) throws TException {
        return para;
    }

    @Override
    public boolean helloBoolean(boolean para) throws TException {
        return para;
    }

    @Override
    public void helloVoid() throws TException {
        System.out.println("Hello World");
    }

    @Override
    public String helloNull() throws TException {
        return null;
    }
}
