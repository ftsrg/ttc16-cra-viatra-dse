/**
 * Generated from platform:/resource/hu.bme.mit.viatra.ttc.dse/src/hu/bme/mit/viatra/ttc/dse/queries/queries.vql
 */
package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.Method;
import hu.bme.mit.viatra.ttc.dse.queries.util.DmmQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.viatra.ttc.dse.queries.dmm pattern,
 * to be used in conjunction with {@link DmmMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see DmmMatcher
 * @see DmmProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class DmmMatch extends BasePatternMatch {
  private Method fM1;
  
  private Method fM2;
  
  private static List<String> parameterNames = makeImmutableList("m1", "m2");
  
  private DmmMatch(final Method pM1, final Method pM2) {
    this.fM1 = pM1;
    this.fM2 = pM2;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("m1".equals(parameterName)) return this.fM1;
    if ("m2".equals(parameterName)) return this.fM2;
    return null;
  }
  
  public Method getM1() {
    return this.fM1;
  }
  
  public Method getM2() {
    return this.fM2;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("m1".equals(parameterName) ) {
    	this.fM1 = (Method) newValue;
    	return true;
    }
    if ("m2".equals(parameterName) ) {
    	this.fM2 = (Method) newValue;
    	return true;
    }
    return false;
  }
  
  public void setM1(final Method pM1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fM1 = pM1;
  }
  
  public void setM2(final Method pM2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fM2 = pM2;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.viatra.ttc.dse.queries.dmm";
  }
  
  @Override
  public List<String> parameterNames() {
    return DmmMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fM1, fM2};
  }
  
  @Override
  public DmmMatch toImmutable() {
    return isMutable() ? newMatch(fM1, fM2) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"m1\"=" + prettyPrintValue(fM1) + ", ");
    
    result.append("\"m2\"=" + prettyPrintValue(fM2)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fM1 == null) ? 0 : fM1.hashCode());
    result = prime * result + ((fM2 == null) ? 0 : fM2.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof DmmMatch)) { // this should be infrequent
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
    DmmMatch other = (DmmMatch) obj;
    if (fM1 == null) {if (other.fM1 != null) return false;}
    else if (!fM1.equals(other.fM1)) return false;
    if (fM2 == null) {if (other.fM2 != null) return false;}
    else if (!fM2.equals(other.fM2)) return false;
    return true;
  }
  
  @Override
  public DmmQuerySpecification specification() {
    try {
    	return DmmQuerySpecification.instance();
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
  public static DmmMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pM2 the fixed value of pattern parameter m2, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static DmmMatch newMutableMatch(final Method pM1, final Method pM2) {
    return new Mutable(pM1, pM2);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pM2 the fixed value of pattern parameter m2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static DmmMatch newMatch(final Method pM1, final Method pM2) {
    return new Immutable(pM1, pM2);
  }
  
  private static final class Mutable extends DmmMatch {
    Mutable(final Method pM1, final Method pM2) {
      super(pM1, pM2);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends DmmMatch {
    Immutable(final Method pM1, final Method pM2) {
      super(pM1, pM2);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
