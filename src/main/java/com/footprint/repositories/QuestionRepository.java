package com.footprint.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.footprint.models.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	Optional<Question> findById(Long id);

	@Query(value = "SELECT * FROM question WHERE status='ativo' AND title!='' ORDER BY id ASC", nativeQuery = true)
	List<Question> listActiveQuestions();
	
}