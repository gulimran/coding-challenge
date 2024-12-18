package imran.coding.challenge.service;

import imran.coding.challenge.algorithm.SortingChallenge;
import imran.coding.challenge.concurrency.ThreadSafeSingleton;
import imran.coding.challenge.datastructure.StringsChallenge;
import imran.coding.challenge.design.RateLimiterChallenge;
import imran.coding.challenge.files.WordCountChallenge;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class TestService {

    @Autowired
    private StringsChallenge stringsChallenge;

    @Autowired
    private SortingChallenge sortingChallenge;

    @Autowired
    private RateLimiterChallenge rateLimiterChallenge;

    @Autowired
    private WordCountChallenge wordCountChallenge;

    public void run() {
        System.out.println("StringsChallenge first non-repeating character in 'swiss' is= "
            + stringsChallenge.firstNonRepeatingChar("swiss"));

        System.out.println("SortingChallenge merging two arrays {1,2,3,4} and {5,6,7,8} = "
            + Arrays.toString(sortingChallenge.mergeSortedArrays(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8})));
        System.out.println("SortingChallenge merging two arrays using quick sort {1,2,3,4} and {5,6,7,8} = "
            + Arrays.toString(sortingChallenge.mergeSortedArraysQuickSort(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8})));

        String userId = "userId1";
        System.out.println("RateLimiterChallenge allow 1st request = "
            + rateLimiterChallenge.allowRequest(userId));
        System.out.println("RateLimiterChallenge allow 2nd request = "
            + rateLimiterChallenge.allowRequest(userId));
        System.out.println("RateLimiterChallenge allow 3rd request = "
            + rateLimiterChallenge.allowRequest(userId));
        System.out.println("RateLimiterChallenge allow 4th request = "
            + rateLimiterChallenge.allowRequest(userId));

        System.out.println("ThreadSafeSingleton get single instance of the class = "
            + ThreadSafeSingleton.getInstance().toString() + " is same as another instance = "
            + ThreadSafeSingleton.getInstance().toString());

        String fileName = "src/main/resources/word-count.txt";
        try {
            System.out.println("WordCountChallenge to count words in the given file '" + fileName + "'  = "
                + wordCountChallenge.wordCount(fileName));
        } catch (Exception e) {
            System.out.println("WordCountChallenge unable to count words in the given file '" + fileName + "'");
        }
    }
}
