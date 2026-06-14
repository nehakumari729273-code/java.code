1 import java.util.*;
class PrimsAlgorithm
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int i,j,n,k,min=0,u=0,v=0,sum=0,flag=0;
		int w[][]=new int[10][10];
		int sol[]=new int[10];
		System.out.println("Enter the no. of vertex");
		n=sc.nextInt();
		if(n==1)
		{
			System.out.println("No path form");
		}
		System.out.println("Enter the Cost matrix");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				w[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter the source matrix");
		int s=sc.nextInt();
		sol[s]=1;
		k=1;
		while(k<=n-1)
		{
			min=99;
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=n;j++)
				{
					if(sol[i]==1 && sol[j]==0)
					{
						if(i!=j && w[i][j]<min)
						{
							min=w[i][j];
							u=i;
							v=j;
						}
					}
				}
			}
			if(min==99)
			{
				break;
			}
			sol[v]=1;
			sum+=min;
			k++;
			System.out.println(u+" ---->  "+v+" = "+min);
		
		if(sol[i]==1)
		{
			flag=1;
			 break;
		}
		}
		if(flag==1)
		{
			System.out.print("No Spanning Tree");
		}
		else
		{
			System.out.println("MST "+sum);
		}
	}
}
2 import java.util.*;
public class Kruskal
{
	static int []parent=new int[10];
	static int find(int a)
	{
		while(parent[a]!=0)
		{
			a=parent[a];
		}
		return a;
	}
	static void union(int a,int b)
	{
		parent[b]=a;
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n,i,j,a=0,b=0,v=0,u=0,edge=1,min,cost=0;
		int[][]w=new int[10][10];
		System.out.println("Enter the number of vertex");
		n=sc.nextInt();
		System.out.println("Enter the cost matrix");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				w[i][j]=sc.nextInt();
				if(w[i][j]==0)
				{
					w[i][j]=99;
				}
			}
		}
		while(edge<n)
		{
			min=99;
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=n;j++)
				{
					if(w[i][j]<min)
					{
						min=w[i][j];
						a=i;
						b=j;
					}
				}
			}
			u=find(a);
			v=find(b);
			if(u!=v)
			{
				System.out.println("( "+a+","+b+")= "+min);
				cost+=min;
				union(u,v);
				edge++;
			}
			w[a][b]=w[b][a]=99;
		}
		System.out.println("The min cost "+cost);
	}
}
3 package dAA;

import java.util.*;

public class Dijkstra
{
    public int distance[] = new int[10];
    public int cost[][] = new int[10][10];

    public void calc(int n, int s)
    {
        int flag[] = new int[n + 1];
        int i, minpos = 1, k, c, minimum;

        for(i = 1; i <= n; i++)
        {
            flag[i] = 0;
            this.distance[i] = this.cost[s][i];
        }

        c = 2;

        while(c <= n)
        {
            minimum = 99;

            for(k = 1; k <= n; k++)
            {
                if(this.distance[k] < minimum && flag[k] != 1)
                {
                    minimum = this.distance[k];
                    minpos = k;
                }
            }

            flag[minpos] = 1;
            c++;

            for(k = 1; k <= n; k++)
            {
                if((this.distance[minpos] + this.cost[minpos][k]
                        < this.distance[k]) && flag[k] != 1)
                {
                    this.distance[k] =
                        this.distance[minpos] + this.cost[minpos][k];
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int nodes, source, i, j;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of nodes");
        nodes = in.nextInt();

        Dijkstra d = new Dijkstra();

        System.out.println("Enter the cost matrix weights");

        for(i = 1; i <= nodes; i++)
        {
            for(j = 1; j <= nodes; j++)
            {
                d.cost[i][j] = in.nextInt();

                if(d.cost[i][j] == 0)
                {
                    d.cost[i][j] = 999;
                }
            }
        }

        System.out.println("Enter the source vertex");
        source = in.nextInt();

        d.calc(nodes, source);

        System.out.println("The Shortest Path is");

        for(i = 1; i <= nodes; i++)
        {
            if(i != source)
            {
                System.out.println(
                    source + " --> " + i +
                    " : " + d.distance[i]
                );
            }
        }
    }
}
6 import java.util.*;
public class TSP
{
	static int besttour[]=new int[10];
	static int mincost=Integer.MAX_VALUE;
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int [][]c=new int[10][10];
		int [] tour=new int[10];
		System.out.println("Enter the number of cities");
		int n=sc.nextInt();
		if(n==1)
		{
			System.out.println("Path is not Possible");
		}
		System.out.println("Enter the cost matrix");
		{
			for(int i=1;i<=n;i++)
			{
				for(int j=1;j<=n;j++)
				{
					c[i][j]=sc.nextInt();
				}
			}
		}
		for(int i=1;i<=n;i++)
		{
			tour[i]=i;
		}
		tsp(c,tour,2,n);
		System.out.println("The Optimal tour is");
		for(int i=1;i<=n;i++)
		{
			System.out.print(besttour[i]+" -----> ");
		}
		System.out.println("\nThe minimum cost = "+mincost);
	}
	static void tsp(int c[][],int tour[],int start,int n)
	{
		if(start>n)
		{
			int cost=0;
			for(int i=1;i<=n;i++)
			{
				cost+=c[tour[i]][tour[i+1]];
			}
			cost+=c[tour[n]][tour[1]];
			if(cost<mincost)
			{
				mincost=cost;
				for(int i=1;i<=n;i++)
				{
					besttour[i]=tour[i];
				}
			}
			return;
		}
		for(int i=start;i<=n;i++)
		{
			swap(tour,start,i);
			tsp(c,tour,start+1,n);
			swap(tour,start,i);
		}
	}
	static void swap(int tour[],int start,int i)
	{
		int temp= tour[start];
		tour[start]=tour[i];
		tour[i]=temp;
	}
}
7 import java.util.*;
public class DKnapsack
{int n, c, p[], w[], v[][];
public DKnapsack(int n, int c, int[] p, int[] w)
{this.n = n;this.c = c;
this.p = p;this.w = w;
this.v = new int[n + 1][c + 1];}
void compute(){
for(int i = 0; i <= n; i++){
for(int j = 0; j <= c; j++)
{if(i == 0 || j == 0)
 {
                    v[i][j] = 0;
                }
                else
                {
                    if(j - w[i] >= 0)
                    {
                        v[i][j] = max(v[i - 1][j],p[i] + v[i - 1][j - w[i]]);
                    }
                    else
                    {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        System.out.println("Optimal Solution : " + v[n][c]);
        traceback();
    }

    void traceback()
    {
        System.out.println("The Objects picked up into Knapsack are:");
        int i = n;
        int j = c;

        while(i > 0)
        {
            if(v[i][j] != v[i - 1][j])
            {
                System.out.print(i + " ");
                j = j - w[i];
            }
            i--;
        }
    }

    private int max(int i, int j)
    {
        return (i > j) ? i : j;
    }

    public static void main(String[] args)
    {
        int n;
        int c;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the no. of objects");
        n = sc.nextInt();

        int[] p = new int[n + 1];
        int[] w = new int[n + 1];

        System.out.println("Enter the capacity of Knapsack");
        c = sc.nextInt();

        System.out.println("Enter the profit for each of the ith objects");
        for(int i = 1; i <= n; i++)
        {
            p[i] = sc.nextInt();
        }

        System.out.println("Enter weights for each of the ith objects");
        for(int i = 1; i <= n; i++)
        {
            w[i] = sc.nextInt();
        }

        DKnapsack dk = new DKnapsack(n, c, p, w);
        dk.compute();

        sc.close();
    }
}
8 import java.util.*;

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
9.import java.util.*;

public class Subset {
    static int c = 0;

    public static void main(String[] args) {
        int w[] = new int[10];
        int n, d, i, sum = 0;
        int x[] = new int[10];
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("====== SUBSET PROBLEM ======");
        System.out.println("Enter the number of elements: ");
        n = sc.nextInt();
        
        System.out.println("Enter the elements in increasing order: ");
        for (i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        
        System.out.println("Enter the value of d: ");
        d = sc.nextInt();
        
        for (i = 0; i < n; i++) {
            sum = sum + w[i];
        }
        
        System.out.println("Sum: " + sum);
        if (sum < d || w[0] > d) {
            System.out.println("Subset is not possible");
            System.out.println("================");
            System.exit(0);
        }
        
        finalsubset(0, 0, sum, x, w, d);
        
        if (c == 0) {
            System.out.println("Subset is not possible");
            System.out.println("********");
        }
        
        sc.close();
    }

    static void finalsubset(int cs, int k, int r, int x[], int w[], int d) {
        x[k] = 1;
        if (cs + w[k] == d) {
            c++;
            System.out.println("\nSolution " + c + " is { ");
            for (int i = 0; i <= k; i++) {
                if (x[i] == 1) {
                    System.out.print(w[i] + " ");
                }
            }
            System.out.println("}");
        } 
        else if (cs + w[k] + w[k + 1] <= d) {
            finalsubset(cs + w[k], k + 1, r - w[k], x, w, d);
        }
        
        if ((cs + r - w[k] >= d) && (cs + w[k + 1] <= d)) {
            x[k] = 0;
            finalsubset(cs, k + 1, r - w[k], x, w, d);
        }
    }
}
10.pakage dAA;
import java.util.*;

public class Hamiltonian {
    static int[] x = new int[25];

    static void Next_Vertex(int G[][], int n, int k) {
        int j;
        while (true) {
            x[k] = (x[k] + 1) % (n + 1);
            if (x[k] == 0) {
                return;
            }
            if (G[x[k - 1]][x[k]] != 0) {
                for (j = 1; j <= k - 1; j++) {
                    if (x[j] == x[k]) {
                        break;
                    }
                }
                if (j == k) {
                    if ((k < n) || (k == n && G[x[n]][x[1]] != 0)) {
                        return;
                    }
                }
            }
        }
    }

    static void H_Cycle(int G[][], int n, int k) {
        int i;
        while (true) {
            Next_Vertex(G, n, k);
            if (x[k] == 0) {
                return;
            }
            if (k == n) {
                System.out.println("\n");
                for (i = 1; i < n; i++) {
                    System.out.print(x[i] + " ---> ");
                }
                System.out.println(x[n]);
            } else {
                H_Cycle(G, n, k + 1);
            }
        }
    }

    public static void main(String[] args) {
        int i, j, n;
        int[][] G = new int[25][25];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();

        System.out.println("Enter the adjacency matrix: ");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                G[i][j] = sc.nextInt();
            }
        }

        x[1] = 1;
        for (i = 2; i <= n; i++) {
            x[i] = 0;
        }

        System.out.println("Hamiltonian Cycles: ");
        H_Cycle(G, n, 2);

        sc.close();
    }
}
