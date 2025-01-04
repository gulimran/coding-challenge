package imran.coding.challenge.files;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class WordCountChallenge {

    /**
     * Count unique words in a given file.
     * @param file - The input file
     * @return The count of occurrence of each unique word in the file
     * @throws IOException
     */
    public Map<String, Integer> wordCount(String file) throws IOException {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.lines().forEach(line -> {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            });
        }

        return wordCount;
    }
}
