
public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(1000000001));
	}
    public static boolean isPalindrome(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int tmp = x;
        
        if(tmp<0)return false;
        int highfactor = 1;
        int lowfactor = 1;
        while(tmp>=10)
        {
            highfactor*=10;
            tmp /=10;
        }
       // highfactor/=10;
        while(highfactor>lowfactor)
        {
            if((x/highfactor)%10 != (x/lowfactor)%10) return false;
            
            highfactor/=10;
            lowfactor*=10;
        }
        return true;
        
    }

}
