package com.gt.demo.service;

import com.gt.demo.model.Submission;
import com.gt.demo.respository.SubmissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private CodeifyService codeifyService;

    public List<Submission> getAllSubmissions() {
        log.info("[SubmissionService] Getting all submissions...");
        return submissionRepository.findAll();
    }

    @Async
    public Submission saveSubmissionForm(Submission submission, String feedbackStatus) {
        log.info("[SubmissionService] Saving single form submission...");

        if (feedbackStatus == null) {
            submission.setFeedbackStatus("unprocessed");
            codeifyService.updateFeedbackStatus(submission);
        } else {
            submission.setFeedbackStatus(feedbackStatus);
        }

        return submissionRepository.save(submission);
    }
}
