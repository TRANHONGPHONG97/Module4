package com.codegym.repository.imlp;

import com.codegym.model.MedicalForm;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalFormRepository implements com.codegym.repository.MedicalFormRepository {
    static List<MedicalForm> medicalFormList = new ArrayList<>();
    String[] year = new String[]{"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000"};
    String[] gender = new String[]{"Nam", "Nu", "Khac"};
    String[] country = new String[]{"Viet Nam", "Lao", "Campuchia", "Thai Lan", "America"};
    String[] vehicle = new String[]{"Plane", "Boat", "Car", "Other"};

    static {
        medicalFormList.add(new MedicalForm("Hao", "1999", "Nam", "Viet Nam", "123321", "Car", "123321", "333", "10/01/2022", "10/03/2022", "Da Nang"));
        medicalFormList.add(new MedicalForm("Hoang", "1999", "Nam", "Viet Nam", "123321", "Car", "123321", "333", "10/01/2022", "10/03/2022", "Da Nang"));
        medicalFormList.add(new MedicalForm("Duy", "1999", "Nam", "Viet Nam", "123321", "Car", "123321", "333", "10/01/2022", "10/03/2022", "Da Nang"));
        medicalFormList.add(new MedicalForm("Toan", "1999", "Nam", "Viet Nam", "123321", "Car", "123321", "333", "10/01/2022", "10/03/2022", "Da Nang"));
        medicalFormList.add(new MedicalForm("Khanh", "1999", "Nam", "Viet Nam", "123321", "Car", "123321", "333", "10/01/2022", "10/03/2022", "Da Nang"));

    }


    @Override
    public List<MedicalForm> getAll() {
        return medicalFormList;
    }

    @Override
    public void save(MedicalForm medicalForm) {
        medicalFormList.add(medicalForm);
    }

    @Override
    public String[] getYear() {
        return year;
    }

    @Override
    public String[] getGender() {
        return gender;
    }

    @Override
    public String[] getCountry() {
        return country;
    }

    @Override
    public String[] getVehicle() {
        return vehicle;
    }
}


