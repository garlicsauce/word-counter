package io.test.wordcounter;

import io.test.wordcounter.service.WordCounter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WordCounterApplication {

	private final WordCounter wordCounter;

	public WordCounterApplication(WordCounter wordCounter) {
		this.wordCounter = wordCounter;
	}

	public static void main(String[] args) {
		SpringApplication.run(WordCounterApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			if (args.length < 1) {
				throw new IllegalArgumentException("Path to file has to be passed as an argument");
			}

			wordCounter.process(args[0])
				.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
		};
	}

}
