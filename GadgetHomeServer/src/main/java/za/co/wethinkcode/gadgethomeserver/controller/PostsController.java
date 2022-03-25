package za.co.wethinkcode.gadgethomeserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.server.ResponseStatusException;
import za.co.wethinkcode.gadgethomeserver.models.Post;
import za.co.wethinkcode.gadgethomeserver.models.User;
import za.co.wethinkcode.gadgethomeserver.repository.UserRepository;
import za.co.wethinkcode.gadgethomeserver.services.PostsService;

import java.util.List;
import java.util.Map;

//Authentication authentication = SecurityContextHolder
//        .getContext().getAuthentication();
//        String username = authentication.getName();

@RestController
@RequestMapping("/ads")
public class PostsController {

    UserRepository userRepo;
    PostsService postsService = new PostsService();

    public PostsController(UserRepository userRepository) {
        this.userRepo = userRepository;
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postsService.getPosts();
    }

    @GetMapping("/posts/id/{id}")
    public Post getPost(@PathVariable Long id) {
        try {
            return postsService.getPost(id);
        } catch (RestClientException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found", e);
        }
    }

    @GetMapping("/posts/key/{keyword}")
    public List<Post> getPostByKeyword(@PathVariable String keyword) {
        try {
            return postsService.getPostsByKeyword(keyword);
        } catch (RestClientException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Posts not found", e);
        }
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Map<String, String> map) {
        System.out.println(map);
        System.out.println(map.get("brand"));
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();

        if (!authentication.isAuthenticated()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User does not exist");
        }

        User user = userRepo.findUserByUserName(authentication.getName());

        Post post = new Post(
                map.get("device"),
                map.get("model"),
                map.get("brand"),
                user,
                Double.parseDouble(map.get("amount")));

        System.out.println(post);

        return postsService.addPost(post);
    }

    @PutMapping("/post/{id}")
    public void updatePost(@PathVariable String id, @RequestBody Post post) {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        String username = authentication.getName();

        if (!userRepo.existsByUserName(username)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");
        }

        postsService.updatePost(post);
    }

}
