package PBL.GroupKTX.SellClothes.Service;

import java.util.List;

import PBL.GroupKTX.SellClothes.Model.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	public List<Product> getAllProductsByName(String nameProduct);
	public Product getProductById(int id);
}
