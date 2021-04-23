package com.company;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.util.Scanner;


public class WebConnect {

    public static void WebConnect(String[] args)  {
    	// asks the user to input the url they would wish to visit
    	System.out.println("Please copy then paste URl below:EX If you wished to take information from Xavier's homepage you would copy then paste https://www.xavier.edu/");
Scanner keyboard = new Scanner(System.in);
String url = keyboard.next(); // url the user inputs if they don't input a proper url it will ask them to do so.
	try {
		var request = HttpRequest.newBuilder(// connecting to the url
				URI.create(url))
				.GET()
				.build();
		try {
			HttpRequest request2 = HttpRequest.newBuilder() // to get the headers from url
					.uri(new URI(url))
					.header("key1", "value1")
					.header("key2", "value2")
					.GET()
					.build();
			System.out.println("connected");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	} catch (IllegalArgumentException e) {
		System.out.println("Please enter a valid URL");
	}
	}
}
