package Questions;

        import java.util.*;

public class CarFleet {

    /**
     * N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
     * <p>
     * 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
     * <p>
     * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
     * <p>
     * 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
     * <p>
     * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
     * <p>
     * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
     * <p>
     * <p>
     * <p>
     * 会有多少车队到达目的地?
     * <p>
     * 输入：target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
     * 输出：3
     * 解释：
     * 从 10 和 8 开始的车会组成一个车队，它们在 12 处相遇。
     * 从 0 处开始的车无法追上其它车，所以它自己就是一个车队。
     * 从 5 和 3 开始的车会组成一个车队，它们在 6 处相遇。
     * 请注意，在到达目的地之前没有其它车会遇到这些车队，所以答案是 3。
     */

    static class Car {
        int position;
        int speed;

        public Car(int p, int s) {
            this.position = p;
            this.speed = s;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0)
            return 0;

        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        //降序
        Arrays.sort(cars, Comparator.comparingInt(car -> car.position));

        int ret = 1;
        float cur;
        float pre = (target - cars[cars.length - 1].position) / (float) cars[cars.length - 1].speed;
        // 需要从后往前遍历，计算时间
        for (int i = cars.length - 2; i >= 0; i--) {
            cur = (target - cars[i].position) / (float) cars[i].speed;
            if (cur > pre) {
                //后面的时间大于前面的时间，就不会追上，
                //因此ret++；
                ret++;
                pre = cur;
            }
        }
        return ret;
    }
}