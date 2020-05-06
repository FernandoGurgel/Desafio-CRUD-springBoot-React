package br.fernando.springboot.services;

import br.fernando.springboot.model.Contact;
import br.fernando.springboot.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

@Service
public class ContactServicesImpl implements ContactServices{

    @Autowired
    ContactRepository repository;

    @Override
    public List<Contact> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Contact> getFindByName(String name) {
        return repository.findByName(name);
    }

//    TODO: criar filtro por número do telefone
//    @Override
//    public Contact getFindByPhone(String phone) {
//        return repository.findByPhone(phone);
//    }

    @Override
    public Contact getFindByUuid(String uuid) {
        return repository.findByUuid(uuid);
    }

    @Override
    public Contact createContact(Contact contact) {
        contact.setUuid(UUID.randomUUID().toString());
        return repository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public String deleteContact(Contact contact) {
        try {
            Contact contacts = repository.findOneId(contact.getId());
            contacts.setActive(!contacts.getActive());
            repository.save(contacts);
        } catch (Exception e){
            return e.toString();
        }
        return "";
    }

}
