package PBL.GroupKTX.SellClothes.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="detailorder")
@Data
public class DetailOrder {
	@Id
	@Column(name="iddetailorder")
	private int idDetailOrder;
	private int quantity;
	@Column(name="idproduct")
	private int idProduct;
	@Column(name="idorder")
	private int idOrder;
//	private Set<Product> Product;
//	private Set<Oder> oders;
}
