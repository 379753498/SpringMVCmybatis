package com.javen.testmybatis;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class test {

	public static void main(String[] args) throws IOException {

		File input = new File("F:\\aabbcc.html");
		Document doc = Jsoup.parse(input, "GBK");

//		System.out.println(doc.toString());
		Elements elementsByTag1 = doc.getElementsByTag("body");
		Elements elementsByTag = elementsByTag1.get(0).getElementsByTag("div");

		for (int i = 0; i < elementsByTag.size(); i++) {
			Elements elementsByTag2 = elementsByTag.get(i).getElementsByTag("li");
			
			
			for (int j = 0; j < elementsByTag2.size(); j++) {
				String text = elementsByTag2.get(j).text();
				System.out.println(text);
			}
			
		}
		
		
		
		
	}
}
