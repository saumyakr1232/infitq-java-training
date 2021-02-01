package com.gu;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Assignment32Test {
    Patient patient1 = new Patient("O", 102);
    Patient patient2 = new Patient("O", 302);
    Patient patient3 = new Patient("P", 101);
    Patient patient4 = new Patient("E", 401);
    Patient patient = new Patient("P", 301);
    Patient patient5 = new Patient("P", 304);
    Patient patient6 = new Patient("P", 305);
    Patient patient7 = new Patient("E", 406);
    Patient patient8 = new Patient("E", 407);
    Patient patient9 = new Patient("E", 409);

    @Test
    void maxVisitedSpeciality1() {
        List<Patient> patientList  = Arrays.asList(patient, patient1, patient2);
        ArrayList<Patient> patients = new ArrayList<>(patientList);
        String result = Assignment32.maxVisitedSpeciality(patients);
        assertEquals("Orthopedics", result);
    }
    @Test
    void maxVisitedSpeciality2() {
        List<Patient> patientList  = Arrays.asList(patient, patient1, patient2, patient5, patient6);
        ArrayList<Patient> patients = new ArrayList<>(patientList);
        String result = Assignment32.maxVisitedSpeciality(patients);
        assertEquals("Pediatrics", result);
    }
    @Test
    void maxVisitedSpeciality3() {
        List<Patient> patientList  = Arrays.asList(patient, patient1, patient8, patient9, patient4, patient7);
        ArrayList<Patient> patients = new ArrayList<>(patientList);
        String result = Assignment32.maxVisitedSpeciality(patients);
        assertEquals("ENT", result);
    }
}
