package com.abin.lee.thrift.service.test;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TMemoryBuffer;
import org.junit.Test;

/**
 * Created by abin
 * Be Created in 2016/8/26.
 * thrift序列化
 */
public class ThriftSerialTest {

    @Test
    public  void testThriftSerial() throws TException {
        // 内存级缓冲，默认32长度，自动增加
        TMemoryBuffer mb0 = new TMemoryBuffer(32);
        TProtocol prot0 = new org.apache.thrift.protocol.TCompactProtocol(mb0);

        TMemoryBuffer mb1 = new TMemoryBuffer(32);
        TProtocol prot1 = new org.apache.thrift.protocol.TBinaryProtocol(mb1);

        TMemoryBuffer mb2 = new TMemoryBuffer(32);
        TProtocol prot2 = new org.apache.thrift.protocol.TJSONProtocol(mb2);

//// 传输消息对象
//        Book msg = new Book();
//        msg.setName("abcdefghjklfadfadfadfadloiue");
//        msg.setId(111);
//// 序列化处理
//        msg.write(prot0);
//        msg.write(prot1);
//        msg.write(prot2);
//        System.out.println("序列化长度Compact：" + mb0.length());
//        System.out.println("序列化长度Binary：" + mb1.length());
//        System.out.println("序列化长度JSON：" + mb2.length());
//// 反序列化处理
//        byte[] data = mb1.getArray(); // 接收的字节
//        Book msg1 = new Book();
//        TMemoryBuffer tmb = new TMemoryBuffer(32);
//        tmb.write(data);
//        TProtocol tp = new org.apache.thrift.protocol.TBinaryProtocol(tmb);
//        msg1.read(tp);
//        System.out.println(msg1.getName());
    }
}
