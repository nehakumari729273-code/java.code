import java.util.*;

public class Queen {

    public static boolean issafe(int r, int c, char[][] b) {

        for (int j = 0; j < b.length; j++) {
            if (b[r][j] == 'Q') {
                return false;
            }
        }

        for (int i = 0; i < b.length; i++) {
            if (b[i][c] == 'Q') {
                return false;
            }
        }

        int x = r;
        for (int y = c; y >= 0 && x >= 0; y--, x--) {
            if (b[x][y] == 'Q') {
                return false;
            }
        }

        x = r;
        for (int y = c; y < b.length && x >= 0; y++, x--) {
            if (b[x][y] == 'Q') {
                return false;
            }
        }

        x = r;
        for (int y = c; x < b.length && y >= 0; y--, x++) {
            if (b[x][y] == 'Q') {
                return false;
            }
        }

        x = r;
        for (int y = c; y < b.length && x < b.length; y++, x++) {
            if (b[x][y] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void saveboard(char[][] b, List<List<String>> a) {
        List<String> n = new ArrayList<>();

        for (int i = 0; i < b.length; i++) {
            String s = "";

            for (int j = 0; j < b[0].length; j++) {
                if (b[i][j] == 'Q') {
                    s += 'Q';
                } else {
                    s += '.';
                }
            }

            n.add(s);
        }

        a.add(n);
    }

    public static void solve(char[][] b, List<List<String>> a, int c) {

        if (c == b.length) {
            saveboard(b, a);
            return;
        }

        for (int r = 0; r < b.length; r++) {
            if (issafe(r, c, b)) {
                b[r][c] = 'Q';
                solve(b, a, c + 1);
                b[r][c] = '.';
            }
        }
    }

    public static void solution(int n) {

        List<List<String>> a = new ArrayList<>();
        char[][] b = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = '.';
            }
        }

        solve(b, a, 0);

        for (List<String> x : a) {
            for (int i = 0; i < x.size(); i++) {
                System.out.println(x.get(i));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solution(4);
    }
}
