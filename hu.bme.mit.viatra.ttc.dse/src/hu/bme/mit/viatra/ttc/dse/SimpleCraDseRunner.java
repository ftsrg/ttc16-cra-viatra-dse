package hu.bme.mit.viatra.ttc.dse;

import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.api.Strategies;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer.DseLoggingLevel;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.objectives.impl.ConstraintsObjective;
import org.eclipse.viatra.dse.solutionstore.SolutionStore;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import architectureCRA.ArchitectureCRAPackage;
import architectureCRA.ClassModel;
import hu.bme.mit.viatra.ttc.dse.objectives.CraIndexObjective;
import hu.bme.mit.viatra.ttc.dse.queries.util.AllFeatureEncapsulatedQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.NoEmptyClassQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.queries.util.NotEncapsulatedFeatureQuerySpecification;
import hu.bme.mit.viatra.ttc.dse.rules.CraDseRules;
import hu.bme.mit.viatra.ttc.dse.statecoder.CraStateCoderFactory;

public class SimpleCraDseRunner {

    public static void main(String[] args) throws ViatraQueryException {

        ClassModel model = CraHelper.createSimpleCraProblem();

        DesignSpaceExplorer.turnOnLoggingWithBasicConfig(DseLoggingLevel.WARN);

        DesignSpaceExplorer dse = new DesignSpaceExplorer();

        dse.setInitialModel(model);
        dse.addMetaModelPackage(ArchitectureCRAPackage.eINSTANCE);
        dse.setStateCoderFactory(new CraStateCoderFactory());

        CraDseRules rules = new CraDseRules();
        dse.addTransformationRule(rules.createClassRule);
        dse.addTransformationRule(rules.addFeatureRule);

        dse.addObjective(
                new ConstraintsObjective()
                        .withHardConstraint(AllFeatureEncapsulatedQuerySpecification.instance())
                        .withHardConstraint(NoEmptyClassQuerySpecification.instance())
                        .withSoftConstraint(NotEncapsulatedFeatureQuerySpecification.instance(), 1)
                        .withComparator(Comparators.LOWER_IS_BETTER));
        dse.addObjective(new CraIndexObjective());

        dse.setSolutionStore(new SolutionStore().storeBestSolutionsOnly());

        dse.startExploration(Strategies.createDfsStrategy(0));

        System.out.println(dse.toStringSolutions());

    }
}
