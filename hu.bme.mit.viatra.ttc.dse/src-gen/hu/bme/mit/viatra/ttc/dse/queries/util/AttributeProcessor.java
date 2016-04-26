package hu.bme.mit.viatra.ttc.dse.queries.util;

import architectureCRA.Attribute;
import hu.bme.mit.viatra.ttc.dse.queries.AttributeMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.viatra.ttc.dse.queries.attribute pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AttributeProcessor implements IMatchProcessor<AttributeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pC the value of pattern parameter c in the currently processed match
   * @param pA the value of pattern parameter a in the currently processed match
   * 
   */
  public abstract void process(final architectureCRA.Class pC, final Attribute pA);
  
  @Override
  public void process(final AttributeMatch match) {
    process(match.getC(), match.getA());
  }
}
