package PBL.GroupKTX.SellClothes.Service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import PBL.GroupKTX.SellClothes.Model.User;

@Service
public interface UserService {
	public User createUser(User user);
	@Cacheable("user")
	public User getUserById(String phone);
	@CachePut("user")
	public User updateUser(User user);
	
}
