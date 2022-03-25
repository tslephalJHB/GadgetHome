package za.co.wethinkcode.gadgethomeserver.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    private String model;
    private String brand;
    private String device;

    @ManyToOne
    @JoinColumn(name = "owner_user_name")
    private User owner;
    private LocalDate datePosted;

    private String description;
    private boolean available;
    private Double amount;

    public Post(String device, String model, String brand, User owner, Double amount) {
        this.device = device;
        this.model = model;
        this.brand = brand;
        this.owner = owner;
        this.amount = amount;
        this.datePosted = LocalDate.now();
    }

    public Post() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public User getOwner() {
        return owner;
    }

    public String getDevice() {
        return device;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
