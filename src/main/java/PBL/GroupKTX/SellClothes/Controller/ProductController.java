package PBL.GroupKTX.SellClothes.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import PBL.GroupKTX.SellClothes.Model.Product;
import PBL.GroupKTX.SellClothes.Model.Dto.ProductDto;
import PBL.GroupKTX.SellClothes.Model.Mapper.ProductMapper;
import PBL.GroupKTX.SellClothes.Model.Repository.ProductRepository;


@RestController
@RequestMapping("/admin")
public class ProductController {
	// Name: Smallboiz
	// GSon retrofit convert Json to object
	// Retrofit
	//Gson
	@Autowired
	private Cloudinary cloudinary;
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/products")
	public ResponseEntity<?> getAllProducts() {
		List<Product> product = productRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	@PostMapping("/products")
	public ResponseEntity<?> addProduct(@ModelAttribute ProductDto productDto) {
		try {
		Map uploadResult  = this.cloudinary.uploader().upload(productDto.getImage().getBytes(), 
				ObjectUtils.asMap(
						"resource_type","auto",
						"folder","projects/pbl4/products"));
		String img = (String)uploadResult.get("secure_url");
		Product product = ProductMapper.toProduct(productDto);
		product.setImage(img);
		productRepository.save(product);
		return ResponseEntity.status(HttpStatus.OK).body(product);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
