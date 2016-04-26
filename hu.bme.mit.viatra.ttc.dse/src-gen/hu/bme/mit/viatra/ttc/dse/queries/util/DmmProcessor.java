package hu.bme.mit.viatra.ttc.dse.queries.util;

import architectureCRA.Method;
import hu.bme.mit.viatra.ttc.dse.queries.DmmMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.viatra.ttc.dse.queries.dmm pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class DmmProcessor implements IMatchProcessor<DmmMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pM1 the value of pattern parameter m1 in the currently processed match
   * @param pM2 the value of pattern parameter m2 in the currently processed match
   * 
   */
  public abstract void process(final Method pM1, final Method pM2);
  
  @Override
  public void process(final DmmMatch match) {
    process(match.getM1(), match.getM2());
  }
}
