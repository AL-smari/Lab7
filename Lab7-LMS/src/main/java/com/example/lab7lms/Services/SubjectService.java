package com.example.lab7lms.Services;

import com.example.lab7lms.Model.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SubjectService {

    ArrayList<Subject>subjects=new ArrayList<>();

    public ArrayList<Subject> getSubjects(){

        return subjects;
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public boolean updateSubject(String id,Subject subject){
        for (int i = 0; i < subjects.size(); i++) {
            if(subjects.get(i).getId().equals(id)){
                subjects.set(i,subject);
                return true;
            }

        }
        return false;
    }

    public boolean deleteSubject(String id){
        for (int i = 0; i < subjects.size(); i++) {
            if(subjects.get(i).getId().equals(id)){
                subjects.remove(i);
                return true;
            }

        }
        return false;
    }

    public boolean changeNumberOfStudent(String id , int number){
        for (int i = 0; i < subjects.size(); i++) {
            if(subjects.get(i).getId().equals(id)){
                subjects.get(i).setNumberOfStudents(number);
                return true;

            }

        }
        return false;
    }
}
