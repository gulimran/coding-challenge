package imran.coding.challenge.datastructure;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class NumbersChallenge {

    /**
     * A Pythagorean triple consists of three positive integers
     * a, b, and c, such that a^2 + b^2 = c^2. Such a triple is
     * commonly written (a, b, c), and a well-known example is
     * (3, 4, 5).  Another example is (8, 15, 17).
     *
     * Implement the method Solution.containsPythagoras(final
     * Collection numbers) returns a boolean that returns true
     * if any three numbers in the collection form a Pythagorean
     * triple, otherwise return false.
     *
     * Focus on correctness of solution and accounting for edge
     * cases. Performance is not being evaluated.
     *
     * Notes:
     *
     * The array is not sorted
     * The triplets can occur in any order and in any position in the array
     * The numbers should be from 1 to 2000
     * The size of the array may contain up to 2000 integers
     *
     * Examples:
     * [3,4,5] -> true
     * [5,1,3,2,4] -> true
     * [3,4,6] -> false
     * [5,3,7,5,6,11] -> false
     * [1,6,10,9,7,8] -> true
     *
     * @param numbers - A Collection<Integer> of integer numbers
     * @return true if the collection contains at least one pythagorean triple */
    public boolean containsPythagoras(final Collection<Integer> numbers) {

        int firstSquaredValue = 0;
        int secondSquaredValue = 0;
        int thirdSquaredValue = 0;

        for (Integer number : numbers) {
            firstSquaredValue = number * number;

            for (Integer number2 : numbers) {
                secondSquaredValue = number2 * number2;

                for (Integer number3 : numbers) {
                    thirdSquaredValue = number3 * number3;

                    if (thirdSquaredValue == secondSquaredValue + firstSquaredValue
                        || secondSquaredValue == firstSquaredValue + thirdSquaredValue
                        || firstSquaredValue == secondSquaredValue - thirdSquaredValue) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
