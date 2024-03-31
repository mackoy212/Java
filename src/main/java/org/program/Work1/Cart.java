package org.program.Work1;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> Products;

    public Cart() {
        Products = new ArrayList<>();
    }

    public boolean addProduct(Product product)
    {
        if (product != null && !Products.contains(product)) {
            Products.add(product);
            return true;
        }
        return false;
    }

    public boolean removeProduct(Product product)
    {
        if (product != null && Products.contains(product)) {
            Products.remove(product);
            return true;
        }
        return false;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public boolean isEmpty() {
        return Products.isEmpty();
    }
}
