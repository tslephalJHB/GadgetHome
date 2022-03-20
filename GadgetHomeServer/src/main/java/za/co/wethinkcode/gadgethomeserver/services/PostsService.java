package za.co.wethinkcode.gadgethomeserver.services;

import org.springframework.stereotype.Service;
import za.co.wethinkcode.gadgethomeserver.models.Post;
import za.co.wethinkcode.gadgethomeserver.repository.PostRepository;

import java.util.List;

@Service
public class PostsService {
    private PostRepository postRepo;

    public PostsService() {
    }

    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    public Post getPost(Integer id) {
        return postRepo.getById(id);
    }

    public List<Post> getPostsByKeyword(String keyword) {
        return postRepo.findByModelOrBrandOrDevice(keyword, keyword, keyword);
    }

    public void updatePost(Post post) {
        Post postDb = postRepo.getById(Math.toIntExact(post.getId()));

        postDb.setAvailable(false);
        postRepo.save(postDb);
    }

    public void deletePost(Post post) {
        postRepo.delete(post);
    }

    public void addPost(Post post) {
        postRepo.save(post);
    }
}
