/**
 * Created by michaelssss on 16-1-8.
 */
public class Dogs {
    private int hungerPer = 0;

    public void bark() {
        System.out.println("Waing Waing Waing!");
    }

    public void walk() {
        System.out.println("I'm Walking");
    }

    public synchronized boolean eatwithsync() {
        if (hungerPer != 100) {
            System.out.println("I'm eating and the hungerPer is " + this.hungerPer);
            this.hungerPer++;
        } else {
            System.out.println("I'm full");
            return true;
        }
        return false;
    }

    public synchronized boolean ishungerwithsync() {
        return hungerPer == 100;
    }


    public boolean eatwithoutsync() {
        if (hungerPer != 100) {
            System.out.println("I'm eating and the hungerPer is " + this.hungerPer);
            this.hungerPer++;
        } else {
            System.out.println("I'm full");
            return true;
        }
        return false;
    }

    public boolean ishungerwithoutsync() {
        return hungerPer == 100;
    }


}
