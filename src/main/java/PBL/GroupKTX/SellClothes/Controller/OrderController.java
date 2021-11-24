package PBL.GroupKTX.SellClothes.Controller;


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

import PBL.GroupKTX.SellClothes.Model.Repository.OrderRepository;
import PBL.GroupKTX.SellClothes.Model.Orders;

@RestController
@RequestMapping("v1/orders")
public class OrderController {
	@Autowired
	OrderRepository orderRepository;
	
	@GetMapping("")
	public ResponseEntity<?> getAllOrders(){
		return ResponseEntity.status(HttpStatus.OK).body(orderRepository.findAll());
	}
	@GetMapping("/getadminorder")
	public ResponseEntity<?> getAdminOrder(){
		return ResponseEntity.status(HttpStatus.OK).body(orderRepository.getAdminOrderbyId());
	}
	@PostMapping("/add")
	public ResponseEntity<?> addOrder(@RequestBody Orders order){
		if(order != null) {
			return ResponseEntity.status(HttpStatus.OK).body(order);
		}
		return ResponseEntity.status(HttpStatus.OK).body(new Orders());
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateOrder(@RequestBody Orders order){
		if(order != null) {
			Orders udOder = orderRepository.findById(order.getIdOrder()).get();
			udOder = order;
			return ResponseEntity.status(HttpStatus.OK).body(orderRepository.save(udOder));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new Orders());
	}
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteOrder(@RequestParam int id){
		orderRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Delete Success");
	}
}
