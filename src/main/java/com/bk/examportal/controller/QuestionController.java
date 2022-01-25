package com.bk.examportal.controller;


import com.bk.examportal.model.exam.Question;
import com.bk.examportal.model.exam.Quiz;
import com.bk.examportal.service.QuestionService;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/")
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
        Question question1 = this.questionService.addQuestion(question);
        return  ResponseEntity.ok(question1);
    }

    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    @GetMapping("/quiz/{questionId}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("questionId") Long questionId){
//        Quiz quiz = new Quiz();
//        quiz.setqId(questionId);
//        Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);
        Quiz quiz = new Quiz();
        Set<Question> questions = quiz.getQuestions();
        List<Question> list = new ArrayList(questions);
        if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())){
            list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }

        list.forEach((q) -> {
            q.setAnswer("");
        });

        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{quesId}")
    public Question get(@PathVariable("quesId") Long quesId){
        return this.questionService.getQuestion(quesId);
    }

    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId){
        this.questionService.deleteQuestion(quesId);
    }

    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
        System.out.println(questions);
        double marksGot = 0;
        int correctAnswer = 0;
        int attempted = 0;

        for (Question q: questions){
            Question question = this.questionService.get(q.getQuesId());
                if(question.getAnswer().equals(q.getGivenAnswer())){
                    correctAnswer++;

                    double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
                    marksGot +=marksSingle;
                }

                if(q.getGivenAnswer() == null || q.getGivenAnswer().trim().equals("")){
                    attempted++;
                }

            };
//        org.hibernate.mapping.Map

        Map<String, Object> map = new HashMap<>();
        map.put("marksGot",marksGot);
        map.put("correctAnswer",correctAnswer);
       // = Map.of("marksGot",marksGot,"correctAnswer",correctAnswer);
        return ResponseEntity.ok(map);
    }

}