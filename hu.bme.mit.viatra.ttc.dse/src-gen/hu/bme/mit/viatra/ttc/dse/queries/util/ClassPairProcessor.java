package hu.bme.mit.viatra.ttc.dse.queries.util;

import hu.bme.mit.viatra.ttc.dse.queries.ClassPairMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.viatra.ttc.dse.queries.classPair pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ClassPairProcessor implements IMatchProcessor<ClassPairMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pC1 the value of pattern parameter c1 in the currently processed match
   * @param pC2 the value of pattern parameter c2 in the currently processed match
   * 
   */
  public abstract void process(final architectureCRA.Class pC1, final architectureCRA.Class pC2);
  
  @Override
  public void process(final ClassPairMatch match) {
    process(match.getC1(), match.getC2());
  }
}
