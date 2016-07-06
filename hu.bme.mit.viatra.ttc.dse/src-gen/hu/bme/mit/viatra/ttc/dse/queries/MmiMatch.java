/**
 * Generated from platform:/resource/hu.bme.mit.viatra.ttc.dse/src/hu/bme/mit/viatra/ttc/dse/queries/queries.vql
 */
package hu.bme.mit.viatra.ttc.dse.queries;

import hu.bme.mit.viatra.ttc.dse.queries.util.MmiQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.viatra.ttc.dse.queries.mmi pattern,
 * to be used in conjunction with {@link MmiMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see MmiMatcher
 * @see MmiProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class MmiMatch extends BasePatternMatch {
  private architectureCRA.Class fC1;
  
  private architectureCRA.Class fC2;
  
  private Integer fN;
  
  private static List<String> parameterNames = makeImmutableList("c1", "c2", "N");
  
  private MmiMatch(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Integer pN) {
    this.fC1 = pC1;
    this.fC2 = pC2;
    this.fN = pN;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("c1".equals(parameterName)) return this.fC1;
    if ("c2".equals(parameterName)) return this.fC2;
    if ("N".equals(parameterName)) return this.fN;
    return null;
  }
  
  public architectureCRA.Class getC1() {
    return this.fC1;
  }
  
  public architectureCRA.Class getC2() {
    return this.fC2;
  }
  
  public Integer getN() {
    return this.fN;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("c1".equals(parameterName) ) {
    	this.fC1 = (architectureCRA.Class) newValue;
    	return true;
    }
    if ("c2".equals(parameterName) ) {
    	this.fC2 = (architectureCRA.Class) newValue;
    	return true;
    }
    if ("N".equals(parameterName) ) {
    	this.fN = (Integer) newValue;
    	return true;
    }
    return false;
  }
  
  public void setC1(final architectureCRA.Class pC1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fC1 = pC1;
  }
  
  public void setC2(final architectureCRA.Class pC2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fC2 = pC2;
  }
  
  public void setN(final Integer pN) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fN = pN;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.viatra.ttc.dse.queries.mmi";
  }
  
  @Override
  public List<String> parameterNames() {
    return MmiMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fC1, fC2, fN};
  }
  
  @Override
  public MmiMatch toImmutable() {
    return isMutable() ? newMatch(fC1, fC2, fN) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"c1\"=" + prettyPrintValue(fC1) + ", ");
    
    result.append("\"c2\"=" + prettyPrintValue(fC2) + ", ");
    
    result.append("\"N\"=" + prettyPrintValue(fN)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fC1 == null) ? 0 : fC1.hashCode());
    result = prime * result + ((fC2 == null) ? 0 : fC2.hashCode());
    result = prime * result + ((fN == null) ? 0 : fN.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof MmiMatch)) { // this should be infrequent
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
    MmiMatch other = (MmiMatch) obj;
    if (fC1 == null) {if (other.fC1 != null) return false;}
    else if (!fC1.equals(other.fC1)) return false;
    if (fC2 == null) {if (other.fC2 != null) return false;}
    else if (!fC2.equals(other.fC2)) return false;
    if (fN == null) {if (other.fN != null) return false;}
    else if (!fN.equals(other.fN)) return false;
    return true;
  }
  
  @Override
  public MmiQuerySpecification specification() {
    try {
    	return MmiQuerySpecification.instance();
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
  public static MmiMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @param pN the fixed value of pattern parameter N, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static MmiMatch newMutableMatch(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Integer pN) {
    return new Mutable(pC1, pC2, pN);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @param pN the fixed value of pattern parameter N, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static MmiMatch newMatch(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Integer pN) {
    return new Immutable(pC1, pC2, pN);
  }
  
  private static final class Mutable extends MmiMatch {
    Mutable(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Integer pN) {
      super(pC1, pC2, pN);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends MmiMatch {
    Immutable(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Integer pN) {
      super(pC1, pC2, pN);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
