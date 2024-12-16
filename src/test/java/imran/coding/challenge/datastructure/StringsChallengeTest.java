package imran.coding.challenge.datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringsChallengeTest {

    private StringsChallenge underTest;

    @BeforeEach
    void setup() {
        underTest = new StringsChallenge();
    }

    private static Stream<Arguments> inputStrings() {
        return Stream.of(
            Arguments.of("swiss", 'w'),
            Arguments.of("aabbccdd", null),
            Arguments.of(null, null),
            Arguments.of("", null),
            Arguments.of("   ", null)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "inputStrings")
    void findFirstNonRepeatingCharacterInString(String input, Character expectedOutput) {
        Character result = underTest.firstNonRepeatingChar(input);
        assertThat(result).isEqualTo(expectedOutput);
    }
}
