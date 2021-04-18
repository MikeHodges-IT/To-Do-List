package listmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author Mike Hodges
 * 
 *         CEN 4025C Software Development II Summer 2020 Dr. Dhrgam AL Kafaf
 * 
 * 
 *
 */
@Entity
@Table(name = "todoitems")
public class TodoItem  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue()
	@Column(name = "itemId", unique = true)
	private int itemId;
	
	@Column(name = "itemTitle", nullable = false)
	private String itemTitle;
	
	@Column(name = "itemDetails", nullable = false)
	private String itemDetails;
	
	@Column(name = "itemCompleted", nullable = false)
	private int itemCompleted;
   
	private static int TRUE = 1;
	private static int FALSE = 0;

	public TodoItem() {
		super();
		this.itemTitle = "No Title";
		this.itemDetails = "No Details";
		this.itemCompleted = FALSE;
	}
	
	/**
	 * @param itemTitle
	 */
	public TodoItem(String itemTitle) {
		super();
		this.itemTitle = itemTitle;
		this.itemDetails = "No Details";
		this.itemCompleted = FALSE;
	}

	/**
	 * @param itemTitle
	 * @param itemDetails
	 */
	public TodoItem( String itemTitle, String itemDetails) {
		super();
		this.itemTitle = itemTitle;
		this.itemDetails = itemDetails;
		this.itemCompleted = FALSE;
	}

	/**
	 * @param itemTitle
	 * @param itemDetails
	 * @param itemComplete
	 */
	public TodoItem(String itemTitle, String itemDetails, int itemCompleted) {
		super();
		this.itemTitle = itemTitle;
		this.itemDetails = itemDetails;
		this.itemCompleted = itemCompleted;
	}


	public TodoItem(int itemId, String itemTitle, String itemDetails, int itemCompleted) {
		super();
		this.itemId = itemId;
		this.itemTitle = itemTitle;
		this.itemDetails = itemDetails;
		this.itemCompleted = itemCompleted;
	}

	/**
	 * @return the itemTitle
	 */
 	public String getItemTitle() {
		return itemTitle;
	}

	/**
	 * @param itemTitle the itemTitle to set
	 */ 
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	/**
	 * @return the itemDetails
	 */
	public String getItemDetails() {
		return itemDetails;
	}

	/**
	 * @param itemDetails the itemDetails to set
	 */ 
	public void setItemDetails(String itemDetails) {
		this.itemDetails = itemDetails;
	}

	/**
	 * @return the itemComplete
	 */
	public int getItemComplete() {
		return itemCompleted;
	}

	/**
	 * 
	 * @param itemCompleted  the itemCompleted to set
	 */
	public void setItemComplete(int itemCompleted) {
		this.itemCompleted = itemCompleted;
	}

	/**
	 * @return the itemNumber
	 */
	public int getItemId() {
		return itemId;
	}

	@Override
	public String toString() {
		return "TodoItem [ itemId= " + itemId + ", itemTitle= " + itemTitle + ", itemDetails= " + itemDetails
				+ ", itemComplete= " + itemCompleted + " ]";
	}

}

