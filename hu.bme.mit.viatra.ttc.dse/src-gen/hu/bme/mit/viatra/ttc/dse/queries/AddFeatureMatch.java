package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.Feature;
import hu.bme.mit.viatra.ttc.dse.queries.util.AddFeatureQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.viatra.ttc.dse.queries.addFeature pattern,
 * to be used in conjunction with {@link AddFeatureMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AddFeatureMatcher
 * @see AddFeatureProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AddFeatureMatch extends BasePatternMatch {
  private architectureCRA.Class fC;
  
  private Feature fF;
  
  private static List<String> parameterNames = makeImmutableList("c", "f");
  
  private AddFeatureMatch(final architectureCRA.Class pC, final Feature pF) {
    this.fC = pC;
    this.fF = pF;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("c".equals(parameterName)) return this.fC;
    if ("f".equals(parameterName)) return this.fF;
    return null;
  }
  
  public architectureCRA.Class getC() {
    return this.fC;
  }
  
  public Feature getF() {
    return this.fF;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("c".equals(parameterName) ) {
    	this.fC = (architectureCRA.Class) newValue;
    	return true;
    }
    if ("f".equals(parameterName) ) {
    	this.fF = (Feature) newValue;
    	return true;
    }
    return false;
  }
  
  public void setC(final architectureCRA.Class pC) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fC = pC;
  }
  
  public void setF(final Feature pF) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fF = pF;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.viatra.ttc.dse.queries.addFeature";
  }
  
  @Override
  public List<String> parameterNames() {
    return AddFeatureMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fC, fF};
  }
  
  @Override
  public AddFeatureMatch toImmutable() {
    return isMutable() ? newMatch(fC, fF) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"c\"=" + prettyPrintValue(fC) + ", ");
    
    result.append("\"f\"=" + prettyPrintValue(fF)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fC == null) ? 0 : fC.hashCode());
    result = prime * result + ((fF == null) ? 0 : fF.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AddFeatureMatch)) { // this should be infrequent
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
    AddFeatureMatch other = (AddFeatureMatch) obj;
    if (fC == null) {if (other.fC != null) return false;}
    else if (!fC.equals(other.fC)) return false;
    if (fF == null) {if (other.fF != null) return false;}
    else if (!fF.equals(other.fF)) return false;
    return true;
  }
  
  @Override
  public AddFeatureQuerySpecification specification() {
    try {
    	return AddFeatureQuerySpecification.instance();
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
  public static AddFeatureMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AddFeatureMatch newMutableMatch(final architectureCRA.Class pC, final Feature pF) {
    return new Mutable(pC, pF);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AddFeatureMatch newMatch(final architectureCRA.Class pC, final Feature pF) {
    return new Immutable(pC, pF);
  }
  
  private static final class Mutable extends AddFeatureMatch {
    Mutable(final architectureCRA.Class pC, final Feature pF) {
      super(pC, pF);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AddFeatureMatch {
    Immutable(final architectureCRA.Class pC, final Feature pF) {
      super(pC, pF);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
