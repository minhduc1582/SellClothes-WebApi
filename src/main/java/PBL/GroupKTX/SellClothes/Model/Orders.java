package PBL.GroupKTX.SellClothes.Model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="orders")
@Data
public class Orders {
	@Id
	@Column(name="idorder")
	private int idOrder;
	@Column(name="uid",nullable=true)
	private String uID;
	@Column(name="totalamount",nullable=true)
	private int totalAmount;
	@Column(name="state",nullable=true)
	private String state;
//	@OneToMany(mappedBy = "orders")
//	private List shipmentDetails;
//	private Set<User> users;
}
