/**
 * Generated from platform:/resource/hu.bme.mit.viatra.ttc.dse/src/hu/bme/mit/viatra/ttc/dse/queries/queries.vql
 */
package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.ClassModel;
import architectureCRA.Feature;
import hu.bme.mit.viatra.ttc.dse.queries.util.CreateClassWithFeautreQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.viatra.ttc.dse.queries.createClassWithFeautre pattern,
 * to be used in conjunction with {@link CreateClassWithFeautreMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see CreateClassWithFeautreMatcher
 * @see CreateClassWithFeautreProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class CreateClassWithFeautreMatch extends BasePatternMatch {
  private ClassModel fCm;
  
  private Feature fF;
  
  private static List<String> parameterNames = makeImmutableList("cm", "f");
  
  private CreateClassWithFeautreMatch(final ClassModel pCm, final Feature pF) {
    this.fCm = pCm;
    this.fF = pF;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cm".equals(parameterName)) return this.fCm;
    if ("f".equals(parameterName)) return this.fF;
    return null;
  }
  
  public ClassModel getCm() {
    return this.fCm;
  }
  
  public Feature getF() {
    return this.fF;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cm".equals(parameterName) ) {
    	this.fCm = (ClassModel) newValue;
    	return true;
    }
    if ("f".equals(parameterName) ) {
    	this.fF = (Feature) newValue;
    	return true;
    }
    return false;
  }
  
  public void setCm(final ClassModel pCm) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCm = pCm;
  }
  
  public void setF(final Feature pF) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fF = pF;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.viatra.ttc.dse.queries.createClassWithFeautre";
  }
  
  @Override
  public List<String> parameterNames() {
    return CreateClassWithFeautreMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCm, fF};
  }
  
  @Override
  public CreateClassWithFeautreMatch toImmutable() {
    return isMutable() ? newMatch(fCm, fF) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cm\"=" + prettyPrintValue(fCm) + ", ");
    
    result.append("\"f\"=" + prettyPrintValue(fF)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCm == null) ? 0 : fCm.hashCode());
    result = prime * result + ((fF == null) ? 0 : fF.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof CreateClassWithFeautreMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    CreateClassWithFeautreMatch other = (CreateClassWithFeautreMatch) obj;
    if (fCm == null) {if (other.fCm != null) return false;}
    else if (!fCm.equals(other.fCm)) return false;
    if (fF == null) {if (other.fF != null) return false;}
    else if (!fF.equals(other.fF)) return false;
    return true;
  }
  
  @Override
  public CreateClassWithFeautreQuerySpecification specification() {
    try {
    	return CreateClassWithFeautreQuerySpecification.instance();
    } catch (ViatraQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static CreateClassWithFeautreMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static CreateClassWithFeautreMatch newMutableMatch(final ClassModel pCm, final Feature pF) {
    return new Mutable(pCm, pF);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static CreateClassWithFeautreMatch newMatch(final ClassModel pCm, final Feature pF) {
    return new Immutable(pCm, pF);
  }
  
  private static final class Mutable extends CreateClassWithFeautreMatch {
    Mutable(final ClassModel pCm, final Feature pF) {
      super(pCm, pF);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends CreateClassWithFeautreMatch {
    Immutable(final ClassModel pCm, final Feature pF) {
      super(pCm, pF);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
