package imran.coding.challenge.datastructure;

import org.springframework.stereotype.Component;

@Component
public class Palindrome {

    /**
     * A word, phrase, or sequence that reads the same backwards as forwards, e.g. madam or nurses run.
     * Determine whether the given string is a palindrome or not.
     * @param input - A given string
     * @return true if the given string is a palindrome or false otherwise
     */
    public boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) return true;

        String validated = removeNonVisible(input);

        int left = 0, right = validated.length() - 1;

        while (left < right) {
            if (validated.charAt(left) != validated.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * Removes all whitespaces and non-visible characters
     */
    private String removeNonVisible(String input) {
        return input.replaceAll("\\s+","");
    }
}
