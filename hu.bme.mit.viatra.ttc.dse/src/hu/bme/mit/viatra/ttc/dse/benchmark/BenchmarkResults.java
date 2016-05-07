package hu.bme.mit.viatra.ttc.dse.benchmark;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Stopwatch;

public class BenchmarkResults {

	public static final String NEWLINE = "\n";
	
	protected List<BenchmarkEntry> entries = new LinkedList<>();
	protected Stopwatch stopwatch = Stopwatch.createUnstarted();
	
	protected BenchmarkResults() {
		
	}
	
	public static BenchmarkResults create() {
		return new BenchmarkResults();
	}

	public BenchmarkEntry createEntry(String input) {
		final Stopwatch stopwatch = Stopwatch.createUnstarted();
		final BenchmarkEntry entry = new BenchmarkEntry(input, stopwatch);
		entries.add(entry);
		return entry;
	}

	public void serialize() throws IOException {
		String results = "input" + BenchmarkEntry.SEPARATOR + "time" + NEWLINE;	
		for (BenchmarkEntry entry : entries) {
			results += entry.toString() + NEWLINE;
		}
		File file = new File("results.csv");
		FileUtils.writeStringToFile(file, results);
	}
	
}
