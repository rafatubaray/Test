package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="purchase_info")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class PurchaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String vendor_name;
	private Long invoice_no;
	private String reference;
	private String product;
	private Long quantity;
	private Long rate;
	private Long total;
	private Long grand_total;
	private Long discount;
	private Long net_amount;
	

}
