package com.example.demo.protoc;

import com.google.protobuf.InvalidProtocolBufferException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ProtobufDemo {
    public static void main(String[] args) throws InvalidProtocolBufferException {

    }

    /**
     * 这种方式类似于普通java对象的序列化，
     * 适用于很多将Protobuf的POJO序列化到内存或者外层的应用场景
     * @throws InvalidProtocolBufferException
     */
    public static void type() throws InvalidProtocolBufferException {
        MsgProtos.Msg.Builder builder = MsgProtos.Msg.newBuilder();
        builder.setAge(100);
        builder.setContent("qqqq");
        MsgProtos.Msg msg = builder.build();
        byte[] data = msg.toByteArray();
        MsgProtos.Msg message = MsgProtos.Msg.parseFrom(data);

    }

    /**
     * 这种方式在阻塞式的二进制码流传输应用场景中是没有问题的，
     * 可以讲二进制码流写入阻塞式的java oio套接字或者输出到文件。
     * 但是，这种方式在异步操作的NIO应用场景中，存在粘包/半包的问题。
     * @throws IOException
     */
    public static void type2() throws IOException {
        MsgProtos.Msg.Builder builder = MsgProtos.Msg.newBuilder();
        builder.setAge(100);
        builder.setContent("qqqq");
        MsgProtos.Msg msg = builder.build();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        msg.writeTo(out);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        MsgProtos.Msg msg1 = MsgProtos.Msg.parseFrom(in);
    }

    /**
     * 这种方式可以用与异步操作的NIO应用场景中，
     * 解决了粘包/半包的问题。
     * @throws IOException
     */
    public static void type3() throws IOException {
        MsgProtos.Msg.Builder builder = MsgProtos.Msg.newBuilder();
        builder.setAge(100);
        builder.setContent("qqqqqq");
        MsgProtos.Msg msg = builder.build();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        msg.writeDelimitedTo(out);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        MsgProtos.Msg msg1 = MsgProtos.Msg.parseDelimitedFrom(in);


    }


}
