package PBL.GroupKTX.SellClothes.Model.Mapper;

import PBL.GroupKTX.SellClothes.Model.Product;
import PBL.GroupKTX.SellClothes.Model.Dto.ProductDto;

public class ProductMapper {
	public static Product toProduct(ProductDto productDto) {
		Product result = new Product();
		result.setName(productDto.getName());
		result.setIdcategory(productDto.getIdcategory());
		result.setDescriptiion(productDto.getDescription());
		result.setPrice(productDto.getPrice());
		
		return result;
	}
}
