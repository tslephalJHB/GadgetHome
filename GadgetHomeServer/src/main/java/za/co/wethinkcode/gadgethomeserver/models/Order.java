package za.co.wethinkcode.gadgethomeserver.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private final Post post;

    @ManyToOne
    @JoinColumn(name = "bought_by_user_name")
    private final User buyer;

    private String transit;
    private String trackId;

    private boolean paymentReleased;

    public Order(User buyer, Post post) {
        this.buyer = buyer;
        this.post = post;
        post.setAvailable(false);
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getTransit() {
        return transit;
    }

    public void setTransit(String transit) {
        this.transit = transit;
    }

    public User getBuyer() {
        return buyer;
    }

    public Post getPost() {
        return post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPaymentReleased() {
        return paymentReleased;
    }

    public Order setPaymentReleased(boolean paymentReleased) {
        this.paymentReleased = paymentReleased;
        return this;
    }
}
