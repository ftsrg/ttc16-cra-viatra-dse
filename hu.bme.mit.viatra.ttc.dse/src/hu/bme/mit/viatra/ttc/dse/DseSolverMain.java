package hu.bme.mit.viatra.ttc.dse;

import java.io.IOException;
import java.util.Arrays;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.dse.util.EMFHelper;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import hu.bme.mit.viatra.ttc.dse.benchmark.BenchmarkEntry;
import hu.bme.mit.viatra.ttc.dse.benchmark.BenchmarkResults;

public class DseSolverMain {

	public static void main(String[] args) throws IOException, ViatraQueryException {
		if (args.length < 1) {
			System.out.println("Usage: DseSolver number-of-runs [inputs]");
			System.out.println("Examples: ");
			System.out.println("- DseSolver 10");
			System.out.println("- DseSolver 5 A B");
		}

		final int runs = Integer.valueOf(args[0]);
		
		String[] inputs = Arrays.copyOfRange(args, 1, args.length);
		if (inputs.length < 1) {
			inputs = new String[] { "A", "B", "C", "D", "E" };
		}

		Logger.getRootLogger().setLevel(Level.WARN);

		final BenchmarkResults results = BenchmarkResults.create();
		
		for (String input : inputs) {
			for (int run = 0; run < runs; run++) {
			    System.out.println("Model: " + input + ", run: " + run);
				final String inputModelName = "TTC_InputRDG_" + input.toUpperCase();
				final BenchmarkEntry entry = results.createEntry(input);
				EObject initialModel = CraDseRunner.loadInitialModel(inputModelName);
				entry.startTimer();
				double craIndex = CraDseRunner.runDseWithInputModel(initialModel);
				entry.stopTimer();
				entry.setCraIndex(craIndex);
				results.serializeLastEntry();
				EMFHelper.serializeModel(initialModel, "result_" + inputModelName + run, "xmi");
			}
		}
		
	}

}
