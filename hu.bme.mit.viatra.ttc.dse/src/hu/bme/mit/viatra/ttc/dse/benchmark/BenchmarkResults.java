package hu.bme.mit.viatra.ttc.dse.benchmark;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.base.Stopwatch;
import com.google.common.io.Files;

public class BenchmarkResults {

	public static final String NEWLINE = "\n";
	
	protected List<BenchmarkEntry> entries = new LinkedList<>();
	protected Stopwatch stopwatch = Stopwatch.createUnstarted();
	protected final File file;
	protected BenchmarkEntry lastEntry;
	
	protected BenchmarkResults() {
	    file = new File("results.csv");
	    String heading = "input" + BenchmarkEntry.SEPARATOR + "CRA-Index" + BenchmarkEntry.SEPARATOR + "time" + NEWLINE;	
	    try {
            Files.write(heading, file, Charsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		
	}
	
	public static BenchmarkResults create() {
		return new BenchmarkResults();
	}

	public BenchmarkEntry createEntry(String input) {
		final Stopwatch stopwatch = Stopwatch.createUnstarted();
		lastEntry = new BenchmarkEntry(input, stopwatch);
		entries.add(lastEntry);
		return lastEntry;
	}

	public void serializeLastEntry() throws IOException {
		Files.append(lastEntry.toString() + NEWLINE, file, Charsets.UTF_8);
	}
	
}
