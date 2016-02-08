/**
 * Created by michaelssss on 16-2-8.
 */
public class mainThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new sendThread());
        thread.start();
        long count = 0;
        long begin = System.nanoTime();
        while (true) {
            try {
                Thread.sleep(Timer.getMins() * 30);
                count += 5;
                System.out.println("已经过去了：" + count + " 秒");
                System.out.println("间隔：" + (System.nanoTime() - begin) + " ms");
                begin = System.nanoTime();
            } catch (Exception e) {

            }
        }
    }
}
