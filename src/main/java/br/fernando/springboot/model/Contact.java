package br.fernando.springboot.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(schema = "creatus")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String uuid;
    @NotNull
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ElementCollection
    @CollectionTable(name="contact_phone_numbers",joinColumns=@JoinColumn(name = "contact_id"),schema = "creatus" )
    @Column(name="phone_number",unique = true)
    private Set<String> phoneNumbers = new HashSet<>();
    @NotNull
    @Column(unique = true)
    private String email;
    @Column()
    private Boolean active = true;

}
