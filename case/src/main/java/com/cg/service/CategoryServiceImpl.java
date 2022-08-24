package com.cg.service;

import com.cg.dao.CategoryDAO;
import com.cg.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author TVD
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public boolean create(Category object) {
        return categoryDAO.create(object);
    }

    @Override
    public boolean update(Category object) {
        return categoryDAO.update(object);
    }

    @Override
    public boolean delete(Category object) {
        return categoryDAO.delete(object);
    }

    @Override
    public Category findById(long categoryId) {
        return categoryDAO.findById(categoryId);
    }

    @Override
    public List<Category> getAll() {
        return categoryDAO.getAll();
    }

}
