package com.codegym.ss7_c0222g1.repository.question;

import com.codegym.ss7_c0222g1.model.customer.Customer;
import com.codegym.ss7_c0222g1.model.question.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface QuestionContentRepository extends JpaRepository<QuestionContent, Integer> {

    @Query(value = "select * from question_content where title like %:titlei% ", nativeQuery = true)
    Page<QuestionContent> findAllTitle(@Param("titlei") String titlei, Pageable pageable);

    @Modifying
    @Query(value = "select * from question_content where question_content_id like %:idi% ", nativeQuery = true)
    QuestionContent findById1(@Param("idi") Integer idi);

}
