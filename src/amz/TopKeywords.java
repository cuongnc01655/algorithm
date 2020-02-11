package amz;

import java.util.*;

public class TopKeywords {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("The man walked the dog", "The lady walked the dog.","Dogs are cool", "Cats are interesting creatures",
                "Cats and Dogs was an interesting movie.", "The man has a brown dog", "movie are think I like");
        List<String> keywords = Arrays.asList("dog", "cat", "the", "bla", "blo");

        int n = 2;
        for (String word: topKeywords(words,keywords, n)) {
            System.out.println(word);
        }
    }

    public static List<String> topKeywords(List<String> sentences, List<String> keywords, int n) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String sentence : sentences) {
            String sanitized = sentence.toLowerCase();
            for (String keyword: keywords) {
                if (sanitized.contains(keyword)) {
                    wordCount.put(keyword, wordCount.getOrDefault(keyword, 0) + 1);
                }
            }
        }
        Map<Integer, List<String>> pivot = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> wc : wordCount.entrySet()) {
            pivot.putIfAbsent(wc.getValue(), new ArrayList<>());
            pivot.get(wc.getValue()).add(wc.getKey());
        }
        List<String> output = new ArrayList<>();
        outputLoop:
        for (List<String> value: pivot.values()) {
            Collections.sort(value);
            for (String word: value) {
                if (output.size() < n) {
                    output.add(word);
                } else {
                    break outputLoop;
                }
            }
        }
        return output;
    }
}
