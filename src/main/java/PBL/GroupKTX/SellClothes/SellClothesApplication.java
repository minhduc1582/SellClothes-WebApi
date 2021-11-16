package PBL.GroupKTX.SellClothes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SellClothesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellClothesApplication.class, args);		
	}
}
