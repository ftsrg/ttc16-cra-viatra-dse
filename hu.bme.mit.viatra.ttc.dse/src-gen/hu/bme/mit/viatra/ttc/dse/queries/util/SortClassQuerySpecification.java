/**
 * Generated from platform:/resource/hu.bme.mit.viatra.ttc.dse/src/hu/bme/mit/viatra/ttc/dse/queries/queries.vql
 */
package hu.bme.mit.viatra.ttc.dse.queries.util;

import com.google.common.collect.Sets;
import hu.bme.mit.viatra.ttc.dse.queries.SortClassMatch;
import hu.bme.mit.viatra.ttc.dse.queries.SortClassMatcher;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate SortClassMatcher in a type-safe way.
 * 
 * @see SortClassMatcher
 * @see SortClassMatch
 * 
 */
@SuppressWarnings("all")
public final class SortClassQuerySpecification extends BaseGeneratedEMFQuerySpecification<SortClassMatcher> {
  private SortClassQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static SortClassQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SortClassMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return SortClassMatcher.on(engine);
  }
  
  @Override
  public SortClassMatcher instantiate() throws ViatraQueryException {
    return SortClassMatcher.create();
  }
  
  @Override
  public SortClassMatch newEmptyMatch() {
    return SortClassMatch.newEmptyMatch();
  }
  
  @Override
  public SortClassMatch newMatch(final Object... parameters) {
    return SortClassMatch.newMatch((architectureCRA.Class) parameters[0], (architectureCRA.Class) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link SortClassQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link SortClassQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static SortClassQuerySpecification INSTANCE = new SortClassQuerySpecification();
    
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
    private final static SortClassQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pC1 = new PParameter("c1", "architectureCRA.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pC2 = new PParameter("c2", "architectureCRA.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pC1, parameter_pC2);
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.viatra.ttc.dse.queries.sortClass";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("c1","c2");
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
      		PVariable var_c1 = body.getOrCreateVariableByName("c1");
      		PVariable var_c2 = body.getOrCreateVariableByName("c2");
      		PVariable var_name1 = body.getOrCreateVariableByName("name1");
      		PVariable var_name2 = body.getOrCreateVariableByName("name2");
      		new TypeConstraint(body, new FlatTuple(var_c1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")));
      		new TypeConstraint(body, new FlatTuple(var_c2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_c1, parameter_pC1),
      		   new ExportedParameter(body, var_c2, parameter_pC2)
      		));
      		//     Class.name(c1,name1)
      		new TypeConstraint(body, new FlatTuple(var_c1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_c1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "NamedElement", "name")));
      		new Equality(body, var__virtual_0_, var_name1);
      		//     Class.name(c2,name2)
      		new TypeConstraint(body, new FlatTuple(var_c2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_c2, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "NamedElement", "name")));
      		new Equality(body, var__virtual_1_, var_name2);
      		//     check(name1.compareTo(name2) <= 0)
      		new ExpressionEvaluation(body, new IExpressionEvaluator() {
      		
      		    @Override
      		    public String getShortDescription() {
      		        return "Expression evaluation from pattern sortClass";
      		    }
      		    
      		    @Override
      		    public Iterable<String> getInputParameterNames() {
      		        return Arrays.asList("name1", "name2");}
      		
      		    @Override
      		    public Object evaluateExpression(IValueProvider provider) throws Exception {
      		        String name1 = (String) provider.getValue("name1");
      		        String name2 = (String) provider.getValue("name2");
      		        return evaluateExpression_1_1(name1, name2);
      		    }
      		},  null); 
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
  
  private static boolean evaluateExpression_1_1(final String name1, final String name2) {
    int _compareTo = name1.compareTo(name2);
    boolean _lessEqualsThan = (_compareTo <= 0);
    return _lessEqualsThan;
  }
}
