package com.spring.basic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MayilaiMuthu
 * @apiNote 04-03-2023
 *
 */
@Data
@Entity
@Table(name = "CUSTOMER_INFO")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

	// spring.batch.job.enabled=false add application.properties

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	public Integer id;
	@Column(name = "FIRST_NAME")
	public String firstName;
	@Column(name = "LAST_NAME")
	public String lastName;
	@Column(name = "EMAIL")
	public String email;
	@Column(name = "GENDER")
	public String gender;
	@Column(name = "CONTACT_NO")
	public String contactNo;
	@Column(name = "COUNTRY")
	public String country;
	@Column(name = "DOB")
	public String dob;

}
