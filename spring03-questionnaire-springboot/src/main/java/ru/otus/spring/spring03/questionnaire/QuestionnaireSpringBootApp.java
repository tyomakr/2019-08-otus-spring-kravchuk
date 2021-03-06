package ru.otus.spring.spring03.questionnaire;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.otus.spring.spring03.questionnaire.service.QuestionService;
import ru.otus.spring.spring03.questionnaire.service.QuestionServiceImpl;

@SpringBootApplication
public class QuestionnaireSpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(QuestionnaireSpringBootApp.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			QuestionService questionService = ctx.getBean(QuestionServiceImpl.class);
			questionService.startQuestions();
		};
	}


}
