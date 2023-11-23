package com.example.lab7lms.Services;

import com.example.lab7lms.Model.Subject;
import com.example.lab7lms.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getTeachers (){

        return teachers;
    }
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }
    public boolean updateTeacher(String id , Teacher teacher){
        for (int i = 0; i < teachers.size(); i++) {
            if(teachers.get(i).getId().equals(id)){
                teachers.set(i,teacher);
                return true;
            }

        }
        return false;
    }

    public boolean deleteTeacher(String id){
        for (int i = 0; i < teachers.size(); i++) {

            if(teachers.get(i).getId().equals(id)){
                teachers.remove(i);
                return true;
            }

        }
        return false;
    }

    public boolean addSubjectToTeacher(ArrayList<Subject> subjects , String teacherId,String subjectId){
        for (int i = 0; i < teachers.size(); i++) {
            if(teachers.get(i).getId().equals(teacherId)){
                for (int j = 0; j < subjects.size(); j++) {
                    if(subjects.get(i).getId().equals(subjectId)){
                        teachers.get(i).setSubject(subjects.get(j));
                        return true;
                    }

                }
            }

        }
        return false;
    }

    public Teacher getBySubject(String id){
        for (int i = 0; i < teachers.size(); i++) {
            if(teachers.get(i).getSubject().getId().equals(id)){
                return teachers.get(i);
            }

        }
        return null;
    }
    
    public boolean changeBook(String id,String book){
        for (int i = 0; i < teachers.size(); i++) {
            if(teachers.get(i).getId().equals(id)&&teachers.get(i).getSubject()!=null){
                teachers.get(i).getSubject().setBook(book);
                return true;
            }
            
        }
        return false;
    }

}
