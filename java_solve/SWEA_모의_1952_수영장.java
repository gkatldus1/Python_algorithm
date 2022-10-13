package swea.모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 29,528 kb , 115 ms

public class SWEA_모의_1952_수영장 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int T;
    // 변수를 잡을 때는 의미 있는 단어를 사용할 것 - 가독성, 소스코드 해석 용이
    static int[] ticket;
    static int[] plan;
    static int A;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 제출 시는 주석!
        // input = new BufferedReader(new StringReader(instr));
        
        T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            ticket = new int[4];
            tokens = new StringTokenizer(input.readLine());
            for (int i = 0; i < 4; i++) {
                ticket[i] = Integer.parseInt(tokens.nextToken());
            }
            // index를 입력과 맞춰주자.
            plan = new int[13];
            tokens = new StringTokenizer(input.readLine());
            for (int i = 1; i < plan.length; i++) {
                plan[i] = Integer.parseInt(tokens.nextToken());
            }

            // 입력 확인
            // System.out.println(Arrays.toString(ticket) +" : "+Arrays.toString(plan));

            // 전역 변수로 뽑을 때 주의 사항 - 초기화
            //A = Integer.MAX_VALUE;
            A = ticket[3]; // 1년권을 깔고 가자!!

            // 값 찾기
            check(1, 0);
            output.append(String.format("#%d %d%n", t, A));

        }// input
        System.out.println(output);
    }

    /**
     * 재귀의 파라미터들을 final 로 처리해서 부지불식간에 변경하는 것을 막아보자.
     * @param month
     *            : 문제의 크기 --> 기저조건
     * @param money
     *            : 구해야 할 값
     */
    static void check(final int month, final int money) {
        // base case
        if (month > 12) {
            // 비용 정산 - 기존에 가지고 있던 최소 vs 방금 찾은 값중 최소값
            A = Math.min(A, money);
            return;
        }
        // inductive case
        if (money > A) {
            return;
        }

        if (plan[month] == 0) {
            check(month+1, money +0);
        }else {
            // 이번달에 plan이 있다면 가능한 시도 해보기
            // 1일권 사용
            check(month+1,  money + plan[month] * ticket[0]);
            // 1개월권 사용
            check(month+1, money + ticket[1]);
            // 3개월권 사용
            check(month+3, money + ticket[2]);
        }
    }

    public static String instr = "10\n"      // T.C
                               + "10 40 100 300\n"            // ticket price - 4개
                               + "0 0 2 9 1 5 0 0 0 0 0 0\n"  // 월별 plan - 12개
                               + "10 100 50 300\n"
                               + "0 0 0 0 0 0 0 0 6 2 7 8\n"
                               + "10 70 180 400\n"
                               + "6 9 7 7 7 5 5 0 0 0 0 0\n"
                               + "10 70 200 550\n"
                               + "0 0 0 0 8 9 6 9 6 9 8 6\n"
                               + "10 80 200 550\n"
                               + "0 8 9 15 1 13 2 4 9 0 0 0\n"
                               + "10 130 360 1200\n"
                               + "0 0 0 15 14 11 15 13 12 15 10 15\n"
                               + "10 180 520 1900\n"
                               + "0 18 16 16 19 19 18 18 15 16 17 16\n"
                               + "10 100 200 1060\n"
                               + "12 9 11 13 11 8 6 12 8 7 15 6\n"
                               + "10 170 500 1980\n"
                               + "19 18 18 17 15 19 19 16 19 15 17 18\n"
                               + "10 200 580 2320\n"
                               + "12 28 24 24 29 25 23 26 26 28 27 22";
}
