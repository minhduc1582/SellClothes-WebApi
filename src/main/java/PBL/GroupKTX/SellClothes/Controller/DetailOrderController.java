package PBL.GroupKTX.SellClothes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import PBL.GroupKTX.SellClothes.Model.Repository.DetailOrderRepository;

@RestController
@RequestMapping("v1/detailorders")
public class DetailOrderController {
	@Autowired
	DetailOrderRepository detailOrderRepository;
	
	@GetMapping("")
	public ResponseEntity<?> getAllDetailsOrders(){
		return ResponseEntity.status(HttpStatus.OK).body(detailOrderRepository.findAll());
	}
	@GetMapping("/getbypidandoid")
	public ResponseEntity<?> getAllDetailsByPidAndOid(String idOrder,String productID){
		return ResponseEntity.status(HttpStatus.OK).body(detailOrderRepository.getDetailOrdersByPidandOid(idOrder, productID));
	}
//	@GetMapping("/getbyphone")
//	public ResponseEntity<?> getDetailOrdersByPhoneUser(@RequestParam String Phone){
//		return ResponseEntity.status(HttpStatus.OK).body(detailOrderRepository.getDetailOrdersByPhone(Phone));
//	}
}
