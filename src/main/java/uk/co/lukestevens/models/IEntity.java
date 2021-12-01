package uk.co.lukestevens.models;

import java.util.Objects;

/**
 * A base entity class to be extended by any domain classes.
 * 
 * This contains the default equals, toString, and hashCode methods
 * @author luke.stevens
 *
 */
public abstract class IEntity {

	public abstract Long getId();
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && this.getClass().equals(obj.getClass())) {
			IEntity e = (IEntity) obj;
			return this.getId().equals(e.getId());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "[" + this.getId() + "]: ";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getId(), this.getClass());
	}

}
