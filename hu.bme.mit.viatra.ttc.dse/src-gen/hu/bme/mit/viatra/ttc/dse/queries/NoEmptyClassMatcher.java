package hu.bme.mit.viatra.ttc.dse.queries;

import hu.bme.mit.viatra.ttc.dse.queries.NoEmptyClassMatch;
import hu.bme.mit.viatra.ttc.dse.queries.util.NoEmptyClassQuerySpecification;
import org.apache.log4j.Logger;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.viatra.ttc.dse.queries.noEmptyClass pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link NoEmptyClassMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern noEmptyClass() {
 *     neg find emptyClass(_);
 * }
 * </pre></code>
 * 
 * @see NoEmptyClassMatch
 * @see NoEmptyClassProcessor
 * @see NoEmptyClassQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class NoEmptyClassMatcher extends BaseMatcher<NoEmptyClassMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static NoEmptyClassMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    NoEmptyClassMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new NoEmptyClassMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(NoEmptyClassMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private NoEmptyClassMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Indicates whether the (parameterless) pattern matches or not.
   * @return true if the pattern has a valid match.
   * 
   */
  public boolean hasMatch() {
    return rawHasMatch(new Object[]{});
  }
  
  @Override
  protected NoEmptyClassMatch tupleToMatch(final Tuple t) {
    try {
    	return NoEmptyClassMatch.newMatch();
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NoEmptyClassMatch arrayToMatch(final Object[] match) {
    try {
    	return NoEmptyClassMatch.newMatch();
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NoEmptyClassMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return NoEmptyClassMatch.newMutableMatch();
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
  public static IQuerySpecification<NoEmptyClassMatcher> querySpecification() throws ViatraQueryException {
    return NoEmptyClassQuerySpecification.instance();
  }
}
