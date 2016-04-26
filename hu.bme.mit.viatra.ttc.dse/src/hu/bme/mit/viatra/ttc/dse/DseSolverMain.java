package hu.bme.mit.viatra.ttc.dse;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.dse.base.DseIdPoolHelper;
import org.eclipse.viatra.dse.util.EMFHelper;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import com.google.common.base.Stopwatch;

public class DseSolverMain {

	public static void main(String[] args) throws IOException, ViatraQueryException {
		RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
		List<String> arguments = runtimeMxBean.getInputArguments();
		System.out.println(arguments);
		
		if (args.length < 1) {
			args = new String[] { "A", "B", "C", "D", "E" };
		}
		
		for (String arg : args) {
			String inputModelName = "TTC_InputRDG_" + arg.toUpperCase();
			runExplorationWithTtcInput(inputModelName);
		}
	}

	private static void runExplorationWithTtcInput(String inputModelName) throws IOException, ViatraQueryException {
		System.out.println("---------- " + inputModelName);
		System.out.println(" Loading model...");
		EObject initialModel = CraDseRunner.loadInitialModel(inputModelName);
		System.out.println(" Running exploration...");
		Stopwatch stopwatch = Stopwatch.createStarted();
		CraDseRunner.runDseWithInputModel(initialModel);
		stopwatch.stop();
		long elapsedMiliseconds = stopwatch.elapsed(TimeUnit.MILLISECONDS);
		System.out.println(" Elapsed time: " + elapsedMiliseconds);
		EMFHelper.serializeModel(initialModel, "result_" + inputModelName, "xmi");
		System.out.println(" Result model serialized.");
		System.out.println();
	}

}
