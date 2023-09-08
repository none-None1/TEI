package teij;
import java.math.*;
import java.util.*;
import java.io.*;
public class TEI_J {
	public static void main(String[] args) {
		Deque<BigInteger> s=new ArrayDeque<>();;
		String code="";
		Scanner sc=new Scanner(System.in);
		if(args.length==0) {
			int d=0;
			while(true) {
				try {
					d=System.in.read();
					if(d==-1) break;
					code+=(char)d;
				}catch(Exception e){
					break;
				}
			}
		}else {
			try {
				InputStream stream = new FileInputStream(args[0]);
				byte[] buf=new byte[1];
				while(stream.read(buf)!=-1) {
					code+=(char)buf[0];
				}
			}catch(Exception e) {
				System.out.println("File not found");
			}
		}
		for(int k=0;k<code.length();k++) {
			char i=code.charAt(k);
			if(i=='+') {
				BigInteger a,b;
				a=s.pop();
				b=s.pop();
				s.push(b.add(a));
			}else if(i=='-') {
				BigInteger a,b;
				a=s.pop();
				b=s.pop();
				s.push(b.subtract(a));
			}else if(i=='*') {
				BigInteger a,b;
				a=s.pop();
				b=s.pop();
				s.push(b.multiply(a));
			}else if(i=='.') {
				BigInteger a;
				a=s.pop();
				System.out.print(a);
				System.out.print(' ');
			}else if(i=='!') {
				BigInteger a;
				a=s.pop();
				System.out.print((char)a.intValue());
			}else if(i==',') {
				s.push(new BigInteger(sc.next()));
			}else if(i=='?') {
				try {
					s.push(BigInteger.valueOf(System.in.read()));
				}catch(IOException e){
					
				}
			}else if(i>='0'&&i<='9') {
				s.push(BigInteger.valueOf(i-'0'));
			}else {
				s.push(BigInteger.valueOf((int)i));
			}
		}
	}
}