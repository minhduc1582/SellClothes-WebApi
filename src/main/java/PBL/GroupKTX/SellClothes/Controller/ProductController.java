package PBL.GroupKTX.SellClothes.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import PBL.GroupKTX.SellClothes.Model.Product;
import PBL.GroupKTX.SellClothes.Model.Dto.ProductDto;
import PBL.GroupKTX.SellClothes.Model.Mapper.ProductMapper;
import PBL.GroupKTX.SellClothes.Model.Repository.ProductRepository;


@RestController
@RequestMapping("v1/products")
public class ProductController {
	// Name: Smallboiz
	// GSon retrofit convert Json to object
	// Retrofit
	//Gson
//	@Autowired
//	private Cloudinary cloudinary;
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("")
	public ResponseEntity<?> getAllProducts() {
		List<Product> product = productRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	@GetMapping("/getbyname")
	public ResponseEntity<?> getProductById(@Validated @RequestParam String nameProduct){
		List<Product> product = productRepository.findProductByName(nameProduct);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	@GetMapping("/getbyid")
	public ResponseEntity<?> getProductById(@RequestParam int idProduct){
		Product product = productRepository.findById(idProduct).get();
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	@GetMapping("/getbyidcategory")
	public ResponseEntity<?> getProductByIdCategory(@RequestParam int idCategory){
		List<Product> product = productRepository.findProductsByIdCategory(idCategory);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	@GetMapping("/getbyidorder")
	public ResponseEntity<?> getProductByIdOrder(@RequestParam int idOrder){
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.findProductByIdOrder(idOrder));
	}
	// add Product
	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@ModelAttribute ProductDto productDto) {
		ProductMapper productMapper = new ProductMapper();
		productRepository.save(productMapper.toProduct(productDto));
		return ResponseEntity.status(HttpStatus.OK).body(productMapper.toProduct(productDto));

	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateProduct(@ModelAttribute ProductDto productDto){
		ProductMapper productMapper = new ProductMapper();
		Product product = productRepository.findById(productDto.getId()).get();
		product = productMapper.toProduct(productDto);
		productRepository.save(product);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteProductById(@RequestParam int id){
		productRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Delete Success");
	}
}
