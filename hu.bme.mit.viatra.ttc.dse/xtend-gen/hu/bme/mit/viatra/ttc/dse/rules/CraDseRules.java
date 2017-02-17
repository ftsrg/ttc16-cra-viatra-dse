package hu.bme.mit.viatra.ttc.dse.rules;

import architectureCRA.ArchitectureCRAFactory;
import architectureCRA.ClassModel;
import architectureCRA.Feature;
import hu.bme.mit.viatra.ttc.dse.queries.AddFeatureMatch;
import hu.bme.mit.viatra.ttc.dse.queries.AddFeatureMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.CreateClassMatch;
import hu.bme.mit.viatra.ttc.dse.queries.CreateClassMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.CreateClassWithFeautreMatch;
import hu.bme.mit.viatra.ttc.dse.queries.CreateClassWithFeautreMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.MergeClassesMatch;
import hu.bme.mit.viatra.ttc.dse.queries.MergeClassesMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.util.AddFeatureQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.CreateClassQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.CreateClassWithFeautreQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.MergeClassesQuerySpecification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.viatra.dse.api.DSEException;
import org.eclipse.viatra.dse.base.DseIdPoolHelper;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class CraDseRules {
  @Extension
  private BatchTransformationRuleFactory factory = new BatchTransformationRuleFactory();
  
  public BatchTransformationRule<?, ?> createClassRule;
  
  public BatchTransformationRule<?, ?> createClassWithFeatureRule;
  
  public BatchTransformationRule<?, ?> addFeatureRule;
  
  public BatchTransformationRule<?, ?> mergeClasses;
  
  public CraDseRules() {
    try {
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateClassMatch, CreateClassMatcher> _createRule = this.factory.<CreateClassMatch, CreateClassMatcher>createRule();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateClassMatch, CreateClassMatcher> _name = _createRule.name("CreateClassRule");
      CreateClassQuerySpecification _instance = CreateClassQuerySpecification.instance();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateClassMatch, CreateClassMatcher> _precondition = _name.precondition(_instance);
      final IMatchProcessor<CreateClassMatch> _function = new IMatchProcessor<CreateClassMatch>() {
        @Override
        public void process(final CreateClassMatch it) {
          architectureCRA.Class clazz = ArchitectureCRAFactory.eINSTANCE.createClass();
          int id = DseIdPoolHelper.INSTANCE.getId(CraDseRules.this.createClassRule);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("C");
          _builder.append(id, "");
          String _string = _builder.toString();
          clazz.setName(_string);
          ClassModel _cm = it.getCm();
          EList<architectureCRA.Class> _classes = _cm.getClasses();
          _classes.add(clazz);
        }
      };
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateClassMatch, CreateClassMatcher> _action = _precondition.action(_function);
      BatchTransformationRule<CreateClassMatch, CreateClassMatcher> _build = _action.build();
      this.createClassRule = _build;
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AddFeatureMatch, AddFeatureMatcher> _createRule_1 = this.factory.<AddFeatureMatch, AddFeatureMatcher>createRule();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AddFeatureMatch, AddFeatureMatcher> _name_1 = _createRule_1.name("AddFeatureRule");
      AddFeatureQuerySpecification _instance_1 = AddFeatureQuerySpecification.instance();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AddFeatureMatch, AddFeatureMatcher> _precondition_1 = _name_1.precondition(_instance_1);
      final IMatchProcessor<AddFeatureMatch> _function_1 = new IMatchProcessor<AddFeatureMatch>() {
        @Override
        public void process(final AddFeatureMatch it) {
          architectureCRA.Class _c = it.getC();
          EList<Feature> _encapsulates = _c.getEncapsulates();
          Feature _f = it.getF();
          _encapsulates.add(_f);
        }
      };
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<AddFeatureMatch, AddFeatureMatcher> _action_1 = _precondition_1.action(_function_1);
      BatchTransformationRule<AddFeatureMatch, AddFeatureMatcher> _build_1 = _action_1.build();
      this.addFeatureRule = _build_1;
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateClassWithFeautreMatch, CreateClassWithFeautreMatcher> _createRule_2 = this.factory.<CreateClassWithFeautreMatch, CreateClassWithFeautreMatcher>createRule();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateClassWithFeautreMatch, CreateClassWithFeautreMatcher> _name_2 = _createRule_2.name("CreateClassWithFeature");
      CreateClassWithFeautreQuerySpecification _instance_2 = CreateClassWithFeautreQuerySpecification.instance();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateClassWithFeautreMatch, CreateClassWithFeautreMatcher> _precondition_2 = _name_2.precondition(_instance_2);
      final IMatchProcessor<CreateClassWithFeautreMatch> _function_2 = new IMatchProcessor<CreateClassWithFeautreMatch>() {
        @Override
        public void process(final CreateClassWithFeautreMatch it) {
          architectureCRA.Class clazz = ArchitectureCRAFactory.eINSTANCE.createClass();
          ClassModel _cm = it.getCm();
          EList<architectureCRA.Class> _classes = _cm.getClasses();
          _classes.add(clazz);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("C");
          Feature _f = it.getF();
          String _name = _f.getName();
          _builder.append(_name, "");
          String _string = _builder.toString();
          clazz.setName(_string);
          EList<Feature> _encapsulates = clazz.getEncapsulates();
          Feature _f_1 = it.getF();
          _encapsulates.add(_f_1);
        }
      };
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<CreateClassWithFeautreMatch, CreateClassWithFeautreMatcher> _action_2 = _precondition_2.action(_function_2);
      BatchTransformationRule<CreateClassWithFeautreMatch, CreateClassWithFeautreMatcher> _build_2 = _action_2.build();
      this.createClassWithFeatureRule = _build_2;
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MergeClassesMatch, MergeClassesMatcher> _createRule_3 = this.factory.<MergeClassesMatch, MergeClassesMatcher>createRule();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MergeClassesMatch, MergeClassesMatcher> _name_3 = _createRule_3.name("MergeClassesRule");
      MergeClassesQuerySpecification _instance_3 = MergeClassesQuerySpecification.instance();
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MergeClassesMatch, MergeClassesMatcher> _precondition_3 = _name_3.precondition(_instance_3);
      final IMatchProcessor<MergeClassesMatch> _function_3 = new IMatchProcessor<MergeClassesMatch>() {
        @Override
        public void process(final MergeClassesMatch it) {
          architectureCRA.Class _c1 = it.getC1();
          EList<Feature> _encapsulates = _c1.getEncapsulates();
          architectureCRA.Class _c2 = it.getC2();
          EList<Feature> _encapsulates_1 = _c2.getEncapsulates();
          _encapsulates.addAll(_encapsulates_1);
          ClassModel _cm = it.getCm();
          EList<architectureCRA.Class> _classes = _cm.getClasses();
          architectureCRA.Class _c2_1 = it.getC2();
          _classes.remove(_c2_1);
        }
      };
      BatchTransformationRuleFactory.BatchTransformationRuleBuilder<MergeClassesMatch, MergeClassesMatcher> _action_3 = _precondition_3.action(_function_3);
      BatchTransformationRule<MergeClassesMatch, MergeClassesMatcher> _build_3 = _action_3.build();
      this.mergeClasses = _build_3;
    } catch (final Throwable _t) {
      if (_t instanceof ViatraQueryException) {
        final ViatraQueryException e = (ViatraQueryException)_t;
        throw new DSEException(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
