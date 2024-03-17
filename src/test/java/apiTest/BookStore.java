package apiTest;


import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.API_Req_Res.Addbook;
import com.API_Req_Res.AuthorizationRequest;
import com.API_Req_Res.ISBN;
import com.API_Req_Res.RemoveBook;

import io.restassured.RestAssured;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

	public class BookStore {

	    private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
	    private static final String BASE_URL = "https://bookstore.toolsqa.com";

	    private static String token;
	    private static Response response;
	    private static String jsonString;
	    private static String bookId;

	    @Test(priority=1)

	    public void iAmAnAuthorizedUser() {
	        AuthorizationRequest credentials = new AuthorizationRequest("TOOLSQA-Test","Test@@123");

	        RestAssured.baseURI = BASE_URL;
	        RequestSpecification request = RestAssured.given();

	        request.header("Content-Type", "application/json");
	        response = request.body(credentials).post("/Account/v1/GenerateToken");

	        String jsonString = response.asString();
	        token = JsonPath.from(jsonString).get("token");
	    }

	    @Test(priority=2)
	    public void listOfBooksAreAvailable() {
	        RestAssured.baseURI = BASE_URL;
	        RequestSpecification request = RestAssured.given();
	        response = request.get("/BookStore/v1/Books");

	        jsonString = response.asString();
	        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");

	        bookId = books.get(0).get("isbn");
	    }

	    @Test(priority=3)
	    public void addBookInList() {

	        Addbook addBooksRequest = new Addbook(USER_ID, new ISBN(bookId));

	        RestAssured.baseURI = BASE_URL;
	        RequestSpecification request = RestAssured.given();
	        request.header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json");

	          response = request.body(addBooksRequest).post("/BookStore/v1/Books");

	    }

	    @Test(priority=3)
	    public void bookIsAdded() {
	        Assert.assertEquals(201, response.getStatusCode());
	    }

	    @Test(priority=4)
	    public void removeBookFromList() {
	        RestAssured.baseURI = BASE_URL;
	        RequestSpecification request = RestAssured.given();
	        RemoveBook removeBookRequest = new RemoveBook(USER_ID, bookId);
	        request.header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json");

	        response = request.body(removeBookRequest).delete("/BookStore/v1/Book");
	    }

	    @Test(priority=5)
	    public void bookIsRemoved(){
	        Assert.assertEquals(204, response.getStatusCode());

	        RestAssured.baseURI = BASE_URL;
	        RequestSpecification request = RestAssured.given();

	        request.header("Authorization", "Bearer " + token)
	                .header("Content-Type", "application/json");

	        response = request.get("/Account/v1/User/" + USER_ID);
	        Assert.assertEquals(200, response.getStatusCode());

	        jsonString = response.asString();
	        List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
	        Assert.assertEquals(0, booksOfUser.size());
	    }

	}