import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PALIN {
	public static String process(String process,char[] ip,int i,int j){
		boolean flag=(i==j);
		String result1="",between=flag?process.substring(i+1,j+1):process.substring(i+1,j);
		int carry=1,cur=0;
		if(flag)
			j++;
		i++;
		while(--i>=0){
			cur = ip[i] - 48 + carry;
			if(cur > 9 && i!=0){
				carry = cur/10;
				cur = cur%10;
			}
			else if(cur<10)
				carry=0;
			result1 = cur + result1;
		}
		return result1 + between + reverse(result1.substring(0,flag?result1.length()-1:result1.length()));
	}
	
	public static char[] reverse(char[] in,int start,int end){
		char out[] = new char[in.length];
		System.arraycopy(in,0,out,0,in.length);
		char store;
		int half = start + ((end + 1) - start) / 2;
		int endCount = end;
		for (int startCount = start; startCount < half; startCount++) {
		    store = out[startCount];
		    out[startCount] = out[endCount];
		    out[endCount] = store;
		    endCount--;
		}
		return out;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		char[] s={'a','b','c','d','e'};
		System.out.println(s);
		System.out.println(reverse(s, 0, s.length));
		/*BufferedReader r = new BufferedReader (new InputStreamReader (System.in));
	    System.out.println(" ");
		int total=Integer.valueOf(r.readLine()),i,j,oldI,oldJ;
		boolean allNinesFlag=true,matchFlag=true;
	    while(total--!=0){
	    	String val = r.readLine();
	    	char[] ip = val.toCharArray();
	    	//all nines
	    	for(int k=0;k<ip.length;k++)
	    		if(ip[k] != '9'){
	    			allNinesFlag = false;
	    			break;
	    		}
	    	if(allNinesFlag){
	    		StringBuilder ans=new StringBuilder("1");
	    		for(int k=0;k<ip.length-1;k++)
	    			ans = ans.append("0");
	    		System.out.println(ans.append("1"));
	    		continue;
	    	}
	    	allNinesFlag = true;
	    	
	    	//otherwise
	    	if(ip.length%2==0){
	    		i=ip.length/2-1;
	    		j=ip.length/2;
	    	}
	    	else{
	    		i=j=ip.length/2;
	    	}
	    	oldI=i;
	    	oldJ=j;
	    	while(true){
	    		if(ip[i]==ip[j]){
	    			i--;
	    			j++;
	    		}
	    		else{
	    			matchFlag=false;
	    			if(ip[i] > ip[j]){
		    			System.out.println(val.substring(0,j) + reverse(val.substring(0,i+1)));
		    			break;
		    		}
		    		else{
		    			System.out.println(process(val,ip, i, j));
		    			break;
		    		}
	    		}
	    		if(i<0 || j==ip.length)
	    			break;
	    	}
	    	if(matchFlag){
	    		System.out.println(process(val,ip,oldI,oldJ));
	    	}
	    	matchFlag=true;
	    }
	    r.close();
*/	}
}
http://fahdshariff.blogspot.in/2010/04/next-palindrome.html
