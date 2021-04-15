import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	
	public final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static ArrayList<String> ans = new ArrayList<String>();
	public static int[] prod = new int[3];
	
	public static void main(String[] args) throws IOException {
		askData();
	}
	
	public static void askData() throws IOException {
		String cases,line;
		cases = br.readLine();
		int i = 0;
		while(i < Integer.parseInt(cases)) {
			line = br.readLine();
			toHanoi(Integer.parseInt(line));
			ans.add("\n");
			i++;
		}
		show();
	}
	public static void show() {
		for(int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i));
		}
	}
	public static void toHanoi(int c) {
		
		prod[0] = c;//a origin
		prod[1] = 0;//c middle
		prod[2] = 0;//b destiny
		ans.add(prod[0] + " " + prod[1] + " " + prod[2] + "\n");
		moverTorre(c,"a", "b", "c");
	}
	public static void moverTorre(int altura, String origen, String destino, String intermedio) {
	    if (altura >= 1) {
	    	moverTorre(altura-1,origen,intermedio,destino);
	    	
	        moverDisco(origen, destino);
	    	
	    	ans.add(prod[0] + " " + prod[1] + " " + prod[2] + "\n");
	        moverTorre(altura-1,intermedio,destino,origen);
	    }
	}
	public static void moverDisco(String origen, String destino) {
		switch(origen){
			case "a" :
				prod[0]--;
				break;
			case "b" :
				prod[2]--;
				break;
			case "c" :
				prod[1]--;
				break;
		}
		switch(destino){
		case "a" :
			prod[0]++;
			break;
		case "b" :
			prod[2]++;
			break;
		case "c" :
			prod[1]++;
			break;
	}
	}
}
