package com.vu.dao;

import com.vu.lib.Impl;
import com.vu.model.Bet;
import com.vu.model.Human;

import java.util.List;

@Impl
public interface HumanDao {
    void addHuman(Human human);

    List<Human> getAllHuman();
}
