
public class divide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ret = divide(12,3);
		System.out.println(ret);
	}
	public static int  divide(int dividend, int divisor) {
		// ��dividend = INT_MIN ʱ��-dividend �������������long long
		long a = dividend >= 0 ? dividend : -(long)dividend;
		long b = divisor >= 0 ? divisor : -(long)divisor;
		// ��dividend = INT_MIN ʱ��divisor = -1 ʱ������������������long long
		long result = 0;
		while (a >= b) {
				long c = b;
				for (int i = 0; a >= c; ++i, c <<= 1) {
				a -= c;
				result += 1 << i;
			}
		}
		return (int) ((((dividend^divisor) >> 31)==1) ? (-result) : (result));
	}
}
