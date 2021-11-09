package PBL.GroupKTX.SellClothes.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "user")
@Data
public class User {
//    @NotNull(message = "Full name is required")
//    @NotEmpty(message = "Full name is required")
//    @ApiModelProperty(
//            example="Sam Smith",
//            notes="Full name cannot be empty",
//            required=true
//    )
//    @JsonProperty("full_name")
	private String name;
    
//    @NotNull(message = "Password is required")
//    @NotEmpty(message = "Password is required")
//    @Size(min = 4, max = 20, message = "Pasword must be between 4 and 20 characters")
//    @ApiModelProperty(
//            example="verysecretpassword",
//            notes="Password can't be empty",
//            required=true
//    )
	@Id
	private String phone;
    
//    @Pattern(regexp="(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Please provide a valid phone number")
//    @ApiModelProperty(
//            example="0916016972",
//            notes="Phone cannot be empty",
//            required=true
//    )
	private String password;
    
//    @NotNull(message = "level is required")
//    @ApiModelProperty(
//            example="1",
//            notes="level cannot be empty",
//            required=true
//    )
	private int level;
}
