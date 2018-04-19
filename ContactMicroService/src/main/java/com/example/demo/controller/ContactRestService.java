package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ContactRepository;
import com.example.demo.entities.Contact;

@RequestMapping("/api")
@RestController
public class ContactRestService {

	private ContactRepository contactRepository; 
	

	/**
	 * @param contactRepository
	 */
	@Autowired
	public ContactRestService(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}
	
	
	@RequestMapping("/hi")
	public String hi() {
		return "Hello World from Restful API";
	}

	@GetMapping(value="/contacts")
	@ResponseBody
	public List<Contact> getAllContact(){
		return contactRepository.findAll();
	}
	
	@GetMapping(value="/contacts/{id}")
	@ResponseBody
	public Contact getContact(@PathVariable Long id){
		return contactRepository.findById(id).get();
	}
	
	@PostMapping(value="/contacts")
	@ResponseBody
	public Contact saveContact(@RequestBody Contact contact){
		return contactRepository.save(contact);
	}
	
	@PutMapping(value="/contacts/{id}")
	@ResponseBody
	public Contact update(@RequestBody Contact contact){
		return contactRepository.save(contact);
	}
	
	@DeleteMapping(value="/contacts/{id}")
	@ResponseBody
	public boolean delete(@PathVariable Long id){
		 contactRepository.deleteById(id);
		 return true;
	}
}
