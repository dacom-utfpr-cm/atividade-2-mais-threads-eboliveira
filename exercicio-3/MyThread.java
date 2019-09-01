
public class MyThread implements Runnable {
    //ranges inferior e superior que a thread é responsável por verificar
    private int sup_range, inf_range;

    public MyThread(int inf_range, int sup_range) {
        this.sup_range = sup_range;
        this.inf_range = inf_range;
    }
    //verifica se o número é primo
    boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    @Override
    public void run() {
        //itera nos ranges e printa os que são primos
        for (int i = this.inf_range; i < this.sup_range; i++) {
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }
}