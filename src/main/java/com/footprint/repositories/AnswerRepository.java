package com.footprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.footprint.models.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{}