package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.Attribute;
import architectureCRA.Method;
import hu.bme.mit.viatra.ttc.dse.queries.util.MaiPartialQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.viatra.ttc.dse.queries.maiPartial pattern,
 * to be used in conjunction with {@link MaiPartialMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see MaiPartialMatcher
 * @see MaiPartialProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class MaiPartialMatch extends BasePatternMatch {
  private architectureCRA.Class fC1;
  
  private architectureCRA.Class fC2;
  
  private Method fM1;
  
  private Attribute fA2;
  
  private static List<String> parameterNames = makeImmutableList("c1", "c2", "m1", "a2");
  
  private MaiPartialMatch(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Method pM1, final Attribute pA2) {
    this.fC1 = pC1;
    this.fC2 = pC2;
    this.fM1 = pM1;
    this.fA2 = pA2;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("c1".equals(parameterName)) return this.fC1;
    if ("c2".equals(parameterName)) return this.fC2;
    if ("m1".equals(parameterName)) return this.fM1;
    if ("a2".equals(parameterName)) return this.fA2;
    return null;
  }
  
  public architectureCRA.Class getC1() {
    return this.fC1;
  }
  
  public architectureCRA.Class getC2() {
    return this.fC2;
  }
  
  public Method getM1() {
    return this.fM1;
  }
  
  public Attribute getA2() {
    return this.fA2;
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
    if ("m1".equals(parameterName) ) {
    	this.fM1 = (Method) newValue;
    	return true;
    }
    if ("a2".equals(parameterName) ) {
    	this.fA2 = (Attribute) newValue;
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
  
  public void setM1(final Method pM1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fM1 = pM1;
  }
  
  public void setA2(final Attribute pA2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fA2 = pA2;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.viatra.ttc.dse.queries.maiPartial";
  }
  
  @Override
  public List<String> parameterNames() {
    return MaiPartialMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fC1, fC2, fM1, fA2};
  }
  
  @Override
  public MaiPartialMatch toImmutable() {
    return isMutable() ? newMatch(fC1, fC2, fM1, fA2) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"c1\"=" + prettyPrintValue(fC1) + ", ");
    
    result.append("\"c2\"=" + prettyPrintValue(fC2) + ", ");
    
    result.append("\"m1\"=" + prettyPrintValue(fM1) + ", ");
    
    result.append("\"a2\"=" + prettyPrintValue(fA2)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fC1 == null) ? 0 : fC1.hashCode());
    result = prime * result + ((fC2 == null) ? 0 : fC2.hashCode());
    result = prime * result + ((fM1 == null) ? 0 : fM1.hashCode());
    result = prime * result + ((fA2 == null) ? 0 : fA2.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof MaiPartialMatch)) { // this should be infrequent
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
    MaiPartialMatch other = (MaiPartialMatch) obj;
    if (fC1 == null) {if (other.fC1 != null) return false;}
    else if (!fC1.equals(other.fC1)) return false;
    if (fC2 == null) {if (other.fC2 != null) return false;}
    else if (!fC2.equals(other.fC2)) return false;
    if (fM1 == null) {if (other.fM1 != null) return false;}
    else if (!fM1.equals(other.fM1)) return false;
    if (fA2 == null) {if (other.fA2 != null) return false;}
    else if (!fA2.equals(other.fA2)) return false;
    return true;
  }
  
  @Override
  public MaiPartialQuerySpecification specification() {
    try {
    	return MaiPartialQuerySpecification.instance();
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
  public static MaiPartialMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pA2 the fixed value of pattern parameter a2, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static MaiPartialMatch newMutableMatch(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Method pM1, final Attribute pA2) {
    return new Mutable(pC1, pC2, pM1, pA2);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pC1 the fixed value of pattern parameter c1, or null if not bound.
   * @param pC2 the fixed value of pattern parameter c2, or null if not bound.
   * @param pM1 the fixed value of pattern parameter m1, or null if not bound.
   * @param pA2 the fixed value of pattern parameter a2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static MaiPartialMatch newMatch(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Method pM1, final Attribute pA2) {
    return new Immutable(pC1, pC2, pM1, pA2);
  }
  
  private static final class Mutable extends MaiPartialMatch {
    Mutable(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Method pM1, final Attribute pA2) {
      super(pC1, pC2, pM1, pA2);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends MaiPartialMatch {
    Immutable(final architectureCRA.Class pC1, final architectureCRA.Class pC2, final Method pM1, final Attribute pA2) {
      super(pC1, pC2, pM1, pA2);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
