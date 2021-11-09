package PBL.GroupKTX.SellClothes.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
		"PBL.GroupKTX.SellClothes.Controller",
		"PBL.GroupKTX.SellClothes.Model.Dto",
		"PBL.GroupKTX.SellClothes.Model"
})
public class WebApiConfig {
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		return resolver;
	}
	@Bean
	public Cloudinary cloudinary() {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				  "cloud_name", "dyvlzl3cw",
				  "api_key", "545395683675983",
				  "api_secret", "z1i3oIu7ssuIG-1Gk6UCCvfc-Hc",
				  "secure", true));
		return cloudinary;
	}
}
