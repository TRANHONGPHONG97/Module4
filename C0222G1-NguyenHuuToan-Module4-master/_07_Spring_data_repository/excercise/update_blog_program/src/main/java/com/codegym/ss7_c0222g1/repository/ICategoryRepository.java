package com.codegym.ss7_c0222g1.repository;

import com.codegym.ss7_c0222g1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
