package com.piyush.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service //So instances are not created
public class ToDoHardCodedService {

	// This will act as our hardcoded database we create static vars add data to them then return whenever the public  function find all is called
	private static List<Todo> todos = new ArrayList();
	private static int idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "in28minutes", "Learn to dance", new Date(), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Learn to Microservices", new Date(), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Learn to Angular", new Date(), false));
	}

	public List<Todo> findAll() {
		return todos;
	}
	
	public Todo deleteById(long id){
		Todo todo = findById(id);
		if(todo == null) {
			return null;
		}
		else {
			
			todos.remove(todo);
			return todo;
			
		}
		
	}
	
	public Todo findById(long id) {
		
		for(Todo todo: todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		
		return null;
		
	}
	
	public Todo save(Todo todo) {
		
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(idCounter++);
			todos.add(todo);
			
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		
		return todo;
		
	}

}
