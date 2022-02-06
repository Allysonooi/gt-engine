package com.gt.demo.config;

import com.gt.demo.model.Submission;
import com.gt.demo.respository.SubmissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DatabaseConfig {
    @Bean
    CommandLineRunner initDatabase(SubmissionRepository submissionRepository) {
        return args -> {
            Submission submission1 = Submission.builder().name("A").email("a@a.com").contactNo("123").agencyName("aN").feedback("aF").feedbackStatus("Unprocessed").build();
            Submission submission2 = Submission.builder().name("B").email("b@b.com").contactNo("123456").agencyName("bN").feedback("bF").feedbackStatus("Unprocessed").build();

            log.info("Preloading " + submissionRepository.save(submission1));
            log.info("Preloading " + submissionRepository.save(submission2));
            log.info("Loading All: " + submissionRepository.findAll());
        };
    }
}
