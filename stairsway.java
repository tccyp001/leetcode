
public class stairsway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("aa");
		System.out.println(f(10));
		System.out.println(f2(10));
	}
    public static int f(int n)
    {
    	if(n==0) return 0;
    	if(n==1) return 1;
    	if(n==2) return 2;
    	
    	return f(n-1) + f(n-2);
    }
    public static int f2(int n)
    {
    	if(n==0)return 0;
    	if(n==1)return 1;
    	if(n==2)return 2;
    	int oneback = 2;
    	int twoback = 1;
    	int cur = 0;
    	for(int i = 3;i<=n;i++)
    	{
    		cur = twoback + oneback;
    		twoback = oneback;
    		oneback = cur;
    		
    	}
    	return cur;
    }
}
