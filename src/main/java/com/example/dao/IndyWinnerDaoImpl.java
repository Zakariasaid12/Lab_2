package com.example.dao;

import com.example.model.IndyWinner;
import com.example.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class IndyWinnerDaoImpl implements IndyWinnerDao {

    @Override
    public IndyWinner findWinnerByYear(int year) {
        // Correct table name here
        String sql = "SELECT DRIVER, AVERAGESPEED, COUNTRY FROM indywinners WHERE YEAR = ?";
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, year); // Set the year parameter
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Retrieve data from the result set
                String driver = rs.getString("DRIVER");
                double averageSpeed = rs.getDouble("AVERAGESPEED");
                String country = rs.getString("COUNTRY");

                // Return a new IndyWinner object
                return new IndyWinner(driver, year, averageSpeed, country);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Log any SQL exceptions
        }

        return null; // Return null if no winner is found
    }
}
