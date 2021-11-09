package PBL.GroupKTX.SellClothes.Model.Mapper;

import PBL.GroupKTX.SellClothes.Model.User;
import PBL.GroupKTX.SellClothes.Model.Dto.UserDto;

public class UserMapper {
	public static UserDto toUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setName(user.getName());
		userDto.setPhone(user.getPhone());
		userDto.setLevel(user.getLevel());
		return userDto;
	}
}
