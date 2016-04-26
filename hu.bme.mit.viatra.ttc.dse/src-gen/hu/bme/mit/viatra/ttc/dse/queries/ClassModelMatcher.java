package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.ClassModel;
import hu.bme.mit.viatra.ttc.dse.queries.ClassModelMatch;
import hu.bme.mit.viatra.ttc.dse.queries.util.ClassModelQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.viatra.ttc.dse.queries.classModel pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ClassModelMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * // Rules
 * pattern classModel(cm : ClassModel) {
 *     ClassModel(cm);
 *     N == count find emptyClass(_);
 *     check(N {@literal <} 1);
 * }
 * </pre></code>
 * 
 * @see ClassModelMatch
 * @see ClassModelProcessor
 * @see ClassModelQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ClassModelMatcher extends BaseMatcher<ClassModelMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ClassModelMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    ClassModelMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ClassModelMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CM = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ClassModelMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private ClassModelMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @return matches represented as a ClassModelMatch object.
   * 
   */
  public Collection<ClassModelMatch> getAllMatches(final ClassModel pCm) {
    return rawGetAllMatches(new Object[]{pCm});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @return a match represented as a ClassModelMatch object, or null if no match is found.
   * 
   */
  public ClassModelMatch getOneArbitraryMatch(final ClassModel pCm) {
    return rawGetOneArbitraryMatch(new Object[]{pCm});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final ClassModel pCm) {
    return rawHasMatch(new Object[]{pCm});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final ClassModel pCm) {
    return rawCountMatches(new Object[]{pCm});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final ClassModel pCm, final IMatchProcessor<? super ClassModelMatch> processor) {
    rawForEachMatch(new Object[]{pCm}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final ClassModel pCm, final IMatchProcessor<? super ClassModelMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCm}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ClassModelMatch newMatch(final ClassModel pCm) {
    return ClassModelMatch.newMatch(pCm);
  }
  
  /**
   * Retrieve the set of values that occur in matches for cm.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ClassModel> rawAccumulateAllValuesOfcm(final Object[] parameters) {
    Set<ClassModel> results = new HashSet<ClassModel>();
    rawAccumulateAllValues(POSITION_CM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for cm.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ClassModel> getAllValuesOfcm() {
    return rawAccumulateAllValuesOfcm(emptyArray());
  }
  
  @Override
  protected ClassModelMatch tupleToMatch(final Tuple t) {
    try {
    	return ClassModelMatch.newMatch((ClassModel) t.get(POSITION_CM));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ClassModelMatch arrayToMatch(final Object[] match) {
    try {
    	return ClassModelMatch.newMatch((ClassModel) match[POSITION_CM]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ClassModelMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ClassModelMatch.newMutableMatch((ClassModel) match[POSITION_CM]);
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
  public static IQuerySpecification<ClassModelMatcher> querySpecification() throws ViatraQueryException {
    return ClassModelQuerySpecification.instance();
  }
}
