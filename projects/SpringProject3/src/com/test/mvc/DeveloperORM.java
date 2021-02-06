// ORM CLASS TO CONNECT TO  MYSQL SCHEMA-TABLE
// Santiago Garcia Arango
package com.test.mvc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "developers")
public class DeveloperORM {

	@Id
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

	public java.sql.Date getBirthday_date() {
		return birthday_date;
	}

	public void setBirthday_date(java.time.LocalDate birthday_date) {
		this.birthday_date = java.sql.Date.valueOf(birthday_date);
	}

	public String getMain_language() {
		return main_language;
	}

	public void setMain_language(String main_language) {
		this.main_language = main_language;
	}

	public java.sql.Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(java.time.LocalDate registration_date) {
//		this.registration_date = registration_date;
	}

	@Override
	public String toString() {
		return "DevelopersORM [id=" + id + ", name=" + name + ", birthday_date=" + birthday_date
				+ ", registration_date=" + registration_date + "]";
	}

}
