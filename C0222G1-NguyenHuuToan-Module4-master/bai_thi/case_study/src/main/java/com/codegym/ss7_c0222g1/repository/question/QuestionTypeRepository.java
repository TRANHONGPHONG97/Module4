package com.codegym.ss7_c0222g1.repository.question;

import com.codegym.ss7_c0222g1.model.question.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface QuestionTypeRepository extends JpaRepository<QuestionType, Integer> {
}
