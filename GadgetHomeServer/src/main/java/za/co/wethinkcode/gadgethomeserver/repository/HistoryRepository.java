package za.co.wethinkcode.gadgethomeserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.wethinkcode.gadgethomeserver.models.History;

public interface HistoryRepository extends JpaRepository<History, Integer> {

    History findHistoryBySearchKeyword(String searchKeyword);
}
