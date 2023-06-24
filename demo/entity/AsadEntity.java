package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ACCOUNT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsadEntity {
	@Id()
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String actName;
	private Long accGroupId;
	private BigDecimal accountBalance;
	private String actCode;
	private Boolean makeSubAccount = false;
	private String discription;
	private Long accSubGroupId;
	private String orgCode;

}
