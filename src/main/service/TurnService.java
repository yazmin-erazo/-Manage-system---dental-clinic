package main.service;

import main.dao.IDao;
import main.model.Turn;

import java.sql.SQLException;
import java.util.List;

public class TurnService {

    private IDao<Turn> turnIDao;

    public TurnService() {
    }

    public TurnService(IDao<Turn> turnIDao) {
        this.turnIDao = turnIDao;
    }

    // ---
    public IDao<Turn> getTurnIDao() {
        return turnIDao;
    }

    public void setTurnIDao(IDao<Turn> turnIDao) {
        this.turnIDao = turnIDao;
    }

    // ---
    public Turn addTurn(Turn turn) throws SQLException {
        return turnIDao.add(turn);
    }

    public void removeTurn(int id){
        turnIDao.remove(id);
    }

    public Turn searchTurn(int id) {
        return turnIDao.search(id);
    }

    public List<Turn> listAll() {
        return turnIDao.listAll();
    }
}
