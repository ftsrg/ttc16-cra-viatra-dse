/**
 * Generated from platform:/resource/hu.bme.mit.viatra.ttc.dse/src/hu/bme/mit/viatra/ttc/dse/queries/queries.vql
 */
package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.Method;
import hu.bme.mit.viatra.ttc.dse.queries.util.MethodQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.viatra.ttc.dse.queries.method pattern,
 * to be used in conjunction with {@link MethodMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see MethodMatcher
 * @see MethodProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class MethodMatch extends BasePatternMatch {
  private architectureCRA.Class fC;
  
  private Method fM;
  
  private static List<String> parameterNames = makeImmutableList("c", "m");
  
  private MethodMatch(final architectureCRA.Class pC, final Method pM) {
    this.fC = pC;
    this.fM = pM;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("c".equals(parameterName)) return this.fC;
    if ("m".equals(parameterName)) return this.fM;
    return null;
  }
  
  public architectureCRA.Class getC() {
    return this.fC;
  }
  
  public Method getM() {
    return this.fM;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("c".equals(parameterName) ) {
    	this.fC = (architectureCRA.Class) newValue;
    	return true;
    }
    if ("m".equals(parameterName) ) {
    	this.fM = (Method) newValue;
    	return true;
    }
    return false;
  }
  
  public void setC(final architectureCRA.Class pC) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fC = pC;
  }
  
  public void setM(final Method pM) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fM = pM;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.viatra.ttc.dse.queries.method";
  }
  
  @Override
  public List<String> parameterNames() {
    return MethodMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fC, fM};
  }
  
  @Override
  public MethodMatch toImmutable() {
    return isMutable() ? newMatch(fC, fM) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"c\"=" + prettyPrintValue(fC) + ", ");
    
    result.append("\"m\"=" + prettyPrintValue(fM)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fC == null) ? 0 : fC.hashCode());
    result = prime * result + ((fM == null) ? 0 : fM.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof MethodMatch)) { // this should be infrequent
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
    MethodMatch other = (MethodMatch) obj;
    if (fC == null) {if (other.fC != null) return false;}
    else if (!fC.equals(other.fC)) return false;
    if (fM == null) {if (other.fM != null) return false;}
    else if (!fM.equals(other.fM)) return false;
    return true;
  }
  
  @Override
  public MethodQuerySpecification specification() {
    try {
    	return MethodQuerySpecification.instance();
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
  public static MethodMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static MethodMatch newMutableMatch(final architectureCRA.Class pC, final Method pM) {
    return new Mutable(pC, pM);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static MethodMatch newMatch(final architectureCRA.Class pC, final Method pM) {
    return new Immutable(pC, pM);
  }
  
  private static final class Mutable extends MethodMatch {
    Mutable(final architectureCRA.Class pC, final Method pM) {
      super(pC, pM);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends MethodMatch {
    Immutable(final architectureCRA.Class pC, final Method pM) {
      super(pC, pM);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
