package com.developer;

import java.io.IOException;

public class App {
	public static void main(String[] args) throws IOException {		
		
		ParseHtmlData htmlData = new ParseHtmlData();
		htmlData.readHtmlData();
	}
}
