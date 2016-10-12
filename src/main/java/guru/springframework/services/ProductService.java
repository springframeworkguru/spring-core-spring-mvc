package guru.springframework.services;

import guru.springframework.commands.ProductForm;
import guru.springframework.domain.Product;

/**
 * Created by jt on 11/6/15.
 */
public interface ProductService extends CRUDService<Product> {

    Product saveOrUpdateProductForm(ProductForm productForm);

}
