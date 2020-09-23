package ic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You want to build a word cloud, an infographic where the size of a word corresponds to how often it appears in the body of text.
 * To do this, you'll need data. Write code that takes a long string and builds its word cloud data in a hash map ↴ , where the keys are words and the values are the number of times the words occurred.
 *
 * Think about capitalized words. For example, look at these sentences:
 *
 *   "After beating the eggs, Dana read the next step:"
 * "Add milk and eggs, then add flour and sugar."
 * What do we want to do with "After", "Dana", and "add"? In this example, your final hash map should include one "Add" or "add" with a value of
 * 2
 * 2. Make reasonable (not necessarily perfect) decisions about cases like "After" and "Dana".
 *
 * Assume the input will only contain words and standard punctuation.
 *
 * You could make a reasonable argument to use regex in your solution. We won't, mainly because performance is difficult to measure and can get pretty bad.
 */
public class WordCloudData {
    private final String text;
    public WordCloudData(String text) {
        this.text = text;
    }

    public Map<String, Integer> getWordsToCounts() {
        String sanitized = text.replaceAll("[^a-zA-Z0-9\\.']"," ").replaceAll("\\.{3}", " ");
        Map<String, Integer> result = new HashMap<>();
        for (String s : sanitized.split("\\s+")) {
            Integer count = result.getOrDefault(s, 0);
            result.put(s, count + 1);
        }
        return result;
    }
}