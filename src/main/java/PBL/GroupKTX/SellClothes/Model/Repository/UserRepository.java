package PBL.GroupKTX.SellClothes.Model.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PBL.GroupKTX.SellClothes.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
}
