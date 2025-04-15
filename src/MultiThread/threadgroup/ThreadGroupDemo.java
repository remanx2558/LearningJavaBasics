package MultiThread.threadgroup;

public class ThreadGroupDemo {
    public static void main(String args[]){

        //Concept1: Thread Grouping
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());


        //
        ThreadGroup parent=new ThreadGroup("ParentGroup");
        System.out.println(parent.getName());
        System.out.println(parent.getParent().getName());

        //
        ThreadGroup child=new ThreadGroup(parent,"ChildGroup");
        System.out.println(child.getName());
        System.out.println(child.getParent().getName());


        //Concept2: Thread using Thread Group
        Thread th1=new Thread(child, "Thread1");
        Thread th2=new Thread(child, "Thread2");
        child.setMaxPriority(4);
        Thread th3=new Thread(child, "Thread3");
        CustomThread th4=new CustomThread(child,"Thread4");
        CustomThread th5=new CustomThread(child,"Thread5");

        System.out.println(child.getName()+" group priority is: "+child.getMaxPriority());
        System.out.println(th1.getName()+" priority is: "+th1.getPriority());
        System.out.println(th2.getName()+" priority is: "+th2.getPriority());
        System.out.println(th3.getName()+" priority is: "+th3.getPriority());

        //Concept 3: Active Threads
        System.out.println(child.activeCount());
        System.out.println(child.activeGroupCount());

        th4.start();
        th5.start();

        System.out.println(child.activeCount());
        child.list();


        try{Thread.sleep(4000);}
        catch (InterruptedException ie){ie.printStackTrace();}

        System.out.println(child.activeCount());
        child.list();






    }
}
