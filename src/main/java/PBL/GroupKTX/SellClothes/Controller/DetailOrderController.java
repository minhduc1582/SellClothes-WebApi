package PBL.GroupKTX.SellClothes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PBL.GroupKTX.SellClothes.Model.Repository.DetailOrderRepository;

@RestController
@RequestMapping("/detailorders")
public class DetailOrderController {
	@Autowired
	DetailOrderRepository detailOrderRepository;
	
	@GetMapping("")
	public ResponseEntity<?> GetAllDetailOrder(){
		return ResponseEntity.status(HttpStatus.OK).body(detailOrderRepository.findAll());
	}
}
