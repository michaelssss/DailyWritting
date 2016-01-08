import java.util.ArrayList;
import java.util.List;

/**
 * Created by michaelssss on 16-1-8.
 */
public class MutiProcessDemo implements Runnable {
    private Dogs dogs;
    private boolean aBoolean;

    public MutiProcessDemo(Dogs dogs, boolean b) {
        setDogs(dogs);
        this.aBoolean = b;
    }

    public static void main(String[] args) {
        /**
         * 从这里可以这是是否选择多线程同步锁方式。
         * 通过实验能够很明显观察到，如果采用多线程喂狗，事实上你不知道狗什么时候被撑死
         */
        boolean isSync = true;
        List<Thread> list = new ArrayList<Thread>();
        Dogs dogs = new Dogs();
        for (int i = 0; i < 100; i++) {
            list.add(new Thread(new MutiProcessDemo(dogs, isSync)));
        }
        for (Thread thread : list) {
            thread.start();
        }
        if (isSync) {
            while (dogs.ishungerwithsync()) ;
        } else {
            while (dogs.ishungerwithoutsync()) ;
        }
    }

    public void setDogs(Dogs dogs) {
        this.dogs = dogs;
    }

    @Override
    public void run() {
//        dogs.bark();
//        dogs.walk();
        if (this.aBoolean) {
            while (dogs.eatwithsync()) ;
        } else while (dogs.eatwithoutsync()) ;
    }
}

