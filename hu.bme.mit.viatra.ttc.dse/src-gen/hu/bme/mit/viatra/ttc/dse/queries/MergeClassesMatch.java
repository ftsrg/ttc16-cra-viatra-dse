package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.ClassModel;
import hu.bme.mit.viatra.ttc.dse.queries.util.MergeClassesQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.viatra.ttc.dse.queries.mergeClasses pattern,
 * to be used in conjunction with {@link MergeClassesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see MergeClassesMatcher
 * @see MergeClassesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class MergeClassesMatch extends BasePatternMatch {
  private ClassModel fCm;
  
  private architectureCRA.Class fC1;
  
  private architectureCRA.Class fC2;
  
  private static List<String> parameterNames = makeImmutableList("cm", "c1", "c2");
  
  private MergeClassesMatch(final ClassModel pCm, final architectureCRA.Class pC1, final architectureCRA.Class pC2) {
    this.fCm = pCm;
    this.fC1 = pC1;
    this.fC2 = pC2;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cm".equals(parameterName)) return this.fCm;
    if ("c1".equals(parameterName)) return this.fC1;
    if ("c2".equals(parameterName)) return this.fC2;
    return null;
  }
  
  public ClassModel getCm() {
    return this.fCm;
  }
  
  public architectureCRA.Class getC1() {
    return this.fC1;
  }
  
  public architectureCRA.Class getC2() {
    return this.fC2;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cm".equals(parameterName) ) {
    	this.fCm = (ClassModel) newValue;
    	return true;
    }
    if ("c1".equals(parameterName) ) {
    	this.fC1 = (architectureCRA.Class) newValue;
    	return true;
    }
    if ("c2".equals(parameterName) ) {
    	this.fC2 = (architectureCRA.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setCm(final ClassModel pCm) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCm = pCm;
  }
  
  public void setC1(final architectureCRA.Class pC1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fC1 = pC1;
  }
  
  public void setC2(final architectureCRA.Class pC2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fC2 = pC2;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.viatra.ttc.dse.queries.mergeClasses";
  }
  
  @Override
  public List<String> parameterNames() {
    return MergeClassesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCm, fC1, fC2};
  }
  
  @Override
  public MergeClassesMatch toImmutable() {
    return isMutable() ? newMatch(fCm, fC1, fC2) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cm\"=" + prettyPrintValue(fCm) + ", ");
    
    result.append("\"c1\"=" + prettyPrintValue(fC1) + ", ");
    
    result.append("\"c2\"=" + prettyPrintValue(fC2)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCm == null) ? 0 : fCm.hashCode());
    result = prime * result + ((fC1 == null) ? 0 : fC1.hashCode());
    result = prime * result + ((fC2 == null) ? 0 : fC2.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof MergeClassesMatch)) { // this should be infrequent
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
    MergeClassesMatch other = (MergeClassesMatch) obj;
    if (fCm == null) {if (other.fCm != null) return false;}
    else if (!fCm.equals(other.fCm)) return false;
    if (fC1 == null) {if (other.fC1 != null) return false;}
    else if (!fC1.equals(other.fC1)) return false;
    if (fC2 == null) {if (other.fC2 != null) return false;}
    else if (!fC2.equals(other.fC2)) return false;
    return true;
  }
  
  @Override
  public MergeClassesQuerySpecification specification() {
    try {
    	return MergeClassesQuerySpecification.instance();
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
  public static MergeClassesMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static MergeClassesMatch newMutableMatch(final ClassModel pCm, final architectureCRA.Class pC1, final architectureCRA.Class pC2) {
    return new Mutable(pCm, pC1, pC2);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static MergeClassesMatch newMatch(final ClassModel pCm, final architectureCRA.Class pC1, final architectureCRA.Class pC2) {
    return new Immutable(pCm, pC1, pC2);
  }
  
  private static final class Mutable extends MergeClassesMatch {
    Mutable(final ClassModel pCm, final architectureCRA.Class pC1, final architectureCRA.Class pC2) {
      super(pCm, pC1, pC2);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends MergeClassesMatch {
    Immutable(final ClassModel pCm, final architectureCRA.Class pC1, final architectureCRA.Class pC2) {
      super(pCm, pC1, pC2);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
