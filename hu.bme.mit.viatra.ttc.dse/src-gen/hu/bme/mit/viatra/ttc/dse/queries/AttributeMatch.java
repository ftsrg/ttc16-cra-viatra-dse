package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.Attribute;
import hu.bme.mit.viatra.ttc.dse.queries.util.AttributeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.viatra.ttc.dse.queries.attribute pattern,
 * to be used in conjunction with {@link AttributeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AttributeMatcher
 * @see AttributeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AttributeMatch extends BasePatternMatch {
  private architectureCRA.Class fC;
  
  private Attribute fA;
  
  private static List<String> parameterNames = makeImmutableList("c", "a");
  
  private AttributeMatch(final architectureCRA.Class pC, final Attribute pA) {
    this.fC = pC;
    this.fA = pA;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("c".equals(parameterName)) return this.fC;
    if ("a".equals(parameterName)) return this.fA;
    return null;
  }
  
  public architectureCRA.Class getC() {
    return this.fC;
  }
  
  public Attribute getA() {
    return this.fA;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("c".equals(parameterName) ) {
    	this.fC = (architectureCRA.Class) newValue;
    	return true;
    }
    if ("a".equals(parameterName) ) {
    	this.fA = (Attribute) newValue;
    	return true;
    }
    return false;
  }
  
  public void setC(final architectureCRA.Class pC) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fC = pC;
  }
  
  public void setA(final Attribute pA) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fA = pA;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.viatra.ttc.dse.queries.attribute";
  }
  
  @Override
  public List<String> parameterNames() {
    return AttributeMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fC, fA};
  }
  
  @Override
  public AttributeMatch toImmutable() {
    return isMutable() ? newMatch(fC, fA) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"c\"=" + prettyPrintValue(fC) + ", ");
    
    result.append("\"a\"=" + prettyPrintValue(fA)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fC == null) ? 0 : fC.hashCode());
    result = prime * result + ((fA == null) ? 0 : fA.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AttributeMatch)) { // this should be infrequent
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
    AttributeMatch other = (AttributeMatch) obj;
    if (fC == null) {if (other.fC != null) return false;}
    else if (!fC.equals(other.fC)) return false;
    if (fA == null) {if (other.fA != null) return false;}
    else if (!fA.equals(other.fA)) return false;
    return true;
  }
  
  @Override
  public AttributeQuerySpecification specification() {
    try {
    	return AttributeQuerySpecification.instance();
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
  public static AttributeMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AttributeMatch newMutableMatch(final architectureCRA.Class pC, final Attribute pA) {
    return new Mutable(pC, pA);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AttributeMatch newMatch(final architectureCRA.Class pC, final Attribute pA) {
    return new Immutable(pC, pA);
  }
  
  private static final class Mutable extends AttributeMatch {
    Mutable(final architectureCRA.Class pC, final Attribute pA) {
      super(pC, pA);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AttributeMatch {
    Immutable(final architectureCRA.Class pC, final Attribute pA) {
      super(pC, pA);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
