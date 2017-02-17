package hu.bme.mit.viatra.ttc.dse.statecoder;

import java.util.Arrays;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.dse.statecode.IStateCoder;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;

import architectureCRA.Class;
import architectureCRA.ClassModel;
import architectureCRA.Feature;
import hu.bme.mit.viatra.ttc.dse.queries.AddFeatureMatch;
import hu.bme.mit.viatra.ttc.dse.queries.CreateClassMatch;
import hu.bme.mit.viatra.ttc.dse.queries.CreateClassWithFeautreMatch;
import hu.bme.mit.viatra.ttc.dse.queries.MergeClassesMatch;

public class CraStateCoder implements IStateCoder {

    private static final String CX = "CX";
    private ClassModel model;

    @Override
    public void init(Notifier notifier) {
        if (notifier instanceof ClassModel) {
            this.model = (ClassModel) notifier;
        } else if (notifier instanceof Resource) {
            this.model = (ClassModel) ((Resource)notifier).getContents().get(0);
        } else if (notifier instanceof ResourceSet) {
            this.model = (ClassModel) ((ResourceSet)notifier).getResources().get(0).getContents().get(0);
        }
    }

    @Override
    public Object createStateCode() {
        
        EList<Class> classes = model.getClasses();
        String[] classCodes = new String[model.getClasses().size()];

        for (int i = 0; i < classes.size(); i++) {
            Class clazz = classes.get(i);
            StringBuilder sb = new StringBuilder();
//            sb.append(clazz.getName());
            EList<Feature> feauters = clazz.getEncapsulates();
            String[] names = new String[feauters.size()];
            int index = 0;
            for (Feature feature : feauters) {
                names[index++] = feature.getName();
            }
            Arrays.sort(names);
            sb.append('(');
            for (String code : names) {
                sb.append(code);
            }
            sb.append("),");
            classCodes[i] = sb.toString();
        }
        
        Arrays.sort(classCodes);
        
        StringBuilder sb = new StringBuilder();
        
        for (String classCode : classCodes) {
            sb.append(classCode);
        }
        
        return sb.toString();
    }

    @Override
    public Object createActivationCode(IPatternMatch match) {
        
        if (match instanceof AddFeatureMatch) {
            AddFeatureMatch addFeatureMatch = (AddFeatureMatch) match;
            return (addFeatureMatch.getC().getName() + addFeatureMatch.getF().getName()).intern();
        } else if (match instanceof CreateClassWithFeautreMatch) {
            CreateClassWithFeautreMatch createClassWithFeautreMatch = (CreateClassWithFeautreMatch) match;
            return (CX + createClassWithFeautreMatch.getF().getName()).intern();
        } else if (match instanceof CreateClassMatch) {
            return CX;
        } else if (match instanceof MergeClassesMatch) {
            MergeClassesMatch mergeClassesMatch = (MergeClassesMatch) match;
            return (mergeClassesMatch.getC1().getName() + mergeClassesMatch.getC2().getName()).intern();
        } else {
            throw new RuntimeException("Unsopprted rule.");
        }
    }

}
