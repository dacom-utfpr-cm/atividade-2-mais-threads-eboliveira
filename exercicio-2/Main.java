/*
	Autor: Eduardo Barbosa de Oliveira RA: 1814559
	Repositório: https://github.com/dacom-utfpr-cm/atividade-2-mais-threads-eboliveira
	Data: 27/08/2019
	Problema: Faça um programa em Java para testar um conjunto de operações sobre um grupo de threads. Use o ThreadGroup.

*/
public class Main{
    public static void main(String[] args) throws InterruptedException {
        //cria o grupo de threads
        ThreadGroup threadGroup = new ThreadGroup("group1");
        //adiciona os grupos de threads
        Thread t1 = new Thread(threadGroup, new MyThread(), "0");
        Thread t2 = new Thread(threadGroup, new MyThread(), "1");
        Thread t3 = new Thread(threadGroup, new MyThread(), "2");
        t1.start();
        t2.start();
        t3.start();
        //mostra o estados das threads
        System.out.println(t1.getState());
        System.out.println(t2.getState());
        System.out.println(t3.getState());
        //interrompe todas as threads
        threadGroup.interrupt();
        //espera as threads serem interrompidas
        Thread.sleep(100);
        //mostra o estados das threads
        System.out.println(t1.getState());
        System.out.println(t2.getState());
        System.out.println(t3.getState());
    }
}