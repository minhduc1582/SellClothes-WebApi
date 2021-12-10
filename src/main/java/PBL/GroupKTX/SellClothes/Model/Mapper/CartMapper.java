package PBL.GroupKTX.SellClothes.Model.Mapper;

import PBL.GroupKTX.SellClothes.Model.Dto.Cart;

public class CartMapper {
	public static Cart toCart(Object[] obj) {
		Cart cart = new Cart();
		for(int i =0;i <= 4;i++) {
			if(obj[i] == null) obj[i] = "";
		}
		cart.setPid(Integer.parseInt(obj[0].toString()));
		cart.setPname(obj[1].toString());
		cart.setPrice(Integer.parseInt(obj[2].toString()));
		cart.setQuantity(Integer.parseInt(obj[3].toString()));
		cart.setIdDetailOrder(Integer.parseInt(obj[4].toString()));	
		return cart;
	}
}
