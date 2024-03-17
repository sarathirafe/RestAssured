package com.API_Req_Res;

public class RemoveBook {
	
	   public String isbn;
	   public String userId;

	    public RemoveBook(String userId, String isbn) {
	    	this.userId = userId;
	    	this.isbn = isbn;
	    }
}
