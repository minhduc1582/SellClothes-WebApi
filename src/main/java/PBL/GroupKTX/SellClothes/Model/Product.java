package PBL.GroupKTX.SellClothes.Model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Entity
@Table(name="product")
@Data
public class Product {
	@Id
	private int id;
	private String name;
	private String descriptiion;
	private int price;
	private String image;
	private int idcategory;
	
//	private Set<Category> categories;
}
