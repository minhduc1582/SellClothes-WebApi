package PBL.GroupKTX.SellClothes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import PBL.GroupKTX.SellClothes.Model.ShipmentDetail;
import PBL.GroupKTX.SellClothes.Model.Repository.ShipmentDetailRepository;

@RestController
@RequestMapping("/shipmentdetail")
public class ShipmentDetailController {
	@Autowired
	ShipmentDetailRepository shipmentDetailRepository;
	
	@GetMapping("")
	public ResponseEntity<?> getShipmentDetailByPhone(@RequestParam String Phone){
		List<ShipmentDetail> result = shipmentDetailRepository.findAllByPhone(Phone);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addShipmentDetail(@RequestBody ShipmentDetail shipmentDetail){
		ShipmentDetail result = shipmentDetailRepository.save(shipmentDetail);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateShipmentDetail(@RequestBody ShipmentDetail shipmentDetail){
		ShipmentDetail result = shipmentDetailRepository.findById(shipmentDetail.getId()).get();
		result.setAddress(shipmentDetail.getAddress());
		result.setCity(shipmentDetail.getCity());
		result.setIdorder(shipmentDetail.getIdorder());
		result.setName(shipmentDetail.getName());
		result.setPhone(shipmentDetail.getPhone());
		shipmentDetailRepository.save(result);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteShipmentDetail(@RequestParam int id){
		shipmentDetailRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Delete Success");
	}
}
