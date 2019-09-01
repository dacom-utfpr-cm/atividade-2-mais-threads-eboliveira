
public class MyThread implements Runnable{
    @Override
    public void run(){
        try {
            while(true){
                //espera para ser interrompida
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
        }
    }
}