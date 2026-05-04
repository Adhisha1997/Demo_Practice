package com.Demo.Api.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.Test;

import com.Utilities.demo.Demo_ConfigureManager;

import io.restassured.http.ContentType;

public class Demo_Login_Test {

	@Test
	public void login() {

		 given().baseUri(Demo_ConfigureManager.uri_config("qa")).accept(ContentType.JSON).contentType(ContentType.JSON)
				.body(Demo_ConfigureManager.login_cred("front")).log().headers().log().method().log().body().log().uri()
		.when().post("login")
		.then().log().all().statusCode(200).time(lessThan(1500L)).body("message", equalTo("Success")).body("data.token", notNullValue());

	}
}
