/**
 * Generated from platform:/resource/hu.bme.mit.viatra.ttc.dse/src/hu/bme/mit/viatra/ttc/dse/queries/queries.vql
 */
package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.Attribute;
import hu.bme.mit.viatra.ttc.dse.queries.AttributeMatch;
import hu.bme.mit.viatra.ttc.dse.queries.util.AttributeQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.viatra.ttc.dse.queries.attribute pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link AttributeMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern attribute(c : Class, a : Attribute) {
 *     find feature(a);
 *     Class.encapsulates(c, a);
 *     Attribute(a);
 * }
 * </pre></code>
 * 
 * @see AttributeMatch
 * @see AttributeProcessor
 * @see AttributeQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class AttributeMatcher extends BaseMatcher<AttributeMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static AttributeMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    AttributeMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new AttributeMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_C = 0;
  
  private final static int POSITION_A = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(AttributeMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private AttributeMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @return matches represented as a AttributeMatch object.
   * 
   */
  public Collection<AttributeMatch> getAllMatches(final architectureCRA.Class pC, final Attribute pA) {
    return rawGetAllMatches(new Object[]{pC, pA});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @return a match represented as a AttributeMatch object, or null if no match is found.
   * 
   */
  public AttributeMatch getOneArbitraryMatch(final architectureCRA.Class pC, final Attribute pA) {
    return rawGetOneArbitraryMatch(new Object[]{pC, pA});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final architectureCRA.Class pC, final Attribute pA) {
    return rawHasMatch(new Object[]{pC, pA});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final architectureCRA.Class pC, final Attribute pA) {
    return rawCountMatches(new Object[]{pC, pA});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final architectureCRA.Class pC, final Attribute pA, final IMatchProcessor<? super AttributeMatch> processor) {
    rawForEachMatch(new Object[]{pC, pA}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final architectureCRA.Class pC, final Attribute pA, final IMatchProcessor<? super AttributeMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pC, pA}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public AttributeMatch newMatch(final architectureCRA.Class pC, final Attribute pA) {
    return AttributeMatch.newMatch(pC, pA);
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
  public Set<architectureCRA.Class> getAllValuesOfc(final AttributeMatch partialMatch) {
    return rawAccumulateAllValuesOfc(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for c.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<architectureCRA.Class> getAllValuesOfc(final Attribute pA) {
    return rawAccumulateAllValuesOfc(new Object[]{
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
  public Set<Attribute> getAllValuesOfa(final AttributeMatch partialMatch) {
    return rawAccumulateAllValuesOfa(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for a.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Attribute> getAllValuesOfa(final architectureCRA.Class pC) {
    return rawAccumulateAllValuesOfa(new Object[]{
    pC, 
    null
    });
  }
  
  @Override
  protected AttributeMatch tupleToMatch(final Tuple t) {
    try {
    	return AttributeMatch.newMatch((architectureCRA.Class) t.get(POSITION_C), (Attribute) t.get(POSITION_A));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AttributeMatch arrayToMatch(final Object[] match) {
    try {
    	return AttributeMatch.newMatch((architectureCRA.Class) match[POSITION_C], (Attribute) match[POSITION_A]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AttributeMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return AttributeMatch.newMutableMatch((architectureCRA.Class) match[POSITION_C], (Attribute) match[POSITION_A]);
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
  public static IQuerySpecification<AttributeMatcher> querySpecification() throws ViatraQueryException {
    return AttributeQuerySpecification.instance();
  }
}
