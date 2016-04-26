package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.Attribute;
import architectureCRA.Method;
import hu.bme.mit.viatra.ttc.dse.queries.util.DmaQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.viatra.ttc.dse.queries.dma pattern,
 * to be used in conjunction with {@link DmaMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see DmaMatcher
 * @see DmaProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class DmaMatch extends BasePatternMatch {
  private Method fM;
  
  private Attribute fA;
  
  private static List<String> parameterNames = makeImmutableList("m", "a");
  
  private DmaMatch(final Method pM, final Attribute pA) {
    this.fM = pM;
    this.fA = pA;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("m".equals(parameterName)) return this.fM;
    if ("a".equals(parameterName)) return this.fA;
    return null;
  }
  
  public Method getM() {
    return this.fM;
  }
  
  public Attribute getA() {
    return this.fA;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("m".equals(parameterName) ) {
    	this.fM = (Method) newValue;
    	return true;
    }
    if ("a".equals(parameterName) ) {
    	this.fA = (Attribute) newValue;
    	return true;
    }
    return false;
  }
  
  public void setM(final Method pM) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fM = pM;
  }
  
  public void setA(final Attribute pA) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fA = pA;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.viatra.ttc.dse.queries.dma";
  }
  
  @Override
  public List<String> parameterNames() {
    return DmaMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fM, fA};
  }
  
  @Override
  public DmaMatch toImmutable() {
    return isMutable() ? newMatch(fM, fA) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"m\"=" + prettyPrintValue(fM) + ", ");
    
    result.append("\"a\"=" + prettyPrintValue(fA)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fM == null) ? 0 : fM.hashCode());
    result = prime * result + ((fA == null) ? 0 : fA.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof DmaMatch)) { // this should be infrequent
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
    DmaMatch other = (DmaMatch) obj;
    if (fM == null) {if (other.fM != null) return false;}
    else if (!fM.equals(other.fM)) return false;
    if (fA == null) {if (other.fA != null) return false;}
    else if (!fA.equals(other.fA)) return false;
    return true;
  }
  
  @Override
  public DmaQuerySpecification specification() {
    try {
    	return DmaQuerySpecification.instance();
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
  public static DmaMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static DmaMatch newMutableMatch(final Method pM, final Attribute pA) {
    return new Mutable(pM, pA);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pM the fixed value of pattern parameter m, or null if not bound.
   * @param pA the fixed value of pattern parameter a, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static DmaMatch newMatch(final Method pM, final Attribute pA) {
    return new Immutable(pM, pA);
  }
  
  private static final class Mutable extends DmaMatch {
    Mutable(final Method pM, final Attribute pA) {
      super(pM, pA);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends DmaMatch {
    Immutable(final Method pM, final Attribute pA) {
      super(pM, pA);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
