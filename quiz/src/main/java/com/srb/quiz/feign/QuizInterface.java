package com.srb.quiz.feign;

import com.srb.quiz.model.QuestionWrapper;
import com.srb.quiz.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("questions/getQuestionsBYCatogeryAndLimit")
    public ResponseEntity<List<Integer>> getQuestionByCategoryAndLimit(@RequestParam String category, @RequestParam int num);


    @PostMapping("questions/getQuestionsByIds")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsByIds(@RequestBody List<Integer> ids);

    @PostMapping("questions/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> response);

}
