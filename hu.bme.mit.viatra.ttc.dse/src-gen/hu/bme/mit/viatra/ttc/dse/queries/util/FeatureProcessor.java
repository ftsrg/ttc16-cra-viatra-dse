package hu.bme.mit.viatra.ttc.dse.queries.util;

import architectureCRA.Feature;
import hu.bme.mit.viatra.ttc.dse.queries.FeatureMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.viatra.ttc.dse.queries.feature pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class FeatureProcessor implements IMatchProcessor<FeatureMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pF the value of pattern parameter f in the currently processed match
   * 
   */
  public abstract void process(final Feature pF);
  
  @Override
  public void process(final FeatureMatch match) {
    process(match.getF());
  }
}
