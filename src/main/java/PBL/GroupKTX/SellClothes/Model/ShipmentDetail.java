package PBL.GroupKTX.SellClothes.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="shipmentdetail")
@Data
public class ShipmentDetail {
	@Id
	@Column(name="idshipment")
	private int idShipment;
	private String name;
	private String phone;
	private String address;
	private String city;
	@Column(name="idorder")
	private int idOrder;
	private String time;
	private String date;
//	private Set<Oder> oders;
}
