package DesignPatternCourseAssignments.singleton;

public class Logger implements Cloneable {

    private static volatile Logger instance;

    //singleton logic
    public static Logger getInstance(){

        if(instance==null){
            synchronized (Logger.class){
                if(instance==null){
                    return instance;
                }
            }
        }

        return instance;
    }
    //Bussiness logic
    public void log(String str){
        System.out.println(str);
    }


    //Helper logic
    @Override
    protected Object clone() throws CloneNotSupportedException {

        throw new CloneNotSupportedException("Singlton class cannot be cloned");
       // return super.clone();
    }
}


/*Requirements

1. log(message): print on screen using sis out statement
2. make it thread safe( Multithreading related)
3.cannot be cloned

 */
