/**
 * Generated from platform:/resource/hu.bme.mit.viatra.ttc.dse/src/hu/bme/mit/viatra/ttc/dse/queries/queries.vql
 */
package hu.bme.mit.viatra.ttc.dse.queries;

import hu.bme.mit.viatra.ttc.dse.queries.AddFeatureMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.AllFeatureEncapsulatedMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.AttributeMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.CreateClassMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.CreateClassWithFeautreMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.DmaMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.DmmMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.EmptyClassMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.EncapsulatedFeatureMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.EncapsulatedMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.FeatureMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.MaiMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.MaiPartialMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.MergeClassesMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.MethodMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.MmiMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.MmiPartialMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.NoEmptyClassMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.NotEncapsulatedFeatureMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.SortClassMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.util.AddFeatureQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.AllFeatureEncapsulatedQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.AttributeQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.CreateClassQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.CreateClassWithFeautreQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.DmaQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.DmmQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.EmptyClassQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.EncapsulatedFeatureQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.EncapsulatedQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.FeatureQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.MaiPartialQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.MaiQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.MergeClassesQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.MethodQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.MmiPartialQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.MmiQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.NoEmptyClassQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.NotEncapsulatedFeatureQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.SortClassQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all patterns defined in queries.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file queries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.viatra.ttc.dse.queries, the group contains the definition of the following patterns: <ul>
 * <li>feature</li>
 * <li>attribute</li>
 * <li>method</li>
 * <li>encapsulated</li>
 * <li>encapsulatedFeature</li>
 * <li>notEncapsulatedFeature</li>
 * <li>allFeatureEncapsulated</li>
 * <li>emptyClass</li>
 * <li>noEmptyClass</li>
 * <li>createClass</li>
 * <li>createClassWithFeautre</li>
 * <li>addFeature</li>
 * <li>mergeClasses</li>
 * <li>dma</li>
 * <li>dmm</li>
 * <li>mmiPartial</li>
 * <li>maiPartial</li>
 * <li>sortClass</li>
 * <li>mmi</li>
 * <li>mai</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Queries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Queries instance() throws ViatraQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Queries();
    }
    return INSTANCE;
  }
  
  private static Queries INSTANCE;
  
  private Queries() throws ViatraQueryException {
    querySpecifications.add(FeatureQuerySpecification.instance());
    querySpecifications.add(AttributeQuerySpecification.instance());
    querySpecifications.add(MethodQuerySpecification.instance());
    querySpecifications.add(EncapsulatedQuerySpecification.instance());
    querySpecifications.add(EncapsulatedFeatureQuerySpecification.instance());
    querySpecifications.add(NotEncapsulatedFeatureQuerySpecification.instance());
    querySpecifications.add(AllFeatureEncapsulatedQuerySpecification.instance());
    querySpecifications.add(EmptyClassQuerySpecification.instance());
    querySpecifications.add(NoEmptyClassQuerySpecification.instance());
    querySpecifications.add(CreateClassQuerySpecification.instance());
    querySpecifications.add(CreateClassWithFeautreQuerySpecification.instance());
    querySpecifications.add(AddFeatureQuerySpecification.instance());
    querySpecifications.add(MergeClassesQuerySpecification.instance());
    querySpecifications.add(DmaQuerySpecification.instance());
    querySpecifications.add(DmmQuerySpecification.instance());
    querySpecifications.add(MmiPartialQuerySpecification.instance());
    querySpecifications.add(MaiPartialQuerySpecification.instance());
    querySpecifications.add(SortClassQuerySpecification.instance());
    querySpecifications.add(MmiQuerySpecification.instance());
    querySpecifications.add(MaiQuerySpecification.instance());
  }
  
  public FeatureQuerySpecification getFeature() throws ViatraQueryException {
    return FeatureQuerySpecification.instance();
  }
  
  public FeatureMatcher getFeature(final ViatraQueryEngine engine) throws ViatraQueryException {
    return FeatureMatcher.on(engine);
  }
  
  public AttributeQuerySpecification getAttribute() throws ViatraQueryException {
    return AttributeQuerySpecification.instance();
  }
  
  public AttributeMatcher getAttribute(final ViatraQueryEngine engine) throws ViatraQueryException {
    return AttributeMatcher.on(engine);
  }
  
  public MethodQuerySpecification getMethod() throws ViatraQueryException {
    return MethodQuerySpecification.instance();
  }
  
  public MethodMatcher getMethod(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MethodMatcher.on(engine);
  }
  
  public EncapsulatedQuerySpecification getEncapsulated() throws ViatraQueryException {
    return EncapsulatedQuerySpecification.instance();
  }
  
  public EncapsulatedMatcher getEncapsulated(final ViatraQueryEngine engine) throws ViatraQueryException {
    return EncapsulatedMatcher.on(engine);
  }
  
  public EncapsulatedFeatureQuerySpecification getEncapsulatedFeature() throws ViatraQueryException {
    return EncapsulatedFeatureQuerySpecification.instance();
  }
  
  public EncapsulatedFeatureMatcher getEncapsulatedFeature(final ViatraQueryEngine engine) throws ViatraQueryException {
    return EncapsulatedFeatureMatcher.on(engine);
  }
  
  public NotEncapsulatedFeatureQuerySpecification getNotEncapsulatedFeature() throws ViatraQueryException {
    return NotEncapsulatedFeatureQuerySpecification.instance();
  }
  
  public NotEncapsulatedFeatureMatcher getNotEncapsulatedFeature(final ViatraQueryEngine engine) throws ViatraQueryException {
    return NotEncapsulatedFeatureMatcher.on(engine);
  }
  
  public AllFeatureEncapsulatedQuerySpecification getAllFeatureEncapsulated() throws ViatraQueryException {
    return AllFeatureEncapsulatedQuerySpecification.instance();
  }
  
  public AllFeatureEncapsulatedMatcher getAllFeatureEncapsulated(final ViatraQueryEngine engine) throws ViatraQueryException {
    return AllFeatureEncapsulatedMatcher.on(engine);
  }
  
  public EmptyClassQuerySpecification getEmptyClass() throws ViatraQueryException {
    return EmptyClassQuerySpecification.instance();
  }
  
  public EmptyClassMatcher getEmptyClass(final ViatraQueryEngine engine) throws ViatraQueryException {
    return EmptyClassMatcher.on(engine);
  }
  
  public NoEmptyClassQuerySpecification getNoEmptyClass() throws ViatraQueryException {
    return NoEmptyClassQuerySpecification.instance();
  }
  
  public NoEmptyClassMatcher getNoEmptyClass(final ViatraQueryEngine engine) throws ViatraQueryException {
    return NoEmptyClassMatcher.on(engine);
  }
  
  public CreateClassQuerySpecification getCreateClass() throws ViatraQueryException {
    return CreateClassQuerySpecification.instance();
  }
  
  public CreateClassMatcher getCreateClass(final ViatraQueryEngine engine) throws ViatraQueryException {
    return CreateClassMatcher.on(engine);
  }
  
  public CreateClassWithFeautreQuerySpecification getCreateClassWithFeautre() throws ViatraQueryException {
    return CreateClassWithFeautreQuerySpecification.instance();
  }
  
  public CreateClassWithFeautreMatcher getCreateClassWithFeautre(final ViatraQueryEngine engine) throws ViatraQueryException {
    return CreateClassWithFeautreMatcher.on(engine);
  }
  
  public AddFeatureQuerySpecification getAddFeature() throws ViatraQueryException {
    return AddFeatureQuerySpecification.instance();
  }
  
  public AddFeatureMatcher getAddFeature(final ViatraQueryEngine engine) throws ViatraQueryException {
    return AddFeatureMatcher.on(engine);
  }
  
  public MergeClassesQuerySpecification getMergeClasses() throws ViatraQueryException {
    return MergeClassesQuerySpecification.instance();
  }
  
  public MergeClassesMatcher getMergeClasses(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MergeClassesMatcher.on(engine);
  }
  
  public DmaQuerySpecification getDma() throws ViatraQueryException {
    return DmaQuerySpecification.instance();
  }
  
  public DmaMatcher getDma(final ViatraQueryEngine engine) throws ViatraQueryException {
    return DmaMatcher.on(engine);
  }
  
  public DmmQuerySpecification getDmm() throws ViatraQueryException {
    return DmmQuerySpecification.instance();
  }
  
  public DmmMatcher getDmm(final ViatraQueryEngine engine) throws ViatraQueryException {
    return DmmMatcher.on(engine);
  }
  
  public MmiPartialQuerySpecification getMmiPartial() throws ViatraQueryException {
    return MmiPartialQuerySpecification.instance();
  }
  
  public MmiPartialMatcher getMmiPartial(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MmiPartialMatcher.on(engine);
  }
  
  public MaiPartialQuerySpecification getMaiPartial() throws ViatraQueryException {
    return MaiPartialQuerySpecification.instance();
  }
  
  public MaiPartialMatcher getMaiPartial(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MaiPartialMatcher.on(engine);
  }
  
  public SortClassQuerySpecification getSortClass() throws ViatraQueryException {
    return SortClassQuerySpecification.instance();
  }
  
  public SortClassMatcher getSortClass(final ViatraQueryEngine engine) throws ViatraQueryException {
    return SortClassMatcher.on(engine);
  }
  
  public MmiQuerySpecification getMmi() throws ViatraQueryException {
    return MmiQuerySpecification.instance();
  }
  
  public MmiMatcher getMmi(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MmiMatcher.on(engine);
  }
  
  public MaiQuerySpecification getMai() throws ViatraQueryException {
    return MaiQuerySpecification.instance();
  }
  
  public MaiMatcher getMai(final ViatraQueryEngine engine) throws ViatraQueryException {
    return MaiMatcher.on(engine);
  }
}
