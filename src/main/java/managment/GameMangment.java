/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managment;

import beans.Game;
import beans.Service;
import dao.DaoFactory;
import dao.GameDao;
import java.util.List;
import org.hibernate.Session;
import static dao.DaoFactory.GAMEDAO;

/**
 *
 * @author < abdelrhman el_hadidy >
 */
public class GameMangment {

    static GameMangment gameMangment = new GameMangment();
    GameDao gameDao;

    public GameMangment() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        gameDao = (GameDao) daoFactory.getDAO(GAMEDAO);
    }

    public static GameMangment getInstance() {
        return gameMangment;
    }


    public List<Game> getAllGames(Session session) {
        return gameDao.getAllGames(session);
    
    }
}
