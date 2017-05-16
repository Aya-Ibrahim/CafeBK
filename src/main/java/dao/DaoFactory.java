/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Abdelrahman
 */
public class DaoFactory {

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return daoFactory;
    }
    static DaoFactory daoFactory = new DaoFactory();
    public static final int TABLESDAO = 1;
    public static final int TABDAO = 2;
    public static final int ADDITIONDAO = 3;
    public static final int CATEGORYDAO = 4;
    public static final int INGREDIENTDAO = 5;
    public static final int ITEMDAO = 6;
    public static final int GAMEDAO = 7;

    public Object getDAO(int daoName) {
        switch (daoName) {
            case 1:
                return TablesDao.getInstance();

            case 2:
                return TabDao.getInstance();

//            case 3:
//            case 4:
//            case 5:
            case 6:
                return ItemDao.getInstance();
            case 7:
                return GameDao.getInstance();
            default:
                return null;
        }

    }
}
