package hu.bme.mit.viatra.ttc.dse;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

public class DseSolverMain {

    public static void main(String[] args) throws IOException, ViatraQueryException {
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        List<String> arguments = runtimeMxBean.getInputArguments();
        System.out.println(arguments);

        if (args.length < 1) {
            args = new String[] { "A", "B", "C", "D", "E" };
        }

        Logger.getRootLogger().setLevel(Level.WARN);

        for (String arg : args) {
            String inputModelName = "TTC_InputRDG_" + arg.toUpperCase();
            CraDseRunner.runExplorationWithTtcInput(inputModelName);
        }
    }

}
