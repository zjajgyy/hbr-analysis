package com.lpxiang.hbr;



import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtil {

	public static int[] readFile(String fileName, String dirname) {

		String path = dirname+ "/" + fileName;
		File file = new File(path);

		if (file.exists()) {

			try {
				FileInputStream in = new FileInputStream(file);
				DataInputStream dis = new DataInputStream(in);
				ArrayList<Integer> data = new ArrayList<Integer>();
				int dataNum = 0;
				int tmp1, tmp2;
				while (dis.available() > 1 &&
						(tmp1 = dis.readUnsignedByte()) >= 0 &&
						(tmp2 = dis.readUnsignedByte()) >= 0) {
					if (dataNum < 60 * 250 * 60 * 24) {
						data.add(tmp2 * 256 + tmp1);
					}
					dataNum++;
				}
				
				// 检测时间
				double time = dataNum / (250+0.0) / (3600 + 0.0);
				//System.out.println(time);
				//BufferedWriter writer = new BufferedWriter(new FileWriter(new File(dirname + "/analysic_test.txt")));
				//writer.write(new DecimalFormat("#####0.00").format(time) + "\n");
				//writer.flush();
				//writer.close();
				
				int[] dataoutput = new int[data.size()];
				int count = 0;
				for (int i : data) {
					dataoutput[count++] = i;
				}
				dis.close();
				return dataoutput;

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// close
			}
		} else {
			System.out.println("File not exist, path: " + path);
		}
		return null;
	}

	public static boolean createDir(String path){
		File folder = new File(path);
		return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
	}
	
	public static void main(String[] argv) {

//		Scanner input = new Scanner(System.in);
//		System.out.println("请输入存放用户测量数据的文件夹路径:");
//		String path = input.next();
//
//		File directory = new File(path);
//		File[] files = directory.listFiles();
//		ArrayList<File> datas = new ArrayList<File>();
//		for(int i = 0; i < files.length; i++){
//			if(!files[i].isDirectory()){
//				datas.add(files[i]);
//			}
//		}
//
//		// 输出文件
//		for (int i = 0; i < datas.size(); i++)
//			System.out.println((i + 1) + " : " + datas.get(i));
//
//		System.out.println("0 : 分析全部数据文件");
//		System.out.println("输入编号，选择分析的文件：");
//		int index = input.nextInt();
		
		// 在该目录下直接生成对应的同名文件夹
//		try {
//			if (index == 0) {
//				// 分析全部
//				for (int i = 0; i < datas.size(); i++) {
//					String p = datas.get(i).toString();
//					DoMain.main(p);
//				}
//
//			} else {
//				String p = datas.get(index-1).toString();
//				DoMain.main(p);
//			}
//		} finally {
//		}

		readFile("t2.bin", "/Users/percy/Desktop/ttt");


	}
}