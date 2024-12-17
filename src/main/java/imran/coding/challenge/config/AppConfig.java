package imran.coding.challenge.config;

import imran.coding.challenge.design.RateLimiterChallenge;
import imran.coding.challenge.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TestService testService() {
        return new TestService();
    }

    @Bean
    public RateLimiterChallenge rateLimiterChallenge() {
        return new RateLimiterChallenge(3, 5);
    }
}
