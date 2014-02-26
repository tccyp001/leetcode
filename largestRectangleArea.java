import java.util.Stack;


public class largestRectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] h = {3,6,5,7,4,8,1,0}; //20
		//int[] h = {4,2,0,3,2,5}; //6
		int[] h = {2,1,5,6,2,3};//10
		int ret = largestRectangleArea(h);
		System.out.println(ret);
		
		int[] h1 = {1,0,1,0,1};//1
		int ret1 = largestRectangleArea(h1);
		System.out.println(ret1);
		
		int[] h2 = {5,4,4,6,3,2,9,5,4,8,1,0,0,4,7,2};//1
		int ret2 = largestRectangleArea(h2);
		System.out.println(ret2);
	}
	 public static int largestRectangleArea(int[] height) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        
		 
		     Stack<Integer> s = new Stack<Integer>();
		     Stack<Integer> spos = new Stack<Integer>();
		     
		     int max = 0;
		     int lastPop = 0;
		     int lastPos = 0;
		     int lastlastpos = 0;
		     int area = 0;
		     for(int i=0;i<height.length;i++)
		     {
		    	 int curH= height[i];
		    	 if(s.isEmpty())
		    	 {
		    		 s.push(curH);
		    		 spos.push(i);
		    	 }
		    	 else 
		    	 {
		    		 while(!s.isEmpty()&&curH<s.peek())
		    		 {
			    		 lastPop = s.pop();
			    		 lastPos = spos.pop();
			    		 lastlastpos = -1;
				    	 if(!spos.isEmpty())lastlastpos = spos.peek();
			    		 area = (i - lastlastpos-1) * lastPop;
			    		 if(area>max)max = area;
			    		 
			    	 }
		    		 if(s.isEmpty())
		    		 {
		    			 area = (lastPos +1 ) * lastPop;
		    		 }
		    		 else
		    		 {
		    			 area = (lastPos-spos.peek() ) * lastPop;
		    		 }
		    		 if(area>max)max = area;
		    		 s.push(curH);
		    		 spos.push(i);

		    	 }
		     }

		     while(!s.isEmpty()){
		    	 lastPop = s.pop();
		    	 lastPos = spos.pop();
		    	 lastlastpos = -1;
		    	 if(!spos.isEmpty())lastlastpos = spos.peek();
				 area = (height.length -  lastlastpos -1)*lastPop;
				 if(area>max)max = area;

		     }
		     area = (height.length)*lastPop;
		     if(area>max)max = area;
		     return max;
	    }
}
