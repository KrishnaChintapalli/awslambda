package com.serverless.hello.function;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.serverless.hello.function.dao.PersonDao;
import com.serverless.hello.function.modal.Person;

/**
 * Lambda function that simply prints "Hello World" if the input String is not
 * provided, otherwise, print "Hello " with the provided input String.
 */
public class HelloWorld implements RequestHandler<Map<String,String>, Object> {
	private PersonDao personDao;

	public Object handleRequest(Map input, Context context) {
		personDao = Application.getBean(PersonDao.class);
		LambdaLogger logger = context.getLogger();
		logger.log("Input: " + input);
		Person p = new Person();
		p.setAddress(input.get("address").toString());
		p.setCardno(input.get("cardno").toString());
		p.setName(input.get("name").toString());
		//
		personDao.save(p);
		logger.log(p.toString());

		 
		return p;
		
	}

	

}