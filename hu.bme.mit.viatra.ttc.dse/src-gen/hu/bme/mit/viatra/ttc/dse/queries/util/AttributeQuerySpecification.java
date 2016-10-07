/**
 * Generated from platform:/resource/hu.bme.mit.viatra.ttc.dse/src/hu/bme/mit/viatra/ttc/dse/queries/queries.vql
 */
package hu.bme.mit.viatra.ttc.dse.queries.util;

import com.google.common.collect.Sets;
import hu.bme.mit.viatra.ttc.dse.queries.AttributeMatch;
import hu.bme.mit.viatra.ttc.dse.queries.AttributeMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.util.FeatureQuerySpecification;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate AttributeMatcher in a type-safe way.
 * 
 * @see AttributeMatcher
 * @see AttributeMatch
 * 
 */
@SuppressWarnings("all")
public final class AttributeQuerySpecification extends BaseGeneratedEMFQuerySpecification<AttributeMatcher> {
  private AttributeQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static AttributeQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected AttributeMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return AttributeMatcher.on(engine);
  }
  
  @Override
  public AttributeMatcher instantiate() throws ViatraQueryException {
    return AttributeMatcher.create();
  }
  
  @Override
  public AttributeMatch newEmptyMatch() {
    return AttributeMatch.newEmptyMatch();
  }
  
  @Override
  public AttributeMatch newMatch(final Object... parameters) {
    return AttributeMatch.newMatch((architectureCRA.Class) parameters[0], (architectureCRA.Attribute) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link AttributeQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link AttributeQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static AttributeQuerySpecification INSTANCE = new AttributeQuerySpecification();
    
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
    private final static AttributeQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pC = new PParameter("c", "architectureCRA.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pA = new PParameter("a", "architectureCRA.Attribute", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Attribute")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pC, parameter_pA);
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.viatra.ttc.dse.queries.attribute";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("c","a");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      setEvaluationHints(new QueryEvaluationHint(null, Collections.<String,Object>emptyMap()));
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_c = body.getOrCreateVariableByName("c");
      		PVariable var_a = body.getOrCreateVariableByName("a");
      		new TypeConstraint(body, new FlatTuple(var_c), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")));
      		new TypeConstraint(body, new FlatTuple(var_a), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Attribute")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_c, parameter_pC),
      		   new ExportedParameter(body, var_a, parameter_pA)
      		));
      		//     find feature(a)
      		new PositivePatternCall(body, new FlatTuple(var_a), FeatureQuerySpecification.instance().getInternalQueryRepresentation());
      		//     Class.encapsulates(c, a)
      		new TypeConstraint(body, new FlatTuple(var_c), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_c, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class", "encapsulates")));
      		new Equality(body, var__virtual_0_, var_a);
      		//     Attribute(a)
      		new TypeConstraint(body, new FlatTuple(var_a), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Attribute")));
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
