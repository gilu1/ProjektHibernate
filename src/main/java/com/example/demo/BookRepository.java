package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	
	public List<Book>  findByTitleIgnoreCase (String title);
	
	public List<Book> findByAuthor(String author);
	
	//Listę książek dla zadanego wydawcy
	public List<Book> findByPublisher (String publisher);
	//Listę książek dla określonego ratingu
	public List<Book> findById(int id);
	//Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.
	public List<Book> findFirstByCategoryNameOrderByTitle(String category);
	
	//Zadanie z wykladowca - zapytania szczegolowe:
	
	
	@Query("select b from Book b where b.title = :title")
	List<Book> findBooksByTitle(@Param("title") String title);
	
	
	
	//Zadanie 2 - zapytanie szczegolowe:
	
	//Listę książek dla których rating jest pomiędzy zadanymi parametrami np. między 3 a 5.
	@Query("select a from Book a where a.rating between :start and :end")
	List<Book> findByRatings(@Param("start") int start, @Param("end") int end);
	
	
	
	
	
	

}
