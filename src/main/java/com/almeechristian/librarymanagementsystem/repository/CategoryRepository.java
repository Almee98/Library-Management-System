package com.almeechristian.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almeechristian.librarymanagementsystem.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
