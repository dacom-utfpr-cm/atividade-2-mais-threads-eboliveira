/*
	Autor: Eduardo Barbosa de Oliveira RA: 1814559
	Repositório: https://github.com/dacom-utfpr-cm/atividade-2-mais-threads-eboliveira
	Data: 26/08/2019
	Problema: Faça um programa em Java que consulte periodicamente o estado de um conjunto de threads.
*/
public class Main{
    public static void main(String[] args) throws InterruptedException {
        //Cria as threads que serão monitoradas
        Thread t1 = new Thread(new MyThread(), "0");
        Thread t2 = new Thread(new MyThread(), "1");
        Thread t3 = new Thread(new MyThread(), "2");
        //Inicia as threads que serão monitoradas
        t1.start();
        t2.start();
        t3.start();
        //Inicia o monitor
        Monitor monitor = new Monitor();
        //Adiciona as threads para serem monitoradas
        monitor.addThread(t1);
        monitor.addThread(t2);
        monitor.addThread(t3);
        //Cria a thread do monitor
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();
        //Espera e interrompe as threads uma a uma
        Thread.sleep(3000);
        t1.interrupt();
        Thread.sleep(3000);
        t2.interrupt();
        Thread.sleep(3000);
        t3.interrupt();
        Thread.sleep(3000);
    }
}