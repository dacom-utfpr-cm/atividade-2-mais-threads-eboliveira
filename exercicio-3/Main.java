/*
	Autor: Eduardo Barbosa de Oliveira RA: 1814559
	Repositório: https://github.com/dacom-utfpr-cm/atividade-2-mais-threads-eboliveira
	Data: 27/08/2019
	Problema: Faça um programa em Java com threads que exiba os números primos entre 0 e 100000.
*/
public class Main{
    public static void main(String[] args) throws InterruptedException {
	//cria as threads passando os seus respectivs ranges, starta cada uma delas e espera todas acabarem
        Thread t1 = new Thread(new MyThread(0, 24_999));
        Thread t2 = new Thread(new MyThread(25_000, 49_999));
        Thread t3 = new Thread(new MyThread(50_000,74_999));
        Thread t4 = new Thread(new MyThread(75_000, 100_000));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}