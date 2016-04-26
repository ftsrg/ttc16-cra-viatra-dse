package hu.bme.mit.viatra.ttc.dse.queries.util;

import architectureCRA.Method;
import hu.bme.mit.viatra.ttc.dse.queries.MmiPartialMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.viatra.ttc.dse.queries.mmiPartial pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MmiPartialProcessor implements IMatchProcessor<MmiPartialMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pC1 the value of pattern parameter c1 in the currently processed match
   * @param pC2 the value of pattern parameter c2 in the currently processed match
   * @param pM1 the value of pattern parameter m1 in the currently processed match
   * @param pM2 the value of pattern parameter m2 in the currently processed match
   * 
   */
  public abstract void process(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Method pM1, final Method pM2);
  
  @Override
  public void process(final MmiPartialMatch match) {
    process(match.getC1(), match.getC2(), match.getM1(), match.getM2());
  }
}
