package com.almeechristian.librarymanagementsystem.service.impl;

import java.util.List;

import com.almeechristian.librarymanagementsystem.repository.AuthorRepository;
import com.almeechristian.librarymanagementsystem.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.almeechristian.librarymanagementsystem.entity.Author;
import com.almeechristian.librarymanagementsystem.exception.NotFoundException;

@Service
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;

	public AuthorServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Author findAuthorById(Long id) {
		return authorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id)));
	}

	@Override
	public void createAuthor(Author author) {
		authorRepository.save(author);
	}

	@Override
	public void updateAuthor(Author author) {
		authorRepository.save(author);
	}

	@Override
	public void deleteAuthor(Long id) {
		final Author author = authorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id)));

		authorRepository.deleteById(author.getId());
	}

}
