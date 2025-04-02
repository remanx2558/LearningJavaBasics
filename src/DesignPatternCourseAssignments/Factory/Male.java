package DesignPatternCourseAssignments.Factory;

public class Male implements Person{

    @Override
    public void wish(String msg) {
        System.out.println("Male: "+msg);
    }
}
