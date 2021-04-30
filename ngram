import java.util.ArrayList;
import java.util.List;
public class ngramLocation {
// ngram being set up ro run through and will look for any strings with Location then pulling the next two words
public static List<String> ngrams(int n, String str) {
        List<String> ngrams = new ArrayList<String>();
        String[] words = str.split("location");// to add more just use the or(|)
        for (int i = 0; i < words.length - n +1; i++)
            ngrams.add(concat(words, i, i+n));
        return ngrams;
    }

    public static String concat(String[] words, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++)
            sb.append((i > start ? " " : "") + words[i]);
        return sb.toString();
    }
public static void wordLength(){
   Website info = new Website();
   String results = info.getResult();
   for (int n = 0; n <=3; n++) {
            for (String ngram : ngrams(2, results)) // I don't have this as an array right now because it looked like we stored teh data in one big string so if it is a array just use results[n]
                System.out.println(ngram);
            System.out.println(); 
    }
  }
}
