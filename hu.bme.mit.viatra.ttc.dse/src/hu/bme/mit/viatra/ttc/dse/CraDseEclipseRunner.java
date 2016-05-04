package hu.bme.mit.viatra.ttc.dse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class CraDseEclipseRunner implements IApplication {

    @Override
    public Object start(IApplicationContext context) throws Exception {
        Logger.getRootLogger().setLevel(Level.WARN);
        CraDseRunner.runExplorationWithTtcInput(CraModelNameConstants.INPUT_A);
//        runExplorationWithTtcInput(CraModelNameConstants.INPUT_B);
//        runExplorationWithTtcInput(CraModelNameConstants.INPUT_C);
//        runExplorationWithTtcInput(CraModelNameConstants.INPUT_D);
//        runExplorationWithTtcInput(CraModelNameConstants.INPUT_E);
        return IApplication.EXIT_OK;
    }

    @Override
    public void stop() {
    }

}
