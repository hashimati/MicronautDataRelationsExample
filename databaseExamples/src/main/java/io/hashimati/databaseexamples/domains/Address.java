package io.hashimati.databaseexamples.domains;

import io.hashimati.databaseexamples.domains.Person;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import io.micronaut.core.annotation.Introspected;
import lombok.Data;
import lombok.ToString;

/**
 * Address
 * 
 */
@Introspected
@Entity
@Table(name = "addresses")
@Data
@ToString
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String country;

     @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     @JoinColumn(name = "person_id", nullable = false)
     @OnDelete(action = OnDeleteAction.CASCADE)
     @JsonIgnore
     private Person person;

    public Address() {

    }

  
      
   
}