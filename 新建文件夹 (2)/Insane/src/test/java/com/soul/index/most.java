package com.soul.index;

public class most {
	public static void main(String[] args) {
		Segmenter seg = new Segmenter("印度尼西亚潜水");
		String word;
		do {
			word = seg.nextWord();
			System.out.println(word);
		} while (word!=null);
	}
}
