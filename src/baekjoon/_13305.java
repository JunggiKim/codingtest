package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 13305번: 주유소
 *
 * [문제 풀이 핵심]
 * - 각 도로에서는 반드시 한번씩만 이동(뒤로 불가)
 * - 기름통 용량이 무제한이므로 한 번에 필요만큼 원하는 만큼 넣을 수 있음
 * - 미래의 더 싼 가격이 나타나면 그 순간부터 계산 가격(minPrice)만 갱신
 * - 실제로는 각 도로별로 '필요한 만큼'만, '현재까지 등장한 최소 가격'으로만 계산 = 그리디
 */
public class _13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 도시 개수 입력 받기
        int n = Integer.parseInt(br.readLine());

        // 2. 도로 거리 입력(N-1개)
        long[] distances = new long[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }

        // 3. 각 도시별 리터당 가격 입력(N개)
        long[] prices = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }

        // 4. 그리디 알고리즘 시작
        long totalCost = 0;           // 정답: 여행 전체 최소 비용
        long minPrice = prices[0];    // 지금까지 본 도시 중 가장 싼 가격 (최초는 0번 도시부터 시작)

        // --- 코어 반복문 ---
        for(int i=0; i<n-1; i++) { // 마지막 도시는 도로가 없으므로 n-1까지 진행
            // 만약에 이번 도시 주유소 가격이 minPrice보다 더 싸면 minPrice 갱신
            // 즉, 그 순간부터 이후 구간은 가장 싼 값으로만 이동
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }

            // 이번 도로 구간 만큼(즉 distances[i]) 주유 비용을 현 minPrice로 합산
            // (필요 최소량만 충전하는 원리)
            totalCost += minPrice * distances[i];
        }

        // 5. 정답(최소 비용) 출력
        System.out.println(totalCost);
    }
}
