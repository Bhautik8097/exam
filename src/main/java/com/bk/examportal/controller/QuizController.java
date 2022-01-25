package com.bk.examportal.controller;


import com.bk.examportal.model.exam.Category;
import com.bk.examportal.model.exam.Quiz;
import com.bk.examportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;


    @PostMapping("/")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
        Quiz quiz1 = this.quizService.addQuiz(quiz);
        return ResponseEntity.ok(quiz1);
    }

    @GetMapping("/{quizId}")
    public Quiz getQuiz(@PathVariable("quizId") Long quizId){
        return this.quizService.getQuiz(quizId);
    }

    @GetMapping("/")
    public ResponseEntity<?> getQuizzes(){
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long quizId){
        this.quizService.deleteQuiz(quizId);
    }

    @GetMapping("/category/{cid}")
    public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid){
        Category category = new Category();
        category.setcId(cid);
        return this.quizService.getQuizzesOfCategory(category);
    }

    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes(){
        return  this.quizService.getActiveQuizzes();
    }

    @GetMapping("/category/active/{cid}")
    public List<Quiz> getActiveQuizzes(@PathVariable("cid") Long cid){
        Category category = new Category();
        category.setcId(cid);
        return this.quizService.getActiveQuizzesOfCategory(category);
    }
}
