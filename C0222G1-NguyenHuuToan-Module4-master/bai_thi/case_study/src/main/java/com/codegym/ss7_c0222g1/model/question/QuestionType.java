package com.codegym.ss7_c0222g1.model.question;

import com.codegym.ss7_c0222g1.model.customer.Customer;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "question_type")
public class QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_type_id", columnDefinition = "INT")
    private Integer questionTypeId;

    @Column(name = "question_type_name", columnDefinition = "VARCHAR(45)")
    private String questionTypeName;

    @OneToMany(mappedBy = "questionType")
    private Set<QuestionContent> questionContents;

    public QuestionType() {
    }

    public QuestionType(Integer questionTypeId, String questionTypeName, Set<QuestionContent> questionContents) {
        this.questionTypeId = questionTypeId;
        this.questionTypeName = questionTypeName;
        this.questionContents = questionContents;
    }

    public Integer getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }

    public Set<QuestionContent> getQuestionContents() {
        return questionContents;
    }

    public void setQuestionContents(Set<QuestionContent> questionContents) {
        this.questionContents = questionContents;
    }


}
