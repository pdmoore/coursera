package pdm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Median {

	// 1213 is the correct answer for this one
	
	// The goal of this problem is to implement the "Median Maintenance"
	// algorithm
	// (covered in the Week 5 lecture on heap applications). The text file
	// contains a
	// list of the integers from 1 to 10000 in unsorted order; you should treat
	// this as a
	// stream of numbers, arriving one by one.
	// Letting xi denote the ith number of the file,
	// the kth median mk is defined as the median of the numbers x1,É,xk.
	// (So, if k is odd, then mk is ((k+1)/2)th smallest number among x1,É,xk;
	// if k is even, then mk is the (k/2)th smallest number among x1,É,xk.)
	//
	// In the box below you should type the sum of these 10000 medians,
	// modulo 10000 (i.e., only the last 4 digits).
	// That is, you should compute (m1+m2+m3+...+m10000)mod10000.

	public static void main(String[] args) {
//		Collection<Long> ints = readIn("tinyMedian.txt");
//		Collection<Long> ints = readIn("smallMedian2.txt");
		 Collection<Long> ints = readIn("Median.txt");

		System.out.println("ints contains " + ints.size());

		long result = median(ints);
		System.out.println("sum of medians: " + result);
		System.out.println("mod 10000: " + result % 10000);
		
	}

	private static long median(Collection<Long> ints) {
		ArrayList<Long> growingList = new ArrayList<Long>();
		long runningTotal = 0;
		for (Long long1 : ints) {
			growingList.add(long1);
			long currentMedian = medianOf(growingList);
			runningTotal += currentMedian;
		}
		return runningTotal;
	}

	private static Long medianOf(ArrayList<Long> growingList) {
		int size = growingList.size();
		Collections.sort(growingList);
		if (size % 1000 == 0) {
			System.out.println(size);
		}
        int medianIx = 0;
        if (size % 2 == 0) {
        	medianIx = size / 2;
        } else {
        	medianIx = (size + 1) / 2;
        }
        Long curMedian = growingList.get(medianIx - 1);
//        System.out.println(curMedian);
		return curMedian;
	}

	public static Collection<Long> readIn(String f) {
		ArrayList<Long> ints = new ArrayList<Long>();

		try {
			File fileIn = new File(f);
			FileReader stream = new FileReader(fileIn);
			BufferedReader buffer = new BufferedReader(stream);
			String s = buffer.readLine();
			while (s != null) {
				ints.add(Long.parseLong(s));
				s = buffer.readLine();
			}
			stream.close();
		} catch (IOException e) {
			System.out.println("Could find the file.");
		}
		return ints;
	}
}
