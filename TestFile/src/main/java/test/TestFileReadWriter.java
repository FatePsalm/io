package main.java.test;
/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年4月2日 下午4:01:56
* 类说明
*/

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TestFileReadWriter {
	//实现文本文件的复制
	@Test
	public void  TestFileReadWriter() throws IOException {
		File in = new File("1.txt");
		File out = new File("2.txt");
		FileReader fileReader = new FileReader(in); 
		FileWriter fileWriter = new FileWriter(out); 
		char[] c=new char[24];
		int len;
		while ((len=fileReader.read(c))!=-1) {
			fileWriter.write(c, 0, len);
		}
		fileWriter .close();
		fileReader.close();
	}
	@Test
	public void testFileReader() throws IOException {
		File file = new File("1.txt");
		FileReader fr=new FileReader(file);
		char[] c=new char[24];
		int len;
		while ((len=fr.read(c))!=-1) {
		String str=new String(c, 0, len);
		System.out.print(str);
			
		}
	}
}
