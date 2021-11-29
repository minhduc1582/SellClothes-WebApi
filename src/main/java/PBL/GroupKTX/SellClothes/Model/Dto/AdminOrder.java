package PBL.GroupKTX.SellClothes.Model.Dto;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminOrder {
	private String uID;
	private String name;
	private String phone;
	private String address;
	private String city;
	private String state;
	private String time;

	private String totalAmount;
}
