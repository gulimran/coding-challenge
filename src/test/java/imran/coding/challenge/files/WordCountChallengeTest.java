package imran.coding.challenge.files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordCountChallengeTest {

    private WordCountChallenge underTest;

    @BeforeEach
    void setUp() {
        underTest = new WordCountChallenge();
    }

    @Test
    void shouldReturnWordCount() throws Exception {
        Map<String, Integer> expected = expectedWordCount();

        Map<String, Integer> actual = underTest.wordCount("src/test/resources/test-word-count.txt");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturnEmptyWordCount_WhenFileIsEmpty() throws Exception {
        Map<String, Integer> actual = underTest.wordCount("src/test/resources/test-word-count-empty.txt");

        assertThat(actual).isEmpty();
    }

    @Test
    void shouldThrowException_WhenFileDoesNotExist() throws Exception {
        assertThrows(FileNotFoundException.class, () -> underTest.wordCount("non-existing-file.txt"));
    }

    private static Map<String, Integer> expectedWordCount() {
        Map<String, Integer> map = new HashMap<>();

        map.put("As", 1);
        map.put("Boot", 4);
        map.put("Getting", 1);
        map.put("If", 1);
        map.put("Initializr", 1);
        map.put("Spring", 6);
        map.put("Started", 1);
        map.put("This", 2);
        map.put("a", 4);
        map.put("accelerate", 1);
        map.put("and", 1);
        map.put("application", 1);
        map.put("as", 1);
        map.put("based", 1);
        map.put("bundled", 1);
        map.put("cases", 1);
        map.put("create", 1);
        map.put("details", 1);
        map.put("development", 1);
        map.put("download", 1);
        map.put("file", 1);
        map.put("fill", 1);
        map.put("for", 1);
        map.put("give", 1);
        map.put("guide", 2);
        map.put("guides", 1);
        map.put("helps", 1);
        map.put("how", 1);
        map.put("in", 1);
        map.put("is", 1);
        map.put("meant", 1);
        map.put("more", 2);
        map.put("of", 2);
        map.put("options", 1);
        map.put("own", 1);
        map.put("pick", 1);
        map.put("project", 3);
        map.put("provides", 1);
        map.put("quick", 1);
        map.put("read", 1);
        map.put("sampling", 1);
        map.put("see", 1);
        map.put("taste", 1);
        map.put("to", 2);
        map.put("up", 1);
        map.put("use", 1);
        map.put("visit", 1);
        map.put("want", 1);
        map.put("will", 1);
        map.put("you", 5);
        map.put("your", 3);
        map.put("zip", 1);

        return map;
    }

}
