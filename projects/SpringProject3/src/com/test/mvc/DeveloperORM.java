// ORM CLASS TO CONNECT TO  MYSQL SCHEMA-TABLE
// Santiago Garcia Arango
package com.test.mvc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "developers")
public class DeveloperORM {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "main_language")
	private String main_language;

	@Column(name = "birthday_date")
	private java.sql.Date birthday_date;

	@Column(name = "registration_date")
	private java.sql.Date registration_date;

	public DeveloperORM() {
	}

	public DeveloperORM(String name, String main_language, java.time.LocalDate birthday_date,
			java.time.LocalDate registration_date) {
		this.name = name;
		this.main_language = main_language;

		// Convert java.time.LocalDate format to java.sql.Date format
		this.birthday_date = java.sql.Date.valueOf(birthday_date);
		this.registration_date = java.sql.Date.valueOf(registration_date);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.sql.Date getBirthdayDate() {
		return birthday_date;
	}

	public void setBirthdayDate(java.time.LocalDate birthday_date) {
		this.birthday_date = java.sql.Date.valueOf(birthday_date);
	}

	public String getMainLanguage() {
		return main_language;
	}

	public void setMainLanguage(String main_language) {
		this.main_language = main_language;
	}

	public java.sql.Date getRegistrationDate() {
		return registration_date;
	}

	public void setRegistrationDate(java.time.LocalDate registration_date) {
//		this.registration_date = registration_date;
	}

	@Override
	public String toString() {
		return "DeveloperORM [id=" + id + ", name=" + name + ", main_language=" + main_language + ", birthday_date="
				+ birthday_date + ", registration_date=" + registration_date + "]";
	}

}
