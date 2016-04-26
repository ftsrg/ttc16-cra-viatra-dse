package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.ClassModel;
import architectureCRA.Feature;
import hu.bme.mit.viatra.ttc.dse.queries.CreateClassWithFeautreMatch;
import hu.bme.mit.viatra.ttc.dse.queries.util.CreateClassWithFeautreQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.viatra.ttc.dse.queries.createClassWithFeautre pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link CreateClassWithFeautreMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern createClassWithFeautre(cm : ClassModel, f : Feature) {
 *     ClassModel(cm);
 *     N == count find emptyClass(_);
 *     check(N {@literal <} 2);
 *     Feature(f);
 *     neg find encapsulated(_, f);
 * }
 * </pre></code>
 * 
 * @see CreateClassWithFeautreMatch
 * @see CreateClassWithFeautreProcessor
 * @see CreateClassWithFeautreQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class CreateClassWithFeautreMatcher extends BaseMatcher<CreateClassWithFeautreMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static CreateClassWithFeautreMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    CreateClassWithFeautreMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new CreateClassWithFeautreMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CM = 0;
  
  private final static int POSITION_F = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(CreateClassWithFeautreMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private CreateClassWithFeautreMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return matches represented as a CreateClassWithFeautreMatch object.
   * 
   */
  public Collection<CreateClassWithFeautreMatch> getAllMatches(final ClassModel pCm, final Feature pF) {
    return rawGetAllMatches(new Object[]{pCm, pF});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return a match represented as a CreateClassWithFeautreMatch object, or null if no match is found.
   * 
   */
  public CreateClassWithFeautreMatch getOneArbitraryMatch(final ClassModel pCm, final Feature pF) {
    return rawGetOneArbitraryMatch(new Object[]{pCm, pF});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final ClassModel pCm, final Feature pF) {
    return rawHasMatch(new Object[]{pCm, pF});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final ClassModel pCm, final Feature pF) {
    return rawCountMatches(new Object[]{pCm, pF});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final ClassModel pCm, final Feature pF, final IMatchProcessor<? super CreateClassWithFeautreMatch> processor) {
    rawForEachMatch(new Object[]{pCm, pF}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final ClassModel pCm, final Feature pF, final IMatchProcessor<? super CreateClassWithFeautreMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCm, pF}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public CreateClassWithFeautreMatch newMatch(final ClassModel pCm, final Feature pF) {
    return CreateClassWithFeautreMatch.newMatch(pCm, pF);
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
  public Set<ClassModel> getAllValuesOfcm(final CreateClassWithFeautreMatch partialMatch) {
    return rawAccumulateAllValuesOfcm(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cm.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ClassModel> getAllValuesOfcm(final Feature pF) {
    return rawAccumulateAllValuesOfcm(new Object[]{
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
  public Set<Feature> getAllValuesOff(final CreateClassWithFeautreMatch partialMatch) {
    return rawAccumulateAllValuesOff(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for f.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Feature> getAllValuesOff(final ClassModel pCm) {
    return rawAccumulateAllValuesOff(new Object[]{
    pCm, 
    null
    });
  }
  
  @Override
  protected CreateClassWithFeautreMatch tupleToMatch(final Tuple t) {
    try {
    	return CreateClassWithFeautreMatch.newMatch((ClassModel) t.get(POSITION_CM), (Feature) t.get(POSITION_F));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected CreateClassWithFeautreMatch arrayToMatch(final Object[] match) {
    try {
    	return CreateClassWithFeautreMatch.newMatch((ClassModel) match[POSITION_CM], (Feature) match[POSITION_F]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected CreateClassWithFeautreMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return CreateClassWithFeautreMatch.newMutableMatch((ClassModel) match[POSITION_CM], (Feature) match[POSITION_F]);
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
  public static IQuerySpecification<CreateClassWithFeautreMatcher> querySpecification() throws ViatraQueryException {
    return CreateClassWithFeautreQuerySpecification.instance();
  }
}
