package com.luxoft.springdb.lab2.dao.jpa;

import com.luxoft.springdb.lab2.dao.CountryDao;
import com.luxoft.springdb.lab2.model.Country;
import lombok.var;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {
	@Override
	public void save(Country country) {
		executeWithEntityManager(entityManager -> {
			var transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(country);
			transaction.commit();
		});
	}

	private void executeWithEntityManager(Consumer<EntityManager> executor) {
		var entityManager = entityManagerFactory.createEntityManager();
		executor.accept(entityManager);
		entityManager.close();
	}

	@Override
	public List<Country> getAllCountries() {
		return getWithEntityManager(entityManager ->
				entityManager
						.createQuery("from Country", Country.class)
						.getResultList());
	}

	private <T> T getWithEntityManager(Function<EntityManager, T> executor) {
		var entityManager = entityManagerFactory.createEntityManager();
		var result = executor.apply(entityManager);
		entityManager.close();
		return result;
	}

	@Override
	public Country getCountryByName(String name) {
		return getWithEntityManager(entityManager -> entityManager
				.createQuery("SELECT c FROM Country c WHERE c.name LIKE :name", Country.class)
				.setParameter("name", name)
				.getSingleResult());
	}
}
