package com.API_Req_Res;

import java.util.ArrayList;
import java.util.List;


	public class Addbook {

	    public String userId;
	    public List<ISBN> collectionOfIsbns;
	    
	    //As of now this is for adding a single book, later we will add another constructor.
	    //That will take a collection of ISBN to add multiple books
	    public Addbook(String userId, ISBN collectionOfIsbns){
	        this.userId = userId;
	        this.collectionOfIsbns = new ArrayList<ISBN>();
	        this.collectionOfIsbns.add(collectionOfIsbns);
	    }
	}
