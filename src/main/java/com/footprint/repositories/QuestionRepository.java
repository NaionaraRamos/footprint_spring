package com.footprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.footprint.models.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

	@Query(value = "SELECT * FROM question WHERE status='ativo' AND title!='' ORDER BY id ASC", nativeQuery = true)
	List<Question> listActiveQuestions();
	
//	@Query(value = "INSERT INTO question IF title!=''")
//	public void inserirPergunta(String pergunta);
	
	//@Query(value = "INSERT INTO user (name, surname, mail, password) VALUES (:name, :surname, :mail, :password) IF ")
}