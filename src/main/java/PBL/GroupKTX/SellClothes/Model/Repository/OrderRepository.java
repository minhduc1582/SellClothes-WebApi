package PBL.GroupKTX.SellClothes.Model.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import PBL.GroupKTX.SellClothes.Model.Orders;
import PBL.GroupKTX.SellClothes.Model.Dto.AdminOrder;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

	@Query(value = "SELECT orders.uID,shipmentdetail.name,shipmentdetail.phone,shipmentdetail.address,shipmentdetail.city,orders.state,shipmentdetail.time,orders.totalAmount "
			+ "FROM orders INNER JOIN shipmentdetail ON orders.idOrder = shipmentdetail.idOrder WHERE orders.state = 'confirmed'",nativeQuery = true)
	public List<Object[]> getAdminOrderbyId();
	@Query(value = "DELETE FROM orders WHERE orders.uID = ?1",nativeQuery = true)
	public void deleteOrderByUID(String uid);
	@Query(value = "select * FROM orders WHERE orders.uID = ?1",nativeQuery = true)
	public List<Orders> getOrdersByUID(String uid);
	@Query(value = "select * FROM orders WHERE orders.uID = ?1 and orders.state = ?2 and orders.totalAmount = ?3",nativeQuery = true)
	public Orders GetOrderByBody(String uID, String state, int totalAmount);
}
