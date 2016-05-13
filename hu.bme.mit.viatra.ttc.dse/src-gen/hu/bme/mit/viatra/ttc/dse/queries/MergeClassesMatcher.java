package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.ClassModel;
import hu.bme.mit.viatra.ttc.dse.queries.MergeClassesMatch;
import hu.bme.mit.viatra.ttc.dse.queries.util.MergeClassesQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.viatra.ttc.dse.queries.mergeClasses pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link MergeClassesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern mergeClasses(cm : ClassModel, c1 : Class, c2 : Class) {
 *     ClassModel(cm);
 *     Class(c1);
 *     Class(c2);
 *     c1 != c2;
 *     find sortClass(c1,c2);
 * }
 * </pre></code>
 * 
 * @see MergeClassesMatch
 * @see MergeClassesProcessor
 * @see MergeClassesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class MergeClassesMatcher extends BaseMatcher<MergeClassesMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static MergeClassesMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    MergeClassesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new MergeClassesMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CM = 0;
  
  private final static int POSITION_C1 = 1;
  
  private final static int POSITION_C2 = 2;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(MergeClassesMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private MergeClassesMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @return matches represented as a MergeClassesMatch object.
   * 
   */
  public Collection<MergeClassesMatch> getAllMatches(final ClassModel pCm, final architectureCRA.Class pC1, final architectureCRA.Class pC2) {
    return rawGetAllMatches(new Object[]{pCm, pC1, pC2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @return a match represented as a MergeClassesMatch object, or null if no match is found.
   * 
   */
  public MergeClassesMatch getOneArbitraryMatch(final ClassModel pCm, final architectureCRA.Class pC1, final architectureCRA.Class pC2) {
    return rawGetOneArbitraryMatch(new Object[]{pCm, pC1, pC2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final ClassModel pCm, final architectureCRA.Class pC1, final architectureCRA.Class pC2) {
    return rawHasMatch(new Object[]{pCm, pC1, pC2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final ClassModel pCm, final architectureCRA.Class pC1, final architectureCRA.Class pC2) {
    return rawCountMatches(new Object[]{pCm, pC1, pC2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final ClassModel pCm, final architectureCRA.Class pC1, final architectureCRA.Class pC2, final IMatchProcessor<? super MergeClassesMatch> processor) {
    rawForEachMatch(new Object[]{pCm, pC1, pC2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final ClassModel pCm, final architectureCRA.Class pC1, final architectureCRA.Class pC2, final IMatchProcessor<? super MergeClassesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCm, pC1, pC2}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public MergeClassesMatch newMatch(final ClassModel pCm, final architectureCRA.Class pC1, final architectureCRA.Class pC2) {
    return MergeClassesMatch.newMatch(pCm, pC1, pC2);
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
  
  /**
   * Retrieve the set of values that occur in matches for cm.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ClassModel> getAllValuesOfcm(final MergeClassesMatch partialMatch) {
    return rawAccumulateAllValuesOfcm(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cm.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ClassModel> getAllValuesOfcm(final architectureCRA.Class pC1, final architectureCRA.Class pC2) {
    return rawAccumulateAllValuesOfcm(new Object[]{
    null, 
    pC1, 
    pC2
    });
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
  public Set<architectureCRA.Class> getAllValuesOfc1(final MergeClassesMatch partialMatch) {
    return rawAccumulateAllValuesOfc1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for c1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<architectureCRA.Class> getAllValuesOfc1(final ClassModel pCm, final architectureCRA.Class pC2) {
    return rawAccumulateAllValuesOfc1(new Object[]{
    pCm, 
    null, 
    pC2
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
  public Set<architectureCRA.Class> getAllValuesOfc2(final MergeClassesMatch partialMatch) {
    return rawAccumulateAllValuesOfc2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for c2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<architectureCRA.Class> getAllValuesOfc2(final ClassModel pCm, final architectureCRA.Class pC1) {
    return rawAccumulateAllValuesOfc2(new Object[]{
    pCm, 
    pC1, 
    null
    });
  }
  
  @Override
  protected MergeClassesMatch tupleToMatch(final Tuple t) {
    try {
    	return MergeClassesMatch.newMatch((ClassModel) t.get(POSITION_CM), (architectureCRA.Class) t.get(POSITION_C1), (architectureCRA.Class) t.get(POSITION_C2));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MergeClassesMatch arrayToMatch(final Object[] match) {
    try {
    	return MergeClassesMatch.newMatch((ClassModel) match[POSITION_CM], (architectureCRA.Class) match[POSITION_C1], (architectureCRA.Class) match[POSITION_C2]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MergeClassesMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return MergeClassesMatch.newMutableMatch((ClassModel) match[POSITION_CM], (architectureCRA.Class) match[POSITION_C1], (architectureCRA.Class) match[POSITION_C2]);
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
  public static IQuerySpecification<MergeClassesMatcher> querySpecification() throws ViatraQueryException {
    return MergeClassesQuerySpecification.instance();
  }
}
