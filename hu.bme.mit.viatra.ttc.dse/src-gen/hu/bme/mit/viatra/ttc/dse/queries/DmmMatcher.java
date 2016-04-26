package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.Method;
import hu.bme.mit.viatra.ttc.dse.queries.DmmMatch;
import hu.bme.mit.viatra.ttc.dse.queries.util.DmmQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.viatra.ttc.dse.queries.dmm pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link DmmMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern dmm(m1 : Method, m2 : Method) {
 *     Method.functionalDependency(m1, m2);
 * }
 * </pre></code>
 * 
 * @see DmmMatch
 * @see DmmProcessor
 * @see DmmQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class DmmMatcher extends BaseMatcher<DmmMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static DmmMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    DmmMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new DmmMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_M1 = 0;
  
  private final static int POSITION_M2 = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(DmmMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private DmmMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pM2 the fixed value of pattern parameter m2, or null if not bound.
   * @return matches represented as a DmmMatch object.
   * 
   */
  public Collection<DmmMatch> getAllMatches(final Method pM1, final Method pM2) {
    return rawGetAllMatches(new Object[]{pM1, pM2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pM2 the fixed value of pattern parameter m2, or null if not bound.
   * @return a match represented as a DmmMatch object, or null if no match is found.
   * 
   */
  public DmmMatch getOneArbitraryMatch(final Method pM1, final Method pM2) {
    return rawGetOneArbitraryMatch(new Object[]{pM1, pM2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pM2 the fixed value of pattern parameter m2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Method pM1, final Method pM2) {
    return rawHasMatch(new Object[]{pM1, pM2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pM2 the fixed value of pattern parameter m2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Method pM1, final Method pM2) {
    return rawCountMatches(new Object[]{pM1, pM2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pM2 the fixed value of pattern parameter m2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Method pM1, final Method pM2, final IMatchProcessor<? super DmmMatch> processor) {
    rawForEachMatch(new Object[]{pM1, pM2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pM2 the fixed value of pattern parameter m2, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Method pM1, final Method pM2, final IMatchProcessor<? super DmmMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pM1, pM2}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pM2 the fixed value of pattern parameter m2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public DmmMatch newMatch(final Method pM1, final Method pM2) {
    return DmmMatch.newMatch(pM1, pM2);
  }
  
  /**
   * Retrieve the set of values that occur in matches for m1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Method> rawAccumulateAllValuesOfm1(final Object[] parameters) {
    Set<Method> results = new HashSet<Method>();
    rawAccumulateAllValues(POSITION_M1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for m1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Method> getAllValuesOfm1() {
    return rawAccumulateAllValuesOfm1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for m1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Method> getAllValuesOfm1(final DmmMatch partialMatch) {
    return rawAccumulateAllValuesOfm1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for m1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Method> getAllValuesOfm1(final Method pM2) {
    return rawAccumulateAllValuesOfm1(new Object[]{
    null, 
    pM2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for m2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Method> rawAccumulateAllValuesOfm2(final Object[] parameters) {
    Set<Method> results = new HashSet<Method>();
    rawAccumulateAllValues(POSITION_M2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for m2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Method> getAllValuesOfm2() {
    return rawAccumulateAllValuesOfm2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for m2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Method> getAllValuesOfm2(final DmmMatch partialMatch) {
    return rawAccumulateAllValuesOfm2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for m2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Method> getAllValuesOfm2(final Method pM1) {
    return rawAccumulateAllValuesOfm2(new Object[]{
    pM1, 
    null
    });
  }
  
  @Override
  protected DmmMatch tupleToMatch(final Tuple t) {
    try {
    	return DmmMatch.newMatch((Method) t.get(POSITION_M1), (Method) t.get(POSITION_M2));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected DmmMatch arrayToMatch(final Object[] match) {
    try {
    	return DmmMatch.newMatch((Method) match[POSITION_M1], (Method) match[POSITION_M2]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected DmmMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return DmmMatch.newMutableMatch((Method) match[POSITION_M1], (Method) match[POSITION_M2]);
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
  public static IQuerySpecification<DmmMatcher> querySpecification() throws ViatraQueryException {
    return DmmQuerySpecification.instance();
  }
}
