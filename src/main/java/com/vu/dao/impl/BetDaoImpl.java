package com.vu.dao.impl;

import com.vu.dao.BetDao;
import com.vu.db.Storage;
import com.vu.lib.Dao;
import com.vu.model.Bet;
import lombok.NoArgsConstructor;

import java.util.List;

@Dao
public class BetDaoImpl implements BetDao {
    @Override
    public void add(Bet bet) {
        Storage.bets.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.bets;
    }
}
