package imran.coding.challenge.datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersChallengeTest {

    private NumbersChallenge underTest;

    @BeforeEach
    void setUp() {
        underTest = new NumbersChallenge();
    }

    private static Stream<Arguments> pythagoreanTriplets() {
        return Stream.of(
            Arguments.of("3,4,5",           true),
            Arguments.of("5,3,4",           true),
            Arguments.of("5,1,3,2,4",       true),
            Arguments.of("3,4,6",           false),
            Arguments.of("5,3,7,5,6,11",    false),
            Arguments.of("1,6,10,9,7,8",    true)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "pythagoreanTriplets")
    void shouldReturnExpectedBooleanForTheGivenPythagoreanTriplets(String pythagoreanTriplets, boolean expectedOutput) {
        assertThat(underTest.containsPythagoras(toCollection(pythagoreanTriplets))).isEqualTo(expectedOutput);
    }

    private Collection<Integer> toCollection(String commaSeparatedNumbers) {
        return Arrays.stream(commaSeparatedNumbers.split(","))
            .mapToInt(Integer::parseInt).boxed().toList();
    }
}
