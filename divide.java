
public class divide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ret = divide(12,3);
		System.out.println(ret);
	}
	public static int  divide(int dividend, int divisor) {
		// 当dividend = INT_MIN 时，-dividend 会溢出，所以用long long
		long a = dividend >= 0 ? dividend : -(long)dividend;
		long b = divisor >= 0 ? divisor : -(long)divisor;
		// 当dividend = INT_MIN 时，divisor = -1 时，结果会溢出，所以用long long
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
