import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        Faker faker = new Faker();
        ArrayList<Teacher> teacherList = new ArrayList<>();
        ArrayList<Student> studentsList = new ArrayList<>();

        for(int i = 0; i < 15; i ++){
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();

            Student newStudent = new Student(firstName, lastName, i, 1);
            studentsList.add(newStudent);

            System.out.println("Student Name: " + firstName + " " + lastName + "\nID: " + i);
        }

        for(int i =0; i < 3; i ++){
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();

            Teacher newTeacher = new Teacher(firstName, lastName, i, 1);
            teacherList.add(newTeacher);

            System.out.println("Student Name: " + firstName + " " + lastName + "\nID: " + i);

        }

        HashMap<Teacher, HashSet<Student>> teacherClass = new HashMap<>();

        for(int i=0; i < teacherList.size(); i++){
            Teacher teacher = teacherList.get(i);
            Integer studentMultiplier = i + 1;

            HashSet<Student> studentsInClass = new HashSet<>();

            for(int j=(studentsList.size()/teacherList.size()) * i; j < 5 * studentMultiplier; j ++ ){
                studentsInClass.add(studentsList.get(j));
            }
            teacherClass.put(teacher, studentsInClass);
        }

    }
}
