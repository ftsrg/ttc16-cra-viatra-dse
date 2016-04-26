package hu.bme.mit.viatra.ttc.dse.queries.util;

import hu.bme.mit.viatra.ttc.dse.queries.EmptyClassMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.viatra.ttc.dse.queries.emptyClass pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class EmptyClassProcessor implements IMatchProcessor<EmptyClassMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pC the value of pattern parameter c in the currently processed match
   * 
   */
  public abstract void process(final architectureCRA.Class pC);
  
  @Override
  public void process(final EmptyClassMatch match) {
    process(match.getC());
  }
}
