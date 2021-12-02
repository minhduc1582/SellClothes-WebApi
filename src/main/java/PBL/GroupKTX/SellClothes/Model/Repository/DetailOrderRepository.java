package PBL.GroupKTX.SellClothes.Model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import PBL.GroupKTX.SellClothes.Model.DetailOrder;

public interface DetailOrderRepository extends JpaRepository<DetailOrder, Integer> {
	@Query(value = "select detailorder.* from detailorder inner join orders on detailorder.idDetailorder = orders.idOrder "
			+ "where orders.uID = ?1", nativeQuery = true)
	public List<DetailOrder> getDetailOrdersByPhone(String phone);
	@Query(value= "SELECT * FROM detailorder WHERE detailorder.idOrder = ?1 AND detailorder.pid = ?2", nativeQuery = true)
	public List<DetailOrder> getDetailOrdersByPidandOid(String idOrder,String productID);
}
