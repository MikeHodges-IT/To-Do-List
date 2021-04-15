package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import listmanagement.dao.ListDOA;
import listmanagement.model.TodoItem;

class UnitTest {
	@Test
	void test() {
		ListDOA listDoa = new ListDOA();
		listDoa.deleteAllTodoItem();
		listDoa.saveTodoItem(new TodoItem("Single Constructor"));
		listDoa.saveTodoItem(new TodoItem("Double","Constructor"));
		listDoa.saveTodoItem(new TodoItem("Triple","Constructor",0));
		List <TodoItem> lti = listDoa.getAllTodoItems();
		lti.forEach(x -> {x.setItemTitle("Updated"); listDoa.updateTodoItem(x);});
		lti.forEach(x -> {listDoa.getTodoItem(x.getItemId());});
		listDoa.deleteAllTodoItem();
		
		listDoa.saveTodoItem(new TodoItem("Module 2 Assignment","Write a simple to-do-item application in Java. It should support the following features Make sure to structure your program in a modular way. In this case, that means you would have ",1));
		listDoa.saveTodoItem(new TodoItem("Module 5 Assignment","Convert your \"To Do List\" application from Module 2 to use Hibernate in order to save its data. ",1));
		listDoa.saveTodoItem(new TodoItem("Module 7 Assignment","Update your \"To Do List\" application. Add a web UI, so that it runs on the Tomcat web server",1));
		listDoa.saveTodoItem(new TodoItem("Module 8 Assignment","Use JMeter to perform load testing on your \"To Do List\" application's web UI. Submit screen shots of JMeter, showing the resulting performance numbers and graphs.",1));
		listDoa.saveTodoItem(new TodoItem("Module 9 Assignment","Implement WAR file deployment of your \"To Do List\" web application. ",1));
		listDoa.saveTodoItem(new TodoItem("Module 11 Assignment","Change your \"To Do List\" web application such that it contains an injection vulnerability, and demonstrate how it can be exploited.",1));
		listDoa.saveTodoItem(new TodoItem("Module 12 Assignment","Add a build process to your \"To Do List\" web application",1));
		listDoa.saveTodoItem(new TodoItem("Module 13 Assignment","Add a service layer to your \"To Do List\" web application. ",0));
		
		lti = listDoa.getAllTodoItems();
		lti.forEach(x -> System.out.println(x.toString()));
	}
}



