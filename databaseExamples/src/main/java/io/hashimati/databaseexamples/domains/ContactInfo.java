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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

/**
 * ContactInfo
 */
@Data
@ToString
@Entity
public class ContactInfo 
{

    @Id
    @GeneratedValue
    private Long id;
    
	private String email; 
    private String mobile; 

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    @JsonIgnore
    private Person person; 
    
}