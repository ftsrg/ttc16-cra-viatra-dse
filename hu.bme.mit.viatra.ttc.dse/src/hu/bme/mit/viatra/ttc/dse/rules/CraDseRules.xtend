package hu.bme.mit.viatra.ttc.dse.rules

import architectureCRA.ArchitectureCRAFactory
import architectureCRA.Class
import hu.bme.mit.viatra.ttc.dse.queries.util.AddFeatureQuerySpecification
import hu.bme.mit.viatra.ttc.dse.queries.util.CreateClassQuerySpecification
import hu.bme.mit.viatra.ttc.dse.queries.util.CreateClassWithFeautreQuerySpecification
import hu.bme.mit.viatra.ttc.dse.queries.util.MergeClassesQuerySpecification
import org.eclipse.viatra.dse.api.DSEException
import org.eclipse.viatra.dse.base.DseIdPoolHelper
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory

class CraDseRules {
    private extension BatchTransformationRuleFactory factory = new BatchTransformationRuleFactory
    
    public BatchTransformationRule<?, ?> createClassRule
    public BatchTransformationRule<?, ?> createClassWithFeatureRule
    public BatchTransformationRule<?, ?> addFeatureRule
    public BatchTransformationRule<?, ?> mergeClasses

    new() {
        try {
            createClassRule = createRule
                .name("CreateClassRule")
                .precondition(CreateClassQuerySpecification.instance())
                .action[
                    var Class clazz = ArchitectureCRAFactory::eINSTANCE.createClass()
                    cm.getClasses().add(clazz)
                    var int id = DseIdPoolHelper::INSTANCE.getId(createClassRule)
                    clazz.setName('''C«id»'''.toString)
                ]
                .build

            addFeatureRule = createRule
                .name("AddFeatureRule")
                .precondition(AddFeatureQuerySpecification.instance())
                .action[
                    c.getEncapsulates().add(f)
                ]
                .build
                
            createClassWithFeatureRule = createRule
                .name("CreateClassWithFeature")
                .precondition(CreateClassWithFeautreQuerySpecification.instance())
                .action[
                    var Class clazz = ArchitectureCRAFactory::eINSTANCE.createClass()
                    cm.getClasses().add(clazz)
                    var int id = DseIdPoolHelper::INSTANCE.getId(createClassWithFeatureRule)
                    clazz.setName('''C«id»'''.toString)
                    clazz.getEncapsulates().add(f)
                ]
                .build

            mergeClasses = createRule
                .name("MergeClassesRule")
                .precondition(MergeClassesQuerySpecification.instance())
                .action[
                    c1.getEncapsulates().addAll(c2.getEncapsulates())
                    cm.getClasses().remove(c2)
                ]
                .build

        } catch (ViatraQueryException e) {
            throw new DSEException(e)
        }

    }
}
