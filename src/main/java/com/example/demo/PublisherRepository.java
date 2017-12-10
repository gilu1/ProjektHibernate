package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer>{

	
	//Metoda pobierajaca dla danego Nipu z zadania 4
	public List<Publisher> findByNip(int nip);
	//Metoda pobierająca  dla zadanego regonu.
	public List<Publisher> findByRegon(int regon);
}
