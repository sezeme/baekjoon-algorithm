import java.util.*;

class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        Arrays.fill(student, 1);

        // 도난 처리
        for (int i : lost) student[i - 1]--;

        // 여벌 체육복 처리
        for (int i : reserve) student[i - 1]++;

        int count = 0;

        for (int i = 0; i < n; i++) {
            // 체육복이 없는 경우
            if (student[i] == 0) {
                // 앞 학생에게 빌릴 수 있는 경우
                if (i > 0 && student[i - 1] == 2) {
                    student[i]++;
                    student[i - 1]--;
                }
                // 뒷 학생에게 빌릴 수 있는 경우
                else if (i < n - 1 && student[i + 1] == 2) {
                    student[i]++;
                    student[i + 1]--;
                }
            }

            // 체육복이 있는 학생이면 수업 가능
            if (student[i] > 0) count++;
        }

        return count;
    }
}