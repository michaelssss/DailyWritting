
/**
 * 作者：梁煜铭
 * <p>
 * 创建时间： 2016 年- 01 月- 25 日
 * <p>
 * 类作用：
 */
public class schedule {
    public static void main(String[] args) {
        long count = 0;
        long begin = System.nanoTime();
        while (true) {
            try {
                Thread.sleep(Timer.getSecond() * 5);
                count += 5;
                System.out.println("已经过去了：" + count + " 秒");
                System.out.println("间隔：" + (System.nanoTime() - begin) + " ms");
                begin = System.nanoTime();
            } catch (Exception e) {

            }
        }
    }
}
