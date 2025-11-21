import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        final int t = bandage[0], x = bandage[1], y = bandage[2];

        int hp = health;
        int prevTime = 0;

        for (int[] atk : attacks) {
            int time = atk[0];
            int dmg  = atk[1];

            int elapsed = time - prevTime - 1;
            if (elapsed > 0 && hp > 0) {
                long heal = (long) elapsed * x + (long) (elapsed / t) * y;
                hp = (int) Math.min(health, hp + heal);
            }

            hp -= dmg;
            if (hp <= 0) return -1;

            prevTime = time;
        }
        
        return hp;
    }
}

