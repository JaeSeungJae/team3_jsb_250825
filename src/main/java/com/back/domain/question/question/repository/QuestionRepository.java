package com.back.domain.question.question.repository;

import com.back.domain.question.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Page<Question> findBySubjectContaining(String subject, Pageable pageable);
    Page<Question> findByContentContaining(String content, Pageable pageable);
    Page<Question> findBySubjectContainingOrContentContaining(String subject, String content, Pageable pageable);

    Question findFirstByOrderByIdDesc();
}
