package hu.bme.mit.viatra.ttc.dse.queries.util;

import architectureCRA.Attribute;
import architectureCRA.Method;
import hu.bme.mit.viatra.ttc.dse.queries.DmaMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.viatra.ttc.dse.queries.dma pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class DmaProcessor implements IMatchProcessor<DmaMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pM the value of pattern parameter m in the currently processed match
   * @param pA the value of pattern parameter a in the currently processed match
   * 
   */
  public abstract void process(final Method pM, final Attribute pA);
  
  @Override
  public void process(final DmaMatch match) {
    process(match.getM(), match.getA());
  }
}
