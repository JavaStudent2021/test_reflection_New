package com.vu.dao;

import com.vu.model.Bet;
import java.util.List;

public interface BetDao {

    void add(Bet bet);

    List<Bet> getAll();
}
