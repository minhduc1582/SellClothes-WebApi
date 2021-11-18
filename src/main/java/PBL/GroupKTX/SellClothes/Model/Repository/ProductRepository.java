package PBL.GroupKTX.SellClothes.Model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import PBL.GroupKTX.SellClothes.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query(value = "select * from Product where Name like %?1%", nativeQuery = true)
	public List<Product> findProductByName(String nameProduct);
	
	@Query(value ="select * from Product where idCategory = ?1", nativeQuery = true)
	public List<Product> findProductsByIdCategory(int idCategory);
	
	@Query(value = "select product.* from product INNER JOIN detailorder ON product.id = detailorder.idOrder Where detailorder.idOrder = ?1", nativeQuery = true)
	public List<Product> findProductByIdOrder(int idOrder); 
}
