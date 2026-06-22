2 package dAA;
import java.util.Scanner;

public class Uniqueness {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean found;
        System.out.println("Unique Elements: ");
        for (int i = 0; i < n; i++) {
            found = false;
            for (int j = 0; j < n; j++) {
                if (i != j && arr[i] == arr[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println(arr[i]);
            }
        }
        System.out.println("Duplicate Elements: ");
        for (int i = 0; i < n; i++) {
            found = false;
            for (int k = 0; k < i; k++) {
                if (arr[i] == arr[k]) {
                    found = true;
                    break;
                }
            }
            
            if (found) continue;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > 1) {
                System.out.println(arr[i]);
            }
        }
        
        sc.close();
    }
}
3 package dAA;
import java.util.*;
public class Sieve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        boolean[] bool = new boolean[num + 1];
        for (int i = 0; i < bool.length; i++) {
            bool[i] = true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (bool[i] == true) {
                for (int j = (i * i); j <= num; j = j + i) {
                    bool[j] = false;
                }
            }
        }
        System.out.println("List of prime numbers up to " + num + " are: ");
        for (int i = 2; i < bool.length; i++) {
            if (bool[i] == true) {
                System.out.println(i);
            }
        }
        
        sc.close();
    }
}
5 package dAA;
import java.util.*;
class MergeSort
{
	static void sort(int n[],int l,int h)
	{
		int m=(l+h)/2;
		if(l<h)
		{
			sort(n,l,m);
			sort(n,m+1,h);
			merge(n,l,m,h);
		}
	}
	static void merge(int n[],int l,int m,int h)
	{
		int i=l,j=m+1,k=l;
		int b[]=new int[n.length];
		while(i<=m && j<=h)
		{
			b[k++]=(n[i]<n[j])?n[i++]:n[j++];
		}
		while(i<=m)
		{
			b[k++]=n[i++];
		}
		while(j<=h)
		{
			b[k++]=n[j++];
		}
		for(i=l;i<=h;i++)
		{
			n[i]=b[i];
		}
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n=sc.nextInt();
		int[]a=new int[n];
		System.out.print("Enter all the elements");
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		sort(a,0,n-1);
		for(int x:a)
		{
			System.out.print(x+" ");
		}
	}
}
6 package dAA;
import java.util.*;
class QuickSort
{
	static void quick(int a[],int l,int h)
	{
		if(l<h)
		{
			int m=part(a,l,h);
			quick(a,l,m-1);
			quick(a,m+1,h);
		}
	}
	static int part(int a[],int l,int h)
	{
		int pivot=a[l],i=l+1,j=h;
		while(i<=j)
		{
			while(i<=h && a[i]<=pivot) i++;
			while(a[j]>pivot)j--;
			if(i<j) swap(a,i,j);
		}
		swap(a,l,j);
		return j;
	}
	static void swap(int a[],int i,int j)
	{
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of element");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter the elements");
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		quick(a,0,n-1);
		for(int x:a)
		{
			System.out.print(x+" ");
		}
	}
}
8 package dAA;

import java.util.*;

public class Min_Max {
    static Scanner sc = new Scanner(System.in);
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int a[];
    static int size;
    static void MAXMIN(int i, int j) {
        int min1, max1, mid;
        if (i == j) {
            max = min = a[i];
        }
        else if (i == j - 1) {
            if (a[i] < a[j]) {
                max = a[j];
                min = a[i];
            } else {
                max = a[i];
                min = a[j];
            }
        }
        else {
            mid = (i + j) / 2;
            MAXMIN(i, mid);
            max1 = max;
            min1 = min;
            MAXMIN(mid + 1, j);
            if (max < max1) {
                max = max1;
            }
            if (min > min1) {
                min = min1;
            }
        }
    }
    public static void InputArray() {
        System.out.println("Enter elements: ");
        for (int i = 0; i < size; i++) {
            a[i] = sc.nextInt();
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter size of an array: ");
        size = sc.nextInt();
        a = new int[size];
        InputArray();
        long start = System.nanoTime();
        MAXMIN(0, size - 1);
        long end = System.nanoTime();
        System.out.println("MAX value: " + max + " | Min value: " + min);
        System.out.println("Time: " + (end - start) + " ns");
    }
}
9 package dAA;
import java.util.Scanner;

class Knapsack1 {
    int n;
    double[] p;
    double[] w;
    double c;
    public Knapsack1(int n, double c, double[] p, double[] w) {
        this.n = n;
        this.c = c;
        this.p = p;
        this.w = w;
    }
    void compute() {
        int i;
        double[] x = new double[n + 1];
        for (i = 0; i < n; i++) {
            x[i] = 0.0;
        }
        double rc = c;
        for (i = 0; i < n; i++) {
            if (w[i] > rc) {
                break;
            }
            x[i] = 1.0;
            rc = rc - w[i];
        }
        if (i < n) {
            x[i] = rc / w[i];
        }
        double netprofit = 0.0;
        System.out.println("The objects picked up into Knapsack are: ");
        for (i = 0; i < n; i++) {
            if (x[i] > 0.0) {
                netprofit = netprofit + (x[i] * p[i]);
            }
            System.out.printf("%.2f ", x[i]);
        }
        System.out.printf("\nNet Profit: %.2f", netprofit);
    }
}

public class knapsack_greedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no. of objects: ");
        int n = sc.nextInt();

        double[] p = new double[n];
        double[] w = new double[n];

        System.out.println("Enter capacity of Knapsack: ");
        double c = sc.nextDouble();

        System.out.println("Enter profit for each " + n + " object: ");
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextDouble();
        }

        System.out.println("Enter weight for each " + n + " object: ");
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextDouble();
        }
        Knapsack1 gk = new Knapsack1(n, c, p, w);
        gk.compute();

        sc.close();
    }
}
10 package dAA;
import java.util.*;
class Job {
    int id;
    int deadline;
    int profit;
    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
public class JobSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of jobs: ");
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter id, deadline & profit " + (i + 1) + ": ");
            int id = sc.nextInt();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }
        System.out.println("Max profit sequence of jobs: ");
        int maxprofit = jobSequencing(jobs, n);
        System.out.println("Max profit: " + maxprofit);
        sc.close();
    }
    public static int jobSequencing(Job[] jobs, int n) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            if (jobs[i].deadline > maxDeadline) {
                maxDeadline = jobs[i].deadline;
            }
        }
        boolean[] result = new boolean[maxDeadline];
        int[] jobsequence = new int[maxDeadline];
        Arrays.fill(result, false);
        Arrays.fill(jobsequence, -1);

        int maxprofit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = Math.min(maxDeadline, jobs[i].deadline) - 1; j >= 0; j--) {
                if (result[j] == false) {
                    result[j] = true;
                    jobsequence[j] = i; 
                    maxprofit += jobs[i].profit;
                    break;
                }
            }
        }
        for (int i = 0; i < maxDeadline; i++) {
            if (jobsequence[i] != -1) {
                System.out.print(jobs[jobsequence[i]].id + " ");
            }
        }
        System.out.println();

        return maxprofit;
    }
}
11 import java.util.*;
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
12 import java.util.*;

public class Kruskal {
    int parent[] = new int[10];

    int find(int m) {
        int p = m;
        while (parent[p] != 0) {
            p = parent[p];
        }
        return p;
    }

    void union(int i, int j) {
        if (i < j) {
            parent[i] = j;
        } else {
            parent[j] = i;
        }
    }

    void krkl(int a[][], int n) {
        int u = 0, v = 0, min, k = 0, i, j, sum = 0;
        
        while (k < n - 1) {
            min = 99;
            
            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if (a[i][j] < min && i != j) {
                        min = a[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            i = find(u);
            j = find(v);

            if (i != j) {
                union(i, j);
                System.out.println("(" + u + "," + v + ") = " + a[u][v]);
                sum = sum + a[u][v];
                k++;
            }

            a[u][v] = a[v][u] = 99;
        }

        System.out.println("Cost of MST: " + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int n = sc.nextInt();
        
        int[][] a = new int[n + 1][n + 1];

        System.out.println("Enter the weighted matrix: ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        Kruskal k = new Kruskal();
        k.krkl(a, n);
    }
}
13 package dAA;

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
17 import java.util.*;
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
16 import java.util.*;
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
18 import java.util.*;

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
19.import java.util.*;

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
20.pakage dAA;
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
