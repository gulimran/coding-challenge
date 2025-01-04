package imran.coding.challenge.datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeTest {

    private Palindrome underTest;

    @BeforeEach
    void setUp() {
        underTest = new Palindrome();
    }

    private static Stream<Arguments> inputStrings() {
        return Stream.of(
            Arguments.of("madam", true),
            Arguments.of("nurses run", true),
            Arguments.of("11/11/11", true),
            Arguments.of(null, true),
            Arguments.of("   ", true),
            Arguments.of("alpha", false),
            Arguments.of("bravo charlie", false),
            Arguments.of("24/12/24", false)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "inputStrings")
    void verifyGivenStringIsPalindromeOrNot(String input, Boolean expected) {
        Boolean result = underTest.isPalindrome(input);
        assertThat(result).withFailMessage(() -> "Result for input is not as expected: " + input).isEqualTo(expected);
    }

}