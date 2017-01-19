package com.lpxiang.hbr;

import java.io.*;

/**
 * Created by percy on 2016/12/25.
 */
public class TestReadFile {

    public static String path = "/Users/percy/Desktop/1.txt";

    public static void test1() {
        try {


            //"./data/healthy/healthy/2.txt"
            FileInputStream in = new FileInputStream(new File(path));
            //DataInputStream input = new DataInputStream(new BufferedInputStream(in));
            BufferedInputStream input = new BufferedInputStream(in);
            byte []a = new byte[100];
            int count = -1, i = 0;

//            while (i++ < 10) {
//                System.out.println(input.readDouble());
//            }

            while ( (count = input.read()) != -1 && i++ < 100) {
                System.out.println((byte)count);
            }
            input.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeTest() {
        try {
            FileOutputStream out = new FileOutputStream("/Users/percy/Desktop/out.bin");
            String s = "1234";
            byte []b = s.getBytes();
            out.write(b, 0, b.length);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void test2() {
        int buffersize = 100;
        int offset = 0;

        byte[] fileData = new byte[buffersize];

        FileInputStream in = null;
        try {
            in = new FileInputStream(new File(path));
            BufferedInputStream buffer = new BufferedInputStream(in);

            int numBytesRead, m = 0;
            String str;
            while((numBytesRead = buffer.read(fileData,0,buffersize)) != -1 && m++ < 10)
            {
                //str = getBinary(fileData);//Adjust this so it can work with a whole array of bytes at once
                //System.out.println(Integer.valueOf(str, 2));

                ByteArrayOutputStream os = new ByteArrayOutputStream(numBytesRead);
                os.write(fileData, 0, numBytesRead);
                byte [] t = os.toByteArray();
                System.out.println(t);

                offset += numBytesRead;
            }


//            ObjectInputStream objInput = new ObjectInputStream(in);
//            int i = 10;
//            while (i-- > 0) {
//                System.out.println(objInput.readDouble());
//            }


            buffer.close();
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String getBinary(byte []arr) {
        String t = null;
        for (int i = 0; i < arr.length; ++i) {
            t = "";
            t += String.format("%8s", Integer.toBinaryString(arr[i] & 0xFF)).replace(' ', '0');

        }
        return t;
    }

    public static void testDataInput() {
        FileInputStream in = null;
        try {
            in = new FileInputStream(new File(path));
            DataInputStream ds = new DataInputStream(in);
            int i=10;
            while (i-- > 0) {
                System.out.println(ds.readDouble());
            }

            ds.close();
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void testBytes() {
        FileInputStream in = null;
        try {
            in = new FileInputStream(new File(path));
            int i = 10, rc;
            byte []temp = new byte[100];
            while (i-- > 0) {
                rc = in.read(temp, 0, 100);

            }


            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String args[]) {
        //writeTest();
        //test2();
        //testDataInput();
        testBytes();
    }


}
