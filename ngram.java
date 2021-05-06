package com;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ngram {
    // ngram being set up ro run through and will look for any strings with Location then pulling the next two words
    public static List<String> ngrams(int n, String str) {
        List<String> ngrams = new ArrayList<String>();
        String[] words = str.split(" ");// to add more just use the or(|)
        for (int i = 0; i < words.length - n +1; i++) {
            if(words[i].equals("Join") && (words[i+1].equals("Facebook"))){
                ngrams.add("Name:" + concat(words, i + 2, i + n + 2));
                i = words.length;
            }
        }
        for (int i = 0; i < words.length - n +1; i++) {
            if(words[i].equals("Looking")){//was New

                if(words[i+2].equals("High")){
                    ngrams.add("From " + concat(words, i+1, i + n + 1) + " School");
                }else{
                    ngrams.add("From " + concat(words, i+2, i + n + 2) );
                }
                i = words.length;
            }

        }

        return ngrams;
    }
    // Concat will build the new strings with desired info
    public static String concat(String[] words, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++)
            sb.append((i > start ? " " : "") + words[i]);
        return sb.toString();
    }
    public static void wordLength(String url) throws IOException {
        Website info = new Website(url);
        info.openHTML();
        String results = info.getWords();
        for (int n = 0; n <=0; n++) {
            for (String ngram : ngrams(2, results)) // I don't have this as an array right now because it looked like we stored teh data in one big string so if it is a array just use results[n]
                System.out.println(ngram);
            System.out.println();
        }
    }
}
