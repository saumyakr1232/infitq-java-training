package com.gu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Assignment32 {


    public static String maxVisitedSpeciality(ArrayList<Patient> patientMedicalSpeciality){
        HashMap<String, String> medicalSpeciality = new HashMap<>();
        medicalSpeciality.put("P", "Pediatrics");
        medicalSpeciality.put("O", "Orthopedics");
        medicalSpeciality.put("E", "ENT");
        HashMap<String, Integer> specialityPatientCount = new HashMap<>();
        specialityPatientCount.put("P", 0);
        specialityPatientCount.put("O", 0);
        specialityPatientCount.put("E", 0);

        for (Patient p : patientMedicalSpeciality){
            if (p.getSpeciality().equals("P")){
                specialityPatientCount.replace("P", specialityPatientCount.get("P") + 1);
            }
            else if (p.getSpeciality().equals("O")){
                specialityPatientCount.replace("O", specialityPatientCount.get("P") + 1);
            }
            else if (p.getSpeciality().equals("E")){
                specialityPatientCount.replace("E", specialityPatientCount.get("P") + 1);
            }
        }
        int max  =  Collections.max(specialityPatientCount.values());

        for (String speciality: medicalSpeciality.keySet()){
            if (specialityPatientCount.get(speciality) == max){
                return medicalSpeciality.get(speciality);
            }
        }
        return  "";

    }

}

class Patient {
    private final String speciality;
    private final int id;

    public Patient(String speciality, int no){
        this.speciality = speciality;
        this.id = no;
    }

    public int getNo() {
        return id;
    }

    public String getSpeciality() {
        return speciality;
    }
}
