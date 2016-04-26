package hu.bme.mit.viatra.ttc.dse.queries.util;

import architectureCRA.Method;
import hu.bme.mit.viatra.ttc.dse.queries.MethodMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.viatra.ttc.dse.queries.method pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MethodProcessor implements IMatchProcessor<MethodMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pC the value of pattern parameter c in the currently processed match
   * @param pM the value of pattern parameter m in the currently processed match
   * 
   */
  public abstract void process(final architectureCRA.Class pC, final Method pM);
  
  @Override
  public void process(final MethodMatch match) {
    process(match.getC(), match.getM());
  }
}
