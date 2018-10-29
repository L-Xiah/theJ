package com.infy.jee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		 Student student = new Student(100, "Haimeimei", 22, 76.5);
//
//		 FileOutputStream fos = new FileOutputStream("stu");
//		 ObjectOutputStream oos = new ObjectOutputStream(fos);
//		 oos.writeObject(student);
//		 oos.flush();
//		 oos.close();

//		FileInputStream fis = new FileInputStream("stu");
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		Student stu = (Student) ois.readObject();
//		System.out.println(stu);
//		ois.close();
	}

	/**
	 * 遍历取文件夹下的文件名
	 * 
	 * @param dirPath
	 */
	private static void showFiles(String dirPath) {
		File root = new File(dirPath);
		if (!root.exists()) {
			throw new IllegalArgumentException("File not found in (" + dirPath + ")");
		}

		if (!root.isDirectory()) {
			throw new IllegalArgumentException("File(" + dirPath + ") is not a directory.");
		}

		File[] files = root.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				showFiles(f.getAbsolutePath());
			} else {
				System.out.println(f.getName());
			}
		}
	}

	/**
	 * 通过输入/输出流进行文件的拷贝操作
	 * 
	 * @param srcFile
	 * @param dstFile
	 */
	public static void copyFile(File srcFile, File dstFile) {
		if (srcFile == null || !srcFile.exists()) {
			throw new IllegalArgumentException("文件不存在");
		}

		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}

		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(dstFile);

			byte[] buf = new byte[8 * 1024];
			int b;
			while ((b = fis.read(buf, 0, buf.length)) != -1) {
				fos.write(buf, 0, b);
			}
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}

				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}