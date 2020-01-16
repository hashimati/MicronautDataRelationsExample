package io.hashimati.databaseexamples.domains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;
import lombok.ToString;

/**
 * Person
 */

@Entity
@Table(name = "persons")
@Introspected
@Data
@ToString
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Person() {
    }
    // private Address address;



    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Address> addresses = new ArrayList<>();

    @OneToOne(mappedBy = "person",cascade  = CascadeType.ALL)

    @OnDelete(action = OnDeleteAction.CASCADE)
    private ContactInfo contactInfo; 


}