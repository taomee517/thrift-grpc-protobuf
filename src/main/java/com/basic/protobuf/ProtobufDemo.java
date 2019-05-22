package com.basic.protobuf;

import com.basic.protobuf.beans.AddressBookProto;
import com.basic.protobuf.beans.SubscribeReqProto;

/**
 * Protobuf案例
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\12 0012 19:14
 */
public class ProtobufDemo {
    public static void main(String[] args) throws Exception{

        AddressBookProto.Person tao = AddressBookProto.Person.newBuilder()
                                    .setId(8001)
                                    .setEmail("taomee517@qq.com")
                                    .setName("tao")
                                    .build();
        byte[] personBytes = tao.toByteArray();
        AddressBookProto.Person personBean = AddressBookProto.Person.parseFrom(personBytes);
        System.out.println(personBean.getName());
        System.out.println(personBean.getEmail());

        SubscribeReqProto.SubscribeReq req = SubscribeReqProto.SubscribeReq.newBuilder()
                .setSubReqId(100)
                .setUserName("Jony-J")
                .setProductName("hip-pop")
                .build();
        byte[] reqBytes = req.toByteArray();
        SubscribeReqProto.SubscribeReq serverReqEntity = SubscribeReqProto.SubscribeReq.parseFrom(reqBytes);
        System.out.println(serverReqEntity.getProductName());
    }
}
