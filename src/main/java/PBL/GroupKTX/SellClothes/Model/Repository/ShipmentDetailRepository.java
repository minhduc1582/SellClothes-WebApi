package PBL.GroupKTX.SellClothes.Model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import PBL.GroupKTX.SellClothes.Model.ShipmentDetail;

public interface ShipmentDetailRepository extends JpaRepository<ShipmentDetail, Integer>{
	@Query(value = "select * from ShipmentDetail where Phone = ?1",nativeQuery = true)
	public List<ShipmentDetail> findAllByPhone(String Phone);

}
