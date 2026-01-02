import java.util.stream.*;

class Solution {

    public String[] solution(String[] files) {
        return IntStream.range(0, files.length)
                        .mapToObj(i -> new File(files[i], i))   // 파일명 + 원래 index 포함 객체 생성
                        .sorted()                               // 커스텀 정렬
                        .map(i -> i.name)                       // 정렬된 원본 문자열 추출
                        .toArray(String[]::new);
    }

    class File implements Comparable<File> {
        String name;    // 원본 파일명
        String head;    // HEAD
        int number;     // NUMBER (정수)
        int index;      // 입력 순서 보존용 index

        File(String file, int index) {
            this.name = file;

            int i = 0;
            while (i < file.length() && !Character.isDigit(file.charAt(i))) i++;
            this.head = file.substring(0, i);  // HEAD 추출

            int j = i;
            while (j < file.length() && j - i < 5 && Character.isDigit(file.charAt(j))) j++;
            this.number = Integer.parseInt(file.substring(i, j));  // NUMBER 추출

            this.index = index;  // 입력 순서 저장
        }

        @Override
        public int compareTo(File o) {
            int headComp = this.head.toLowerCase().compareTo(o.head.toLowerCase());
            if (headComp != 0) return headComp;  // HEAD 비교

            int numberComp = Integer.compare(this.number, o.number);
            if (numberComp != 0) return numberComp;  // NUMBER 비교

            return Integer.compare(this.index, o.index);  // 입력 순서 유지
        }
    }
}