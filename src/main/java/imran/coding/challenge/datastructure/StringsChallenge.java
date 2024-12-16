package imran.coding.challenge.datastructure;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class StringsChallenge {

    public Character firstNonRepeatingChar(String input) {
        if (Objects.isNull(input) || input.isBlank()) return null;

        Map<Character, Integer> characterCount = new HashMap<>();
        char[] inputChars = input.toCharArray();

        for (Character inputChar : inputChars) {
            if (!characterCount.containsKey(inputChar)) {
                characterCount.put(inputChar, 1);
            } else {
                characterCount.put(inputChar, characterCount.get(inputChar) + 1);
            }
        }

        return characterCount.entrySet().stream()
            .filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey)
            .toList().get(0);
    }
}
