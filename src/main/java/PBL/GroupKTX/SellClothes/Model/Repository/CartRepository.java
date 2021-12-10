package PBL.GroupKTX.SellClothes.Model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import PBL.GroupKTX.SellClothes.Model.Dto.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	@Query(value="SELECT product.pid, product.pname, product.price, detailorder.quantity, detailorder.idDetailorder FROM orders "
			+ "INNER JOIN detailorder ON orders.idOrder = detailorder.idOrder "
			+ "INNER JOIN product on detailorder.pid = product.pid WHERE orders.uID = ?1",nativeQuery = true)
	public List<Object[]> getListCartByUID(String uID);
}
