package uk.co.lukestevens.models

import java.util.Objects

/**
 * A base entity class to be extended by any domain classes.
 *
 * This contains the default equals, toString, and hashCode methods
 * @author luke.stevens
 *
 */
abstract class IEntity {
	abstract val id: Int?

	override fun equals(other: Any?): Boolean {
		if (other != null && this::class == other::class) {
			val e = other as IEntity
			return this.id == e.id
		}
		return false
	}

	override fun toString(): String {
		return "%s (%d)".format(this::class, this.id)
	}

	override fun hashCode(): Int {
		return Objects.hash(this.id, this::class)
	}
}