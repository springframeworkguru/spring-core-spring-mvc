package guru.springframework.services;

import guru.springframework.domain.Product;

import java.util.List;

/**
 * Created by jt on 11/6/15.
 */
public interface ProductService {

    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveOrUpdateProduct(Product product);
}
