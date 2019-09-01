import java.util.Vector;

public class Monitor implements Runnable{
    private Vector<Thread> threads = new Vector<>();
    @Override
    public void run() {
        while(true){
            try {
                for(Thread t:this.threads){
                    //Mostra o estado das threads monitoradas
                    System.out.println("Estado da Thread " + t.getName() + ": "  + t.getState() );
                }
                System.out.println();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addThread(Thread t){
        this.threads.add(t);
    }
}
