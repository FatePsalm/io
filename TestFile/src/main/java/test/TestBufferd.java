package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年4月2日 下午4:22:40 类说明
 */
public class TestBufferd {
	// 使用bufferdInputstream
	@Test
	public void testBufferdInputStream() throws IOException {
		//1.提供读取写入文件
		File file=new File("1.txt");
		File file2=new File("3.txt");
		//2.先创建节点流
		FileInputStream fis=new FileInputStream(file);
		FileOutputStream fos=new FileOutputStream(file2,true);
		//3.传送给缓冲流
		BufferedInputStream bis=new BufferedInputStream(fis);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		//4.具体的复制
		byte[] b=new byte[1024];
		int len;
		while ((len=bis.read(b))!=-1) {
				bos.write(b,0,len);
				bos.flush();//保险起见
		}
		//关闭高级流就可以关闭低级流
		bos.close();
		bis.close();
	}
}
