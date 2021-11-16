package PBL.GroupKTX.SellClothes.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PBL.GroupKTX.SellClothes.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
