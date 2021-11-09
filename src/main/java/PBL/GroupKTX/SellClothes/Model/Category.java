package PBL.GroupKTX.SellClothes.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="category")
@Data
public class Category {
	@Id
	int id;
	String name;
}
