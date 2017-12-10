package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerBooks {

	@Autowired
	BookRepository bookRepository;

	@RequestMapping(value = "/findBooksByTitle", method = RequestMethod.GET)
	@ResponseBody
	public String checkLocale() {
		List<Book> ksiazki = bookRepository.findByTitleIgnoreCase("title2");
		for (Book ksiazka : ksiazki) {
			System.out.println("Tytuł: " + ksiazka.getTitle() + ", autor: " + ksiazka.getAuthor());
		}
		return "Wynik w konsoli";

	}
	//Zadanie 3
	//Listę książek dla zadanego autora.
	@RequestMapping(value = "/findBooksByAuthor", method = RequestMethod.GET)
	@ResponseBody
	public String checkAuthor(){
		List<Book> authors = bookRepository.findByAuthor("author1");
		for(Book author: authors){
			System.out.println("Tytuł:  " +author.getTitle() + ", autor: " + author.getAuthor() + ", decripton : " + author.getDescription());
		}
		return "wyniki 2 w konsoli";
	}
	
	//Listę książek dla zadanego wydawcy
	@RequestMapping(value = "/findBooksByPublisher", method = RequestMethod.GET)
	@ResponseBody
	public String checkPublisher(){
		List<Book> publishers = bookRepository.findByPublisher("publisher1");
		for(Book publisher: publishers){
			System.out.println("Tytuł:  " +publisher.getTitle() + ", autor: " + publisher.getAuthor() + ", decripton : " + publisher.getDescription() + ", publisher: " + publisher.getPublisher());
		}
		return "wyniki podpunktu 2 zadania 3  w konsoli";
	}
	//Listę książek dla określonego ratingu
	@RequestMapping(value = "/findBooksById", method = RequestMethod.GET)
	@ResponseBody
	public String checkId(){
		List<Book> ids = bookRepository.findById(1);
		for(Book id: ids){
			System.out.println("Tytuł:  " +id.getTitle() + ", autor: " + id.getAuthor() + ", decripton : " + id.getDescription() + ", publisher: " + id.getPublisher());
		}
		return "wyniki podpunktu 3 zadania 3  w konsoli";
	}
	//Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.
	@RequestMapping(value = "/findFirstByCategoryNameOrderByTitle", method = RequestMethod.GET)
	@ResponseBody
	public String checkFirst(){
		List<Book> firsts = bookRepository.findFirstByCategoryNameOrderByTitle("title1");
		for(Book first: firsts){
			System.out.println("Tytuł:  " +first.getTitle() + ", autor: " + first.getAuthor() + ", decripton : " + first.getDescription() + ", publisher: " + first.getPublisher());
		}
		return "wyniki podpunktu 4 zadania 3  w konsoli";
	}
	
	//ZADANIA Z PYTANIAMI SZCZEGOLOWYMI
	
	//Zadanie 1 z wykladowca- zapytania szczegolowe
	@RequestMapping(value = "/findBooksByTitle2", method = RequestMethod.GET)
	@ResponseBody
	public String findBooksByTitleSecond(){
		List<Book> ksiazki = bookRepository.findBooksByTitle("title1");
		for(Book first: ksiazki){
			System.out.println("Tytuł:  " +first.getTitle() + ", autor: " + first.getAuthor() + ", decripton : " + first.getDescription() + ", publisher: " + first.getPublisher());
		}
		return "wyniki podpunktu 4 zadania 3  w konsoli";
	}
	//Listę książek dla których rating jest pomiędzy zadanymi parametrami np. między 3 a 5.
	@RequestMapping( value ="/findByRating2", method = RequestMethod.GET)
	@ResponseBody
	public String findByRatings2(){
		List<Book> ksiazki = bookRepository.findByRatings(2, 4);
		for(Book first: ksiazki){
			System.out.println("Tytuł:  " +first.getTitle() + ", autor: " + first.getAuthor() + ", decripton : " + first.getDescription() + ", publisher: " + first.getPublisher());
		}
		
		
		return "Wyniki sa w konsoli :-) ";
	}
	
	//Listę książek dla zadanego wydawcy.
	
}
