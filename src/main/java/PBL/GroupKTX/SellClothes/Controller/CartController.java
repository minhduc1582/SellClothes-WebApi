package PBL.GroupKTX.SellClothes.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import PBL.GroupKTX.SellClothes.Model.Dto.Cart;
import PBL.GroupKTX.SellClothes.Model.Mapper.CartMapper;
import PBL.GroupKTX.SellClothes.Model.Repository.CartRepository;

@RestController
@RequestMapping("v1/carts")
public class CartController {
	@Autowired
	CartRepository cartRepository;
	
	@GetMapping("/getcartbyuid")
	public ResponseEntity<?> getCartByUID(@RequestParam String uid){
		List<Cart> listCart = new ArrayList<Cart>();
		for(Object[] o : cartRepository.getListCartByUID(uid)) {
			listCart.add(CartMapper.toCart(o));
		}
		return ResponseEntity.status(HttpStatus.OK).body(listCart);
	}
}
