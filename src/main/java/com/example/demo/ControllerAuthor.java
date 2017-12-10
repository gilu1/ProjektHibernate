package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerAuthor {

	@Autowired
	AuthorRepository authorRepository;
	
//	 Metoda pobierająca  Autora dla zadanego email
	@RequestMapping(value="/findByEmail", method=RequestMethod.GET)
	@ResponseBody
	public String checkByMail(){
		List<Author> emails = authorRepository.findByEmail("email1@op.pl");
		for(Author email: emails){
			System.out.println("Id: " + email.getId() + ", email to:" + email.getEmail() + ", FirstName: " + email.getFirstName() + ", LastName:" + email.getLastName());
		}
		
		
		
		return "Wynik mailow w konsoli";
	}
	// Metoda pobiera Autora dla zadanego peselu.
	@RequestMapping(value="/findByPesel", method=RequestMethod.GET)
	@ResponseBody
	public String checkByPesel(){
		List<Author> pesels = authorRepository.findByPesel("93032006252");
		for(Author email: pesels){
			System.out.println("Id: " + email.getId() + ", email to:" + email.getEmail() + ", FirstName: " + email.getFirstName() + ", LastName:" + email.getLastName());
		}
		
		
		
		return "Wynik peselow w konsoli";
	}
	// Metoda pobiera Autora dla zadanego nazwiska.
	@RequestMapping(value="/findByLastName", method=RequestMethod.GET)
	@ResponseBody
	public String checkByLastName(){
		List<Author> names = authorRepository.findByLastName("lastname1");
		for(Author email: names){
			System.out.println("Id: " + email.getId() + ", email to:" + email.getEmail() + ", FirstName: " + email.getFirstName() + ", LastName:" + email.getLastName());
		}
		
		
		
		return "Wynik lastnamow w konsoli";
	}
	
	
	
	
}
