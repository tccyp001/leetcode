
public class LPSubstr1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "FourscoreandsevenyearsagoourfaathersbroughtforthonthiscontainentanewnationconceivedinzLibertyanddedicatedtothepropositionthatallmenarecreatedequalNowweareengagedinagreahtcivilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		String revStr = new StringBuilder(str).reverse().toString();
		
		int len = str.length();
		
		int[][] dp = new int[len+1][len+1];
		int max = 0;
		int maxPos = 0;
		for(int i =0;i<str.length();i++)
		{
			for(int j =0;j<str.length();j++)
			{
				if(str.charAt(i) == revStr.charAt(j))
				{
					
					dp[i+1][j+1] = dp[i][j] + 1;
					if(dp[i+1][j+1]>max)
					{
						max = dp[i+1][j+1];
						maxPos = i;
					}
				}
				
			}
		}
		
		System.out.println(max);
		System.out.println(maxPos);
		System.out.println(str.substring(maxPos - max + 1, maxPos+1));
		
	}
	
	
	

}
