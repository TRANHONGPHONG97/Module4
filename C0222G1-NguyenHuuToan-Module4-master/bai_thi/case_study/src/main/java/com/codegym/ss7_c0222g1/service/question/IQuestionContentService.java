package com.codegym.ss7_c0222g1.service.question;

import com.codegym.ss7_c0222g1.model.customer.Customer;
import com.codegym.ss7_c0222g1.model.question.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionContentService {
    Page<QuestionContent> findAllByTitle(String title, Pageable pageable);

    void save(QuestionContent questionContent);

     void delete(QuestionContent questionContent);

     QuestionContent findById (Integer id);
}
