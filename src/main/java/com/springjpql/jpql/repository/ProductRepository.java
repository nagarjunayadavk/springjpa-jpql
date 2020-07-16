package com.springjpql.jpql.repository;

import java.beans.Expression;
import java.util.List;

import javax.persistence.criteria.Path;

import org.hibernate.query.criteria.internal.predicate.BooleanExpressionPredicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springjpql.jpql.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

//	private static EntityManagerFactory entityManagerFactory =
//	          Persistence.createEntityManagerFactory("product");
	
	@Query(value = "select * from product p where p.name LIKE %:name%", nativeQuery = true)
	List<Product> findSimilarProductsByName(String name);
	
////	@Query(" p.name LIKE %:name%" )
//	@NamedQuery
//	
//	List<Product> findAll(String name);
	
//	EntityManager em = entityManagerFactory.createEntityManager();
//    Query query = em.createQuery(
//            "select * from product p where p.name LIKE %:name%");
	
	@Query(value = "select * from product p where p.name = :value", nativeQuery = true)
	List<Product> searchProducts(String column, String value);

	
}
