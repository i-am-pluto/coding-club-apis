package com.codingclubwebsite.codingclub.problem.examples;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExampleRepository extends CrudRepository<Example,String> {
    public List<Example> findAllByProblemId(String id);
}
