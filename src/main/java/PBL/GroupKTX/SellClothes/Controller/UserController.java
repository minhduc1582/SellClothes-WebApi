package PBL.GroupKTX.SellClothes.Controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import PBL.GroupKTX.SellClothes.Model.*;
import PBL.GroupKTX.SellClothes.Model.Mapper.UserMapper;
import PBL.GroupKTX.SellClothes.Model.Repository.*;


@RestController
@RequestMapping("v1/accounts")
public class UserController {
	//https://shareprogramming.net/requestbody-va-responsebody-annotation-trong-spring/
	// Chú ý validate dữ liệu
	
	@Autowired
	public UserRepository userRepository;
	
	// create User

    @PostMapping("")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
    	String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
    	user.setPassword(hash);
        User result = userRepository.save(user);
        return ResponseEntity.ok(result);
    }
	
//	// get all user	
//    @GetMapping("")
//    public ResponseEntity<?> getListUser(HttpServletRequest request) {
//        List<User> result = userRepository.findAll();
//        System.out.println(request.getRemoteAddr());
//        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
//    }
    
    // check-login
    @GetMapping("/login")
    public ResponseEntity<?> checkTrueLogin(@RequestParam String phone,@RequestParam String password,@RequestParam int level,HttpServletRequest request){
    	System.out.println(request.getRemoteAddr());
    	User account = userRepository.findById(phone).get();
    	boolean isUserOrAdmin = BCrypt.checkpw(password, account.getPassword()) &&  level == account.getLevel();
		if(isUserOrAdmin == true) return  ResponseEntity.status(HttpStatus.OK).body(UserMapper.toUserDto(account));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    
//    // Delete
//    @DeleteMapping("/delete")
//    public ResponseEntity<?> deleteUser(@RequestParam String phoneNumber) {
//    	userRepository.deleteById(phoneNumber);
//        return ResponseEntity.ok("Delete success");
//    }
    
    // update
    @PutMapping("/update")
    public ResponseEntity<?> updateUser( @RequestBody User user) {
        User updateUser = userRepository.findById(user.getPhone()).get();
        updateUser.setName(user.getName());
        String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        updateUser.setPassword(hash);
        updateUser.setLevel(user.getLevel());
        userRepository.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }
}
