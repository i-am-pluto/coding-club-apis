package com.codingclubwebsite.codingclub.problem.examples;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExampleRepository extends CrudRepository<Example,String> {
    public List<Example> findAllByProblemId(String id);
}
