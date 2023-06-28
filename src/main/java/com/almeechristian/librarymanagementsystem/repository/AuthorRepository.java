package com.almeechristian.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almeechristian.librarymanagementsystem.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
