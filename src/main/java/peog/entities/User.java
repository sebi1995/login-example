package peog.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import peog.entities.account.AccountStatus;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private Date birthdate;

    @Column
    private String sex;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private AccountStatus accountStatus;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Information> informationList;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creation_date;

    public User() {

    }

    public User(String username, String password, String email, Date birthdate, String sex, Address address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.sex = sex;
        this.address = address;
        this.accountStatus = new AccountStatus(true);
        this.informationList = new ArrayList<>();
        this.creation_date = new Timestamp(new Date().getTime());
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountStatus.getAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountStatus.getAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.accountStatus.getCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return this.accountStatus.getEnabled();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void setInformationList(List<Information> informationList) {
        this.informationList = informationList;
    }

    public List<Information> getInformationList() {
        return informationList;
    }
}