package hu.bme.mit.viatra.ttc.dse.rules;

import org.eclipse.viatra.dse.api.DSEException;
import org.eclipse.viatra.dse.api.DSETransformationRule;
import org.eclipse.viatra.dse.base.DseIdPoolHelper;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import architectureCRA.ArchitectureCRAFactory;
import architectureCRA.Class;
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
import hu.bme.mit.viatra.ttc.dse.queries.util.AddFeatureProcessor;
import hu.bme.mit.viatra.ttc.dse.queries.util.AddFeatureQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.CreateClassProcessor;
import hu.bme.mit.viatra.ttc.dse.queries.util.CreateClassQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.CreateClassWithFeautreProcessor;
import hu.bme.mit.viatra.ttc.dse.queries.util.CreateClassWithFeautreQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.MergeClassesProcessor;
import hu.bme.mit.viatra.ttc.dse.queries.util.MergeClassesQuerySpecification;

public class CraDseRules {

    public DSETransformationRule<CreateClassMatch, CreateClassMatcher> createClassRule;
    public DSETransformationRule<CreateClassWithFeautreMatch, CreateClassWithFeautreMatcher> createClassWithFeatureRule;
    public DSETransformationRule<AddFeatureMatch, AddFeatureMatcher> addFeatureRule;
    public DSETransformationRule<MergeClassesMatch, MergeClassesMatcher> mergeClasses;
    
    public CraDseRules() {
        try {
            createClassRule = new DSETransformationRule<>("CreateClassRule",
                    CreateClassQuerySpecification.instance(),
                    new CreateClassProcessor() {
                        
                        @Override
                        public void process(ClassModel pCm) {
                            Class clazz = ArchitectureCRAFactory.eINSTANCE.createClass();
                            pCm.getClasses().add(clazz);
                            
                            int id = DseIdPoolHelper.INSTANCE.getId(createClassRule);
                            
                            clazz.setName("C" + id);
                        }
                    });
            
            addFeatureRule = new DSETransformationRule<>("AddFeatureRule",
                    AddFeatureQuerySpecification.instance(),
                    new AddFeatureProcessor() {
                        
                        @Override
                        public void process(Class pC, Feature pF) {
                            pC.getEncapsulates().add(pF);
                        }
                    });
            
            createClassWithFeatureRule = new DSETransformationRule<>("CreateClassWithFeature",
                    CreateClassWithFeautreQuerySpecification.instance(),
                    new CreateClassWithFeautreProcessor() {
                        @Override
                        public void process(ClassModel pCm, Feature pF) {
                            Class clazz = ArchitectureCRAFactory.eINSTANCE.createClass();
                            pCm.getClasses().add(clazz);
                            
                            int id = DseIdPoolHelper.INSTANCE.getId(createClassWithFeatureRule);
                            
                            clazz.setName("C" + id);
                            
                            clazz.getEncapsulates().add(pF);
                        }
                    });
            
            mergeClasses = new DSETransformationRule<>("MergeClassesRule",
                    MergeClassesQuerySpecification.instance(),
                    new MergeClassesProcessor() {
                        
                        @Override
                        public void process(ClassModel pCm, Class pC1, Class pC2) {
                            pC1.getEncapsulates().addAll(pC2.getEncapsulates());
                            pCm.getClasses().remove(pC2);
                        }
                    });
            
        } catch (ViatraQueryException e) {
            throw new DSEException(e);
        }
    }
    
}
