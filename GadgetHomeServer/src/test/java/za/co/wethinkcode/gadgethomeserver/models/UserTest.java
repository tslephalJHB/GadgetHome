package za.co.wethinkcode.gadgethomeserver.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.wethinkcode.gadgethomeserver.models.User;

public class UserTest {

    @Test
    void userWithNullValues() {
        User user = new User("tshiamo", "password");

        Assertions.assertThat(user.getUserName()).isEqualTo("tshiamo");
        Assertions.assertThat(user.getPassword()).isEqualTo("password");
        Assertions.assertThat(user.getRole()).isNull();
        Assertions.assertThat(user.getEmail()).isNull();
        Assertions.assertThat(user.getFirstName()).isNull();
        Assertions.assertThat(user.getLastName()).isNull();
    }

    @Test
    void userWithNotNullValues() {
        User user = new User("tshiamo", "password");
        user.setRole("USER");
        user.setEmail("tshiamo.lephale@gmail.com");
        user.setFirstName("Tshiamo");
        user.setLastName("Lephale");

        Assertions.assertThat(user.getUserName()).isNotNull();
        Assertions.assertThat(user.getPassword()).isNotNull();
        Assertions.assertThat(user.getRole()).isNotNull();
        Assertions.assertThat(user.getEmail()).isNotNull();
        Assertions.assertThat(user.getFirstName()).isNotNull();
        Assertions.assertThat(user.getLastName()).isNotNull();

        Assertions.assertThat(user.getUserName()).isEqualTo("tshiamo");
        Assertions.assertThat(user.getPassword()).isEqualTo("password");
        Assertions.assertThat(user.getRole()).isEqualTo("USER");
        Assertions.assertThat(user.getEmail()).isEqualTo("tshiamo.lephale@gmail.com");
        Assertions.assertThat(user.getFirstName()).isEqualTo("Tshiamo");
        Assertions.assertThat(user.getLastName()).isEqualTo("Lephale");
    }
}
