package za.co.wethinkcode.gadgethomeserver.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.wethinkcode.gadgethomeserver.models.History;
import za.co.wethinkcode.gadgethomeserver.models.User;

import java.time.LocalDate;

public class HistoryTest {

    @Test
    void historyTest() {
        User user = new User("tshiamo", "password");
        History history = new History(user, "s21", 1L);

        Assertions.assertThat(history.getUser().getUserName()).isEqualTo("tshiamo");
        Assertions.assertThat(history.getSearchKeyword()).isEqualTo("s21");
        Assertions.assertThat(history.getPostId()).isEqualTo(1);
        Assertions.assertThat(history.getLastAccessed()).isEqualTo(LocalDate.now());
    }
}
