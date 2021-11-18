package PBL.GroupKTX.SellClothes.Model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import PBL.GroupKTX.SellClothes.Model.DetailOrder;

public interface DetailOrderRepository extends JpaRepository<DetailOrder, Integer> {
	@Query(value = "select Detailorder.* from Detailorder inner join order on Detailorder.idOrder = Order.id "
			+ "where Order.PhoneUser =?1", nativeQuery = true)
	public List<DetailOrder> getDetailOrdersByPhone(String phone);
	
}
