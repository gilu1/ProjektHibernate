package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	
//	 Metoda pobierająca  Autora dla zadanego email
	public List<Author> findByEmail(String email);
	// Metoda pobiera Autora dla zadanego peselu.
	public List<Author> findByPesel(String pesel);
	// Metoda pobiera Autora dla zadanego nazwiska.
	public List<Author> findByLastName (String lastName);
}
