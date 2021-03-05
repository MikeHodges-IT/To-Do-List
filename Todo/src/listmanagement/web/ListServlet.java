package listmanagement.web;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import listmanagement.dao.ListDOA;
import listmanagement.model.TodoItem;
import trace.Trace;
/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ListDOA listDao;
    public void init() {
    	listDao = new ListDOA();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getServletPath();
		 Trace.trace(action);
	        try {
	            switch (action) {
	                case "/new":
	                    showNewForm(request, response);
	                    break;
	                case "/insert":
	                    insertTodoItem(request, response);
	                    break;
	                case "/delete":
	                	deleteItem(request, response);
	                    break;
	                case "/edit":
	                    showEditForm(request, response);
	                    break;
	                case "/update":
	                    updateListItem(request, response);
	                    break;
	                default:
	                	listItems(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	 }
	private void insertTodoItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String itemTitle = request.getParameter("itemTitle");
        String itemDetails = request.getParameter("itemDetails");
        String itemComplete = request.getParameter("itemComplete");
        int complete = 0;
        System.out.println(itemComplete);
          if(itemComplete != null) {complete = 1;}
        TodoItem todoItem = new TodoItem(itemTitle, itemDetails, complete);
        listDao.saveTodoItem(todoItem);
        response.sendRedirect("list");
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ItemEntryForm.jsp");
        dispatcher.forward(request, response);
	}
	private void updateListItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        String itemTitle    = request.getParameter("itemTitle");
        String itemDetails  = request.getParameter("itemDetails");
        String itemComplete = request.getParameter("itemComplete");
        int complete = 0;
        System.out.println(itemComplete);
          if(itemComplete != null) {complete = 1;}
        TodoItem todoItem = new TodoItem(itemId, itemTitle, itemDetails, complete);
        listDao.updateTodoItem(todoItem);
        response.sendRedirect("list");
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TodoItem existingItem = listDao.getTodoItem(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ItemEntryForm.jsp");
        request.setAttribute("todoItem", existingItem);
        dispatcher.forward(request, response);
	}
	private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        listDao.deleteTodoItem(id);
        response.sendRedirect("list");
	}
	private void listItems(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        request.setAttribute("todolist", listDao.getAllTodoItems());
        RequestDispatcher dispatcher = request.getRequestDispatcher("ItemList.jsp");
        dispatcher.forward(request, response);
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

 }
