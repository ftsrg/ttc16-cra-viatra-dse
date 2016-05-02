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

    private static final String CRA_INDEX_OBJECTIVE_NAME = "CraIndexObjective";
    private MmiMatcher mmiMatcher;
    private MaiMatcher maiMatcher;
    private AttributeMatcher attributeMatcher;
    private MethodMatcher methodMatcher;

    private double cohesion;
    private double coupling;
    private ClassModel model;

    public CraIndexObjective() {
        super(CRA_INDEX_OBJECTIVE_NAME);
        setComparator(Comparators.HIGHER_IS_BETTER);
    }

    @Override
    public void init(ThreadContext context) {
        ViatraQueryEngine queryEngine = context.getQueryEngine();
        try {
            mmiMatcher = MmiMatcher.on(queryEngine);
            maiMatcher = MaiMatcher.on(queryEngine);
            attributeMatcher = AttributeMatcher.on(queryEngine);
            methodMatcher = MethodMatcher.on(queryEngine);
        } catch (ViatraQueryException e) {
        }
        Notifier notifier = context.getModel();
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
                if (c1 != c2) {
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

        return cohesion - coupling;
    }

    @Override
    public IObjective createNew() {
        return new CraIndexObjective();
    }

    @Override
    public boolean isHardObjective() {
        return false;
    }

    @Override
    public boolean satisifiesHardObjective(Double fitness) {
        return true;
    }

}
