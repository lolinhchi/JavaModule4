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



	public int getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public int getParentId() {
		return parentId;
	}



	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	/*
	 * public static void main(String[] args) { Category cat = new Category();
	 * System.out.println(Integer.toHexString(cat.hashCode()));
	 * System.out.println(cat.toString()); }
	 */

}
