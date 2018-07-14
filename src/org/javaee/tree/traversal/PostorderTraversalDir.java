package org.javaee.tree.traversal;

import java.io.File;

import org.javaee.util.StringUtils;

/**
 * 后序遍历 系统目录，根据所在层级进行缩进打印出层级结构。
 * 
 * @author qiuzj
 *
 */
public class PostorderTraversalDir {

	public static void postorderPrint(File file, int depth) {
		if (!file.exists()) {
			return;
		}
		if (file.isDirectory()) {
			for (File childDir : file.listFiles()) {
				postorderPrint(childDir, depth + 1);
			}
		}
		StringUtils.print(file.getName(), depth);
	}
	
	public static void main(String[] args) {
		String dir = "D:\\Dropbox\\#1-数据结构、算法";
		File file = new File(dir);
		postorderPrint(file, 0);
	}
	
}
