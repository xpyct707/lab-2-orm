package com.luxoft.springdb.lab2.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter(onMethod_ = {
			@Id,
			@GeneratedValue,
			@Column(nullable = false)})
	private int id;

	@Getter(onMethod_ = @Column)
	private String name;

	@Getter(onMethod_ = @Column(name = "code_name"))
	private String codeName;


	public Country(int id, String name, String codeName) {
		this.id = id;
		this.name = name;
		this.codeName = codeName;
	}

	public Country(String name, String codeName) {
		this.name = name;
		this.codeName = codeName;
	}
}
