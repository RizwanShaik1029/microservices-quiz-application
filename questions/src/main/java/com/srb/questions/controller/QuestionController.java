package com.srb.questions.controller;

import com.srb.questions.model.Questions;
import com.srb.questions.model.QuestionsDto;
import com.srb.questions.model.Response;
import com.srb.questions.service.QuestionService;
import jakarta.persistence.PostRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.RescaleOp;
import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions()
    {
        return new ResponseEntity<>(questionService.getAllQuestion(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestions(@RequestBody List<Questions> question)
    {
        return questionService.addQuestions(question);
    }

    @GetMapping("/getQuestionsBYCatogeryAndLimit")
    public ResponseEntity<List<Integer>> getQuestionByCategoryAndLimit(@RequestParam String category, @RequestParam int num)
    {
        return questionService.getQuestionByCatAndLimit(category,num);
    }

    @PostMapping("/getQuestionsByIds")
    public ResponseEntity<List<QuestionsDto>> getQuestionsByIds(@RequestBody List<Integer> ids)
    {
        return questionService.getQuetionsByIds(ids);
    }


    @GetMapping("/ByCategory/{category}")
    public ResponseEntity<List<Questions>> getQuestionsByCat(@PathVariable String category)
    {
        return questionService.getQuestionsByCat(category);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> response)
    {
        return questionService.getScore(response);
    }


}
