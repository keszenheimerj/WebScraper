package com;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.io.IOException;

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
