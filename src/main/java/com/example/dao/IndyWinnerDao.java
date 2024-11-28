package com.example.dao;

import java.util.List;

import com.example.model.IndyWinner;

public interface IndyWinnerDao {
    List<IndyWinner> getWinners(int offset, int limit) throws Exception;

	IndyWinner findWinnerByYear(int i);
}
