package com.piyush.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Below we make use of JpaRepository extension to communicate with the created db
//We provide the object/db we are trying to manage and the type of the primary key
//The tag below tells spring we are dealing with a repository
@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long> {
	
	//Here we are searching by username
	List<Todo> findByUsername(String username);

}
