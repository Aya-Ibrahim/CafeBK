/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Game;
import beans.Item;
import beans.Service;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author < abdelrhman el_hadidy >
 */
public class GameDao {

    public static GameDao gameDao = new GameDao();

    public GameDao() {
    }

    public static GameDao getInstance() {
        return gameDao;
    }

    public List<Game> getAllGames(Session session) {
        List<Game> games = new ArrayList<Game>();
        Query Query = session.createQuery("from Game where isActive is true ");
        games = Query.list();
        return games;
    }

}
