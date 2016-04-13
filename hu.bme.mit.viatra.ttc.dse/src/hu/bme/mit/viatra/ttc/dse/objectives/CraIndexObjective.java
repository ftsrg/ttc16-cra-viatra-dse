package hu.bme.mit.viatra.ttc.dse.objectives;

import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.objectives.IObjective;
import org.eclipse.viatra.dse.objectives.impl.BaseObjective;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import architectureCRA.Class;
import hu.bme.mit.viatra.ttc.dse.queries.AttributeMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.ClassPairMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.ClazzMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.MaiMatch;
import hu.bme.mit.viatra.ttc.dse.queries.MaiMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.MethodMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.MmiMatch;
import hu.bme.mit.viatra.ttc.dse.queries.MmiMatcher;
import hu.bme.mit.viatra.ttc.dse.queries.util.ClassPairProcessor;
import hu.bme.mit.viatra.ttc.dse.queries.util.ClazzProcessor;

public class CraIndexObjective extends BaseObjective {

    private static final String CRA_INDEX_OBJECTIVE_NAME = "CraIndexObjective";
    private MmiMatcher mmiMatcher;
    private MaiMatcher maiMatcher;
    private AttributeMatcher attributeMatcher;
    private MethodMatcher methodMatcher;
    private ClazzMatcher clazzMatcher;
    private ClassPairMatcher classPairMatcher;

    double cohesion;
    double coupling;

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
            clazzMatcher = ClazzMatcher.on(queryEngine);
            classPairMatcher = ClassPairMatcher.on(queryEngine);
        } catch (ViatraQueryException e) {
        }
    }

    @Override
    public Double getFitness(ThreadContext context) {

        cohesion = 0.0d;
        coupling = 0.0d;

        clazzMatcher.forEachMatch(new ClazzProcessor() {
            @Override
            public void process(Class pC) {
                MaiMatch maiMatch = maiMatcher.getOneArbitraryMatch(pC, pC, null);
                Integer mai = maiMatch.getN();
                MmiMatch mmiMatch = mmiMatcher.getOneArbitraryMatch(pC, pC, null);
                Integer mmi = mmiMatch.getN();
                int attributes = attributeMatcher.countMatches(pC, null);
                int methods = methodMatcher.countMatches(pC, null);

                int maiDiv = methods * attributes;
                int mmiDiv = methods * (methods - 1);

                cohesion += (maiDiv == 0 ? 0 : (double) mai / maiDiv) + (mmiDiv == 0 ? 0 : (double) mmi / mmiDiv);
            }
        });

        classPairMatcher.forEachMatch(new ClassPairProcessor() {
            @Override
            public void process(Class pC1, Class pC2) {
                MaiMatch maiMatch = maiMatcher.getOneArbitraryMatch(pC1, pC2, null);
                Integer mai = maiMatch.getN();
                MmiMatch mmiMatch = mmiMatcher.getOneArbitraryMatch(pC1, pC2, null);
                Integer mmi = mmiMatch.getN();
                int methods1 = methodMatcher.countMatches(pC1, null);
                int attributes = attributeMatcher.countMatches(pC2, null);
                int methods2 = methodMatcher.countMatches(pC2, null);

                int maiDiv = methods1 * attributes;
                int mmiDiv = methods1 * (methods2 - 1);

                coupling += (maiDiv == 0 ? 0 : (double) mai / maiDiv) + (mmiDiv == 0 ? 0 : (double) mmi / mmiDiv);

            }
        });

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
