package hu.bme.mit.viatra.ttc.dse.statecoder;

import org.eclipse.viatra.dse.statecode.IStateCoder;
import org.eclipse.viatra.dse.statecode.IStateCoderFactory;

public class CraStateCoderFactory implements IStateCoderFactory {

    @Override
    public IStateCoder createStateCoder() {
        return new CraStateCoder();
    }

}
