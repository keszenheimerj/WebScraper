package com;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.util.Scanner;

public class WebConnect {


    public static void main(String[] args) throws IOException {

        System.out.println("Please copy then paste a Facebook URl below:EX If you wished to take information from my roommate's Facebook you would copy paste https://www.facebook.com/brendan.kelleher.16");
        Scanner keyboard = new Scanner(System.in);
        String url = keyboard.next();
        ngram nG = new ngram();
        nG.wordLength(url);
    }

}
