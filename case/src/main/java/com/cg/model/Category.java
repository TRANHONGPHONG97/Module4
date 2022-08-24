package com.cg.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author TVD
 */
@Entity(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue
    private long categoryId;
    private String categoryName;
    private String categoryUrl;
    private boolean categoryStatus;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private List<Product> listProduct;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public boolean isCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(boolean categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

}
