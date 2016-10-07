/**
 * Generated from platform:/resource/hu.bme.mit.viatra.ttc.dse/src/hu/bme/mit/viatra/ttc/dse/queries/queries.vql
 */
package hu.bme.mit.viatra.ttc.dse.queries;

import hu.bme.mit.viatra.ttc.dse.queries.AllFeatureEncapsulatedMatch;
import hu.bme.mit.viatra.ttc.dse.queries.util.AllFeatureEncapsulatedQuerySpecification;
import org.apache.log4j.Logger;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.viatra.ttc.dse.queries.allFeatureEncapsulated pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link AllFeatureEncapsulatedMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern allFeatureEncapsulated() {
 *     neg find notEncapsulatedFeature(_);
 * }
 * </pre></code>
 * 
 * @see AllFeatureEncapsulatedMatch
 * @see AllFeatureEncapsulatedProcessor
 * @see AllFeatureEncapsulatedQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class AllFeatureEncapsulatedMatcher extends BaseMatcher<AllFeatureEncapsulatedMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static AllFeatureEncapsulatedMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    AllFeatureEncapsulatedMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (AllFeatureEncapsulatedMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static AllFeatureEncapsulatedMatcher create() throws ViatraQueryException {
    return new AllFeatureEncapsulatedMatcher();
  }
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(AllFeatureEncapsulatedMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private AllFeatureEncapsulatedMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Indicates whether the (parameterless) pattern matches or not.
   * @return true if the pattern has a valid match.
   * 
   */
  public boolean hasMatch() {
    return rawHasMatch(new Object[]{});
  }
  
  @Override
  protected AllFeatureEncapsulatedMatch tupleToMatch(final Tuple t) {
    try {
    	return AllFeatureEncapsulatedMatch.newMatch();
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AllFeatureEncapsulatedMatch arrayToMatch(final Object[] match) {
    try {
    	return AllFeatureEncapsulatedMatch.newMatch();
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AllFeatureEncapsulatedMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return AllFeatureEncapsulatedMatch.newMutableMatch();
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<AllFeatureEncapsulatedMatcher> querySpecification() throws ViatraQueryException {
    return AllFeatureEncapsulatedQuerySpecification.instance();
  }
}
