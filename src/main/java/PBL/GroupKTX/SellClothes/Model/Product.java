package PBL.GroupKTX.SellClothes.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Table(name="product")
@Data
public class Product {
	@Id
	private int pid;
	private String pname;
	private String description;
	private int price;
	private String image;
	@Column(name="idcategory")
	private int idCategory;
	
//	private Set<Category> categories;
}
