package com.codegym.ss7_c0222g1.service.question;

import com.codegym.ss7_c0222g1.model.question.QuestionContent;
import com.codegym.ss7_c0222g1.repository.question.QuestionContentRepository;
import com.codegym.ss7_c0222g1.repository.question.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionContentService implements IQuestionContentService {

    @Autowired
    private QuestionContentRepository questionContentRepository;

    @Override
    public Page<QuestionContent> findAllByTitle(String title, Pageable pageable) {
        return questionContentRepository.findAllTitle(title,pageable);
    }

    @Override
    public void save(QuestionContent questionContent) {
        questionContentRepository.save(questionContent);
    }

    @Override
    public void delete(QuestionContent questionContent) {
        questionContentRepository.delete(questionContent);
    }

    @Override
    public QuestionContent findById(Integer id) {
        return questionContentRepository.findById1(id);
    }
}
