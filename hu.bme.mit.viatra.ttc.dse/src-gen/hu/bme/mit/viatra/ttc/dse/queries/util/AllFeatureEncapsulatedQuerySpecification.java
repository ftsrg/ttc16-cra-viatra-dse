package hu.bme.mit.viatra.ttc.dse.queries.util;

import com.google.common.collect.Sets;
import hu.bme.mit.viatra.ttc.dse.queries.AllFeatureEncapsulatedMatch;
import hu.bme.mit.viatra.ttc.dse.queries.AllFeatureEncapsulatedMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.util.EncapsulatedFeatureQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.FeatureQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.PatternMatchCounter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate AllFeatureEncapsulatedMatcher in a type-safe way.
 * 
 * @see AllFeatureEncapsulatedMatcher
 * @see AllFeatureEncapsulatedMatch
 * 
 */
@SuppressWarnings("all")
public final class AllFeatureEncapsulatedQuerySpecification extends BaseGeneratedEMFQuerySpecification<AllFeatureEncapsulatedMatcher> {
  private AllFeatureEncapsulatedQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static AllFeatureEncapsulatedQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected AllFeatureEncapsulatedMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return AllFeatureEncapsulatedMatcher.on(engine);
  }
  
  @Override
  public AllFeatureEncapsulatedMatch newEmptyMatch() {
    return AllFeatureEncapsulatedMatch.newEmptyMatch();
  }
  
  @Override
  public AllFeatureEncapsulatedMatch newMatch(final Object... parameters) {
    return AllFeatureEncapsulatedMatch.newMatch();
  }
  
  /**
   * Inner class allowing the singleton instance of {@link AllFeatureEncapsulatedQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link AllFeatureEncapsulatedQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static AllFeatureEncapsulatedQuerySpecification INSTANCE = new AllFeatureEncapsulatedQuerySpecification();
    
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
    private final static AllFeatureEncapsulatedQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.viatra.ttc.dse.queries.allFeatureEncapsulated";
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
      		PVariable var_N = body.getOrCreateVariableByName("N");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		PVariable var_M = body.getOrCreateVariableByName("M");
      		PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		));
      		//     N == count find feature(_)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new PatternMatchCounter(body, new FlatTuple(var___0_), FeatureQuerySpecification.instance().getInternalQueryRepresentation(), var__virtual_0_);
      		new Equality(body, var_N, var__virtual_0_);
      		//     M == count find encapsulatedFeature(_)
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new PatternMatchCounter(body, new FlatTuple(var___1_), EncapsulatedFeatureQuerySpecification.instance().getInternalQueryRepresentation(), var__virtual_1_);
      		new Equality(body, var_M, var__virtual_1_);
      		//     N == M
      		new Equality(body, var_N, var_M);
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
