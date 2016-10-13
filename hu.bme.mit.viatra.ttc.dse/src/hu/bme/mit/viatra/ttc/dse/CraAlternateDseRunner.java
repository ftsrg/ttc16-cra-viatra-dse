package hu.bme.mit.viatra.ttc.dse;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer.DseLoggingLevel;
import org.eclipse.viatra.dse.api.SolutionTrajectory;
import org.eclipse.viatra.dse.evolutionary.EvolutionaryStrategyBuilder;
import org.eclipse.viatra.dse.solutionstore.SolutionStore;
import org.eclipse.viatra.dse.util.EMFHelper;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements;

import com.google.common.base.Stopwatch;

import architectureCRA.ArchitectureCRAPackage;
import hu.bme.mit.viatra.ttc.dse.objectives.CraIndexObjective;
import hu.bme.mit.viatra.ttc.dse.rules.CraDseRules;
import hu.bme.mit.viatra.ttc.dse.statecoder.CraStateCoderFactory;

public class CraAlternateDseRunner {

    
    public static void main(String[] args) throws IOException, ViatraQueryException {
        DesignSpaceExplorer.turnOnLoggingWithBasicConfig(DseLoggingLevel.WARN);
        runExplorationWithTtcInput(CraHelper.INPUT_C);
    }
    
    public static double runDseWithInputModel(EObject model) throws ViatraQueryException {
        
        CraDseRules rules = new CraDseRules();
        BatchTransformation transformation = BatchTransformation.forScope(new EMFScope(model))
                .addRule(rules.createClassWithFeatureRule)
                .build();
        BatchTransformationStatements statements = transformation.getTransformationStatements();
        
        statements.fireAllCurrent(rules.createClassWithFeatureRule);
        
        
        DesignSpaceExplorer dse = new DesignSpaceExplorer();
        
        dse.setInitialModel(model);
        dse.addMetaModelPackage(ArchitectureCRAPackage.eINSTANCE);
        dse.setStateCoderFactory(new CraStateCoderFactory());
        
        dse.addTransformationRule(rules.mergeClasses);
        
        dse.addObjective(new CraIndexObjective());

        SolutionStore solutionStore = new SolutionStore(5);
        solutionStore.acceptAnySolutions();
        dse.setSolutionStore(solutionStore);
        
        dse.startExploration(EvolutionaryStrategyBuilder.createNsga2Strategy(40));
        
        System.out.println(dse.toStringSolutions());
        SolutionTrajectory solution = dse.getArbitrarySolution();
        solution.doTransformation(model);
        return solution.getFitness().get(CraIndexObjective.CRA_INDEX_OBJECTIVE_NAME);
        
    }

    public static void runExplorationWithTtcInput(String inputModelName) throws IOException, ViatraQueryException {
        System.out.println("---------- " + inputModelName);
        System.out.println("Loading model...");
        EObject initialModel = CraHelper.loadInitialModel(inputModelName);
        System.out.println("Running exploration...");
        
        Stopwatch stopwatch = Stopwatch.createStarted();
        
        CraAlternateDseRunner.runDseWithInputModel(initialModel);
        
        stopwatch.stop();
        long elapsedMiliseconds = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        
        System.out.println("Init and exploration time: " + elapsedMiliseconds);
        
        EMFHelper.serializeModel(initialModel, "result_" + inputModelName, "xmi");
        System.out.println("Result model serialized.");
        System.out.println();
    }
}
