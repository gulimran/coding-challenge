package imran.coding.challenge.design;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateLimiterChallengeTest {

    private static final int REQUEST_LIMIT = 3;
    private static final int TIME_WINDOW = 5;
    private static final String USER_ID = "userId1";

    private RateLimiterChallenge underTest;


    @BeforeEach
    void setup() {
        underTest = new RateLimiterChallenge(REQUEST_LIMIT, TIME_WINDOW);
    }

    @Test
    void allowFirstRequestFromUser() {
        assertThat(underTest.allowRequest(USER_ID)).isEqualTo(true);
    }

    @Test
    void doNotAllowFourthRequestFromUser() {
        for (int i=0; i<3; i++) underTest.allowRequest(USER_ID);

        assertThat(underTest.allowRequest(USER_ID)).isEqualTo(false);
    }

    @Test
    void allowFourthRequestFromUser_IfTimeWindowExpires() throws Exception {
        for (int i=0; i<3; i++) underTest.allowRequest(USER_ID);

        Thread.sleep(TIME_WINDOW * 1000 + 1);

        assertThat(underTest.allowRequest(USER_ID)).isEqualTo(true);
    }

    @Test
    void allowFourthRequestFromUser_IfTimeWindowForOnlyFirstRequestExpires() throws Exception {
        underTest.allowRequest(USER_ID);
        Thread.sleep(3 * 1000);

        for (int i=0; i<2; i++) underTest.allowRequest(USER_ID);
        Thread.sleep(2 * 1000 + 1);

        assertThat(underTest.allowRequest(USER_ID)).isEqualTo(true);
    }

}
