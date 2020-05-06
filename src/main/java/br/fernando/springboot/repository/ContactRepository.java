package br.fernando.springboot.repository;

import br.fernando.springboot.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Long> {

    @Query(" from Contact where active = true")
    List<Contact> findAll();

    @Query(" from Contact where name like %?1%")
    List<Contact> findByName(String name);

    Contact findByUuid(String uuid);

    @Query(" from Contact where id = ?1")
    Contact findOneId(Long id);
}
