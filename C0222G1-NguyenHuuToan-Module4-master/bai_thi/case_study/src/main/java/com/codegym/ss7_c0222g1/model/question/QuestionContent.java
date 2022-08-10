package com.codegym.ss7_c0222g1.model.question;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "question_content")
public class QuestionContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_content_id", columnDefinition = "INT")
    private Integer questionContentId;

    @ManyToOne
    @JoinColumn(name = "question_type_id", referencedColumnName = "question_type_id", columnDefinition = "INT")
    private QuestionType questionType;

    @Column(name = "title", columnDefinition = "VARCHAR(45)")
    private String title;

    @Column(name = "content", columnDefinition = "VARCHAR(45)")
    private String content;

    @Column(name = "answer", columnDefinition = "VARCHAR(45)")
    private String answer;

    @Column(name = "date_create", columnDefinition = "DATE")
    private String dateCreate;

    @Column(name = "status", columnDefinition = "VARCHAR(45)")
    private String status;

    public QuestionContent() {
    }

    public QuestionContent(Integer questionContentId, QuestionType questionType, String title, String content, String answer, String dateCreate, String status) {
        this.questionContentId = questionContentId;
        this.questionType = questionType;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.dateCreate = dateCreate;
        this.status = status;
    }

    public Integer getQuestionContentId() {
        return questionContentId;
    }

    public void setQuestionContentId(Integer questionContentId) {
        this.questionContentId = questionContentId;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
