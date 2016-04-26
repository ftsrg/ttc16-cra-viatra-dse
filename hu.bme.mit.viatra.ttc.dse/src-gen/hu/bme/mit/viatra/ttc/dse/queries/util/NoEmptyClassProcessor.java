package hu.bme.mit.viatra.ttc.dse.queries.util;

import hu.bme.mit.viatra.ttc.dse.queries.NoEmptyClassMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.viatra.ttc.dse.queries.noEmptyClass pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class NoEmptyClassProcessor implements IMatchProcessor<NoEmptyClassMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * 
   */
  public abstract void process();
  
  @Override
  public void process(final NoEmptyClassMatch match) {
    process();
  }
}
