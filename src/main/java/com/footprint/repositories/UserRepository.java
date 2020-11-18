package com.footprint.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.footprint.dto.UserDto;
import com.footprint.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByMail(String mail);
	
	@Query(value = "INSERT INTO user_permission VALUES (1, :id)", nativeQuery = true)
	public void insertPermission(Long id);
	
	@Query(value = "INSERT INTO user (name, surname, mail, password) VALUES (:name, :surname, :mail, :password) IF name!=''", nativeQuery = true)
	public UserDto insertUser(@Param("name") String name, @Param("surname") String surname, @Param("mail") String mail, @Param("password") String password);
}