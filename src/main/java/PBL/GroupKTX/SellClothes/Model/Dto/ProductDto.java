package PBL.GroupKTX.SellClothes.Model.Dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	private int id;
	private String name;
	private String description;
	private int price;
	private MultipartFile image;
	private int idcategory;
}