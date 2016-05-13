package hu.bme.mit.viatra.ttc.dse.queries.util;

import com.google.common.collect.Sets;
import hu.bme.mit.viatra.ttc.dse.queries.MergeClassesMatch;
import hu.bme.mit.viatra.ttc.dse.queries.MergeClassesMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.util.SortClassQuerySpecification;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate MergeClassesMatcher in a type-safe way.
 * 
 * @see MergeClassesMatcher
 * @see MergeClassesMatch
 * 
 */
@SuppressWarnings("all")
public final class MergeClassesQuerySpecification extends BaseGeneratedEMFQuerySpecification<MergeClassesMatcher> {
  private MergeClassesQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static MergeClassesQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MergeClassesMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MergeClassesMatcher.on(engine);
  }
  
  @Override
  public MergeClassesMatch newEmptyMatch() {
    return MergeClassesMatch.newEmptyMatch();
  }
  
  @Override
  public MergeClassesMatch newMatch(final Object... parameters) {
    return MergeClassesMatch.newMatch((architectureCRA.ClassModel) parameters[0], (architectureCRA.Class) parameters[1], (architectureCRA.Class) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link MergeClassesQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link MergeClassesQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static MergeClassesQuerySpecification INSTANCE = new MergeClassesQuerySpecification();
    
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
    private final static MergeClassesQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.viatra.ttc.dse.queries.mergeClasses";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("cm","c1","c2");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(
      			 new PParameter("cm", "architectureCRA.ClassModel", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "ClassModel"))),
      			 new PParameter("c1", "architectureCRA.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class"))),
      			 new PParameter("c2", "architectureCRA.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")))
      			);
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_cm = body.getOrCreateVariableByName("cm");
      		PVariable var_c1 = body.getOrCreateVariableByName("c1");
      		PVariable var_c2 = body.getOrCreateVariableByName("c2");
      		new TypeConstraint(body, new FlatTuple(var_cm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "ClassModel")));
      		new TypeConstraint(body, new FlatTuple(var_c1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")));
      		new TypeConstraint(body, new FlatTuple(var_c2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_cm, "cm"),
      		   new ExportedParameter(body, var_c1, "c1"),
      		   new ExportedParameter(body, var_c2, "c2")
      		));
      		//     ClassModel(cm)
      		new TypeConstraint(body, new FlatTuple(var_cm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "ClassModel")));
      		//     Class(c1)
      		new TypeConstraint(body, new FlatTuple(var_c1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")));
      		//     Class(c2)
      		new TypeConstraint(body, new FlatTuple(var_c2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://momot.big.tuwien.ac.at/architectureCRA/1.0", "Class")));
      		//     c1 != c2
      		new Inequality(body, var_c1, var_c2);
      		//     find sortClass(c1,c2)
      		new PositivePatternCall(body, new FlatTuple(var_c1, var_c2), SortClassQuerySpecification.instance().getInternalQueryRepresentation());
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
