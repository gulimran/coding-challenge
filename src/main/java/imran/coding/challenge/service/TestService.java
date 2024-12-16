package imran.coding.challenge.service;

import imran.coding.challenge.datastructure.StringsChallenge;
import org.springframework.beans.factory.annotation.Autowired;

public class TestService {

    @Autowired
    private StringsChallenge stringsChallenge;

    public void run() {
        System.out.println("StringsChallenge first non-repeating character in 'swiss' is= "
            + stringsChallenge.firstNonRepeatingChar("swiss"));
    }
}
