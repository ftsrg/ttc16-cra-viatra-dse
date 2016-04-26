/**
 */
package architectureCRA;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link architectureCRA.Feature#getIsEncapsulatedBy <em>Is Encapsulated By</em>}</li>
 * </ul>
 *
 * @see architectureCRA.ArchitectureCRAPackage#getFeature()
 * @model abstract="true"
 * @generated
 */
public interface Feature extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Is Encapsulated By</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link architectureCRA.Class#getEncapsulates <em>Encapsulates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Encapsulated By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Encapsulated By</em>' reference.
	 * @see #setIsEncapsulatedBy(architectureCRA.Class)
	 * @see architectureCRA.ArchitectureCRAPackage#getFeature_IsEncapsulatedBy()
	 * @see architectureCRA.Class#getEncapsulates
	 * @model opposite="encapsulates"
	 * @generated
	 */
	architectureCRA.Class getIsEncapsulatedBy();

	/**
	 * Sets the value of the '{@link architectureCRA.Feature#getIsEncapsulatedBy <em>Is Encapsulated By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Encapsulated By</em>' reference.
	 * @see #getIsEncapsulatedBy()
	 * @generated
	 */
	void setIsEncapsulatedBy(architectureCRA.Class value);

} // Feature
