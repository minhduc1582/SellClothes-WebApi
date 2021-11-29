package PBL.GroupKTX.SellClothes.Controller;


import java.util.ArrayList;
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

import PBL.GroupKTX.SellClothes.Model.Repository.OrderRepository;
import PBL.GroupKTX.SellClothes.Model.Orders;
import PBL.GroupKTX.SellClothes.Model.Dto.AdminOrder;
import PBL.GroupKTX.SellClothes.Model.Mapper.AdminOrderMapper;

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
		List<AdminOrder> listAdminOrders = new ArrayList<AdminOrder>();
		for(Object[] o : orderRepository.getAdminOrderbyId()) {
			listAdminOrders.add(AdminOrderMapper.toAdminOrder(o));
		}
		return ResponseEntity.status(HttpStatus.OK).body(listAdminOrders);
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
