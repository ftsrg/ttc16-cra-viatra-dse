/**
 * Generated from platform:/resource/hu.bme.mit.viatra.ttc.dse/src/hu/bme/mit/viatra/ttc/dse/queries/queries.vql
 */
package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.Method;
import hu.bme.mit.viatra.ttc.dse.queries.MethodMatch;
import hu.bme.mit.viatra.ttc.dse.queries.util.MethodQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.viatra.ttc.dse.queries.method pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link MethodMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern method(c : Class, m : Method) {
 *     find feature(m);
 *     Class.encapsulates(c, m);
 *     Method(m);
 * }
 * </pre></code>
 * 
 * @see MethodMatch
 * @see MethodProcessor
 * @see MethodQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class MethodMatcher extends BaseMatcher<MethodMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static MethodMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    MethodMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (MethodMatcher)engine.getMatcher(querySpecification());
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
  public static MethodMatcher create() throws ViatraQueryException {
    return new MethodMatcher();
  }
  
  private final static int POSITION_C = 0;
  
  private final static int POSITION_M = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(MethodMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private MethodMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @return matches represented as a MethodMatch object.
   * 
   */
  public Collection<MethodMatch> getAllMatches(final architectureCRA.Class pC, final Method pM) {
    return rawGetAllMatches(new Object[]{pC, pM});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @return a match represented as a MethodMatch object, or null if no match is found.
   * 
   */
  public MethodMatch getOneArbitraryMatch(final architectureCRA.Class pC, final Method pM) {
    return rawGetOneArbitraryMatch(new Object[]{pC, pM});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final architectureCRA.Class pC, final Method pM) {
    return rawHasMatch(new Object[]{pC, pM});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final architectureCRA.Class pC, final Method pM) {
    return rawCountMatches(new Object[]{pC, pM});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final architectureCRA.Class pC, final Method pM, final IMatchProcessor<? super MethodMatch> processor) {
    rawForEachMatch(new Object[]{pC, pM}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final architectureCRA.Class pC, final Method pM, final IMatchProcessor<? super MethodMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pC, pM}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public MethodMatch newMatch(final architectureCRA.Class pC, final Method pM) {
    return MethodMatch.newMatch(pC, pM);
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
  
  /**
   * Retrieve the set of values that occur in matches for c.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<architectureCRA.Class> getAllValuesOfc(final MethodMatch partialMatch) {
    return rawAccumulateAllValuesOfc(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for c.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<architectureCRA.Class> getAllValuesOfc(final Method pM) {
    return rawAccumulateAllValuesOfc(new Object[]{
    null, 
    pM
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for m.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Method> rawAccumulateAllValuesOfm(final Object[] parameters) {
    Set<Method> results = new HashSet<Method>();
    rawAccumulateAllValues(POSITION_M, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for m.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Method> getAllValuesOfm() {
    return rawAccumulateAllValuesOfm(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for m.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Method> getAllValuesOfm(final MethodMatch partialMatch) {
    return rawAccumulateAllValuesOfm(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for m.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Method> getAllValuesOfm(final architectureCRA.Class pC) {
    return rawAccumulateAllValuesOfm(new Object[]{
    pC, 
    null
    });
  }
  
  @Override
  protected MethodMatch tupleToMatch(final Tuple t) {
    try {
    	return MethodMatch.newMatch((architectureCRA.Class) t.get(POSITION_C), (Method) t.get(POSITION_M));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MethodMatch arrayToMatch(final Object[] match) {
    try {
    	return MethodMatch.newMatch((architectureCRA.Class) match[POSITION_C], (Method) match[POSITION_M]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MethodMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return MethodMatch.newMutableMatch((architectureCRA.Class) match[POSITION_C], (Method) match[POSITION_M]);
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
  public static IQuerySpecification<MethodMatcher> querySpecification() throws ViatraQueryException {
    return MethodQuerySpecification.instance();
  }
}
