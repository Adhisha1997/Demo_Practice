package com.Demo.Api.test;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.Utilities.demo.Demo_AuthToken;
import com.Utilities.demo.Demo_ConfigureManager;

import io.restassured.http.ContentType;
import io.restassured.http.Header;

public class Demo_UserDetails_Test {

	@Test
	public static void userDetails() {
		
		Header auth_header = new Header("Authorization",Demo_AuthToken.authToken());
		
		given()
		   .baseUri(Demo_ConfigureManager.uri_config("QA")).contentType(ContentType.JSON).accept(ContentType.JSON)
		   .header(auth_header).log().uri().log().method().log().headers()
	   .when()
	       .get("userdetails")
	   .then()
	       .statusCode(200).log().all();
 	}
	
}
