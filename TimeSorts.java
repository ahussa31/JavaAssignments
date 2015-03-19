//Aemen Hussain

package group5;

import algs21.*;
import java.math.*;
import java.util.Random;
import stdlib.*;

public class TimeSorts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double start=8.0;
		double end= 19.0;
		double x;
		int doub2int;
		
		Random generator= new Random();
		double constantRatio;

		StdOut.print("Array\t\t\tInsertion\t\t\tSelection\t\t\tShell\n");
		StdOut.print("Length\t\tTime\t\tRatio\t\tTime\t\tRatio\t\tTime\t\tRatio\n");
		
		for(x=start; x<end; x++ ){ 
			doub2int=(int)Math.pow(2.0,x);
	
			Integer[] inserTimes= new Integer[doub2int];
			Integer[] selecTimes= new Integer[doub2int];
			Integer[] shellTimes= new Integer[doub2int];

			for (int y=0; y<doub2int;y++){
				inserTimes[y]=generator.nextInt(); //adds random values to array of length 2^n
				selecTimes[y]=generator.nextInt();
				shellTimes[y]=generator.nextInt();
			}
			
			Stopwatch InserTimer = new Stopwatch();
			Insertion.sort(inserTimes);
			double endTime=InserTimer.elapsedTime();
			double ratio1=(endTime*Math.pow(10,9))/(Math.pow(doub2int,2));
			Stopwatch SelectTimer = new Stopwatch();
			Selection.sort(selecTimes);
			double endTime2=SelectTimer.elapsedTime();
			double ratio2=(endTime2*Math.pow(10,9))/(Math.pow(doub2int,2));
			Stopwatch ShellTimer = new Stopwatch();
			Shell.sort(shellTimes);
			double endTime3=ShellTimer.elapsedTime();
			double ratio3=(endTime3*Math.pow(10,9))/(doub2int*Math.sqrt(doub2int));
	
			StdOut.printf("%6d\t\t%7.3f\t\t%8.4f\t%7.3f\t\t%8.4f\t%7.3f\t\t%8.4f\n",doub2int,endTime,ratio1,endTime2,ratio2,endTime3,ratio3);
}}}
