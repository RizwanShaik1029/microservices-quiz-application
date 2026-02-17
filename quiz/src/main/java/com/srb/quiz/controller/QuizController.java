package com.srb.quiz.controller;

import com.srb.quiz.model.QuestionWrapper;
import com.srb.quiz.model.QuizDto;
import com.srb.quiz.model.Response;
import com.srb.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto)
    {
        return quizService.createQuiz(quizDto.getCategory(), quizDto.getNum(),quizDto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id)
    {
        return quizService.getQuizQuestions(id);
    }

    @GetMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz( @PathVariable Integer id, @RequestBody List<Response> response)
    {
        return quizService.calculateResult(id,response);
    }

}
