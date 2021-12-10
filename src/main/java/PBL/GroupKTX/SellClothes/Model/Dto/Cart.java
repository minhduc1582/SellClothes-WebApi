package PBL.GroupKTX.SellClothes.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	private int pid;
	private String pname;
	private int price;
	private int quantity;
	private int idDetailOrder;
}
