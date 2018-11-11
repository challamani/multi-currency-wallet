package in.co.myrupee;

import in.co.myrupee.service.CricketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MyRupeeApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CricketService cricketService;
    public static void main(String[] args) {
        SpringApplication.run(MyRupeeApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {

        List<String> players = cricketService.getAllTeamPlayers(1);
        for (String player : players) {
            logger.info(" player => " + player);
        }
    }
}
