package com.yedam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileTest {

	@Test
	public void list() {

		File file = new File("C:\\temp");
		String[] list = file.list();
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}

//	@Test
	public void rename() {
		File file = new File("C:/temp/original2.jpg");
		file.renameTo(new File("C:/temp/originalSpringRN.jpg"));
	}

	@Test
	public void copy() throws IOException {
		FileInputStream fi = new FileInputStream(new File("c:/temp", "writer.txt"));
		FileOutputStream fo = new FileOutputStream(new File("C:/temp", "복사.txt"));

		int temp;
		while ((temp = fi.read()) != -1) {
			fo.write(temp);
		}
		fi.close();
		fo.close();
	}

}
