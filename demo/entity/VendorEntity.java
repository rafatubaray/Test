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
@Data
@Table(name="vendor_info")
@AllArgsConstructor
@NoArgsConstructor
public class VendorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String vendor_name;
	private Long invoice_no;
	private String reference;
	private Long grand_total;
	private Long discount;
	private Long net_amount;
}
