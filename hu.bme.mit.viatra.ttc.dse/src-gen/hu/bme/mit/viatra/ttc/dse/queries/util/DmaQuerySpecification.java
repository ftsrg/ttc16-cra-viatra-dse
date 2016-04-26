package hu.bme.mit.viatra.ttc.dse.queries.util;

import com.google.common.collect.Sets;
import hu.bme.mit.viatra.ttc.dse.queries.DmaMatch;
import hu.bme.mit.viatra.ttc.dse.queries.DmaMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate DmaMatcher in a type-safe way.
 * 
 * @see DmaMatcher
 * @see DmaMatch
 * 
 */
@SuppressWarnings("all")
public final class DmaQuerySpecification extends BaseGeneratedEMFQuerySpecification<DmaMatcher> {
  private DmaQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static DmaQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected DmaMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return DmaMatcher.on(engine);
  }
  
  @Override
  public DmaMatch newEmptyMatch() {
    return DmaMatch.newEmptyMatch();
  }
  
  @Override
  public DmaMatch newMatch(final Object... parameters) {
    return DmaMatch.newMatch((architectureCRA.Method) parameters[0], (architectureCRA.Attribute) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link DmaQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link DmaQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static DmaQuerySpecification INSTANCE = new DmaQuerySpecification();
    
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
    private final static DmaQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.viatra.ttc.dse.queries.dma";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("m","a");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(
      			 new PParameter("m", "architectureCRA.Method", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Method"))),
      			 new PParameter("a", "architectureCRA.Attribute", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Attribute")))
      			);
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_m = body.getOrCreateVariableByName("m");
      		PVariable var_a = body.getOrCreateVariableByName("a");
      		new TypeConstraint(body, new FlatTuple(var_m), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Method")));
      		new TypeConstraint(body, new FlatTuple(var_a), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Attribute")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_m, "m"),
      		   new ExportedParameter(body, var_a, "a")
      		));
      		//     Method.dataDependency(m, a)
      		new TypeConstraint(body, new FlatTuple(var_m), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Method")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_m, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Method", "dataDependency")));
      		new Equality(body, var__virtual_0_, var_a);
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
