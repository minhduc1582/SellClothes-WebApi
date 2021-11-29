package PBL.GroupKTX.SellClothes.Model.Mapper;

import PBL.GroupKTX.SellClothes.Model.Dto.AdminOrder;

public class AdminOrderMapper {
	public static AdminOrder toAdminOrder(Object[] obj) {
		AdminOrder adminOrder = new AdminOrder();
		for(int i =0;i<=7;i++) {
			if(obj[i] == null) obj[i] = "";
		}
		adminOrder.setUID(obj[0].toString());
		adminOrder.setName(obj[1].toString());
		adminOrder.setPhone(obj[2].toString());
		adminOrder.setAddress(obj[3].toString());
		adminOrder.setCity(obj[4].toString());
		adminOrder.setState(obj[5].toString());
		adminOrder.setTime(obj[6].toString());
		adminOrder.setTotalAmount(obj[7].toString());
		
		return adminOrder;
	}
}
