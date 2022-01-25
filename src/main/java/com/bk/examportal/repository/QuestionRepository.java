package com.bk.examportal.repository;

import com.bk.examportal.model.exam.Question;
import com.bk.examportal.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
