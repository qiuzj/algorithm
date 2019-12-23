package org.javaee.heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 合并有序小文件
 * 
 */
public class MergeSortedFilesTest {

	public static final String BASE_DIR = "D:/Dropbox/#1-数据结构、算法/algorithm/src/main/resources/";
	public static final String SOURCE_FILENAME = "linux.words";

	@Test
	public void testMerge() throws IOException {

		//文件总数fileCount
		int fileCount = 10;
			
		// 创建fileCount相应数量的BufferedReader 
		List<BufferedReader> readerList = new ArrayList<>(fileCount);
		for (int i = 0; i < fileCount; i++) {
			FileInputStream fis = new FileInputStream(BASE_DIR + SOURCE_FILENAME + i);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			readerList.add(br);
		}
		
		// 创建小顶堆，容量为fileCount
		MinGenericHeap<Node> heap = new MinGenericHeap<Node>(fileCount);
		
		// 先从每个文件中取1个元素，放入堆中
		String line = null;
		for (int i = 0; i < fileCount; i++) {
			if ((line = readerList.get(i).readLine()) != null) {
				heap.insert(new Node(line.trim().toLowerCase(), i));
			}
		}
		
		// 创建大文件BufferedReader 
		FileOutputStream fos = new FileOutputStream(BASE_DIR + SOURCE_FILENAME + "_big");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		// 然后进入循环处理
		while (true) {
			// 取出堆顶元素
			Node minNode = heap.removeTop();
			
			// 为空则break结束处理
			if (minNode == null) {
				break;
			}
			
			// 放入大文件
			bw.write(minNode.getValue());
			bw.write('\n');
			
			// 如果堆顶元素所在文件的下一个元素存在，则插入堆
			int fileIndex = minNode.getFileIndex();
			if ((line = readerList.get(fileIndex).readLine()) != null) {
				heap.insert(new Node(line.trim(), fileIndex));
			}
		}
		 
		//关闭大文件BufferedReader 
		bw.close();
		
		// 关闭所有BufferedReader 
		for (BufferedReader br : readerList) {
			br.close();
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
