import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ngram {
    // ngram being set up ro run through and will look for any strings with Location then pulling the next two words
    public static List<String> ngrams(int n, String str) {
        List<String> ngrams = new ArrayList<String>();
        String[] wordsAfterLocation = str.split("location");// to add more just use the or(|)
        String[] wordsAfterStudies = str.split("Studies");
        for (int i = 0; i < wordsAfterLocation.length - n +1; i++) {
            ngrams.add(concat(wordsAfterLocation, i, i + n));
        }
        for (int i = 0; i < wordsAfterStudies.length - n +1; i++) {
            if(wordsAfterStudies[i].equals("at")){
                for(int j = i; j < wordsAfterStudies.length - n +1; j++)
                    ngrams.add(concat(wordsAfterStudies, i, i + n));
                i = wordsAfterStudies.length;
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
        for (int n = 0; n <=3; n++) {
            for (String ngram : ngrams(2, results)) // I don't have this as an array right now because it looked like we stored teh data in one big string so if it is a array just use results[n]
                System.out.println(ngram);
            System.out.println();
        }
    }
}
