package peog.entities;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String address1;

    @Column
    private String address2;

    @Column
    private String post_code;

    @Column
    private String county;

    @Column
    private String country;

    @OneToOne(mappedBy = "address")
    private User user;

    public Address(){

    }

    public Address(String address1, String address2, String post_code, String county, String country, User user) {
        this.address1 = address1;
        this.address2 = address2;
        this.post_code = post_code;
        this.county = county;
        this.country = country;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
