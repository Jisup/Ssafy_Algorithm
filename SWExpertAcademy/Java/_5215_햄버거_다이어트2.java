

// 
//int n, l;
//pair<int, int> p[30];
//int dp[10004];
// 
//int main() {
//    int t;
//    scanf("%d", &t);
// 
//    for (int tc = 1; tc <= t; tc++) {
//        scanf("%d %d", &n, &l);
// 
//        memset(dp, 0, sizeof dp);
//        for (int i = 0; i < n; i++) {
//            scanf("%d %d", &p[i].first, &p[i].second);
// 
//            for (int j = l; j >= p[i].second; j--) {
//                if (dp[j] < p[i].first + dp[j - p[i].second])
//                    dp[j] = p[i].first + dp[j - p[i].second];
//            }
//        }
//        printf("#%d %d\n", tc, dp[l]);
//    }
//}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class _5215_햄버거_다이어트2 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static int N, Limit;
 
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 1 ~ 20
            Limit = Integer.parseInt(st.nextToken());
             
            int[][] arr = new int[N+1][2];
            for(int i = 1; i<= N; i++) { //0칸 기저 셋팅
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); //점수
                arr[i][1] = Integer.parseInt(st.nextToken()); //칼로리
            }
             
            // 0개, 0 제한 셋팅으로 +1칸
            // 행이 늘어날수록 고려하는 물건개수 늘어남
            // 열은 가능한 칼로리
            int[][] dp = new int[N+1][Limit+1];
             
            for(int i = 1; i<=N; i++) {
                for(int j = 1; j<=Limit; j++) {
                    int score = arr[i][0];
                    int kcal = arr[i][1];
                    if(j - kcal >=0) { //해당 칼로리를 먹어도 제한 이내라면
                        dp[i][j] = Math.max(dp[i-1][j-kcal] + score, dp[i-1][j]); //그 칼로리 먹은거랑 안먹은거랑 점수 뭐가 큰지 갱신
                    }
                    else //칼로리 넘으면 못고름
                        dp[i][j] = dp[i-1][j];
                }
            }
            sb.append("#" + tc + " " + dp[N][Limit] + "\n");
        } // end TC
        System.out.println(sb.toString());
    }
}