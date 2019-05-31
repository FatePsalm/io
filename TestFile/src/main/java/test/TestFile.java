package main.java.test;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;


/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年4月2日 上午11:21:17 类说明 文件操作类 java.io.File类
 *          1.凡是与输入\输出相关的类\接口等定义在java.io包下 2.File是一个类,可以有构造器创建其对象.此对象对着一个文件(.txt
 *          .avi .doc .ppt)或文件目录 3.file类对象是与平台无关的.
 *          4.file中的方法,仅涉及到如何创建\删除\重命名等等.只要是涉及文件内容的.file 是无能为力的,必须由IO流来完成
 *          5.File类的对象常作为IO流的具体类的构造器的形参.
 */
public class TestFile {
	/**
	 * 新建一个文件相关
	 * 
	 * @throws IOException
	 */
	@Test
	public void test3() throws IOException {
		File file = new File("hello.txt");
		System.out.println(file.delete());// 删除一个文件
		if (!file.exists()) {
			boolean createNewFile = file.createNewFile();
			System.out.println("创建一个文件:" + createNewFile);
		}
		// 创建一个文件
		File file2 = new File("hello");
		if (!file2.exists()) {
			boolean mkdir = file2.mkdir();//创建一个文件目录
			boolean mkdirs = file2.mkdirs();//文件的上层文件目录不存在一并给创建了
			System.out.println("mkdir:" + mkdir);
		}
		//浏览文件目录
		String[] list = file2.list();//返回字符串
		File[] listFiles = file2.listFiles();//返回文件类型的数组
		for (String string : list) {
			System.out.println("string:"+string);
		}
		for (File file3 : listFiles) {
			System.out.println(file3.getName());
		}
	}

	/**
	 * 获取文件信息
	 */
	@Test
	public void test2() {
		File file = new File("hello.txt");
		System.out.println(file.exists());// 是否存在
		System.out.println(file.canWrite());// 可写
		System.out.println(file.canRead());// 可读
		System.out.println(file.isFile());// 是一个文件
		System.out.println(file.isDirectory());// 是一个文件目录
		System.out.println(new Date(file.lastModified()));// 最后修改时间
		System.out.println(file.length());// 文件长度
	}

	/**
	 * 路径: 绝对路径,包括盘符在内的完整的文件路径 相对路径:在当前文件目录下的文件路径.
	 */
	@Test
	public void test1() {
		// 绝对路径
		// File file1=new File("d:/io/helloworld.txt");
		// 相对路径
		File file2 = new File("hello.txt");
		System.out.println(file2.getName());// 文件名
		System.out.println(file2.getPath());
		System.out.println(file2.getAbsoluteFile());
		System.out.println(file2.getParent());
		System.out.println(file2.getAbsolutePath());
		// renameTo(File new Name):重命名
		// file1.renameTo(file2):file1重命名为file2.要求:file1文件一定存在.file2文件一定不存在
		boolean renameTo = file2.renameTo(new File("file3"));
		System.out.println("renameTo:" + renameTo);
	}
}
