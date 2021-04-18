package listmanagement.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import listmanagement.model.TodoItem;
import listmanagement.util.HibernateUtil;
import trace.Trace;

public class ListDOA {
    /**
     * Save todoItem
     * @param todoItem
     */
    public void  saveTodoItem(TodoItem todoItem) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the object
            session.save(todoItem);
            // commit transaction
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
       Trace.trace("Saved >>"+todoItem.toString());
    }
    /**
     * Update TodoItem
     * @param TodoItem
     */
    public void updateTodoItem(TodoItem todoItem) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the object
            session.update(todoItem);
            Trace.trace("Updated >>"+todoItem.toString());
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    /**
     * Delete TodoItem
     * @param id
     */
    public void deleteTodoItem(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // Delete a object
            TodoItem todoItem = session.get(TodoItem.class, id);
            if (todoItem != null) {
            	 Trace.trace("Deleted >>"+todoItem.toString());
                session.delete(todoItem);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
     }

    /**
     * Get TodoItem By ID
     * @param id
     * @return
     */
    public TodoItem getTodoItem(int id) {
        Transaction transaction = null;
        TodoItem todoItem = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            todoItem = session.get(TodoItem.class, id);
            Trace.trace("Get   >>>>"+todoItem.toString());
            // commit transaction
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return todoItem;
    }
    /**
     * Get all TodoItem
     * @return
     */
    @SuppressWarnings("unchecked")
	public List < TodoItem > getAllTodoItems() {
        Transaction transaction = null;
        List < TodoItem > listOfUser = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession();)  {
            // start a transaction
            transaction = session.beginTransaction();
            // get an object
            listOfUser = session.createQuery("from TodoItem ti ORDER BY ti.itemId DESC").getResultList();
            // commit transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
         return listOfUser;
    }
    /**
     * Delete All TodoItem
     * @param id
     */
    public void deleteAllTodoItem() {
    	List <TodoItem> list = getAllTodoItems();
    	list.forEach( x -> deleteTodoItem(x.getItemId()));
    	}
}
