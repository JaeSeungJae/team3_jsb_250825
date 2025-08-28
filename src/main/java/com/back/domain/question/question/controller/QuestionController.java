package com.back.domain.question.question.controller;

import com.back.domain.question.question.entity.Question;
import com.back.domain.question.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/list")
    @Transactional(readOnly = true)
    public String showList(Model model) {
        List<Question> questions = questionService.findByAll();
        model.addAttribute("questions", questions);
        return "question/question/list";
    }

    @GetMapping("/{id}/detail")
    @Transactional(readOnly = true)
    public String showDetail(@PathVariable int id, Model model) {
        Question question = questionService.findById(id);
        model.addAttribute("question", question);
        return "question/question/detail";
    }
}
