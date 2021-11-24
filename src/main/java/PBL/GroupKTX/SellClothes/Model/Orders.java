package PBL.GroupKTX.SellClothes.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="orders")
@Data
public class Orders {
	@Id
	@Column(name="idorder")
	private int idOrder;
	@Column(name="uid")
	private String uID;
	@Column(name="totalamount")
	private int totalAmount;
	private String state;
//	private Set<User> users;
}
