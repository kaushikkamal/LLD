package InventoryOrderManagementSystem.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
    private int productCategoryId;
    private String categoryName;
    private List<Product> products;
    private double price;

    public ProductCategory(int productCategoryId, String categoryName, double price) {
        this.productCategoryId = productCategoryId;
        this.categoryName = categoryName;
        this.price = price;
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int count) {
        for (int i = 1; i <= count; i++) {
            products.remove(0);
        }
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
