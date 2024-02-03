package com.tamilcreations.estorepublicaccess.productDetailView;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductDetailViewRepo extends JpaRepository<ProductDetailView, Long>, JpaSpecificationExecutor<ProductDetailView>
{
	
	@Query(value="SELECT * FROM ProductDetailView pdv where pdv.product_id > :after AND pdv.product_name  LIKE %:productName% ORDER BY pdv.product_id ASC LIMIT :limit", nativeQuery=true)
	List<ProductDetailView> getAllActiveProductDetailsWithStocksPriceAndDiscounts(String productName, int limit);

	@Query(value = "SELECT * FROM ProductDetailView WHERE CASE WHEN :after IS NOT NULL THEN product_id > :after AND product_name LIKE %:productName% WHEN :before IS NOT NULL THEN product_id < :before AND product_name LIKE %:productName% ELSE product_name LIKE %:productName% END ORDER BY product_id ASC LIMIT :limit", nativeQuery = true)
	//@Query(value="SELECT * FROM ProductDetailView pdv where pdv.product_id > :after AND pdv.product_name  LIKE %:productName% ORDER BY pdv.product_id ASC LIMIT :limit", nativeQuery=true)
	List<ProductDetailView> getAllActiveProductDetailsWithStocksPriceAndDiscounts(@Param("productName") String productName, @Param("limit") int limit, @Param("after") Long after,@Param("before") Long before);
}
