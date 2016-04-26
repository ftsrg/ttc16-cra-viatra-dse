package hu.bme.mit.viatra.ttc.dse.queries;

import hu.bme.mit.viatra.ttc.dse.queries.AllFeatureEncapsulated2Match;
import hu.bme.mit.viatra.ttc.dse.queries.util.AllFeatureEncapsulated2QuerySpecification;
import org.apache.log4j.Logger;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.viatra.ttc.dse.queries.allFeatureEncapsulated2 pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link AllFeatureEncapsulated2Match}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern allFeatureEncapsulated2() {
 *     neg find notEncapsulatedFeature(_);
 * }
 * </pre></code>
 * 
 * @see AllFeatureEncapsulated2Match
 * @see AllFeatureEncapsulated2Processor
 * @see AllFeatureEncapsulated2QuerySpecification
 * 
 */
@SuppressWarnings("all")
public class AllFeatureEncapsulated2Matcher extends BaseMatcher<AllFeatureEncapsulated2Match> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static AllFeatureEncapsulated2Matcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    AllFeatureEncapsulated2Matcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new AllFeatureEncapsulated2Matcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(AllFeatureEncapsulated2Matcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private AllFeatureEncapsulated2Matcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
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
  protected AllFeatureEncapsulated2Match tupleToMatch(final Tuple t) {
    try {
    	return AllFeatureEncapsulated2Match.newMatch();
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AllFeatureEncapsulated2Match arrayToMatch(final Object[] match) {
    try {
    	return AllFeatureEncapsulated2Match.newMatch();
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AllFeatureEncapsulated2Match arrayToMatchMutable(final Object[] match) {
    try {
    	return AllFeatureEncapsulated2Match.newMutableMatch();
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
  public static IQuerySpecification<AllFeatureEncapsulated2Matcher> querySpecification() throws ViatraQueryException {
    return AllFeatureEncapsulated2QuerySpecification.instance();
  }
}
