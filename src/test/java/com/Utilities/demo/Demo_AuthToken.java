package com.Utilities.demo;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Demo_AuthToken {

	
	public static  String authToken() {
		
	String token=	given()
		      .baseUri(Demo_ConfigureManager.uri_config("QA")).accept(ContentType.JSON).contentType(ContentType.JSON)
		      .body(Demo_ConfigureManager.login_cred("QC")).log().uri().log().method().log().body().log().headers()
	   .when()
	          .post("login")
	   .then()
	          .extract().body().jsonPath().getString("data.token");
	System.out.println("///////////////////////////////////////////"+ token);
	
	return token;
	
	
	}
}
