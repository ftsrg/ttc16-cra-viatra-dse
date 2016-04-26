package hu.bme.mit.viatra.ttc.dse.queries.util;

import hu.bme.mit.viatra.ttc.dse.queries.ClazzMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.viatra.ttc.dse.queries.clazz pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ClazzProcessor implements IMatchProcessor<ClazzMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pC the value of pattern parameter c in the currently processed match
   * 
   */
  public abstract void process(final architectureCRA.Class pC);
  
  @Override
  public void process(final ClazzMatch match) {
    process(match.getC());
  }
}
