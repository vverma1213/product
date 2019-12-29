package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
	
	@Query("select p from Product p where p.seller like %?1")
	public List<Product> getNumberOfProductBySeller(String seller);
}
