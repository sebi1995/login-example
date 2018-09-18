package peog.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String information;

    @Column
    private Date postDate;

    @Column
    private Boolean hidden;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public Information() {

    }

    public Information(String information, Date postDate, Boolean hidden) {
        this.information = information;
        this.postDate = postDate;
        this.hidden = hidden;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
