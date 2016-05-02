package hu.bme.mit.viatra.ttc.dse.queries.util;

import com.google.common.collect.Sets;
import hu.bme.mit.viatra.ttc.dse.queries.MaiPartialMatch;
import hu.bme.mit.viatra.ttc.dse.queries.MaiPartialMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.util.DmaQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.EncapsulatedQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate MaiPartialMatcher in a type-safe way.
 * 
 * @see MaiPartialMatcher
 * @see MaiPartialMatch
 * 
 */
@SuppressWarnings("all")
public final class MaiPartialQuerySpecification extends BaseGeneratedEMFQuerySpecification<MaiPartialMatcher> {
  private MaiPartialQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static MaiPartialQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MaiPartialMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MaiPartialMatcher.on(engine);
  }
  
  @Override
  public MaiPartialMatch newEmptyMatch() {
    return MaiPartialMatch.newEmptyMatch();
  }
  
  @Override
  public MaiPartialMatch newMatch(final Object... parameters) {
    return MaiPartialMatch.newMatch((architectureCRA.Class) parameters[0], (architectureCRA.Class) parameters[1], (architectureCRA.Method) parameters[2], (architectureCRA.Attribute) parameters[3]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link MaiPartialQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link MaiPartialQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static MaiPartialQuerySpecification INSTANCE = new MaiPartialQuerySpecification();
    
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
    private final static MaiPartialQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.viatra.ttc.dse.queries.maiPartial";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("c1","c2","m1","a2");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(
      			 new PParameter("c1", "architectureCRA.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class"))),
      			 new PParameter("c2", "architectureCRA.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class"))),
      			 new PParameter("m1", "architectureCRA.Method", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Method"))),
      			 new PParameter("a2", "architectureCRA.Attribute", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Attribute")))
      			);
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_c1 = body.getOrCreateVariableByName("c1");
      		PVariable var_c2 = body.getOrCreateVariableByName("c2");
      		PVariable var_m1 = body.getOrCreateVariableByName("m1");
      		PVariable var_a2 = body.getOrCreateVariableByName("a2");
      		new TypeConstraint(body, new FlatTuple(var_c1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")));
      		new TypeConstraint(body, new FlatTuple(var_c2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")));
      		new TypeConstraint(body, new FlatTuple(var_m1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Method")));
      		new TypeConstraint(body, new FlatTuple(var_a2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Attribute")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_c1, "c1"),
      		   new ExportedParameter(body, var_c2, "c2"),
      		   new ExportedParameter(body, var_m1, "m1"),
      		   new ExportedParameter(body, var_a2, "a2")
      		));
      		//     find encapsulated(c1, m1)
      		new PositivePatternCall(body, new FlatTuple(var_c1, var_m1), EncapsulatedQuerySpecification.instance().getInternalQueryRepresentation());
      		//     find encapsulated(c2, a2)
      		new PositivePatternCall(body, new FlatTuple(var_c2, var_a2), EncapsulatedQuerySpecification.instance().getInternalQueryRepresentation());
      		//     find dma(m1,a2)
      		new PositivePatternCall(body, new FlatTuple(var_m1, var_a2), DmaQuerySpecification.instance().getInternalQueryRepresentation());
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
