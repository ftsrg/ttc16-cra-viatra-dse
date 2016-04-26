package hu.bme.mit.viatra.ttc.dse.queries.util;

import com.google.common.collect.Sets;
import hu.bme.mit.viatra.ttc.dse.queries.AllFeatureEncapsulated2Match;
import hu.bme.mit.viatra.ttc.dse.queries.AllFeatureEncapsulated2Matcher;
import hu.bme.mit.viatra.ttc.dse.queries.util.NotEncapsulatedFeatureQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate AllFeatureEncapsulated2Matcher in a type-safe way.
 * 
 * @see AllFeatureEncapsulated2Matcher
 * @see AllFeatureEncapsulated2Match
 * 
 */
@SuppressWarnings("all")
public final class AllFeatureEncapsulated2QuerySpecification extends BaseGeneratedEMFQuerySpecification<AllFeatureEncapsulated2Matcher> {
  private AllFeatureEncapsulated2QuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static AllFeatureEncapsulated2QuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected AllFeatureEncapsulated2Matcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return AllFeatureEncapsulated2Matcher.on(engine);
  }
  
  @Override
  public AllFeatureEncapsulated2Match newEmptyMatch() {
    return AllFeatureEncapsulated2Match.newEmptyMatch();
  }
  
  @Override
  public AllFeatureEncapsulated2Match newMatch(final Object... parameters) {
    return AllFeatureEncapsulated2Match.newMatch();
  }
  
  /**
   * Inner class allowing the singleton instance of {@link AllFeatureEncapsulated2QuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link AllFeatureEncapsulated2QuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static AllFeatureEncapsulated2QuerySpecification INSTANCE = new AllFeatureEncapsulated2QuerySpecification();
    
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
    private final static AllFeatureEncapsulated2QuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.viatra.ttc.dse.queries.allFeatureEncapsulated2";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList();
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(
      			);
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		));
      		//     neg find notEncapsulatedFeature(_)
      		new NegativePatternCall(body, new FlatTuple(var___0_), NotEncapsulatedFeatureQuerySpecification.instance().getInternalQueryRepresentation());
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
