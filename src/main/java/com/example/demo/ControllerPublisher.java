package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerPublisher {

	@Autowired
	PublisherRepository publisherRepository;

	//Metoda pobierajaca dla danego Nipu z zadania 4
	@RequestMapping(value = "/findByNip", method = RequestMethod.GET)
	@ResponseBody
	public String findNip() {
		List<Publisher> nip = publisherRepository.findByNip(1181587422);
		for (Publisher nips : nip) {
			System.out.println("Id: " + nips.getId() + ", name: " + nips.getName()+ ", Nip: " + nips.getNip()+ " , regon" + nips.getRegon());
		}
		return "Wynik w konsoli";

	}
	
	
	//Metoda pobierająca  dla zadanego regonu.
	@RequestMapping(value = "/findByRegon", method = RequestMethod.GET)
	@ResponseBody
	public String findByRegon(){
		List<Publisher> regs = publisherRepository.findByRegon(17230132);
		for (Publisher reg : regs) {
			System.out.println("Id: " + reg.getId() + ", name: " + reg.getName()+ ", Nip: " + reg.getNip()+ " , regon" + reg.getRegon());
		}
		
		return "Wynik regonow w konsoli";
	}
}
