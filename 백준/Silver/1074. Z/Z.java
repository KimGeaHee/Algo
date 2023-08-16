import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int tr;
	static int tc;

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String[] nrc = bReader.readLine().split(" ");
		int n = Integer.parseInt(nrc[0]);
		tr = Integer.parseInt(nrc[1]);
		tc = Integer.parseInt(nrc[2]);
		int size = (int) Math.pow(2, n);
		f(size);
	}

	public static void f(int l) {
		int r=0;
		int c=0;
		int cnt=0;
		while (true) {
			if(r==tr && c==tc) {
				break;
			}
			l = l / 2;
			if (tr < r+l && tc < c+l) {
				continue;
			} else if (tr < r+l && tc >= c+l) {
				c+=l;
				cnt+=l*l;
			} else if (tr >= r+l && tc < c+l) {
				r+=l;
				cnt+=(l*l)*2;
			} else {
				r+=l;
				c+=l;
				cnt+=(l*l)*3;
			}
		}
		System.out.println(cnt);
	}
}