package com.almeechristian.librarymanagementsystem.service.impl;

import java.util.List;

import com.almeechristian.librarymanagementsystem.repository.CategoryRepository;
import com.almeechristian.librarymanagementsystem.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.almeechristian.librarymanagementsystem.entity.Category;
import com.almeechristian.librarymanagementsystem.exception.NotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Category findCategoryById(Long id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Category not found  with ID %d", id)));
	}

	@Override
	public void createCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Long id) {
		final Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Category not found  with ID %d", id)));

		categoryRepository.deleteById(category.getId());
	}

}
