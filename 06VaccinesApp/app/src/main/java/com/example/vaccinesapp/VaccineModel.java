package com.example.vaccinesapp;

public class VaccineModel {
    private String vaccineName;
    private int vaccineImage;

    public VaccineModel(String vaccineName, int vaccineImage) {
        this.vaccineName = vaccineName;
        this.vaccineImage = vaccineImage;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public int getVaccineImage() {
        return vaccineImage;
    }
}
