package com.foo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foo.jms.Email;

@RestController
public class EmailController {

	@Autowired
    private JmsTemplate jmsTemplate;
	
	@GetMapping("/email/{to}")
	public void sentEmail(@PathVariable("to") String to, @RequestParam("content") String content) {
		Email email = new Email(to, content);
		this.jmsTemplate.convertAndSend("mailbox", email);
	}
	
}
