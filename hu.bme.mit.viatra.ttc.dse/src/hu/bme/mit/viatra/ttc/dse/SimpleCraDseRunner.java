package hu.bme.mit.viatra.ttc.dse;

import java.io.IOException;

import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.api.Strategies;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.objectives.impl.ConstraintsObjective;
import org.eclipse.viatra.dse.solutionstore.SolutionStore;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.junit.Test;

import architectureCRA.ArchitectureCRAFactory;
import architectureCRA.ArchitectureCRAPackage;
import architectureCRA.Attribute;
import architectureCRA.ClassModel;
import architectureCRA.Method;
import hu.bme.mit.viatra.ttc.dse.objectives.CraIndexObjective;
import hu.bme.mit.viatra.ttc.dse.queries.util.AllFeatureEncapsulatedQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.NoEmptyClassQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.NotEncapsulatedFeatureQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.rules.CraDseRules;
import hu.bme.mit.viatra.ttc.dse.statecoder.CraStateCoderFactory;

public class SimpleCraDseRunner {

    @Test
    public void runDseWithInputModel() throws IOException, ViatraQueryException {
        
        ClassModel model = createSimpleCraProblem();
        
        DesignSpaceExplorer dse = new DesignSpaceExplorer();
        
        dse.setInitialModel(model);
        dse.addMetaModelPackage(ArchitectureCRAPackage.eINSTANCE);
        dse.setStateCoderFactory(new CraStateCoderFactory());
        
        CraDseRules rules = new CraDseRules();
        dse.addTransformationRule(rules.createClassRule);
        dse.addTransformationRule(rules.addFeatureRule);
        
        dse.addObjective(new ConstraintsObjective()
                .withHardConstraint("allFeatureEncapsulated", AllFeatureEncapsulatedQuerySpecification.instance())
                .withHardConstraint("noEmtpyClass", NoEmptyClassQuerySpecification.instance())
                .withSoftConstraint("unusedFeature", NotEncapsulatedFeatureQuerySpecification.instance(), 1)
                .withComparator(Comparators.LOWER_IS_BETTER)
                );
        dse.addObjective(new CraIndexObjective());
        
        dse.setSolutionStore(new SolutionStore().storeBestSolutionsOnly());
        
        dse.startExploration(Strategies.createDfsStrategy(0));
        
        System.out.println(dse.toStringSolutions());
        
    }

    public static ClassModel createSimpleCraProblem() {
        ArchitectureCRAFactory factory = ArchitectureCRAFactory.eINSTANCE;
        ClassModel model = factory.createClassModel();
        Method m1 = factory.createMethod();
        Method m2 = factory.createMethod();
        Method m3 = factory.createMethod();
        Attribute a1 = factory.createAttribute();
        m1.setName("M1");
        m2.setName("M2");
        m3.setName("M3");
        a1.setName("A1");
        model.getFeatures().add(m1);
        model.getFeatures().add(m2);
        model.getFeatures().add(m3);
        model.getFeatures().add(a1);
        m1.getFunctionalDependency().add(m2);
        m2.getFunctionalDependency().add(m3);
        m2.getDataDependency().add(a1);
        return model;
    }

}
