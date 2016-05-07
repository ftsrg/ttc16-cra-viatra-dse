package hu.bme.mit.viatra.ttc.dse.benchmark;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public class BenchmarkEntry {

	public static String SEPARATOR = ",";
	
	protected String input;
	
	protected Stopwatch stopwatch;

	public BenchmarkEntry(String input, Stopwatch stopwatch) {
		this.input = input;
		this.stopwatch = stopwatch;
	}
	
	public void startTimer() {
		stopwatch.start();
	}
	
	public void stopTimer() {
		stopwatch.stop();
	}
	
	@Override
	public String toString() {
		return input + SEPARATOR + stopwatch.elapsed(TimeUnit.NANOSECONDS);
	}

}
