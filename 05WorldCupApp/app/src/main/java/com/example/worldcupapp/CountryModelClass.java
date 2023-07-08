package com.example.worldcupapp;

public class CountryModelClass {
    private String countryName,numberOfWins;
    private int flagImg;

    public CountryModelClass(String countryName, String numberOfWins, int flagImg) {
        this.countryName = countryName;
        this.numberOfWins = numberOfWins;
        this.flagImg = flagImg;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(String numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getFlagImg() {
        return flagImg;
    }

    public void setFlagImg(int flagImg) {
        this.flagImg = flagImg;
    }
}
