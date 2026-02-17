package com.srb.questions.service;

import com.srb.questions.model.Questions;
import com.srb.questions.model.QuestionsDto;
import com.srb.questions.model.Response;
import com.srb.questions.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepo;

    public List<Questions> getAllQuestion() {
        return questionRepo.findAll();
    }

    public ResponseEntity<String> addQuestions(List<Questions> questions) {
        for(Questions q: questions)
            questionRepo.save(q);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> getQuestionByCatAndLimit(String category, int num)
    {
        List<Integer> ids = questionRepo.getQuestionsByCatoryAndLimit(category,num);

        return new ResponseEntity<>(ids, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionsDto>> getQuetionsByIds(List<Integer> ids) {
        List<Questions> question = new ArrayList<>();
        List<QuestionsDto> dto = new ArrayList<>();

        for(Integer id : ids)
        {
            Optional<Questions> q = questionRepo.findById(id);
            if(q.isPresent())
                question.add(q.get());
        }

        for(Questions ques:question)
        {
            QuestionsDto qd = new QuestionsDto();

            qd.setId(ques.getId());
            qd.setQuestionTitle(ques.getQuestionTitle());
            qd.setOption1(ques.getOption1());
            qd.setOption2(ques.getOption2());
            qd.setOption3(ques.getOption3());
            qd.setOption4(ques.getOption4());
            dto.add(qd);

        }

        return new ResponseEntity<>(dto, HttpStatus.OK);

    }

    public ResponseEntity<List<Questions>> getQuestionsByCat(String category) {
        return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);

    }

    public ResponseEntity<Integer> getScore(List<Response> response) {

        int ans=0;
        for(Response res : response)
        {
            Questions question = questionRepo.findById(res.getId()).get();
            if(res.getResponse().equals(question.getCorrectAnswer()))
                ans++;
        }


        return new ResponseEntity<>(ans,HttpStatus.OK);
    }
}
