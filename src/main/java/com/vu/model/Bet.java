package com.vu.model;


import com.vu.lib.Dao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bet {
    private int value;
    private double risk;
}
