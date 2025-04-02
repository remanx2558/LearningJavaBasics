package DesignPatternCourseAssignments.Factory;

public class PersonFactory {

    public static Person getPerson(String type){
        if(type.equalsIgnoreCase("male")){
            return new Male();
        }
        else{
            return new Female();
        }
    }
}
