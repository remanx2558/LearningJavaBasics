package DesignPatternCourseAssignments.Template;

public class DesktopManufacturer extends ComputerManufacturer{
    @Override
    void addHardisk() {
        System.out.println("Laptop HardDisk added");
    }

    @Override
    void addRam() {
        System.out.println("Laptop Ram added");
    }

    @Override
    void addKeyboard() {
        System.out.println("Laptop Keyboard added");
    }
}
