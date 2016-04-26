package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.Feature;
import hu.bme.mit.viatra.ttc.dse.queries.EncapsulatedMatch;
import hu.bme.mit.viatra.ttc.dse.queries.util.EncapsulatedQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.viatra.ttc.dse.queries.encapsulated pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link EncapsulatedMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern encapsulated(c : Class, f : Feature) {
 *     Class.encapsulates(c, f);
 * }
 * </pre></code>
 * 
 * @see EncapsulatedMatch
 * @see EncapsulatedProcessor
 * @see EncapsulatedQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class EncapsulatedMatcher extends BaseMatcher<EncapsulatedMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static EncapsulatedMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    EncapsulatedMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new EncapsulatedMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_C = 0;
  
  private final static int POSITION_F = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(EncapsulatedMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private EncapsulatedMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return matches represented as a EncapsulatedMatch object.
   * 
   */
  public Collection<EncapsulatedMatch> getAllMatches(final architectureCRA.Class pC, final Feature pF) {
    return rawGetAllMatches(new Object[]{pC, pF});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return a match represented as a EncapsulatedMatch object, or null if no match is found.
   * 
   */
  public EncapsulatedMatch getOneArbitraryMatch(final architectureCRA.Class pC, final Feature pF) {
    return rawGetOneArbitraryMatch(new Object[]{pC, pF});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final architectureCRA.Class pC, final Feature pF) {
    return rawHasMatch(new Object[]{pC, pF});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final architectureCRA.Class pC, final Feature pF) {
    return rawCountMatches(new Object[]{pC, pF});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final architectureCRA.Class pC, final Feature pF, final IMatchProcessor<? super EncapsulatedMatch> processor) {
    rawForEachMatch(new Object[]{pC, pF}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final architectureCRA.Class pC, final Feature pF, final IMatchProcessor<? super EncapsulatedMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pC, pF}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public EncapsulatedMatch newMatch(final architectureCRA.Class pC, final Feature pF) {
    return EncapsulatedMatch.newMatch(pC, pF);
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
  public Set<architectureCRA.Class> getAllValuesOfc(final EncapsulatedMatch partialMatch) {
    return rawAccumulateAllValuesOfc(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for c.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<architectureCRA.Class> getAllValuesOfc(final Feature pF) {
    return rawAccumulateAllValuesOfc(new Object[]{
    null, 
    pF
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for f.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Feature> rawAccumulateAllValuesOff(final Object[] parameters) {
    Set<Feature> results = new HashSet<Feature>();
    rawAccumulateAllValues(POSITION_F, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for f.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Feature> getAllValuesOff() {
    return rawAccumulateAllValuesOff(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for f.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Feature> getAllValuesOff(final EncapsulatedMatch partialMatch) {
    return rawAccumulateAllValuesOff(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for f.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Feature> getAllValuesOff(final architectureCRA.Class pC) {
    return rawAccumulateAllValuesOff(new Object[]{
    pC, 
    null
    });
  }
  
  @Override
  protected EncapsulatedMatch tupleToMatch(final Tuple t) {
    try {
    	return EncapsulatedMatch.newMatch((architectureCRA.Class) t.get(POSITION_C), (Feature) t.get(POSITION_F));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected EncapsulatedMatch arrayToMatch(final Object[] match) {
    try {
    	return EncapsulatedMatch.newMatch((architectureCRA.Class) match[POSITION_C], (Feature) match[POSITION_F]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected EncapsulatedMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return EncapsulatedMatch.newMutableMatch((architectureCRA.Class) match[POSITION_C], (Feature) match[POSITION_F]);
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
  public static IQuerySpecification<EncapsulatedMatcher> querySpecification() throws ViatraQueryException {
    return EncapsulatedQuerySpecification.instance();
  }
}
