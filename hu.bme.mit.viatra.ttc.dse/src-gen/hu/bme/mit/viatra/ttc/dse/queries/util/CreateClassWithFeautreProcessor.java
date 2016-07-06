/**
 * Generated from platform:/resource/hu.bme.mit.viatra.ttc.dse/src/hu/bme/mit/viatra/ttc/dse/queries/queries.vql
 */
package hu.bme.mit.viatra.ttc.dse.queries.util;

import architectureCRA.ClassModel;
import architectureCRA.Feature;
import hu.bme.mit.viatra.ttc.dse.queries.CreateClassWithFeautreMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.viatra.ttc.dse.queries.createClassWithFeautre pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class CreateClassWithFeautreProcessor implements IMatchProcessor<CreateClassWithFeautreMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCm the value of pattern parameter cm in the currently processed match
   * @param pF the value of pattern parameter f in the currently processed match
   * 
   */
  public abstract void process(final ClassModel pCm, final Feature pF);
  
  @Override
  public void process(final CreateClassWithFeautreMatch match) {
    process(match.getCm(), match.getF());
  }
}
