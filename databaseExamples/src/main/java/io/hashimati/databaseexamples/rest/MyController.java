package io.hashimati.databaseexamples.rest;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.hashimati.databaseexamples.domains.Address;
import io.hashimati.databaseexamples.domains.ContactInfo;
import io.hashimati.databaseexamples.domains.Person;
import io.hashimati.databaseexamples.repositories.AddressRepository;
import io.hashimati.databaseexamples.repositories.ContactInfoRepository;
import io.hashimati.databaseexamples.repositories.PersonRepository;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Produces;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

/**
 * MyController
 */
@Controller("/")
public class MyController {


    @Inject 
    private PersonRepository personRepository; 

    @Inject
    private ContactInfoRepository contactInfoRepository; 
    @Inject AddressRepository addressRepository; 
    @Get("/add")
    public Person addPerson()
    {

        Person ahmed = new Person(); 
        
        ahmed.setName("Ahmed ");
        Address address = new Address(); 
        address.setCountry("Salam");
        
        Address address2 = new Address(); 
        address2.setCountry("Saihat");
        
        
        
        ahmed.getAddresses().add(address); 
        ahmed.getAddresses().add(address2); 
        
        address.setPerson(ahmed);
        address2.setPerson(ahmed);
        
        ContactInfo contactInfo= new ContactInfo(); 

        contactInfo.setEmail("hashimati.ahmed@gmail.com");
        contactInfo.setMobile("966542345678");
       
        contactInfo.setPerson(ahmed);
        ahmed.setContactInfo(contactInfo);

        Person result =  personRepository.save(ahmed);
        return result;   
     }
     @Get("/all")
     public List<Person> getPerson()
     {
         return personRepository.findAll();
     }  
     @Delete("/clean")
     public String deleteAll(){

        //it should be in this sequence because of the foreign key constraints. 
        contactInfoRepository.deleteAll();; 
        addressRepository.deleteAll();; 
        personRepository.deleteAll();; 
        return "All records got deleted"; 
     }
     @Get("/clean")
     @Produces(value = MediaType.TEXT_PLAIN)
     public String deleteAllUsingGet(){ 
       return deleteAll(); 
     }

  
}