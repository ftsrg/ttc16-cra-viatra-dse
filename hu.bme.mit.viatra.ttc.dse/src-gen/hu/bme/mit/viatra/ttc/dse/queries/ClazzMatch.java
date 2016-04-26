package hu.bme.mit.viatra.ttc.dse.queries;

import hu.bme.mit.viatra.ttc.dse.queries.util.ClazzQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.viatra.ttc.dse.queries.clazz pattern,
 * to be used in conjunction with {@link ClazzMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ClazzMatcher
 * @see ClazzProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ClazzMatch extends BasePatternMatch {
  private architectureCRA.Class fC;
  
  private static List<String> parameterNames = makeImmutableList("c");
  
  private ClazzMatch(final architectureCRA.Class pC) {
    this.fC = pC;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("c".equals(parameterName)) return this.fC;
    return null;
  }
  
  public architectureCRA.Class getC() {
    return this.fC;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("c".equals(parameterName) ) {
    	this.fC = (architectureCRA.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setC(final architectureCRA.Class pC) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fC = pC;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.viatra.ttc.dse.queries.clazz";
  }
  
  @Override
  public List<String> parameterNames() {
    return ClazzMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fC};
  }
  
  @Override
  public ClazzMatch toImmutable() {
    return isMutable() ? newMatch(fC) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"c\"=" + prettyPrintValue(fC)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fC == null) ? 0 : fC.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ClazzMatch)) { // this should be infrequent
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
    ClazzMatch other = (ClazzMatch) obj;
    if (fC == null) {if (other.fC != null) return false;}
    else if (!fC.equals(other.fC)) return false;
    return true;
  }
  
  @Override
  public ClazzQuerySpecification specification() {
    try {
    	return ClazzQuerySpecification.instance();
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
  public static ClazzMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ClazzMatch newMutableMatch(final architectureCRA.Class pC) {
    return new Mutable(pC);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ClazzMatch newMatch(final architectureCRA.Class pC) {
    return new Immutable(pC);
  }
  
  private static final class Mutable extends ClazzMatch {
    Mutable(final architectureCRA.Class pC) {
      super(pC);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ClazzMatch {
    Immutable(final architectureCRA.Class pC) {
      super(pC);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
