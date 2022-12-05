package javaBeans;

import java.io.Serializable;

public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int categoryId;
	private String categoryName;
	private int parentId;
	
	
	public Category() {
		super();
	}
	public int getId() {
		return categoryId;
	}
	public void setId(int id) {
		this.categoryId = id;
	}
	public String getName() {
		return categoryName;
	}
	public void setName(String name) {
		this.categoryName = name;
	}
	public int getParent() {
		return parentId;
	}
	public void setParent(int parent) {
		this.parentId = parent;
	}
	

}
