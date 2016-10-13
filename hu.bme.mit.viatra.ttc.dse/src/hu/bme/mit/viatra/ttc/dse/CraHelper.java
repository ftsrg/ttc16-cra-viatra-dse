package hu.bme.mit.viatra.ttc.dse;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.dse.util.EMFHelper;

import architectureCRA.ArchitectureCRAFactory;
import architectureCRA.ArchitectureCRAPackage;
import architectureCRA.Attribute;
import architectureCRA.ClassModel;
import architectureCRA.Method;

public class CraHelper {

    public static final String INPUT_A = "TTC_InputRDG_A";
    public static final String INPUT_B = "TTC_InputRDG_B";
    public static final String INPUT_C = "TTC_InputRDG_C";
    public static final String INPUT_D = "TTC_InputRDG_D";
    public static final String INPUT_E = "TTC_InputRDG_E";

    public static EObject loadInitialModel(String inputModelName) throws IOException {
        EMFHelper.registerExtensionForXmiSerializer("xmi");
        ArchitectureCRAPackage.eINSTANCE.eClass();
        ResourceSetImpl rSet = new ResourceSetImpl();
        Resource resource = rSet.createResource(URI.createFileURI(inputModelName + ".xmi"));
        resource.load(null);
        return resource.getContents().get(0);
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
