package com.luxoft.springdb.lab2.dao.jpa;

import lombok.Setter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class AbstractJpaDao {
	@Setter(onMethod_ = @PersistenceUnit)
	protected EntityManagerFactory entityManagerFactory;
}