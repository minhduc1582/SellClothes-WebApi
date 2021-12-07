package PBL.GroupKTX.SellClothes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import PBL.GroupKTX.SellClothes.Model.DetailOrder;
import PBL.GroupKTX.SellClothes.Model.Repository.DetailOrderRepository;

@RestController
@RequestMapping("v1/detailorders")
public class DetailOrderController {
	@Autowired
	DetailOrderRepository detailOrderRepository;
	
	@GetMapping("")
	public ResponseEntity<?> getAllDetailOrders(){
		return ResponseEntity.status(HttpStatus.OK).body(detailOrderRepository.findAll());
	}
	@GetMapping("/getbypidandoid")
	public ResponseEntity<?> getAllDetailsByPidAndOid(String idOrder,String productID){
		return ResponseEntity.status(HttpStatus.OK).body(detailOrderRepository.getDetailOrdersByPidandOid(idOrder, productID));
	}
	@PostMapping("/add")
	public ResponseEntity<?> addDetailOrders(@RequestBody DetailOrder detailOrder){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(detailOrderRepository.save(detailOrder));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(new DetailOrder());
		}
	}
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteDetailOrders(@RequestParam int id){
		try {
			detailOrderRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Delete Success");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.OK).body("Delete Fail");
		}
	}
//	@GetMapping("/getbyphone")
//	public ResponseEntity<?> getDetailOrdersByPhoneUser(@RequestParam String Phone){
//		return ResponseEntity.status(HttpStatus.OK).body(detailOrderRepository.getDetailOrdersByPhone(Phone));
//	}
}
