package com;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.lang.*;

public class Website {
    private URL url;//store url
    //private String name;
    private ArrayList words = new ArrayList<>();

    public Website(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void openHTML() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream())); //swap for fr

        String line;
        String last = "";
        //int countCheck = 0;//need two then grab name
        while ((line = br.readLine()) != null) {
            String[] split = line.split("\\s+");
            ArrayList<String> aL = new ArrayList<>();
            for (String s : split) {


                if (s.length() > 0 && !Character.isUpperCase(s.charAt(0))) {
                    s = "";
                }
                for (int i = 0; i < s.length() - 1; i++) {
                    if ((Character.isLowerCase(s.charAt(i)) && Character.isUpperCase(s.charAt(i + 1))) || s.substring(i).equals(".")) {
                        i = s.length();
                        s = "";
                    }
                }
                if (s.matches(".*\\d.*")) {
                    s = "";
                }
                if (s.contains("<")) {
                    s = s.substring(0, s.indexOf("<") + 1);
                }
                if (s.contains(">")) {
                    s = s.substring(s.indexOf(">") + 1, s.length());
                }
                if (s.contains("\"") || s.contains("\\")) {
                    //s = s.substring(0, s.indexOf("<")+1);
                    s = "";
                }

                //look for individual sign usages
                if (s.contains("<") || s.contains("=") || s.contains("-") || s.contains("_") || s.contains("/") || s.contains(":") || s.contains(";") || s.contains("[") || s.contains("]") || s.contains("{") || s.contains("}")) {
                    s = "";
                }
                if (s.contains("png") || s.equals(last)) {
                    s = "";
                }
                if (s.contains("title")) {
                    s = s.substring(s.indexOf("=") + 1, s.length());
                }
                if (s.length() == 1 && !(s.equals("a") || s.equals("e") || s.equals("i"))) {
                    s = "";
                }
                if (!s.equals("")) {
                    last = s;
                    aL.add(s);
                }

            }

            words.addAll(aL);
        }

        br.close();
    }
    public String getWords(){
        StringBuilder out = new StringBuilder();
        for (Object s : words) {
            out.append(s).append(" ");
        }
        return out.toString();
    }
}
