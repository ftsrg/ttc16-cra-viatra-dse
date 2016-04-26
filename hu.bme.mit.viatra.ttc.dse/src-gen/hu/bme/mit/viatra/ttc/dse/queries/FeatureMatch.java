package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.Feature;
import hu.bme.mit.viatra.ttc.dse.queries.util.FeatureQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.viatra.ttc.dse.queries.feature pattern,
 * to be used in conjunction with {@link FeatureMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see FeatureMatcher
 * @see FeatureProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class FeatureMatch extends BasePatternMatch {
  private Feature fF;
  
  private static List<String> parameterNames = makeImmutableList("f");
  
  private FeatureMatch(final Feature pF) {
    this.fF = pF;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("f".equals(parameterName)) return this.fF;
    return null;
  }
  
  public Feature getF() {
    return this.fF;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("f".equals(parameterName) ) {
    	this.fF = (Feature) newValue;
    	return true;
    }
    return false;
  }
  
  public void setF(final Feature pF) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fF = pF;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.viatra.ttc.dse.queries.feature";
  }
  
  @Override
  public List<String> parameterNames() {
    return FeatureMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fF};
  }
  
  @Override
  public FeatureMatch toImmutable() {
    return isMutable() ? newMatch(fF) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"f\"=" + prettyPrintValue(fF)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fF == null) ? 0 : fF.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof FeatureMatch)) { // this should be infrequent
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
    FeatureMatch other = (FeatureMatch) obj;
    if (fF == null) {if (other.fF != null) return false;}
    else if (!fF.equals(other.fF)) return false;
    return true;
  }
  
  @Override
  public FeatureQuerySpecification specification() {
    try {
    	return FeatureQuerySpecification.instance();
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
  public static FeatureMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static FeatureMatch newMutableMatch(final Feature pF) {
    return new Mutable(pF);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static FeatureMatch newMatch(final Feature pF) {
    return new Immutable(pF);
  }
  
  private static final class Mutable extends FeatureMatch {
    Mutable(final Feature pF) {
      super(pF);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends FeatureMatch {
    Immutable(final Feature pF) {
      super(pF);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
