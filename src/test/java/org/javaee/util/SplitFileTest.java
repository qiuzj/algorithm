package org.javaee.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;

public class SplitFileTest {

	public static final String BASE_DIR = "D:/Dropbox/#1-数据结构、算法/algorithm/src/main/resources/";
	public static final String SOURCE_FILENAME = "linux.words";
	private int splitCount = 10;
	
	/**
	 * 将文件的每一个字符串，随机写到其中任一文件中
	 */
	@Test
	public void testRandomSplit() {
		List<BufferedWriter> bwList = new ArrayList<>();
		for (int i = 0; i < splitCount; i++) {
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(BASE_DIR + SOURCE_FILENAME + i);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				BufferedWriter bw = new BufferedWriter(osw);
				bwList.add(bw);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
		
		try (FileInputStream fis = new FileInputStream(BASE_DIR + SOURCE_FILENAME);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);) {
			Random r = new Random();
			String line = null;
			while ((line = br.readLine()) != null) {
				int rv = r.nextInt(splitCount);
				bwList.get(rv).write(line + '\n');
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		bwList.forEach(bw -> {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 平均分割到多个文件，多出来的写到最后一个文件。因此，最后一个文件可能比其他文件多或者少
	 */
	@Test
	public void testAverageSplit() {
		/* 计算文件总行数 */
		long totalCount = 0;
		try (FileInputStream fis = new FileInputStream(BASE_DIR + SOURCE_FILENAME);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);) {
			totalCount = br.lines().count();
			System.out.println("totalCount: " + totalCount);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		/* 分割到10个文件 */
		try (FileInputStream fis = new FileInputStream(BASE_DIR + SOURCE_FILENAME);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);) {
			// 每个文件的行数
			long fileMaxCount = totalCount / splitCount;
			// 循环写到每个文件
			IntStream.range(0, splitCount).forEach(i -> {
				try (FileOutputStream fos = new FileOutputStream(BASE_DIR + SOURCE_FILENAME + i);
						OutputStreamWriter osw = new OutputStreamWriter(fos);
						BufferedWriter bw = new BufferedWriter(osw);) {
					String line = null;
					// 当前文件已写入的行数
					long currentFileCount = 0;
					// 循环写一个文件
					while ((line = br.readLine()) != null && currentFileCount++ < fileMaxCount) {
						bw.write(line);
						bw.write('\n');
					}
					// 剩下的追加到最后一个文件
					while (i == splitCount - 1 && (line = br.readLine()) != null) {
						bw.write(line);
						bw.write('\n');
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
