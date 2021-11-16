package PBL.GroupKTX.SellClothes.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import PBL.GroupKTX.SellClothes.Model.User;
import PBL.GroupKTX.SellClothes.Model.Repository.UserRepository;

@Component
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(User user) {		
		return userRepository.saveAndFlush(user);
	}

	@Override
	public User getUserById(String phone) {
		return  userRepository.findById(phone).get();
	}

	@Override
	public User updateUser(User user) {
		return userRepository.saveAndFlush(user);
	}

}
