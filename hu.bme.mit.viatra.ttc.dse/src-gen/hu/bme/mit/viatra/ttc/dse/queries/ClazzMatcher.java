package hu.bme.mit.viatra.ttc.dse.queries;

import hu.bme.mit.viatra.ttc.dse.queries.ClazzMatch;
import hu.bme.mit.viatra.ttc.dse.queries.util.ClazzQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.viatra.ttc.dse.queries.clazz pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ClazzMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern clazz(c : Class) {
 *     Class(c);
 * }
 * </pre></code>
 * 
 * @see ClazzMatch
 * @see ClazzProcessor
 * @see ClazzQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ClazzMatcher extends BaseMatcher<ClazzMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ClazzMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    ClazzMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ClazzMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_C = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ClazzMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private ClazzMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @return matches represented as a ClazzMatch object.
   * 
   */
  public Collection<ClazzMatch> getAllMatches(final architectureCRA.Class pC) {
    return rawGetAllMatches(new Object[]{pC});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @return a match represented as a ClazzMatch object, or null if no match is found.
   * 
   */
  public ClazzMatch getOneArbitraryMatch(final architectureCRA.Class pC) {
    return rawGetOneArbitraryMatch(new Object[]{pC});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final architectureCRA.Class pC) {
    return rawHasMatch(new Object[]{pC});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final architectureCRA.Class pC) {
    return rawCountMatches(new Object[]{pC});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final architectureCRA.Class pC, final IMatchProcessor<? super ClazzMatch> processor) {
    rawForEachMatch(new Object[]{pC}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final architectureCRA.Class pC, final IMatchProcessor<? super ClazzMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pC}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ClazzMatch newMatch(final architectureCRA.Class pC) {
    return ClazzMatch.newMatch(pC);
  }
  
  /**
   * Retrieve the set of values that occur in matches for c.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<architectureCRA.Class> rawAccumulateAllValuesOfc(final Object[] parameters) {
    Set<architectureCRA.Class> results = new HashSet<architectureCRA.Class>();
    rawAccumulateAllValues(POSITION_C, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for c.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<architectureCRA.Class> getAllValuesOfc() {
    return rawAccumulateAllValuesOfc(emptyArray());
  }
  
  @Override
  protected ClazzMatch tupleToMatch(final Tuple t) {
    try {
    	return ClazzMatch.newMatch((architectureCRA.Class) t.get(POSITION_C));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ClazzMatch arrayToMatch(final Object[] match) {
    try {
    	return ClazzMatch.newMatch((architectureCRA.Class) match[POSITION_C]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ClazzMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ClazzMatch.newMutableMatch((architectureCRA.Class) match[POSITION_C]);
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
  public static IQuerySpecification<ClazzMatcher> querySpecification() throws ViatraQueryException {
    return ClazzQuerySpecification.instance();
  }
}
