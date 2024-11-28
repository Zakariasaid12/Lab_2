package com.example.model;

public class IndyWinner {
    private int year;              // The year of the race
    private String winnerName;     // The name of the winner
    private double averageSpeed;   // The average speed of the winner
    private String country;        // The country of the winner

    // Constructor with all fields
    public IndyWinner(String winnerName, int year, double averageSpeed, String country) {
        this.year = year;
        this.winnerName = winnerName;
        this.averageSpeed = averageSpeed;
        this.country = country;
    }

    // Getters and setters
    public int getYear() { 
        return year; 
    }

    public void setYear(int year) { 
        this.year = year; 
    }

    public String getWinnerName() { 
        return winnerName; 
    }

    public void setWinnerName(String winnerName) { 
        this.winnerName = winnerName; 
    }

    public double getAverageSpeed() { 
        return averageSpeed; 
    }

    public void setAverageSpeed(double averageSpeed) { 
        this.averageSpeed = averageSpeed; 
    }

    public String getCountry() { 
        return country; 
    }

    public void setCountry(String country) { 
        this.country = country; 
    }

    // Optional: Override toString for easier debugging
    @Override
    public String toString() {
        return "IndyWinner{" +
                "year=" + year +
                ", winnerName='" + winnerName + '\'' +
                ", averageSpeed=" + averageSpeed +
                ", country='" + country + '\'' +
                '}';
    }
}
