package CoreJava;

public class GarbageCollectorDemo {

    int objId;

    GarbageCollectorDemo(int id){
        objId=id;
    }

    public static void main(String args[]){

        for(int i=0;i<100000;i++){
            new GarbageCollectorDemo(i);
            System.gc();
        }
    }

    @Override
    protected void finalize() {
        System.out.println("GC called for object with id: "+this.objId);
    }


}
