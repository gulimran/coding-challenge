package imran.coding.challenge.service;

import imran.coding.challenge.algorithm.SortingChallenge;
import imran.coding.challenge.datastructure.StringsChallenge;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class TestService {

    @Autowired
    private StringsChallenge stringsChallenge;

    @Autowired
    private SortingChallenge sortingChallenge;

    public void run() {
        System.out.println("StringsChallenge first non-repeating character in 'swiss' is= "
            + stringsChallenge.firstNonRepeatingChar("swiss"));

        System.out.println("SortingChallenge merging two lists {1,2,3,4} and {5,6,7,8} = "
            + Arrays.toString(sortingChallenge.mergeSortedArrays(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8})));
    }
}
