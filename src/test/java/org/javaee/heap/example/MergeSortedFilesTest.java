package org.javaee.heap.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.javaee.heap.MinGenericHeap;
import org.junit.Test;

/**
 * 实战1：合并有序小文件
 * 
 */
public class MergeSortedFilesTest {

	public static final String BASE_DIR = "D:/Dropbox/#1-数据结构、算法/algorithm/src/main/resources/";
	public static final String SOURCE_FILENAME = "linux.words";

	@Test
	public void testMerge() {

		// 文件总数fileCount
		int fileCount = 10;
		// 小文件输入流对象
		List<BufferedReader> readerList = new ArrayList<>(fileCount);
		// 大文件输出流对象
		BufferedWriter bw = null;
		
		try {
			// 1.为每个小文件创建输入流量对象br，并通过索引号缓存起来
			for (int i = 0; i < fileCount; i++) {
				FileInputStream fis = new FileInputStream(BASE_DIR + SOURCE_FILENAME + i);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
				readerList.add(br);
			}
			
			// 2.为大文件创建输出流对象bw
			FileOutputStream fos = new FileOutputStream(BASE_DIR + SOURCE_FILENAME + "_big");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			
			// 3.创建小顶堆heap. 容量为fileCount
			MinGenericHeap<Node> heap = new MinGenericHeap<Node>(fileCount);
			
			// 4.依次从每个文件中各取1个元素v，创建节点T(v,i)，并插入堆中
			String line = null;
			for (int i = 0; i < fileCount; i++) {
				if ((line = readerList.get(i).readLine()) != null) {
					heap.insert(new Node(line.trim(), i));
				}
			}
			
			// 然后进入循环处理
			while (true) {
				// 1.取出堆顶T（堆中的最小值）
				Node minNode = heap.removeTop();
				
				// 为空则break结束处理
				if (minNode == null) {
					break;
				}
				
				// 2.将堆顶元素值写入大文件
				bw.write(minNode.getValue());
				bw.write('\n');
				
				// 3.如果堆顶元素所在文件的下一个元素存在，则插入堆
				int fileIndex = minNode.getFileIndex();
				if ((line = readerList.get(fileIndex).readLine()) != null) {
					heap.insert(new Node(line.trim(), fileIndex));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭文件流
			close(bw);
			for (BufferedReader br : readerList) {
				close(br);
			}
		}
	}
	
	@Test
	public void testCompare() {
		try (FileInputStream fis1 = new FileInputStream(BASE_DIR + SOURCE_FILENAME);
			InputStreamReader isr1 = new InputStreamReader(fis1);
			BufferedReader br1 = new BufferedReader(isr1);
			FileInputStream fis2 = new FileInputStream(BASE_DIR + SOURCE_FILENAME + "_big");
			InputStreamReader isr2 = new InputStreamReader(fis2);
			BufferedReader br2 = new BufferedReader(isr2);) {
			String line1 = null;
			String line2 = null;
			while ((line1 = br1.readLine()) != null && (line2 = br2.readLine()) != null) {
				if (!line1.equals(line2)) {
					throw new IllegalArgumentException(String.format("%s is not equals to %s", line1, line2));
				}
			}
			if (br1.readLine() != null || br2.readLine() != null) {
				throw new IllegalArgumentException("line1 is not equals to line2");
			}
			System.out.println("Well done!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void close(Closeable c) {
		if (c != null) {
			try {
				c.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 定义堆元素：包含字符串值、来自哪个文件
	class Node implements Comparable<Object> {
		private String value;
		private int fileIndex;
		
		public Node(String value, int fileIndex) {
			this.value = value;
			this.fileIndex = fileIndex;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public int getFileIndex() {
			return fileIndex;
		}
		public void setFileIndex(int fileIndex) {
			this.fileIndex = fileIndex;
		}
		@Override
		public int compareTo(Object o) {
			if (this == o) {
				return 0;
			}
			return value.compareToIgnoreCase(((Node) o).getValue());
		}
		@Override
		public String toString() {
			return "Node [value=" + value + ", fileIndex=" + fileIndex + "]";
		}
	}
	
	/**
	 * 打印数组
	 * 
	 * @param array
	 */
	public static void println(Node[] array) {
		if (array == null || array.length <= 0) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (Node obj : array) {
			sb.append(obj).append(",");
		}
		System.out.println(sb.subSequence(0, sb.length() - 1));
	}

}
