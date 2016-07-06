/**
 * Generated from platform:/resource/hu.bme.mit.viatra.ttc.dse/src/hu/bme/mit/viatra/ttc/dse/queries/queries.vql
 */
package hu.bme.mit.viatra.ttc.dse.queries.util;

import architectureCRA.Attribute;
import architectureCRA.Method;
import hu.bme.mit.viatra.ttc.dse.queries.MaiPartialMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.viatra.ttc.dse.queries.maiPartial pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MaiPartialProcessor implements IMatchProcessor<MaiPartialMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pC1 the value of pattern parameter c1 in the currently processed match
   * @param pC2 the value of pattern parameter c2 in the currently processed match
   * @param pM1 the value of pattern parameter m1 in the currently processed match
   * @param pA2 the value of pattern parameter a2 in the currently processed match
   * 
   */
  public abstract void process(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Method pM1, final Attribute pA2);
  
  @Override
  public void process(final MaiPartialMatch match) {
    process(match.getC1(), match.getC2(), match.getM1(), match.getA2());
  }
}
