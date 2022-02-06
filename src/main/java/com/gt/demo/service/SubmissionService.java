package com.gt.demo.service;

import com.gt.demo.model.Submission;
import com.gt.demo.respository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;

    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public Submission saveSubmissionForm(Submission submission) {
        submission.setFeedbackStatus("Processing");
        return submissionRepository.save(submission);
    }
}
