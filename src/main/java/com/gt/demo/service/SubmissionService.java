package com.gt.demo.service;

import com.gt.demo.model.Submission;
import com.gt.demo.respository.SubmissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;

    public List<Submission> getAllSubmissions() {
        log.info("[SubmissionService] Getting all submissions...");
        return submissionRepository.findAll();
    }

    public Submission saveSubmissionForm(Submission submission) {
        log.info("[SubmissionService] Saving single form submission...");
        submission.setFeedbackStatus("Processing");
        return submissionRepository.save(submission);
    }
}
