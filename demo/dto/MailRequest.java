package com.example.demo.dto;

import lombok.Data;

@Data
public class MailRequest {

	private String name;
	private String to;
	private String from;
	private String subject;
}
