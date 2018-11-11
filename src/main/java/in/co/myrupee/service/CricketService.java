package in.co.myrupee.service;

import java.util.List;

public interface CricketService {

    public List<String> getAllTeamPlayers(long teamId);
    public void addBarcelonaPlayer(String name, String position, int number);
}
