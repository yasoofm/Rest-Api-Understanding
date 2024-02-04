package com.codedtask.ContactsProject.bo;

public class CreateAddContactRequest {

    private String name, email, phone;

    public CreateAddContactRequest(){

    }

    public CreateAddContactRequest(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name){
        this.name = name;
    }


}
