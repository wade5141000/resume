package com.sedia.resume.controller;

import java.util.HashMap;

public class BaseController {
	private HashMap results = new HashMap<String, String>(){{
		put("State", ERROR);
		put("Message", MESSAGE);
	}};
	
	final String ERROR = "ERROR";
	final String OK = "OK";
	final String MESSAGE = "Message";
}
