package hu.bme.mit.viatra.ttc.dse.objectives;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.objectives.IObjective;
import org.eclipse.viatra.dse.objectives.impl.BaseObjective;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import architectureCRA.Class;
import architectureCRA.ClassModel;
import hu.bme.mit.viatra.ttc.dse.queries.AttributeMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.MaiMatch;
import hu.bme.mit.viatra.ttc.dse.queries.MaiMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.MethodMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.MmiMatch;
import hu.bme.mit.viatra.ttc.dse.queries.MmiMatcher;

public class CraIndexObjective extends BaseObjective {

    public static final String CRA_INDEX_OBJECTIVE_NAME = "CraIndexObjective";
    public static final String COHESION_OBJECTIVE_NAME = "CohesionObjective";
    public static final String COUPLING_OBJECTIVE_NAME = "CouplingObjective";
    private MmiMatcher mmiMatcher;
    private MaiMatcher maiMatcher;
    private AttributeMatcher attributeMatcher;
    private MethodMatcher methodMatcher;

    private double cohesion;
    private double coupling;
    private ClassModel model;

    public static enum CraFitnessType {
    	CraIndex,
    	Coupling,
    	Cohesion
    }

    protected CraFitnessType type = CraFitnessType.CraIndex;

    public CraIndexObjective() {
    	this(CraFitnessType.CraIndex);
    }

    public CraIndexObjective(CraFitnessType type) {
    	super(getObjectiveName(type));
    	this.type = type;
		switch (type) {
		case CraIndex:
		case Cohesion:
			setComparator(Comparators.HIGHER_IS_BETTER);
			break;
		case Coupling:
			setComparator(Comparators.LOWER_IS_BETTER);
			break;
		default:
			break;
		}
    }

	private static String getObjectiveName(CraFitnessType type) {
		switch (type) {
		case CraIndex:
			return CRA_INDEX_OBJECTIVE_NAME;
		case Cohesion:
			return COHESION_OBJECTIVE_NAME;
		case Coupling:
			return COUPLING_OBJECTIVE_NAME;
		default:
			return null;
		}
	}

    @Override
    public void init(ThreadContext context) {
        super.init(context);
        
        initWithModel(context.getQueryEngine(), context.getModel());
    }

    public void initWithModel(ViatraQueryEngine queryEngine, Notifier notifier) {
        try {
            mmiMatcher = MmiMatcher.on(queryEngine);
            maiMatcher = MaiMatcher.on(queryEngine);
            attributeMatcher = AttributeMatcher.on(queryEngine);
            methodMatcher = MethodMatcher.on(queryEngine);
        } catch (ViatraQueryException e) {
        }
        if (notifier instanceof ClassModel) {
            this.model = (ClassModel) notifier;
        } else if (notifier instanceof Resource) {
            this.model = (ClassModel) ((Resource)notifier).getContents().get(0);
        } else if (notifier instanceof ResourceSet) {
            this.model = (ClassModel) ((ResourceSet)notifier).getResources().get(0).getContents().get(0);
        }
    }

    @Override
    public Double getFitness(ThreadContext context) {

        cohesion = 0.0d;
        coupling = 0.0d;

        for (Class c1 : model.getClasses()) {
            
            if (c1.getEncapsulates().isEmpty()) {
                continue;
            }
            
            MaiMatch maiMatch = maiMatcher.getOneArbitraryMatch(c1, c1, null);
            Integer mai = maiMatch.getN();
            MmiMatch mmiMatch = mmiMatcher.getOneArbitraryMatch(c1, c1, null);
            Integer mmi = mmiMatch.getN();
            int attributes = attributeMatcher.countMatches(c1, null);
            int methods = methodMatcher.countMatches(c1, null);

            int maiDiv = methods * attributes;
            int mmiDiv = methods * (methods - 1);

            cohesion += (maiDiv == 0 ? 0 : (double) mai / maiDiv) + (mmiDiv == 0 ? 0 : (double) mmi / mmiDiv);
            
            for (Class c2 : model.getClasses()) {
                if (c1 != c2 && !c1.getEncapsulates().isEmpty()) {
                    maiMatch = maiMatcher.getOneArbitraryMatch(c1, c2, null);
                    mai = maiMatch.getN();
                    mmiMatch = mmiMatcher.getOneArbitraryMatch(c1, c2, null);
                    mmi = mmiMatch.getN();
                    methods = methodMatcher.countMatches(c1, null);
                    attributes = attributeMatcher.countMatches(c2, null);
                    int methods2 = methodMatcher.countMatches(c2, null);

                    maiDiv = methods * attributes;
                    mmiDiv = methods * (methods2 - 1);

                    coupling += (maiDiv == 0 ? 0 : (double) mai / maiDiv) + (mmiDiv == 0 ? 0 : (double) mmi / mmiDiv);
                }
            }
        }

        switch (type) {
		case CraIndex:
			return cohesion - coupling;
		case Cohesion:
			return cohesion;
		case Coupling:
			return coupling;
		default:
			return 0d;
		}
    }

    @Override
    public IObjective createNew() {
        CraIndexObjective objective = new CraIndexObjective(type);
        if (isThereFitnessConstraint) {
            objective.withHardConstraintOnFitness(fitnessConstraint, fitnessConstraintComparator);
        }
        return objective;
    }

}
