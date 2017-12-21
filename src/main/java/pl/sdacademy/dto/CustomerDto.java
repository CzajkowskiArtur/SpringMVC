package pl.sdacademy.dto;

import pl.sdacademy.entity.Customer;

import java.time.LocalDate;

public class CustomerDto {
    private Integer id;
    private String email;
    private String name;
    private String surname;
    private LocalDate dateOfBrith;

    public CustomerDto(Customer entity){
        id = entity.getId();
        email = entity.getEmail();
        name = entity.getName();
        surname = entity.getSurname();
        dateOfBrith= entity.getDateIfBirth();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBrith() {
        return dateOfBrith;
    }

    public void setDateOfBrith(LocalDate dateOfBrith) {
        this.dateOfBrith = dateOfBrith;
    }
}
