package com.gt.demo.respository;

import com.gt.demo.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findByEmailAndContactNo(String email, String contactNo);
}
