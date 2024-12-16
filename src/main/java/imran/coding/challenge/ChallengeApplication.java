package imran.coding.challenge;

import imran.coding.challenge.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(ApplicationContext ctx, TestService testService) {
		System.out.println("Running main program in " + ctx.getId());
		return args -> testService.run();
	}

}
