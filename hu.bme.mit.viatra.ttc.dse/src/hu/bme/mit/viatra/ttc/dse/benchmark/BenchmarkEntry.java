package hu.bme.mit.viatra.ttc.dse.benchmark;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public class BenchmarkEntry {

	public static String SEPARATOR = ",";
	
	protected String input;
	protected Stopwatch stopwatch;
	protected double craIndex;

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

	public void setCraIndex(double craIndex) {
        this.craIndex = craIndex;
    }

	@Override
	public String toString() {
		return input + SEPARATOR + craIndex + SEPARATOR + getElapsedTime();
	}

    public long getElapsedTime() {
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

}
