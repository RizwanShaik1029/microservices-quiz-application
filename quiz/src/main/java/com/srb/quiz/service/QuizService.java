package com.srb.quiz.service;

import com.srb.quiz.feign.QuizInterface;
import com.srb.quiz.model.QuestionWrapper;
import com.srb.quiz.model.Response;
import com.srb.quiz.repository.QuizRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.srb.quiz.model.Quiz;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizInterface quizInterface;

    @Autowired
    private QuizRepositoy quizRepo;

    public ResponseEntity<String> createQuiz(String category, int num, String title)
    {
        List<Integer> questions = quizInterface.getQuestionByCategoryAndLimit(category,num).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);

        quizRepo.save(quiz);
        return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Quiz quiz = quizRepo.findById(id).get();

        List<Integer> questionIds = quiz.getQuestionIds();
        return quizInterface.getQuestionsByIds(questionIds);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
        ResponseEntity<Integer> score = quizInterface.getScore(response);
        return score;
    }
}
