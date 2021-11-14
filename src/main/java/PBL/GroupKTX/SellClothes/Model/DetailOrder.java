package PBL.GroupKTX.SellClothes.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="detailorder")
@Data
public class DetailOrder {
	@Id
	private int id;
	private int quantity;
	private int idproduct;
	private int idorder;
//	private Set<Product> Product;
//	private Set<Oder> oders;
}
