public class Concorrencia extends Thread {
    public void run() {

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("OI");
    }

}
