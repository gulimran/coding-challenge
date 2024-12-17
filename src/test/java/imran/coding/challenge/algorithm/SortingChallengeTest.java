package imran.coding.challenge.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortingChallengeTest {

    private SortingChallenge underTest;

    @BeforeEach
    void setup() {
        underTest = new SortingChallenge();
    }

    private static Stream<Arguments> inputIntegerArrays() {
        return Stream.of(
            Arguments.of(new int[]{1,2,3,4}, new int[]{5,6,7,8}, new int[]{1,2,3,4,5,6,7,8}),
            Arguments.of(new int[]{1,5,3,7}, new int[]{2,4,6,8}, new int[]{1,2,3,4,5,6,7,8}),
            Arguments.of(new int[]{5,6,7,8}, new int[]{1,2,3,4}, new int[]{1,2,3,4,5,6,7,8}),
            Arguments.of(new int[]{8,7,6,5}, new int[]{4,3,2,1}, new int[]{1,2,3,4,5,6,7,8}),
            Arguments.of(new int[]{8,7,6,5}, new int[]{1,2,3,4}, new int[]{1,2,3,4,5,6,7,8}),
            Arguments.of(null, new int[]{5,6,7,8}, new int[]{5,6,7,8}),
            Arguments.of(new int[]{1,2,3,4}, null, new int[]{1,2,3,4}),
            Arguments.of(null, null, null),
            Arguments.of(new int[]{}, null, new int[]{}),
            Arguments.of(null, new int[]{}, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource(value = "inputIntegerArrays")
    void mergeTwoIntegerArraysAndSortTheResult(int[] array1, int[] array2, int[] expectedOutput) {
        int[] result = underTest.mergeSortedArrays(array1, array2);
        assertThat(result).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @MethodSource(value = "inputIntegerArrays")
    void mergeTwoIntegerArraysAndSortTheResultUsingQuickSort(int[] array1, int[] array2, int[] expectedOutput) {
        int[] result = underTest.mergeSortedArraysQuickSort(array1, array2);
        assertThat(result).isEqualTo(expectedOutput);
    }

}
