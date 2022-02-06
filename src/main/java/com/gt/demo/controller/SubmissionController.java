package com.gt.demo.controller;

import com.gt.demo.model.Response;
import com.gt.demo.model.Submission;
import com.gt.demo.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @GetMapping()
    public ResponseEntity<Response> getSubmissions (@RequestParam String email, @RequestParam  String contactNo) {

        Response response = new Response(
                submissionService.getSubmissionsByEmailAndContact(email, contactNo),
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Response> createSubmission (@RequestBody Submission submission) {
        submission.setFeedbackStatus("unprocessed");

        Response response = new Response(
                submissionService.saveSubmissionForm(submission),
                HttpStatus.CREATED.value()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
