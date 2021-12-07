package PBL.GroupKTX.SellClothes.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="detailorder")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailOrder {
	@Id
	@Column(name="iddetailorder")
	private int idDetailorder;
	@Column(name="pid")
	private int pid;
	private int quantity;
	@Column(name="idorder")
	private int idOrder;
//	private Set<Product> Product;
//	private Set<Oder> oders;
}