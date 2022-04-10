package com.vu.dao;

import com.vu.lib.Impl;
import com.vu.model.Bet;
import java.util.List;

@Impl
public interface BetDao {

    void add(Bet bet);

    List<Bet> getAll();
}
