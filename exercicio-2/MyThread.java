
public class MyThread implements Runnable{
    @Override
    public void run(){
        try {
            while(true){
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
        }
    }
}