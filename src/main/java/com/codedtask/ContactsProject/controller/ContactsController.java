package com.codedtask.ContactsProject.controller;

import com.codedtask.ContactsProject.bo.CreateAddContactRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ContactsController {

    private final ArrayList<CreateAddContactRequest> contacts = new ArrayList<CreateAddContactRequest>();

    @PostMapping("/addContact")
    public ResponseEntity<String> addContact(@RequestBody CreateAddContactRequest createAddContactRequest){
        for(CreateAddContactRequest contact : contacts){
            if(contact.getEmail().equals(createAddContactRequest.getEmail()))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Contact already exists with this email!");
        }
        contacts.add(createAddContactRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Contact added successfully");
    }

    @GetMapping("/getContactDetail")
    public ResponseEntity<?> getContactDetail(@RequestParam String name){
        CreateAddContactRequest foundContact;

        for (CreateAddContactRequest contact : contacts) {
            if (contact.getName().equals(name)) {
                foundContact = contact;
                return new ResponseEntity<>(foundContact, HttpStatus.OK);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found");
    }

}
