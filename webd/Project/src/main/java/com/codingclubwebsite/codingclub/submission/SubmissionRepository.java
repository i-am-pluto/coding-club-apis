package com.codingclubwebsite.codingclub.submission;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepository extends CrudRepository<SubmissionEntity,String> {
//    List<SubmissionEntity> findAllByPending(Boolean pending);
}
