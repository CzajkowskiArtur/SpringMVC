package pl.sdacademy.entity;






import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


    @Entity
    @Table(name="CUSTOMER")
    public class Customer  {


        @Id
        @Column(name="id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;


        @Column(name="email")
        private String email;

        @Column(name="name")
        private String name;

        @Column(name="surname")
        private String surname;

        @Column(name="password")
        private String password;

        @Column(name="date_of_birth")
        private LocalDate dateIfBirth;

        //ODERS


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

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public LocalDate getDateIfBirth() {
            return dateIfBirth;
        }

        public void setDateIfBirth(LocalDate dateIfBirth) {
            this.dateIfBirth = dateIfBirth;
        }
    }
