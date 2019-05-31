package main.java.test;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年4月2日 下午2:38:29
* 类说明
* 1.流的分类
* 按照数据流向的不同:输入流\输出流
* 按照处理数据的单位的不同:字节流\字符流(处理的文本文件)
* 按照角色的不同,节点流 (直接作用于文件的)处理流
* 1.IO体系
* 抽象基类                字节流(文件流)
* Inputstream            FileInputStream
* OutputStream         FileOutputStream
* reader                    FileReader
* Writer                    FileWriter
*/
public class TestFileInputOutputstream {
	//输出流
	@Test
	public void testFileOutputsream() throws IOException {
		File file = new File("hello.txt"); 
		FileOutputStream fileOutputStream=new FileOutputStream(file);
		fileOutputStream.write(new String("I Love Your").getBytes());
		fileOutputStream.close();
	}
	@Test
	public void testFileInputsream2() throws IOException {
		//1.创建一个File类的对象
		File file=new File("hello.txt");
		//2.创建一个FileInputStream类的对象
		FileInputStream fiStream=new FileInputStream(file);
		//3.调用FileInputStream的方法,实现file文件的读取
		byte[] b=new byte[5];
		int len;
		while ((len=fiStream.read(b))!=-1) {
			String string = new String(b, 0, len);
			System.out.println(string);
			for(int i=0;i<len;i++) {
				System.out.println((char)b[i]);
			}
		}
		//4.关闭响应的流
		fiStream.close();
	}
	//从硬盘存在的一个文件中,读取其内容到程序中
	//要读取的文件一定要存在否则抛FileNotFoundException
	@Test
	public void testFileInputsream() throws IOException {
		//1.创建一个File类的对象
		File file=new File("hello.txt");
		//2.创建一个FileInputStream类的对象
		FileInputStream fiStream=new FileInputStream(file);
		//3.调用FileInputStream的方法,实现file文件的读取
		int b=fiStream.read();
		while (b!=-1) {
			System.out.println(b);
			b=fiStream.read();
		}
		//4.关闭响应的流
		fiStream.close();
	}
}
