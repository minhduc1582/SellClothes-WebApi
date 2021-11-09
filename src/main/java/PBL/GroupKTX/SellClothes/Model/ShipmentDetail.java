package PBL.GroupKTX.SellClothes.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="shipmentdetail")
@Data
public class ShipmentDetail {
	@Id
	private int id;
	private String name;
	private String phone;
	private String address;
	private String city;
	private int idorder;
//	private Set<Oder> oders;
}
