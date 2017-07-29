package dao;

import persistence.Doctor;
import java.util.List;


public interface DoctorsService {

    Doctor getDoctorById(long id);
    void addDoctor(Doctor doc);
    Doctor addDoctor(String firstName,String lastName, long specialization);
    Doctor updateDoctor
            (Doctor doc, String firstName, String lastName, long specialization);
    Doctor updateDoctor
            (long id, String firstName, String lastName, long specialization);
    void deleteDoctor(Doctor doc);
    void deleteDoctor(long id);
    List<Doctor> getAllDoctors();
    List<Doctor> getDoctorsBySpecialization(long spec);

}
