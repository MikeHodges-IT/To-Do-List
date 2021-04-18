package listmanagement.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import listmanagement.dao.ListDOA;
import listmanagement.model.TodoItem;

@Path("/ToDoService")
 public class ToDoService {
	private ListDOA listDao = new ListDOA();
    @GET 
    @Path("/xml") 
    @Produces(MediaType.APPLICATION_XML) 
    public Response getAllXml() {
       	XStream xstream = new XStream();
      	xstream.alias("TodoItem", List.class);
      	String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?> \n"
      					+	xstream.toXML(listDao.getAllTodoItems());
        return Response.ok().entity(xmlString).build();
    }
	@GET 
    @Path("/json") 
    @Produces(MediaType.APPLICATION_JSON) 
    public Response getAllJason(){
		String jsonString = new Gson().toJson(listDao.getAllTodoItems());
        return Response.ok().entity(jsonString).build();
    }
	private ListDOA listAllDao = new ListDOA();
    @GET 
    @Path("/xml/{todoid}") 
    @Produces(MediaType.APPLICATION_XML) 
    public Response getXml(@PathParam("todoid") int todoid) {
       	XStream xstream = new XStream();
      	xstream.alias("TodoItem", List.class);
      	String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?> \n"
      					+	xstream.toXML(listDao.getTodoItem(todoid));
        return Response.ok().entity(xmlString).build();
    }
	@GET 
    @Path("/json/{todoid}") 
    @Produces(MediaType.APPLICATION_JSON) 
    public Response getJason(@PathParam("todoid") int todoid){
		String jsonString = new Gson().toJson(listDao.getTodoItem(todoid));
        return Response.ok().entity(jsonString).build();
    }
	@DELETE
	@Path("/todo/{todoid}")
	@Produces(MediaType.APPLICATION_XML)
	   public String deleteTodo(@PathParam("todoid") int todoid){
	     listDao.deleteTodoItem(todoid);
	     return "Deleted: " + todoid;
	}
	@POST
	@Path("/todo/{todoname}/{tododesc}/")
	@Produces(MediaType.APPLICATION_XML)
	   public String newTodo(@PathParam("toname") String itemTitle, @PathParam("tododesc") String itemDetails){
		TodoItem todoItem = new TodoItem(itemTitle, itemDetails); 
		listDao.saveTodoItem(todoItem);
	     return "Insert Success: ";
	}
	
	
}