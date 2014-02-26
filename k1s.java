
public class k1s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int a =  15;
		  System.out.println(Integer.toBinaryString(a));
		  int b,c,d,e,f,g;
		  for(int i= 0;i<10;i++)
		  {   //a = 100110
			  b = a | (a-1);// b = 100111;
			  c = b+1; // c = 101000;
			  d = c^b; //d = 001111;
			  e = d +1;// e = 010000;
			  f = a ^ (e>>1);// f = 101110
			  f = f ^ (e>>2); // f = 101010
			  g = f & d>>2;
			  f = f & ~(d>>2);
			  while(g>0 &&(g&1) == 0) g = g>>1;
			  f = f |g;
			  a = f;
			  System.out.println(Integer.toBinaryString(f));
		  }

	}

}
