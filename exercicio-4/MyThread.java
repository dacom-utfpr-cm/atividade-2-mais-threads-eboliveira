import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

import java.util.Vector;

public class MyThread implements Runnable {
    private int sup_range;
    private int inf_range;
    private ThreadGroup group;
    private Vector<Integer> vector;
    private int value;
    private int return_value = -1;

    public MyThread(int inf_range, int sup_range, ThreadGroup group, Vector<Integer> vector, int value) {
        this.sup_range = sup_range;
        this.inf_range = inf_range;
        this.group = group;
        this.vector = vector;
        this.value = value;
    }

    @Override
    public void run() {
        try{

            for (int i = this.inf_range; i < this.sup_range; i++) {
                if(this.vector.get(i) == this.value ){
                    this.return_value = i;
                    this.group.interrupt();
                }
                if(Thread.currentThread().isInterrupted()){
                    throw new InterruptedException();
                }
            }
        }catch (InterruptedException e){
            System.out.println("Thread interrompida");
        }
    }

    public int getReturn_value() {
        return return_value;
    }
}