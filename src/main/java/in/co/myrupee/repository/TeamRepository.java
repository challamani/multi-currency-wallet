package in.co.myrupee.repository;

import in.co.myrupee.dto.Player;
import in.co.myrupee.dto.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    Team findByPlayers(Player player);
}
