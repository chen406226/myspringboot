package com.soul.index;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import com.github.mustachejava.util.NodeValue;

public class Segmenter {
	String text = null;
	int offset;
	public Segmenter(String text){
		this.text = text;
		offset = 0;
	}
	public String nextWord(){
		String word = null;
		if (text==null||rootNode==null) {
			return word;
		}
		if (offset >= text.length()) {
			return word;
		}
		TSTNode currentNode = root;
		int charIndex = offset;
		while (true) {
			if (currentNode == null) {
				if (word == null) {
					word = text.substring(offset, offset+1);
					offset++;
				}
				return word;
			}
			int charComp = text.charAt(charIndex) - currentNode.spliter;
			if (charComp == 0) {
				charIndex++;
				if (currentNode.nodeValue != null) {
					word = currentNode.nodeValue;
					offset = charIndex;
				}
				if (charIndex == text.length()) {
					return word;
				}
				currentNode = currentNode.mid;
			}else if (charComp < 0) {
				currentNode = currentNode.left;
			}else {
				currentNode = currentNode.right;
			}
			return "";
		}
	}
	public final static class TSTNode {
		public String nodeValue;

		public String data;

		protected TSTNode left;
		protected TSTNode mid;
		protected TSTNode right;

		public char spliter;

		public TSTNode(char key) {
			this.spliter = key;
		}

		public TSTNode() {
		}

		public String toString() {
			return "data: " + data + "   spliter:" + spliter;
		}

		public void addWord(String word) {
			if(data==null){
				data = word;
			}
		}

		public boolean isTerminal() {
			return (data!=null);
		}
	}
	private static TSTNode root; //
	public TSTNode rootNode;
	{
		String fileName = "./lib/word.txt";
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(fileReader);
			String line;
			try {
				while ((line=reader.readLine())!=null) { //按行读
					StringTokenizer st = new StringTokenizer(line, "\t");
					String key = st.nextToken(); //得到词
					TSTNode endNode = creatTSTNode(key);
					endNode.nodeValue = key;
					
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				reader.close();
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//创建一个结点
	public TSTNode creatTSTNode(String key)throws NullPointerException,IllegalArgumentException {
		if(key==null){
			throw new NullPointerException("空指针异常");
		}
		int charIndex = 0;
		TSTNode currentNode = rootNode;
		if (rootNode == null) {
			rootNode = new TSTNode(key.charAt(0));
		}
		while (true) {
			int compa = (key.charAt(charIndex) - currentNode.spliter);
			if (compa == 0) {
				charIndex++;
				if (charIndex == key.length()) {
					return currentNode;				
				}
				if (currentNode.left == null) {
					currentNode.left = new TSTNode(key.charAt(charIndex));
				}
				currentNode = currentNode.left;
			} else if (compa < 0) {
				if (currentNode.mid == null) {
					currentNode.mid = new TSTNode(key.charAt(charIndex));
				}
				currentNode = currentNode.mid;
			} else {
				if (currentNode.right == null) {
					currentNode.right = new TSTNode(key.charAt(charIndex));
				}
				currentNode = currentNode.right;
			}
		}				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
