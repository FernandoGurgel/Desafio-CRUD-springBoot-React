package br.fernando.springboot.controller;

import br.fernando.springboot.model.Contact;
import br.fernando.springboot.services.ContactServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    ContactServicesImpl services;

    @GetMapping()
    public @ResponseBody
    List<Contact> findAll(){
        return services.getAll();
    }

    @GetMapping("/name")
    public @ResponseBody
    List<Contact> findName(@RequestParam String name){
        return services.getFindByName(name);
    }

    @PutMapping()
    public @ResponseBody Contact updateContact(@RequestBody Contact contact){
        return services.updateContact(contact);
    }

    @PostMapping()
    public @ResponseBody Contact createContact(@RequestBody Contact contact){
        return services.createContact(contact);
    }

    @DeleteMapping()
    public @ResponseBody String deleteContact(Contact contact){
        return services.deleteContact(contact);
    }
}
