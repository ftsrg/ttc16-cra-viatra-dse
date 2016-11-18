/**
 * Generated from platform:/resource/hu.bme.mit.viatra.ttc.dse/src/hu/bme/mit/viatra/ttc/dse/queries/queries.vql
 */
package hu.bme.mit.viatra.ttc.dse.queries.util;

import com.google.common.collect.Sets;
import hu.bme.mit.viatra.ttc.dse.queries.NoEmptyClassMatch;
import hu.bme.mit.viatra.ttc.dse.queries.NoEmptyClassMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.util.EmptyClassQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryBackendFactory;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate NoEmptyClassMatcher in a type-safe way.
 * 
 * @see NoEmptyClassMatcher
 * @see NoEmptyClassMatch
 * 
 */
@SuppressWarnings("all")
public final class NoEmptyClassQuerySpecification extends BaseGeneratedEMFQuerySpecification<NoEmptyClassMatcher> {
  private NoEmptyClassQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static NoEmptyClassQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected NoEmptyClassMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return NoEmptyClassMatcher.on(engine);
  }
  
  @Override
  public NoEmptyClassMatcher instantiate() throws ViatraQueryException {
    return NoEmptyClassMatcher.create();
  }
  
  @Override
  public NoEmptyClassMatch newEmptyMatch() {
    return NoEmptyClassMatch.newEmptyMatch();
  }
  
  @Override
  public NoEmptyClassMatch newMatch(final Object... parameters) {
    return NoEmptyClassMatch.newMatch();
  }
  
  /**
   * Inner class allowing the singleton instance of {@link NoEmptyClassQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link NoEmptyClassQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static NoEmptyClassQuerySpecification INSTANCE = new NoEmptyClassQuerySpecification();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private final static Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternalSneaky();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static NoEmptyClassQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final List<PParameter> parameters = Arrays.asList();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.viatra.ttc.dse.queries.noEmptyClass";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList();
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      setEvaluationHints(new QueryEvaluationHint(null, (IQueryBackendFactory)null));
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		));
      		//     neg find emptyClass(_)
      		new NegativePatternCall(body, new FlatTuple(var___0_), EmptyClassQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	// to silence compiler error
      	if (false) throw new ViatraQueryException("Never", "happens");
      } catch (ViatraQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
