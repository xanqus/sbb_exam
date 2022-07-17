package com.mysite.sbb.Answer.service;

import com.mysite.sbb.Answer.dao.AnswerRepository;
import com.mysite.sbb.Answer.domain.Answer;
import com.mysite.sbb.Question.domain.Question;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setReplyLike(false);
        this.answerRepository.save(answer);
    }

    public void setLike(int answerId) {
        Answer answer = answerRepository.findById(answerId).get();
        if(answer.getReplyLike()==true) {
            answer.setReplyLike(false);
        } else {
            answer.setReplyLike(true);
        }
        this.answerRepository.save(answer);

    }
}
