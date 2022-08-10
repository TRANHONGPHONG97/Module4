package com.codegym.ss7_c0222g1.controller;

import com.codegym.ss7_c0222g1.model.customer.Customer;
import com.codegym.ss7_c0222g1.model.question.QuestionContent;
import com.codegym.ss7_c0222g1.model.question.QuestionType;
import com.codegym.ss7_c0222g1.repository.question.QuestionContentRepository;
import com.codegym.ss7_c0222g1.repository.question.QuestionTypeRepository;
import com.codegym.ss7_c0222g1.service.question.QuestionContentService;
import com.codegym.ss7_c0222g1.service.question.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionContentService questionContentService;

    @Autowired
    private QuestionTypeService questionTypeService;

    @GetMapping("/list")
    public String showList(@RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "title", defaultValue = "") String title,
                           Model model) {
        Sort sort = Sort.by("question_content_id");
        Page<QuestionContent> questionContentList = questionContentService.findAllByTitle(title, PageRequest.of(page, 3, sort));
        model.addAttribute("questionContent", new QuestionContent());
        model.addAttribute("questionContentList", questionContentList);
        model.addAttribute("title", title);
        return "/question/QuestionList";
    }

    @GetMapping("/create")
    public String showCreateQuestionContent(Model model) {
        model.addAttribute("questionContent", new QuestionContent());
        model.addAttribute("listQuestionType", questionTypeService.findAll());
        return "/question/QuestionAdd";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("questionContent") QuestionContent questionContent, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listCustomerType", questionTypeService.findAll());
            return "/customer/CustomerAdd";
        } else {
            questionContentService.save(questionContent);
            return "redirect:/question/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Integer id) {
        QuestionContent questionContent = questionContentService.findById(id);
        questionContentService.delete(questionContent);
        return "redirect:/question/list";
    }
}
