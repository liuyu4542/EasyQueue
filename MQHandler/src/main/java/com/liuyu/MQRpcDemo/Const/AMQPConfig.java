package com.liuyu.MQRpcDemo.Const;
//rabbitMq登陆配置
public class AMQPConfig {
   //队列名称
   public static final String QUEUE_NAME="hello.world.queue";
   public static final String EXCHANGE_NAME="hello.world.queue";
   public static final String HOST="10.160.29.7";
   public static final int PORT=5672;
   public static final String USER_NAME="liuyu";
   public static final String PASSWD="33@6a+";
   //打开应答 false ,关闭 true
   public static final boolean ACK=false;
   //公平转发
   public static final int PREFETCHCount=1;
   //队列持久化
   public static final boolean PERSISTENT=true;
}
