package PBL.GroupKTX.SellClothes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PBL.GroupKTX.SellClothes.Model.Repository.CategoryRepository;

@RestController
@RequestMapping("v1/categories")
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("")
	public ResponseEntity<?> getAllCategory(){
		return ResponseEntity.status(HttpStatus.OK).body(categoryRepository.findAll());
	}
}
