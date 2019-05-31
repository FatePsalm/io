package main.java.test;
/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年4月2日 下午5:00:20
* 类说明
* 转换流
*/

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestOtherStream {
	@Test
	public void test1() throws IOException {
		File in = new File("TestFile/1.txt");
		File out = new File("TestFile/4.txt");
		FileInputStream fis = new FileInputStream(in);
		FileWriter fw = new FileWriter(out);
		InputStreamReader isr = new InputStreamReader(fis, "GBK");
		BufferedReader bufferedReader = new BufferedReader(isr);
		BufferedWriter bfw = new BufferedWriter(fw);
		String str;
		while ((str = bufferedReader.readLine()) != null) {
			bfw.write(str);
			bfw.newLine();
			bfw.flush();
		}
		bfw.close();
		bufferedReader.close();
	}
}
