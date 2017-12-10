package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ValidationController {

	@Autowired
	Validator validator;
	//@ResponseBody 
	@RequestMapping(value = "/validate", method = RequestMethod.GET)

	
	public String validateBook(Model model) {
		Book book = new Book();
		book.setTitle("Test");
		book.setRating(20);
		book.setAuthor(" ");

		Set<ConstraintViolation<Book>> violations = validator.validate(book);
		List<String> list1 = new ArrayList<>();
		if (!violations.isEmpty()) {
			for (ConstraintViolation<Book> constraintViolation : violations) {
				System.out.println(constraintViolation.getPropertyPath() + "	" + constraintViolation.getMessage());
				list1.add(constraintViolation.getPropertyPath() + "	" + constraintViolation.getMessage());
			}
			model.addAttribute("lista",list1);
		} else {
			// save object }

			return "validate";

		}
		return "validate";
	}
	@RequestMapping(value="/validBook", method=RequestMethod.GET)
	public String checkBook(Model model){
		model.addAttribute("book", new Book());
		return "validateBook";
	
	}
	@RequestMapping(value="/validBook", method=RequestMethod.POST)
	public String checkValidBook(@Valid Book book, BindingResult binding){
		
		if(binding.hasErrors()){
			return "validateBook";
		}else{
			return "success";
		}
	}

}
