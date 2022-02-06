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

    @GetMapping("/getAll")
    public ResponseEntity<Response> getAllSubmissions () {
        Response response = new Response(
                submissionService.getAllSubmissions(),
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveSubmission (@RequestBody Submission submission) {
        Response response = new Response(
                submissionService.saveSubmissionForm(submission),
                HttpStatus.CREATED.value()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
