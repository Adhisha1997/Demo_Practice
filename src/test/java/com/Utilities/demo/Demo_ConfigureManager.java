package com.Utilities.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

import org.mozilla.javascript.ast.SwitchCase;

import com.POJO.Demo_LoginCredentials;

import static com.POJO.Demo_LoginCredentials.*;

public class Demo_ConfigureManager {

	// URL CONFIG
	public static String uri_config(String env) {

		String path;
		Properties prop = new Properties();
		//env.toUpperCase();

		switch (env) {
		case "QA" -> path = "/src/test/resources/Configure/config.qa.properties";
		case "DEV" -> path = "/src/test/resources/Configure/config.DEV.properties";
		default -> path = "/src/test/resources/Configure/config.qa.properties";
		}

		File prop_file = new File(System.getProperty("user.dir") + path);
		FileReader filereader = null;
		try {
			filereader = new FileReader(prop_file);
			prop.load(filereader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("BASEURI");

	}

	// LOGIN CREDENTIALS

	public static Demo_LoginCredentials login_cred(String role) {

		Demo_LoginCredentials cred = null;

		if (role.equalsIgnoreCase("FRONT")) {
			cred = new Demo_LoginCredentials("iamfd", "password");
		} else if (role.equalsIgnoreCase("sup")) {
			cred = new Demo_LoginCredentials("iamsup", "password");
		} else if (role.equalsIgnoreCase("eng")) {
			cred = new Demo_LoginCredentials("iameng", "password");
		} else if (role.equalsIgnoreCase("QC")) {
			cred = new Demo_LoginCredentials("iamqc", "password");
		}
		return cred;

	}

}
