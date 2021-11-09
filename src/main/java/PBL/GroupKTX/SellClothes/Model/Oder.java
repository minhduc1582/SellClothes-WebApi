package PBL.GroupKTX.SellClothes.Model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="order")
@Data
public class Oder {
	@Id
	private int id;
	private LocalDate time;
	private String phoneuser;
//	private Set<User> users;
}
