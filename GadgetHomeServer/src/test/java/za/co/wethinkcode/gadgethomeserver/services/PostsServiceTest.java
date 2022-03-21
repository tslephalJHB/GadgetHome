package za.co.wethinkcode.gadgethomeserver.services;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import za.co.wethinkcode.gadgethomeserver.models.Post;

@ContextConfiguration(classes = {PostsService.class})
@ExtendWith(SpringExtension.class)
class PostsServiceTest {
    @Autowired
    private PostsService postsService;

    @Test
    @Disabled("TODO: This test is incomplete")
    void testGetPosts() {
        // TODO: This test is incomplete.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at za.co.wethinkcode.gadgethomeserver.services.PostsService.getPosts(PostsService.java:24)
        //   In order to prevent getPosts()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPosts().
        //   See https://diff.blue/R013 to resolve this issue.

        this.postsService.getPosts();
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testGetPost() {
        // TODO: This test is incomplete.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at za.co.wethinkcode.gadgethomeserver.services.PostsService.getPost(PostsService.java:28)
        //   In order to prevent getPost(Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPost(Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        this.postsService.getPost(1L);
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testGetPostsByKeyword() {
        // TODO: This test is incomplete.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at za.co.wethinkcode.gadgethomeserver.services.PostsService.getPostsByKeyword(PostsService.java:32)
        //   In order to prevent getPostsByKeyword(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPostsByKeyword(String).
        //   See https://diff.blue/R013 to resolve this issue.

        this.postsService.getPostsByKeyword("Keyword");
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testUpdatePost() throws JsonProcessingException {
        // TODO: This test is incomplete.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at za.co.wethinkcode.gadgethomeserver.services.PostsService.updatePost(PostsService.java:36)
        //   In order to prevent updatePost(Post)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updatePost(Post).
        //   See https://diff.blue/R013 to resolve this issue.

        Post post = new Post();
        post.setAvailable(true);
        post.setDescription("The characteristics of someone or something");
        post.setId(123L);
        this.postsService.updatePost(post);
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testUpdatePost2() throws JsonProcessingException {
        // TODO: This test is incomplete.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at za.co.wethinkcode.gadgethomeserver.services.PostsService.updatePost(PostsService.java:36)
        //   In order to prevent updatePost(Post)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updatePost(Post).
        //   See https://diff.blue/R013 to resolve this issue.

        Post post = mock(Post.class);
        when(post.getId()).thenReturn(123L);
        doNothing().when(post).setAvailable(anyBoolean());
        doNothing().when(post).setDescription((String) any());
        doNothing().when(post).setId((Long) any());
        post.setAvailable(true);
        post.setDescription("The characteristics of someone or something");
        post.setId(123L);
        this.postsService.updatePost(post);
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testUpdatePost3() throws JsonProcessingException {
        // TODO: This test is incomplete.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArithmeticException: integer overflow
        //       at java.lang.Math.toIntExact(Math.java:1074)
        //       at za.co.wethinkcode.gadgethomeserver.services.PostsService.updatePost(PostsService.java:36)
        //   In order to prevent updatePost(Post)
        //   from throwing ArithmeticException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updatePost(Post).
        //   See https://diff.blue/R013 to resolve this issue.

        Post post = mock(Post.class);
        when(post.getId()).thenReturn(Long.MAX_VALUE);
        doNothing().when(post).setAvailable(anyBoolean());
        doNothing().when(post).setDescription((String) any());
        doNothing().when(post).setId((Long) any());
        post.setAvailable(true);
        post.setDescription("The characteristics of someone or something");
        post.setId(123L);
        this.postsService.updatePost(post);
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testDeletePost() {
        // TODO: This test is incomplete.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at za.co.wethinkcode.gadgethomeserver.services.PostsService.deletePost(PostsService.java:43)
        //   In order to prevent deletePost(Post)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   deletePost(Post).
        //   See https://diff.blue/R013 to resolve this issue.

        Post post = new Post();
        post.setAvailable(true);
        post.setDescription("The characteristics of someone or something");
        post.setId(123L);
        this.postsService.deletePost(post);
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testDeletePost2() {
        // TODO: This test is incomplete.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at za.co.wethinkcode.gadgethomeserver.services.PostsService.deletePost(PostsService.java:43)
        //   In order to prevent deletePost(Post)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   deletePost(Post).
        //   See https://diff.blue/R013 to resolve this issue.

        Post post = mock(Post.class);
        doNothing().when(post).setAvailable(anyBoolean());
        doNothing().when(post).setDescription((String) any());
        doNothing().when(post).setId((Long) any());
        post.setAvailable(true);
        post.setDescription("The characteristics of someone or something");
        post.setId(123L);
        this.postsService.deletePost(post);
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testAddPost() throws JsonProcessingException {
        // TODO: This test is incomplete.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at za.co.wethinkcode.gadgethomeserver.services.PostsService.addPost(PostsService.java:47)
        //   In order to prevent addPost(Post)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   addPost(Post).
        //   See https://diff.blue/R013 to resolve this issue.

        Post post = new Post();
        post.setAvailable(true);
        post.setDescription("The characteristics of someone or something");
        post.setId(123L);
        this.postsService.addPost(post);
    }
}

