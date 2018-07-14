package org.javaee.tree.traversal;

import java.io.File;

import org.javaee.util.StringUtils;

/**
 * 中序遍历 系统目录，根据所在层级进行缩进打印出层级结构。
 * 
 * @author qiuzj
 *
 */
public class InorderTraversalDir {

	public static void inorderPrint(File file, int depth) {
		if (!file.exists()) {
			return;
		}
		
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files.length <= 0) {
				return;
			}
			
			int count = 0;
			for (File childDir : files) {
				inorderPrint(childDir, depth + 1);
				if (++count == 1) { // 呵呵，其实是假的中序遍历，固定第2个就打印父节点
					StringUtils.print(file.getName(), depth);
				}
			}
		} else { // 如果是文件直接打印
			StringUtils.print(file.getName(), depth);
		}
	}
	
	public static void main(String[] args) {
		String dir = "D:\\Dropbox\\#1-数据结构、算法";
		File file = new File(dir);
		inorderPrint(file, 0);
	}
	
}
