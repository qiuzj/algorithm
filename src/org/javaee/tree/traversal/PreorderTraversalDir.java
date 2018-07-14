package org.javaee.tree.traversal;

import java.io.File;

import org.javaee.util.StringUtils;

/**
 * 先序遍历 系统目录，根据所在层级进行缩进打印出层级结构。
 * 
 * @author qiuzj
 *
 */
public class PreorderTraversalDir {

	public static void preorderPrint(File file, int depth) {
		if (!file.exists()) {
			return;
		}
		StringUtils.print(file.getName(), depth);
		if (file.isDirectory()) {
			for (File childDir : file.listFiles()) {
				preorderPrint(childDir, depth + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		String dir = "D:\\Dropbox\\#1-数据结构、算法";
		File file = new File(dir);
		preorderPrint(file, 0);
	}
	
}
