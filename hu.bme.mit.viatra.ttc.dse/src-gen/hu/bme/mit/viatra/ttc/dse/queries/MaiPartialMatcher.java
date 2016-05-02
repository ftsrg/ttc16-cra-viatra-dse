package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.Attribute;
import architectureCRA.Method;
import hu.bme.mit.viatra.ttc.dse.queries.MaiPartialMatch;
import hu.bme.mit.viatra.ttc.dse.queries.util.MaiPartialQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.viatra.ttc.dse.queries.maiPartial pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link MaiPartialMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern maiPartial(c1 : Class, c2 : Class, m1: Method, a2: Attribute) {
 *     find encapsulated(c1, m1);
 *     find encapsulated(c2, a2);
 *     find dma(m1,a2);
 * }
 * </pre></code>
 * 
 * @see MaiPartialMatch
 * @see MaiPartialProcessor
 * @see MaiPartialQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class MaiPartialMatcher extends BaseMatcher<MaiPartialMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static MaiPartialMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    MaiPartialMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new MaiPartialMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_C1 = 0;
  
  private final static int POSITION_C2 = 1;
  
  private final static int POSITION_M1 = 2;
  
  private final static int POSITION_A2 = 3;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(MaiPartialMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private MaiPartialMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pA2 the fixed value of pattern parameter a2, or null if not bound.
   * @return matches represented as a MaiPartialMatch object.
   * 
   */
  public Collection<MaiPartialMatch> getAllMatches(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Method pM1, final Attribute pA2) {
    return rawGetAllMatches(new Object[]{pC1, pC2, pM1, pA2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pA2 the fixed value of pattern parameter a2, or null if not bound.
   * @return a match represented as a MaiPartialMatch object, or null if no match is found.
   * 
   */
  public MaiPartialMatch getOneArbitraryMatch(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Method pM1, final Attribute pA2) {
    return rawGetOneArbitraryMatch(new Object[]{pC1, pC2, pM1, pA2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pA2 the fixed value of pattern parameter a2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Method pM1, final Attribute pA2) {
    return rawHasMatch(new Object[]{pC1, pC2, pM1, pA2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pA2 the fixed value of pattern parameter a2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Method pM1, final Attribute pA2) {
    return rawCountMatches(new Object[]{pC1, pC2, pM1, pA2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pA2 the fixed value of pattern parameter a2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Method pM1, final Attribute pA2, final IMatchProcessor<? super MaiPartialMatch> processor) {
    rawForEachMatch(new Object[]{pC1, pC2, pM1, pA2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pA2 the fixed value of pattern parameter a2, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Method pM1, final Attribute pA2, final IMatchProcessor<? super MaiPartialMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pC1, pC2, pM1, pA2}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pA2 the fixed value of pattern parameter a2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public MaiPartialMatch newMatch(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Method pM1, final Attribute pA2) {
    return MaiPartialMatch.newMatch(pC1, pC2, pM1, pA2);
  }
  
  /**
   * Retrieve the set of values that occur in matches for c1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<architectureCRA.Class> rawAccumulateAllValuesOfc1(final Object[] parameters) {
    Set<architectureCRA.Class> results = new HashSet<architectureCRA.Class>();
    rawAccumulateAllValues(POSITION_C1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for c1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<architectureCRA.Class> getAllValuesOfc1() {
    return rawAccumulateAllValuesOfc1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for c1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<architectureCRA.Class> getAllValuesOfc1(final MaiPartialMatch partialMatch) {
    return rawAccumulateAllValuesOfc1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for c1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<architectureCRA.Class> getAllValuesOfc1(final architectureCRA.Class pC2, final Method pM1, final Attribute pA2) {
    return rawAccumulateAllValuesOfc1(new Object[]{
    null, 
    pC2, 
    pM1, 
    pA2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for c2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<architectureCRA.Class> rawAccumulateAllValuesOfc2(final Object[] parameters) {
    Set<architectureCRA.Class> results = new HashSet<architectureCRA.Class>();
    rawAccumulateAllValues(POSITION_C2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for c2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<architectureCRA.Class> getAllValuesOfc2() {
    return rawAccumulateAllValuesOfc2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for c2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<architectureCRA.Class> getAllValuesOfc2(final MaiPartialMatch partialMatch) {
    return rawAccumulateAllValuesOfc2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for c2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<architectureCRA.Class> getAllValuesOfc2(final architectureCRA.Class pC1, final Method pM1, final Attribute pA2) {
    return rawAccumulateAllValuesOfc2(new Object[]{
    pC1, 
    null, 
    pM1, 
    pA2
    });
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
  public Set<Method> getAllValuesOfm1(final MaiPartialMatch partialMatch) {
    return rawAccumulateAllValuesOfm1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for m1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Method> getAllValuesOfm1(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Attribute pA2) {
    return rawAccumulateAllValuesOfm1(new Object[]{
    pC1, 
    pC2, 
    null, 
    pA2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for a2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Attribute> rawAccumulateAllValuesOfa2(final Object[] parameters) {
    Set<Attribute> results = new HashSet<Attribute>();
    rawAccumulateAllValues(POSITION_A2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for a2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Attribute> getAllValuesOfa2() {
    return rawAccumulateAllValuesOfa2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for a2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Attribute> getAllValuesOfa2(final MaiPartialMatch partialMatch) {
    return rawAccumulateAllValuesOfa2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for a2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Attribute> getAllValuesOfa2(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Method pM1) {
    return rawAccumulateAllValuesOfa2(new Object[]{
    pC1, 
    pC2, 
    pM1, 
    null
    });
  }
  
  @Override
  protected MaiPartialMatch tupleToMatch(final Tuple t) {
    try {
    	return MaiPartialMatch.newMatch((architectureCRA.Class) t.get(POSITION_C1), (architectureCRA.Class) t.get(POSITION_C2), (Method) t.get(POSITION_M1), (Attribute) t.get(POSITION_A2));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MaiPartialMatch arrayToMatch(final Object[] match) {
    try {
    	return MaiPartialMatch.newMatch((architectureCRA.Class) match[POSITION_C1], (architectureCRA.Class) match[POSITION_C2], (Method) match[POSITION_M1], (Attribute) match[POSITION_A2]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MaiPartialMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return MaiPartialMatch.newMutableMatch((architectureCRA.Class) match[POSITION_C1], (architectureCRA.Class) match[POSITION_C2], (Method) match[POSITION_M1], (Attribute) match[POSITION_A2]);
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
  public static IQuerySpecification<MaiPartialMatcher> querySpecification() throws ViatraQueryException {
    return MaiPartialQuerySpecification.instance();
  }
}
