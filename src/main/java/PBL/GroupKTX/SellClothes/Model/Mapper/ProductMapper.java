package PBL.GroupKTX.SellClothes.Model.Mapper;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import PBL.GroupKTX.SellClothes.Configs.WebApiConfig;
import PBL.GroupKTX.SellClothes.Model.Product;
import PBL.GroupKTX.SellClothes.Model.Dto.ProductDto;

@RestController
public class ProductMapper {

	
	public  Product toProduct(ProductDto productDto) {
		WebApiConfig cloud = new WebApiConfig();
		Product result = new Product();
		result.setId(productDto.getId());
		result.setName(productDto.getName());
		result.setIdcategory(productDto.getIdcategory());
		result.setDescriptiion(productDto.getDescription());
		result.setPrice(productDto.getPrice());
		try {
		Map uploadResult  = cloud.cloudinary().uploader().upload(productDto.getImage().getBytes(), 
				ObjectUtils.asMap(
						"resource_type","auto",
						"folder","projects/pbl4/products"));
		String img = (String)uploadResult.get("secure_url");
		result.setImage(img);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}