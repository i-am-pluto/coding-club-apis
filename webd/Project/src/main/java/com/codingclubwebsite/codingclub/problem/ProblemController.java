package com.codingclubwebsite.codingclub.problem;

import com.codingclubwebsite.codingclub.problem.examples.Example;
import com.codingclubwebsite.codingclub.problem.examples.ExampleRepository;
import com.codingclubwebsite.codingclub.problem.testCases.TestCase;
import com.codingclubwebsite.codingclub.problem.testCases.TestCaseRepository;
import com.codingclubwebsite.codingclub.responses.DeleteRequestResponse;
import com.codingclubwebsite.codingclub.responses.PostRequestResponse;
import com.codingclubwebsite.codingclub.responses.PutRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProblemController {

    @Autowired
    private ExampleRepository exampleRepository;
    @Autowired
    private TestCaseRepository testCaseRepository;

    @Autowired
    private ProblemRepository problemRepository;

    /*
    * Add a problem
    * Update a problem
    * Delete a problem
    * Get all problems
    * Get one problem
     */

    @PostMapping("/problemset/add")
    public PostRequestResponse addProblem(@RequestBody ProblemTemplate problemTemplate){

        Problem problem = generateProblemFromTemplate(problemTemplate);
        problem.setSno((int) (problemRepository.count()+1));
        problemRepository.save(problem);
        return new PostRequestResponse("Request Accepted",problem.getProblemId(),"The request to add a problem was accepted");

    }

    @PutMapping("/problemset/{id}/update")
    public PutRequestResponse updateProblem(@PathVariable String id, @RequestBody ProblemTemplate problemTemplate){

        for(TestCase testCase: testCaseRepository.findAllByProblemId(id)){
            testCaseRepository.deleteById(testCase.getTestCaseId());
        }

        for(Example example: exampleRepository.findAllByProblemId(id)){
            exampleRepository.deleteById(example.getExampleId());
        }

        Problem problem = generateProblemFromTemplate(problemTemplate);
        problemRepository.save(problem);
        return new PutRequestResponse("Update Problem Request Accepted",problem.getProblemId(),"the problem has been updated");

    }

    @DeleteMapping("/problemset/{id}/delete")
    public DeleteRequestResponse deleteProblem(@PathVariable String id){

        for(TestCase testCase: testCaseRepository.findAllByProblemId(id)){
            testCaseRepository.deleteById(testCase.getTestCaseId());
        }

        for(Example example: exampleRepository.findAllByProblemId(id)){
            exampleRepository.deleteById(example.getExampleId());
        }

        problemRepository.deleteById(id);
        return new DeleteRequestResponse("Delete Request Accepted","","The problem was deleted");

    }

    @RequestMapping ("/problemset")
    public ArrayList<ProblemTemplate> getAllProblems(){
        
        ArrayList<ProblemTemplate> problems=new ArrayList<>();
        for(Problem problem : problemRepository.findAll()){
            problems.add(generateProblemTemplateFromProblem(problem));
        }
        return problems;
    }

    @RequestMapping("problemset/{id}")
    public ProblemTemplate getAProblem(@PathVariable String id){
        Problem problem = problemRepository.findById(id).get();
        return generateProblemTemplateFromProblem(problem);
    }

    
    private Problem generateProblemFromTemplate(ProblemTemplate problemTemplate){

        for(Example example : problemTemplate.getExamples()){
            exampleRepository.save(example);
        }

        for(TestCase testCase : problemTemplate.getTestCases()){
            testCaseRepository.save(testCase);
        }
        return new Problem(problemTemplate.getProblemId(), problemTemplate.getStatement(),problemTemplate.getSno(),problemTemplate.getDiff(),problemTemplate.getSubmissions(),problemTemplate.getTimeLimit());

    }
    private ProblemTemplate generateProblemTemplateFromProblem(Problem problem){
        
        List<Example> examples = exampleRepository.findAllByProblemId(problem.getProblemId());
        List<TestCase> testCases = testCaseRepository.findAllByProblemId(problem.getProblemId());
        return new ProblemTemplate(problem.getProblemId(), problem.getStatement(),problem.getSno(),problem.getDiff(),problem.getSubmissions(),examples,testCases,problem.getTimeLimit());

    }


}
