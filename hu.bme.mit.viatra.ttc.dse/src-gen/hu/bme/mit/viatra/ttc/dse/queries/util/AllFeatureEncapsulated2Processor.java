package hu.bme.mit.viatra.ttc.dse.queries.util;

import hu.bme.mit.viatra.ttc.dse.queries.AllFeatureEncapsulated2Match;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.viatra.ttc.dse.queries.allFeatureEncapsulated2 pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AllFeatureEncapsulated2Processor implements IMatchProcessor<AllFeatureEncapsulated2Match> {
  /**
   * Defines the action that is to be executed on each match.
   * 
   */
  public abstract void process();
  
  @Override
  public void process(final AllFeatureEncapsulated2Match match) {
    process();
  }
}
