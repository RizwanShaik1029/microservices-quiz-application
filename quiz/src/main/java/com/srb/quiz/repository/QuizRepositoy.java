package com.srb.quiz.repository;

import com.srb.quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepositoy extends JpaRepository<Quiz,Integer> {

}
