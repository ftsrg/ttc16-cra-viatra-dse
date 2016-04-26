package hu.bme.mit.viatra.ttc.dse.queries.util;

import com.google.common.collect.Sets;
import hu.bme.mit.viatra.ttc.dse.queries.EncapsulatedMatch;
import hu.bme.mit.viatra.ttc.dse.queries.EncapsulatedMatcher;
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
 * A pattern-specific query specification that can instantiate EncapsulatedMatcher in a type-safe way.
 * 
 * @see EncapsulatedMatcher
 * @see EncapsulatedMatch
 * 
 */
@SuppressWarnings("all")
public final class EncapsulatedQuerySpecification extends BaseGeneratedEMFQuerySpecification<EncapsulatedMatcher> {
  private EncapsulatedQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static EncapsulatedQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected EncapsulatedMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return EncapsulatedMatcher.on(engine);
  }
  
  @Override
  public EncapsulatedMatch newEmptyMatch() {
    return EncapsulatedMatch.newEmptyMatch();
  }
  
  @Override
  public EncapsulatedMatch newMatch(final Object... parameters) {
    return EncapsulatedMatch.newMatch((architectureCRA.Class) parameters[0], (architectureCRA.Feature) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link EncapsulatedQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link EncapsulatedQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static EncapsulatedQuerySpecification INSTANCE = new EncapsulatedQuerySpecification();
    
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
    private final static EncapsulatedQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.viatra.ttc.dse.queries.encapsulated";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("c","f");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(
      			 new PParameter("c", "architectureCRA.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class"))),
      			 new PParameter("f", "architectureCRA.Feature", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Feature")))
      			);
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_c = body.getOrCreateVariableByName("c");
      		PVariable var_f = body.getOrCreateVariableByName("f");
      		new TypeConstraint(body, new FlatTuple(var_c), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")));
      		new TypeConstraint(body, new FlatTuple(var_f), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Feature")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_c, "c"),
      		   new ExportedParameter(body, var_f, "f")
      		));
      		//     Class.encapsulates(c, f)
      		new TypeConstraint(body, new FlatTuple(var_c), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_c, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class", "encapsulates")));
      		new Equality(body, var__virtual_0_, var_f);
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
