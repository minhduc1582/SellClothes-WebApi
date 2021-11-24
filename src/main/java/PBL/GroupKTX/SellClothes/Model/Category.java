package PBL.GroupKTX.SellClothes.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="category")
@Data
public class Category {
	@Id
	@Column(name ="idcategory")
	int idCategory;
	String name;
}
