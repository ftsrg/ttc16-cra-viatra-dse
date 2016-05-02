package hu.bme.mit.viatra.ttc.dse;

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.api.SolutionTrajectory;
import org.eclipse.viatra.dse.base.DseIdPoolHelper;
import org.eclipse.viatra.dse.evolutionary.EvolutionaryStrategyBuilder;
import org.eclipse.viatra.dse.evolutionary.crossovers.CutAndSpliceCrossover;
import org.eclipse.viatra.dse.evolutionary.crossovers.SwapTransitionCrossover;
import org.eclipse.viatra.dse.evolutionary.initialselectors.BfsInitialSelector;
import org.eclipse.viatra.dse.evolutionary.mutationrate.SimpleMutationRate;
import org.eclipse.viatra.dse.evolutionary.mutations.AddRandomTransitionMutation;
import org.eclipse.viatra.dse.evolutionary.mutations.ModifyRandomTransitionMutation;
import org.eclipse.viatra.dse.evolutionary.stopconditions.CompositeStopCondition;
import org.eclipse.viatra.dse.evolutionary.stopconditions.OneSurvivalStopCondition;
import org.eclipse.viatra.dse.evolutionary.stopconditions.ParetoFrontIncludesGoalSolutionStopCondition;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.objectives.impl.ConstraintsObjective;
import org.eclipse.viatra.dse.solutionstore.SolutionStore;
import org.eclipse.viatra.dse.util.EMFHelper;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.junit.Test;

import architectureCRA.ArchitectureCRAPackage;
import hu.bme.mit.viatra.ttc.dse.objectives.CraIndexObjective;
import hu.bme.mit.viatra.ttc.dse.operators.RemoveUnusedClassMutation;
import hu.bme.mit.viatra.ttc.dse.queries.util.AllFeatureEncapsulatedQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.NoEmptyClassQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.NotEncapsulatedFeatureQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.rules.CraDseRules;
import hu.bme.mit.viatra.ttc.dse.statecoder.CraStateCoderFactory;

public class CraDseRunner {

    @Test
    public void test() throws IOException, ViatraQueryException {
        Logger.getRootLogger().setLevel(Level.WARN);
        String inputModelName = CraModelNameConstants.INPUT_B;
        EObject initialModel = loadInitialModel(inputModelName);
        runDseWithInputModel(initialModel);
        EMFHelper.serializeModel(initialModel, "result_" + inputModelName, "xmi");
    }

    public static EObject loadInitialModel(String inputModelName) throws IOException {
		EMFHelper.registerExtensionForXmiSerializer("xmi");
		ArchitectureCRAPackage.eINSTANCE.eClass();
        ResourceSetImpl rSet = new ResourceSetImpl();
        Resource resource = rSet.createResource(URI.createFileURI(inputModelName + ".xmi"));
        resource.load(null);
        return resource.getContents().get(0);
    }
    
    public static void runDseWithInputModel(EObject model) throws IOException, ViatraQueryException {
        
        DesignSpaceExplorer dse = new DesignSpaceExplorer();
        
        dse.setInitialModel(model);
        dse.addMetaModelPackage(ArchitectureCRAPackage.eINSTANCE);
        dse.setStateCoderFactory(new CraStateCoderFactory());
        
        CraDseRules rules = new CraDseRules();
        dse.addTransformationRule(rules.createClassRule);
//        dse.addTransformationRule(rules.createClassWithFeatureRule);
        dse.addTransformationRule(rules.addFeatureRule);
        
        dse.addObjective(new ConstraintsObjective()
                .withHardConstraint("allFeatureEncapsulated", AllFeatureEncapsulatedQuerySpecification.instance())
                .withHardConstraint("noEmtpyClass", NoEmptyClassQuerySpecification.instance())
                .withSoftConstraint("unusedFeature", NotEncapsulatedFeatureQuerySpecification.instance(), 1)
                .withComparator(Comparators.LOWER_IS_BETTER)
                .withLevel(0)
                );
        dse.addObjective(new CraIndexObjective().withLevel(0));
        
        SolutionStore solutionStore = new SolutionStore(1);
        solutionStore.logSolutionsWhenFound();
//        solutionStore.acceptAnySolutions();
        dse.setSolutionStore(solutionStore);
        
        
        EvolutionaryStrategyBuilder nsga2 = EvolutionaryStrategyBuilder.createNsga2Builder(40);
        nsga2.setInitialPopulationSelector(new BfsInitialSelector(0.18f, 2));
        nsga2.setMutationRate(new SimpleMutationRate(0.8));
        nsga2.addMutation(new AddRandomTransitionMutation(), 6);
        nsga2.addMutation(new ModifyRandomTransitionMutation(), 2);
        nsga2.addCrossover(new CutAndSpliceCrossover());
        nsga2.addCrossover(new SwapTransitionCrossover());
        nsga2.addMutation(new RemoveUnusedClassMutation());
        
//        nsga2.addStrategyAdapter(new EvolutionaryStrategyConsoleLogAdapter());
//        nsga2.addStrategyAdapter(new EvolutionaryStrategyLogAdapter());
        nsga2.setStopCondition(
                new CompositeStopCondition()
//                .withStopCondition(new IterationStopCondition(1000))
                .withStopCondition(new OneSurvivalStopCondition(100))
//                .withStopCondition(new ConstantParetoFrontStopCondition(100))
                .withStopCondition(new ParetoFrontIncludesGoalSolutionStopCondition())
                );

//        dse.startExplorationWithTimeout(nsga2.build(), 20000);
        dse.startExploration(nsga2.build());
        
        System.out.println(dse.toStringSolutions());
        DseIdPoolHelper.INSTANCE.resetFallBackId();
        SolutionTrajectory solution = dse.getArbitrarySolution();
        solution.doTransformation(model);
        
    }

}
