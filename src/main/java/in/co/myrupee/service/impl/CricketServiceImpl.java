package in.co.myrupee.service.impl;

import in.co.myrupee.dto.Player;
import in.co.myrupee.dto.Team;
import in.co.myrupee.repository.PlayerRepository;
import in.co.myrupee.repository.TeamRepository;
import in.co.myrupee.service.CricketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CricketServiceImpl implements CricketService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    public List<String> getAllTeamPlayers(long teamId) {
        List<String> result = new ArrayList<>();
        List<Player> players = playerRepository.findByTeamId(teamId);
        for (Player player : players) {
            result.add(player.getName());
        }
        return result;
    }
    public void addBarcelonaPlayer(String name, String position, int number) {

        Optional<Player> player = playerRepository.findById(1l);

        System.out.println("Player :: " + player.get().toString());
        Team barcelona = teamRepository.findByPlayers(player.get());
        Player newPlayer = new Player();
        newPlayer.setName(name);
        newPlayer.setPosition(position);
        newPlayer.setNum(number);
        newPlayer.setTeam(barcelona);
        System.out.println("Team :: " + barcelona.toString() + "new player ::" + newPlayer.toString());

        playerRepository.save(newPlayer);

    }
}
