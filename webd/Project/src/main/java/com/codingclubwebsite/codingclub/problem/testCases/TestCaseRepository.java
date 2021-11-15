package com.codingclubwebsite.codingclub.problem.testCases;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface TestCaseRepository extends CrudRepository<TestCase,String> {
    public List<TestCase> findAllByProblemId(String id);
}
