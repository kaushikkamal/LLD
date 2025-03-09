package InventoryOrderManagementSystem.Inventory;

import InventoryOrderManagementSystem.Product.Product;
import InventoryOrderManagementSystem.Product.ProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
    private List<ProductCategory> productCategoryList;

    public Inventory() {
        this.productCategoryList = new ArrayList<>();
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    //add new category
    public void addCategory(int categoryId, String name, int price) {
        ProductCategory productCategory = new ProductCategory(categoryId, name, price);
        productCategoryList.add(productCategory);
    }

    //add product to the particular category
    public void addProduct(Product product, int productCategoryId) {
        //take out the respective productCategory Object
        ProductCategory categoryObject = null;
        for (ProductCategory category : productCategoryList) {
            if (category.getProductCategoryId() == productCategoryId) {
                categoryObject = category;
            }
        }

        if (categoryObject != null) {
            categoryObject.addProduct(product);
        }
    } //remove product from the category

    public void removeItems(Map<Integer, Integer> productCategoryAndCountMap) { // <ProductId, Count>
        for (Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet()) {
            ProductCategory category = getProductCategoryFromID(entry.getKey());
            category.removeProduct(entry.getValue());
        }
    }

    private ProductCategory getProductCategoryFromID(int productCategoryId) {
        for (ProductCategory productCategory : productCategoryList) {
            if (productCategory.getProductCategoryId() == productCategoryId) {
                return productCategory;
            }
        }

        return null;
    }
}
