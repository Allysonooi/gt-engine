package com.gt.demo.service;

import com.gt.demo.model.Submission;
import com.gt.demo.respository.SubmissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private CodeifyService codeifyService;

    public List<Submission> getSubmissionsByEmailAndContact(String email, String contactNo) {
        log.info("[SubmissionService] Getting all submissions...");
        return submissionRepository.findByEmailAndContactNo(email, contactNo);
    }

    @Async
    public Submission saveSubmissionForm(Submission submission) {
        String feedbackStatus = codeifyService.getFeedbackStatus(submission);
        submission.setFeedbackStatus(feedbackStatus);

        log.info("[SubmissionService] Saving Submission...");
        return submissionRepository.save(submission);
    }
}
