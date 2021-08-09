package com.ecom.controler;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.model.Book;
import com.ecom.repo.BookRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "books")
public class BookControler {
	
	private byte[] bytes;

	@Autowired
	private BookRepo bookRepository;
	
	@GetMapping("/get")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	@PostMapping("/add")
	public Book saveuserDetails(@RequestParam("imageFile") MultipartFile file,@RequestParam("users") String users) throws IOException {

		Book book = new  ObjectMapper().readValue(users, Book.class);
		book.setPicByte(file.getBytes());
		
		
			return bookRepository.save(book);
	
	}
	
	
	@DeleteMapping(path = { "/{id}" })
	public void deleteBook(@PathVariable("id") long id) {
		bookRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		bookRepository.deleteAll();
	}
	
	@GetMapping("findby/{id}")
	public Book findbyid(@PathVariable("id") Long id)
	{
		return bookRepository.findById(id).get();
	}
	
	@PutMapping("/update/{id}")
	public Book updateBook(@RequestBody Book book)  {
		
		Long id = book.getId();
		Book b = bookRepository.findById(id).get();
		b.setName(book.getName());
		b.setAuthor(book.getAuthor());
		b.setPicByte(book.getPicByte());
		b.setPrice(book.getPrice());
		
		return bookRepository.save(b);
	}

}
