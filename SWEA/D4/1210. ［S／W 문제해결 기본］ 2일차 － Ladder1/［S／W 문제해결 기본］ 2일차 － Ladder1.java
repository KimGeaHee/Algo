import java.io.FileInputStream;
import java.util.Scanner;

//[SW문제 해결 기본] 2일차 - Ladder1(1210-D4)
public class Solution {
	static int[][] ladder=new int [100][100];
	static boolean find=false;         // 출구(2)를 찾으면 true
	
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int T=sc.nextInt();
			find=false;
			int start=0;       // 시작점을 기억할 변수(출구를 찾았을 경우 시작점을 가지고 탈출)
			
			//사다리타기 배열생성------------------------------------
			for(int row=0; row<100; row++) {
				for(int col=0; col<100; col++) {
					ladder[row][col]=sc.nextInt();
				}
			}
			
			//사다리타기-------------------------------------------
			for(int col=0; col<100; col++) {
				if(ladder[0][col]==1) {
					findX(0,col);     //출발점: (0,0),(0,1),(0,2) ~ (0,99)
					
					if(find) {
						start=col;   // 시작점을 start 대입
						break;
					}
				}
			}
			System.out.println("#" + T + " " + start);
		}
	}
	
	//사다리타기 알고리즘------------------
	public static void findX(int i, int j) {
		boolean visited[][]=new boolean[100][100];
		
		while(i<100) {
			visited[i][j]=true;   //지나온길
			if(ladder[i][j]==2) {
				find=true;
				break;
			}
			
			if(j-1>=0 && ladder[i][j-1]==1 && visited[i][j-1]==false) {  //왼쪽으로 이동
				j--;
			}else if(j+1<100 && ladder[i][j+1]==1 && visited[i][j+1]==false) {  //오른쪽으로 이동
				j++;
			}else {  //아래로 이동
				i++;
			}
		}
	}
}