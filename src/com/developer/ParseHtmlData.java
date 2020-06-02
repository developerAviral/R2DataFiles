package com.developer;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseHtmlData {

	public void readHtmlData() throws IOException {

		String page = "http://web.mta.info/developers/turnstile.html";
		// Connecting to the web page
		Connection conn = Jsoup.connect(page);
		// executing the get request
		Document doc = conn.get();

		// Retrieving the contents div of the web page
		Elements elements = doc.select("div[class=span-84 last]").select("*");

		FileWriter writer = new FileWriter("datafile.txt", false);

		int count = 0;
		for (Element element : elements) {
			if (count > 1) {
				writer.write(element.ownText() + "\n");

				if (!element.ownText().isEmpty() && element.ownText() != " ") {
					String[] dateArray = element.ownText().split(",[ ]*");
					String[] monthDate = dateArray[1].trim().split(" ");
					
					System.out.print(" Day: " + dateArray[0].trim());
					System.out.print(" Month: " + monthDate[0].trim());
					System.out.print(" Date: " + monthDate[1].trim());
					System.out.print(" Year: " + dateArray[2].trim());
					System.out.println();
				}
			}
			count++;
		}
		writer.close();
	}

}
