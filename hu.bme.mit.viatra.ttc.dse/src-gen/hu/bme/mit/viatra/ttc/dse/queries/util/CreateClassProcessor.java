package hu.bme.mit.viatra.ttc.dse.queries.util;

import architectureCRA.ClassModel;
import hu.bme.mit.viatra.ttc.dse.queries.CreateClassMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.viatra.ttc.dse.queries.createClass pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class CreateClassProcessor implements IMatchProcessor<CreateClassMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCm the value of pattern parameter cm in the currently processed match
   * 
   */
  public abstract void process(final ClassModel pCm);
  
  @Override
  public void process(final CreateClassMatch match) {
    process(match.getCm());
  }
}
