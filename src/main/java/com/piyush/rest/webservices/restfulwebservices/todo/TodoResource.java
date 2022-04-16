package com.piyush.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class TodoResource {

	@Autowired // This allows spring to manage our dependencies
	private ToDoHardCodedService todoService;

	// Get all requests mapping
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return todoService.findAll();
	}

	// Get specific todo
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable long id) {
		return todoService.findById(id);
	}

	// Delete mapping by id
	@DeleteMapping("/users/{username}/todos/{id}") // From a delete method we either return new content or some sort of
	public ResponseEntity<Void> deleteTodosByID(@PathVariable String username, @PathVariable long id) {
		Todo todo = todoService.deleteById(id);
		if (todo != null) {
			//returns no content if request is succcessfull
			return ResponseEntity.noContent().build();
		}
		//else return not found status
		return ResponseEntity.notFound().build();
	}

	//This is a Put mapping used to update the request
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodosByID(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {//Recieving the requestbody using annotations
		Todo newTodo = todoService.save(todo);
		//ResponseEntity gives us more options on how we deal with a response to an api call for example below we send back the new todo and a 200 status code
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	//This is a Post mapping to add a new record
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Todo> newTodosByID(@PathVariable String username, @RequestBody Todo todo) {//Recieving the requestbody using annotations
		
		//get the details of the created todo
		Todo createdTodo = todoService.save(todo);
		
		//Taking the current path and appending "/{newid}"
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		//ResponseEntity returns a status called created and returns the new uri to as a response
		return ResponseEntity.created(uri).build();
	}

}
