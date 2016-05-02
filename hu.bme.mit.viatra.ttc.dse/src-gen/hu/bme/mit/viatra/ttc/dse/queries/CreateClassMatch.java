package hu.bme.mit.viatra.ttc.dse.queries;

import architectureCRA.ClassModel;
import hu.bme.mit.viatra.ttc.dse.queries.util.CreateClassQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.viatra.ttc.dse.queries.createClass pattern,
 * to be used in conjunction with {@link CreateClassMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see CreateClassMatcher
 * @see CreateClassProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class CreateClassMatch extends BasePatternMatch {
  private ClassModel fCm;
  
  private static List<String> parameterNames = makeImmutableList("cm");
  
  private CreateClassMatch(final ClassModel pCm) {
    this.fCm = pCm;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cm".equals(parameterName)) return this.fCm;
    return null;
  }
  
  public ClassModel getCm() {
    return this.fCm;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cm".equals(parameterName) ) {
    	this.fCm = (ClassModel) newValue;
    	return true;
    }
    return false;
  }
  
  public void setCm(final ClassModel pCm) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCm = pCm;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.viatra.ttc.dse.queries.createClass";
  }
  
  @Override
  public List<String> parameterNames() {
    return CreateClassMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCm};
  }
  
  @Override
  public CreateClassMatch toImmutable() {
    return isMutable() ? newMatch(fCm) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cm\"=" + prettyPrintValue(fCm)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCm == null) ? 0 : fCm.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof CreateClassMatch)) { // this should be infrequent
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
    CreateClassMatch other = (CreateClassMatch) obj;
    if (fCm == null) {if (other.fCm != null) return false;}
    else if (!fCm.equals(other.fCm)) return false;
    return true;
  }
  
  @Override
  public CreateClassQuerySpecification specification() {
    try {
    	return CreateClassQuerySpecification.instance();
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
  public static CreateClassMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static CreateClassMatch newMutableMatch(final ClassModel pCm) {
    return new Mutable(pCm);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCm the fixed value of pattern parameter cm, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static CreateClassMatch newMatch(final ClassModel pCm) {
    return new Immutable(pCm);
  }
  
  private static final class Mutable extends CreateClassMatch {
    Mutable(final ClassModel pCm) {
      super(pCm);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends CreateClassMatch {
    Immutable(final ClassModel pCm) {
      super(pCm);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
