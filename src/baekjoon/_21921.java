package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 21921번: 블로그
 *
 * [문제 풀이 핵심]
 * - 입력된 방문자 기록(배열)을 날짜 순서대로 놓고, 연속 X일 구간별 합을 계산한다
 * - 슬라이딩 윈도우(투 포인터)로 O(N)에 모든 구간의 합을 빠르게 구한다
 * - 최대 방문자 수(maxSum)를 기록하고, 그 최대값이 나온 기간의 개수(count)를 센다
 * - 만약 최대 방문자 수가 0이면 "SAD"만 출력한다(기간 개수는 출력하지 않음)
 */
public class _21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 첫 줄: 전체 기간(N)과 구간 길이(X) 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 전체 기간(방문자 기록 개수)
        int x = Integer.parseInt(st.nextToken()); // 연속 구간 길이(X일)

        // 2. 둘째 줄: N일 방문자 수 배열 입력 받기
        int[] inputs = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken()); // 날짜순 입력 그대로 저장
        }

        // 3. 초기값 설정: 첫 X일 합계를 구함
        int sum = 0; // 현재 구간 방문자 합
        for (int i = 0; i < x; i++) {
            sum += inputs[i]; // 첫 X일 구간 합 구하기
        }

        int maxSum = sum; // 최대 방문자 합 초기값은 첫 구간의 합으로
        int count = 1;    // 최대값 나오는 기간 개수(일단 첫 구간으로 1부터 시작)

        // 4. 슬라이딩 윈도우: 구간을 한 칸씩 오른쪽으로 옮기면서 합계 갱신
        for (int i = x; i < n; i++) {
            // 맨 왼쪽 값을 빼고, 새로 들어오는 값을 더해 새로운 구간 합 계산
            sum = sum - inputs[i - x] + inputs[i];

            // 구간 합이 기존 최대값보다 크면, 최대값을 갱신하고 기간 개수는 1로 리셋
            if (sum > maxSum) {
                maxSum = sum;
                count = 1;
            }
            // 구간 합이 현재 최대값과 같다면 기간 개수를 1 증가
            else if (sum == maxSum) {
                count++;
            }
            // 구간 합이 작으면 아무것도 하지 않음
        }

        // 5. 출력
        // 만약 최대 방문자 수가 0이면 "SAD"만 출력
        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum); // 첫 줄: 최대 방문자 수
            System.out.println(count);  // 둘째 줄: 최대값 나온 기간 개수
        }
    }
}
