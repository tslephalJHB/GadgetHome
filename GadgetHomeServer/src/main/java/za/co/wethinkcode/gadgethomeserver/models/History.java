package za.co.wethinkcode.gadgethomeserver.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_user_name")
    private User user;

    private String searchKeyword;

    private Integer postId;

    private LocalDate lastAccessed;

    public History(User user, String searchKeyword, Integer postId) {
        this.user = user;
        this.searchKeyword = searchKeyword;
        this.postId = postId;
        this.lastAccessed = LocalDate.now();
    }

    public History() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User accountId) {
        this.user = accountId;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public LocalDate getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(LocalDate lastAccessed) {
        this.lastAccessed = lastAccessed;
    }
}
