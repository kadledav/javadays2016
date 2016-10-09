package org.got.travel.castle.model;

import javax.persistence.*;

/**
 * This class models a Castle data structure.
 * 
 * @author macalak@itexperts.sk
 *
 */

@Entity
public class Castle {
	private @Id @GeneratedValue Long id;
	private @Version Long version;
	private String name;
	private String ruler;
	private String location;

	public Castle() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRuler() {
		return ruler;
	}

	public void setRuler(String ruler) {
		this.ruler = ruler;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setId(Long id) { this.id = id; }

	public Long getVersion() { return version; }

	public void setVersion(Long version) { this.version = version; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Castle castle = (Castle) o;

		if (!id.equals(castle.id)) return false;
		if (!version.equals(castle.version)) return false;
		if (!name.equals(castle.name)) return false;
		if (!ruler.equals(castle.ruler)) return false;
		if (!location.equals(castle.location)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + version.hashCode();
		result = 31 * result + name.hashCode();
		result = 31 * result + ruler.hashCode();
		result = 31 * result + location.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Castle{" +
				"id=" + id +
				", version=" + version +
				", name='" + name + '\'' +
				", ruler='" + ruler + '\'' +
				", location='" + location + '\'' +
				'}';
	}
}
