package hu.bme.mit.viatra.ttc.dse;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.viatra.dse.util.EMFHelper;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import com.google.common.base.Stopwatch;

public class CraDseEclipseRunner implements IApplication {

    @Override
    public Object start(IApplicationContext context) throws Exception {
        runExplorationWithTtcInput(CraModelNameConstants.INPUT_A);
        runExplorationWithTtcInput(CraModelNameConstants.INPUT_B);
        runExplorationWithTtcInput(CraModelNameConstants.INPUT_C);
        runExplorationWithTtcInput(CraModelNameConstants.INPUT_D);
        runExplorationWithTtcInput(CraModelNameConstants.INPUT_E);
        return IApplication.EXIT_OK;
    }

    private void runExplorationWithTtcInput(String inputModelName) throws IOException, ViatraQueryException {
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

    @Override
    public void stop() {
    }

}
