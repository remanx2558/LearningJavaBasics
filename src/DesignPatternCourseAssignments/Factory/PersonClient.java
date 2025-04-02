package DesignPatternCourseAssignments.Factory;

public class PersonClient {
    public static void main(String args[]){
        Person male=PersonFactory.getPerson("male");
        Person female=PersonFactory.getPerson("female");

        male.wish("I want to be Engineer");
        female.wish("I want to be Nurse");

    }
}
