package com.Test.Dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.dao.IndyWinnerDao;
import com.example.model.IndyWinner;

class IndyWInnerDao {

    private IndyWinnerDao dao;

    @BeforeEach
    public void setUp() {
         // Assuming DAO is implemented correctly
    }

    @Test
    public void testFindWinnerByYear() {
        IndyWinner winner = dao.findWinnerByYear(2023);
        assertNotNull(winner);
        assertEquals("Expected Winner Name", winner.getWinnerName());
    }
}
