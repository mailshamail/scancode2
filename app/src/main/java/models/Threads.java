package models;

public class Threads extends Thread{

    public Thread getCurrentThread(){
        return currentThread();
    }

    @Override
    public void run() {
        super.run();

        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void stopThread(){
        if(isInterrupted()) {
            interrupt();
        }else{
            System.out.println(interrupted());
        }
    }
}
