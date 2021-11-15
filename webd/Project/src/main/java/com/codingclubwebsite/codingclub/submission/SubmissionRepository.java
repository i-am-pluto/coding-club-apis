package com.codingclubwebsite.codingclub.submission;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubmissionRepository extends CrudRepository {
    List<SubmissionController> findAllByPending(Boolean pending);
}
