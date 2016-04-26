/**
 */
package architectureCRA;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link architectureCRA.Method#getDataDependency <em>Data Dependency</em>}</li>
 *   <li>{@link architectureCRA.Method#getFunctionalDependency <em>Functional Dependency</em>}</li>
 * </ul>
 *
 * @see architectureCRA.ArchitectureCRAPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends Feature {
	/**
	 * Returns the value of the '<em><b>Data Dependency</b></em>' reference list.
	 * The list contents are of type {@link architectureCRA.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Dependency</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Dependency</em>' reference list.
	 * @see architectureCRA.ArchitectureCRAPackage#getMethod_DataDependency()
	 * @model
	 * @generated
	 */
	EList<Attribute> getDataDependency();

	/**
	 * Returns the value of the '<em><b>Functional Dependency</b></em>' reference list.
	 * The list contents are of type {@link architectureCRA.Method}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functional Dependency</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functional Dependency</em>' reference list.
	 * @see architectureCRA.ArchitectureCRAPackage#getMethod_FunctionalDependency()
	 * @model
	 * @generated
	 */
	EList<Method> getFunctionalDependency();

} // Method
