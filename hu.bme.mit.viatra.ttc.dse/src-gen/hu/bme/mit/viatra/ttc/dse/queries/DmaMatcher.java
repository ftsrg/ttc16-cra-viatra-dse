/**
 * Generated from platform:/resource/hu.bme.mit.viatra.ttc.dse/src/hu/bme/mit/viatra/ttc/dse/queries/queries.vql
 */
package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.Attribute;
import architectureCRA.Method;
import hu.bme.mit.viatra.ttc.dse.queries.DmaMatch;
import hu.bme.mit.viatra.ttc.dse.queries.util.DmaQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.viatra.ttc.dse.queries.dma pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link DmaMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * // Objectives
 * pattern dma(m : Method, a : Attribute) {
 *     Method.dataDependency(m, a);
 * }
 * </pre></code>
 * 
 * @see DmaMatch
 * @see DmaProcessor
 * @see DmaQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class DmaMatcher extends BaseMatcher<DmaMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static DmaMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    DmaMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (DmaMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static DmaMatcher create() throws ViatraQueryException {
    return new DmaMatcher();
  }
  
  private final static int POSITION_M = 0;
  
  private final static int POSITION_A = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(DmaMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private DmaMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @return matches represented as a DmaMatch object.
   * 
   */
  public Collection<DmaMatch> getAllMatches(final Method pM, final Attribute pA) {
    return rawGetAllMatches(new Object[]{pM, pA});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @return a match represented as a DmaMatch object, or null if no match is found.
   * 
   */
  public DmaMatch getOneArbitraryMatch(final Method pM, final Attribute pA) {
    return rawGetOneArbitraryMatch(new Object[]{pM, pA});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Method pM, final Attribute pA) {
    return rawHasMatch(new Object[]{pM, pA});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Method pM, final Attribute pA) {
    return rawCountMatches(new Object[]{pM, pA});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Method pM, final Attribute pA, final IMatchProcessor<? super DmaMatch> processor) {
    rawForEachMatch(new Object[]{pM, pA}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Method pM, final Attribute pA, final IMatchProcessor<? super DmaMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pM, pA}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public DmaMatch newMatch(final Method pM, final Attribute pA) {
    return DmaMatch.newMatch(pM, pA);
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
  public Set<Method> getAllValuesOfm(final DmaMatch partialMatch) {
    return rawAccumulateAllValuesOfm(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for m.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Method> getAllValuesOfm(final Attribute pA) {
    return rawAccumulateAllValuesOfm(new Object[]{
    null, 
    pA
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for a.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Attribute> rawAccumulateAllValuesOfa(final Object[] parameters) {
    Set<Attribute> results = new HashSet<Attribute>();
    rawAccumulateAllValues(POSITION_A, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for a.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Attribute> getAllValuesOfa() {
    return rawAccumulateAllValuesOfa(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for a.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Attribute> getAllValuesOfa(final DmaMatch partialMatch) {
    return rawAccumulateAllValuesOfa(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for a.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Attribute> getAllValuesOfa(final Method pM) {
    return rawAccumulateAllValuesOfa(new Object[]{
    pM, 
    null
    });
  }
  
  @Override
  protected DmaMatch tupleToMatch(final Tuple t) {
    try {
    	return DmaMatch.newMatch((Method) t.get(POSITION_M), (Attribute) t.get(POSITION_A));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected DmaMatch arrayToMatch(final Object[] match) {
    try {
    	return DmaMatch.newMatch((Method) match[POSITION_M], (Attribute) match[POSITION_A]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected DmaMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return DmaMatch.newMutableMatch((Method) match[POSITION_M], (Attribute) match[POSITION_A]);
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
  public static IQuerySpecification<DmaMatcher> querySpecification() throws ViatraQueryException {
    return DmaQuerySpecification.instance();
  }
}
