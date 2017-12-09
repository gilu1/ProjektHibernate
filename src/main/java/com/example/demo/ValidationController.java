package com.example.demo;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ValidationController {

	@Autowired
	Validator validator;
	@ResponseBody
	@RequestMapping(value = "/validate", method = RequestMethod.GET)

	public String validateBook() {
		Book book = new Book();
		book.setTitle("Test");
		book.setRating(20);
		book.setAuthor(" ");

		Set<ConstraintViolation<Book>> violations = validator.validate(book);
		if (!violations.isEmpty()) {
			for (ConstraintViolation<Book> constraintViolation : violations) {
				System.out.println(constraintViolation.getPropertyPath() + "	" + constraintViolation.getMessage());
			}
		} else {
			// save object }

			return "aa";

		}
		return "aa";
	}

}
