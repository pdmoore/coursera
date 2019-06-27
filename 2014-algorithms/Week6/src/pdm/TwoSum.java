package pdm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class TwoSum {

	// Brute force implementation - there are much faster ways according to the threads
	// in the forums
	// answer for the 2sum.txt file is 16744
	// and took around 11 minutes
	// BUT THERE WAS A BUG - was using intValue() off of the Long. Doh!
	// ran again and the answer was 427
	// but took a lot longer - almost 30 minutes!!
	
	private static int toSum(Collection<Long> longs) {
		TreeSet<Integer> found = new TreeSet<Integer>();
		
		for (int t = -10000; t <= 10000; t++) {
			if (t % 500 == 0) System.out.println("checking " + t);
			for (Iterator<Long> iterator = longs.iterator(); iterator.hasNext();) {
				Long a = (Long) iterator.next();
				long target = t - a.longValue();
				if ((target != a) && longs.contains(target)) {
					found.add(t);
					break;
				}
			}
		}
		
		return found.size();
	}
	
	public static void main(String[] args) {
//		Collection<Long> longs = readIn("LargeSet.txt");
//		Collection<Long> longs = readIn("smallSet.txt");
//		Collection<Long> longs = readIn("positives.txt");
		Collection<Long> longs = readIn("2sum.txt");
		
		System.out.println("ints contains " + longs.size());
		
		int result = toSum(longs);
		System.out.println("answer: " + result);
	}
	
	public static Collection<Long> readIn(String f) {
		HashSet<Long> longs = new HashSet<Long>();
		
		try {
			File fileIn = new File(f);
			FileReader stream = new FileReader(fileIn);
			BufferedReader buffer = new BufferedReader(stream);
			String s = buffer.readLine();
			while (s != null) {
				longs.add(Long.parseLong(s));
				s = buffer.readLine();
			}
			stream.close();
		} catch (IOException e) {
			System.out.println("Could find the file.");
		}
		return longs;
	}
	//This code works but TreeSet turns out to be very slow on lookups
//	public static TreeSet<Long> readIn(String f) {
//		TreeSet<Long> ints = new TreeSet<Long>();
//		
//		try {
//			File fileIn = new File(f);
//			FileReader stream = new FileReader(fileIn);
//			BufferedReader buffer = new BufferedReader(stream);
//			String s = buffer.readLine();
//			while (s != null) {
//				ints.add(Long.parseLong(s));
//				s = buffer.readLine();
//			}
//			stream.close();
//		} catch (IOException e) {
//			System.out.println("Could find the file.");
//		}
//		return ints;
//	}
}
