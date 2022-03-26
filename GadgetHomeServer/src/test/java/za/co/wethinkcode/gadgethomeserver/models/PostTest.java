package za.co.wethinkcode.gadgethomeserver.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PostTest {
    @Test
    void testConstructor() {
        Post actualPost = new Post();
        actualPost.setAvailable(true);
        actualPost.setDescription("The characteristics of someone or something");
        actualPost.setId(123L);
        assertNull(actualPost.getBrand());
        assertNull(actualPost.getDatePosted());
        assertEquals("The characteristics of someone or something", actualPost.getDescription());
        assertNull(actualPost.getDevice());
        assertEquals(123L, actualPost.getId().longValue());
        assertNull(actualPost.getModel());
        assertNull(actualPost.getOwner());
        assertTrue(actualPost.isAvailable());
    }

    @Test
    void testConstructor2() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        user.setUserName("janedoe");
        Post actualPost = new Post("Device", "Model", "Brand", "", user, 1.00);

        assertEquals("Brand", actualPost.getBrand());
        assertSame(user, actualPost.getOwner());
        assertEquals("Model", actualPost.getModel());
        assertEquals("Device", actualPost.getDevice());
    }
}

