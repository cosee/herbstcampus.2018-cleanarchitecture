package cosee.candyshop.database.entity.candy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandyRepository extends JpaRepository<CandyEntity, String> {
}
