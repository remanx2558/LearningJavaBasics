package DesignPatternCourseAssignments.Template;

public abstract class ComputerManufacturer {

    void buildComputer(){
        addHardisk();
        addRam();
        addKeyboard();
    }
    abstract void addHardisk();
    abstract void addRam();
    abstract void addKeyboard();
}
