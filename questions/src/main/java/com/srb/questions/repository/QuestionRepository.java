package com.srb.questions.repository;

import com.srb.questions.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer> {

    @Query("select q.id from Questions q where q.category=:category order by RAND() LIMIT :num")
    List<Integer> getQuestionsByCatoryAndLimit(String category, int num);

    List<Questions> findByCategory(String category);
}
