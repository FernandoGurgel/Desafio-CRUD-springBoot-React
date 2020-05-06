package br.fernando.springboot.services;

import br.fernando.springboot.model.Contact;
import java.util.List;

public interface ContactServices {

    public List<Contact> getAll();
    public List<Contact> getFindByName( String name);
    public Contact getFindByUuid( String uuid);
    public Contact createContact( Contact contact);
    public Contact updateContact( Contact contact);
    public String deleteContact( Contact contact);
}
