package com;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Website {
    private URL url;//store url


    public Website(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //use url to
    public void openHTML() throws IOException {
        Scanner scanner = new Scanner(url.openStream());
        StringBuffer stringBuffer = new StringBuffer();
        while (scanner.hasNext()) {
            stringBuffer.append(scanner.next());
            //System.out.println(scanner.next());
        }
        String result = fetchString(stringBuffer);

        result = fetchStringWOSymbols(result);//Removing the HTML tags

        System.out.println("Contents of the web page: " + result);
    }
    public void loadDataToText() throws IOException{
        FileWriter fw = new FileWriter("webData.txt", true);
        PrintWriter data = new PrintWriter(fw);
        data.println(results);
        data.close();
    }

    private String fetchString(StringBuffer stringBuffer) {
        String output = stringBuffer.toString();
        System.out.println(output);
        return output;
    }

    private String fetchStringWOSymbols(String result){
        result = result.replaceAll("<[^>]*>", "");
        return result;
    }

}
