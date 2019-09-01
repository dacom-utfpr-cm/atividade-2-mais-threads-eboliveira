import java.util.ArrayList;
import java.util.Vector;

/*
	Autor: Eduardo Barbosa de Oliveira RA: 1814559
	Repositório: https://github.com/dacom-utfpr-cm/atividade-2-mais-threads-eboliveira
	Data: 27/08/2019
	Problema: Faça um programa em Java que realize uma busca paralela em um vetor de inteiros.
	Informe para o método: valor procurado, vetor de inteiros e o número de threads.
*/
public class Main {
    public static int parallel_search(int value, Vector<Integer> vector, int threadLen) throws InterruptedException {
        int index = -1;
        int range_len = (int) Math.ceil((double) vector.size() / (double) threadLen);
        int return_value = -1;
        ThreadGroup group = new ThreadGroup("group1");
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<MyThread> myThreads = new ArrayList<>();
        for (int i = 0; i < threadLen; i++) {
            int inf_range = i * range_len;
            int sup_range;
            if (i == threadLen - 1) {
                sup_range = vector.size() - 1;
            } else {
                sup_range = ((i + 1) * range_len) - 1;
            }
            MyThread myThread = new MyThread(inf_range, sup_range, group, vector, value);
            Thread t = new Thread(group, myThread);
            threads.add(t);
            myThreads.add(myThread);
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        for (MyThread t : myThreads) {
            if(t.getReturn_value() != -1){
                return_value = t.getReturn_value();
            }
        }
        return return_value;
    }

    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < 1000; i++) {
            vector.add(i);
        }
        int index  = parallel_search(100, vector, 7);
        if(index == -1){
            System.out.println("Valor não encontrado");
        }else{
            System.out.println("Valor encontrado na posição: " + index);
        }
    }

}