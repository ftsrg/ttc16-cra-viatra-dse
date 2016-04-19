package hu.bme.mit.viatra.ttc.dse;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.api.SolutionTrajectory;
import org.eclipse.viatra.dse.evolutionary.EvolutionaryStrategyBuilder;
import org.eclipse.viatra.dse.evolutionary.EvolutionaryStrategyConsoleLogAdapter;
import org.eclipse.viatra.dse.evolutionary.stopconditions.CompositeStopCondition;
import org.eclipse.viatra.dse.evolutionary.stopconditions.ConstantParetoFrontStopCondition;
import org.eclipse.viatra.dse.evolutionary.stopconditions.ParetoFrontIncludesGoodSolutionStopCondition;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.objectives.impl.ConstraintsObjective;
import org.eclipse.viatra.dse.solutionstore.SolutionStore;
import org.eclipse.viatra.dse.util.EMFHelper;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.junit.Test;

import architectureCRA.ArchitectureCRAPackage;
import hu.bme.mit.viatra.ttc.dse.objectives.CraIndexObjective;
import hu.bme.mit.viatra.ttc.dse.queries.util.AllFeatureEncapsulated2QuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.NoEmptyClassQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.NotEncapsulatedFeatureQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.rules.CraDseRules;
import hu.bme.mit.viatra.ttc.dse.statecoder.CraStateCoderFactory;

public class CraDseRunner {

    private static final String INPUT_A = "TTC_InputRDG_A";
    private static final String INPUT_B = "TTC_InputRDG_B";
    private static final String INPUT_C = "TTC_InputRDG_C";
    private static final String INPUT_D = "TTC_InputRDG_D";
    private static final String INPUT_E = "TTC_InputRDG_E";
    
    private static final String INPUT_MODEL = INPUT_B;

    @Test
    public void test() throws IOException, ViatraQueryException {
        
        DesignSpaceExplorer dse = new DesignSpaceExplorer();
        
        ResourceSetImpl rSet = new ResourceSetImpl();
        Resource resource = rSet.createResource(URI.createFileURI(INPUT_MODEL + ".xmi"));
        resource.load(null);
        
        EObject model = resource.getContents().get(0);
        dse.setInitialModel(model);
        dse.addMetaModelPackage(ArchitectureCRAPackage.eINSTANCE);
        dse.setStateCoderFactory(new CraStateCoderFactory());
        
        CraDseRules rules = new CraDseRules();
        dse.addTransformationRule(rules.createClassRule);
//        dse.addTransformationRule(rules.createClassWithFeatureRule);
        dse.addTransformationRule(rules.addFeatureRule);
        
        dse.addObjective(new ConstraintsObjective()
                .withHardConstraint("allFeatureEncapsulated", AllFeatureEncapsulated2QuerySpecification.instance())
                .withHardConstraint("noEmtpyClass", NoEmptyClassQuerySpecification.instance())
                .withSoftConstraint("unusedFeature", NotEncapsulatedFeatureQuerySpecification.instance(), 1)
                .withComparator(Comparators.LOWER_IS_BETTER)
                .withLevel(0)
                );
        dse.addObjective(new CraIndexObjective().withLevel(0));
//        dse.addObjective(new ConstraintsObjective("emptyClassObjective")
//                .withSoftConstraint("emtpyClass", EmptyClassQuerySpecification.instance(), 1)
//                .withComparator(Comparators.LOWER_IS_BETTER)
//                .withLevel(1)
//                );
//        dse.addObjective(new ConstraintsObjective("classObjective")
//                .withSoftConstraint("class", ClazzQuerySpecification.instance(), 1)
//                .withComparator(Comparators.HIGHER_IS_BETTER)
//                .withLevel(1)
//                );
        
        SolutionStore solutionStore = new SolutionStore(1);
        solutionStore.logSolutionsWhenFound();
        dse.setSolutionStore(solutionStore);
        
        EvolutionaryStrategyBuilder nsga2 = EvolutionaryStrategyBuilder.createNsga2BuilderFull(25);
        nsga2.addStrategyAdapter(new EvolutionaryStrategyConsoleLogAdapter());
//        nsga2.addStrategyAdapter(new EvolutionaryStrategyLogAdapter());
        nsga2.setStopCondition(new CompositeStopCondition()
                .withStopCondition(new ConstantParetoFrontStopCondition(50))
                .withStopCondition(new ParetoFrontIncludesGoodSolutionStopCondition())
                );
        dse.startExploration(nsga2.build());
        
        System.out.println(dse.toStringSolutions());
        
        SolutionTrajectory solution = dse.getArbitrarySolution();
        solution.doTransformation(model);
        
        EMFHelper.serializeModel(model, "result_" + INPUT_MODEL, "xmi");
        
    }

}
