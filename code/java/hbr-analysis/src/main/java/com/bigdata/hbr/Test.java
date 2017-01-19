package com.bigdata.hbr;




import java.io.IOException;

/**
 * Created by percy on 2017/1/5.
 */
public class Test {

    public static Integer num = 0;

    public static void main(String[] args) throws IOException {
//        Configuration conf = HBaseConfiguration.create();
//        conf.set("hbase.zookeeper.quorum", "192.168.128.128");
//        HBaseAdmin admin = new HBaseAdmin(conf);
//        HTableDescriptor tableDescriptor = admin.getTableDescriptor(Bytes.toBytes("database"));
//        byte[] name = tableDescriptor.getName();
//        System.out.println(new String(name));
//        HColumnDescriptor[] columnFamilies = tableDescriptor.getColumnFamilies();
//        for (HColumnDescriptor d : columnFamilies) {
//            System.out.println(d.getNameAsString());
//        }

//        int n = 3;
//        while (n-- > 0) {
//            new Thread(new ProcessDemo()).start();
//        }

        System.out.println("------over!-----");
    }
}


class ProcessDemo implements Runnable {

    @Override
    public void run() {
        while (true) {

            synchronized (ProcessDemo.class) {
                System.out.println(Test.num++);
            }

            //System.out.println(Test.num++);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}