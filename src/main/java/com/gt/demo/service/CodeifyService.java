package com.gt.demo.service;

import com.gt.demo.model.Feedback;
import com.gt.demo.model.Submission;
import com.gt.demo.respository.SubmissionRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class CodeifyService {
    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private SubmissionService submissionService;

    @Value("${codeify.submission.url}")
    private String codeifySubmissionUrl;

    public void updateFeedbackStatus(Submission submission) {
        log.info("[CodeifyService] Retrieving Feedback Status...");

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(codeifySubmissionUrl)
                .queryParam("feedback", submission.getFeedback());

        ResponseEntity<Feedback> response = restTemplate.getForEntity(builder.toUriString(), Feedback.class);
        String feedbackStatus = response.getBody().getStatus();

        log.info("[CodeifyService] Updating Feedback Status...");
        submissionService.saveSubmissionForm(submission, feedbackStatus);
    }
}
