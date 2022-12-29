package cshyb_main.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Collage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int collageld; 
	private String collageName; 
	private String collageAddress;
	@OneToMany(mappedBy = "collage",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Student> students=new ArrayList<Student>();
	public Collage() {}
	
	public Collage(int collageld, String collageName, String collageAddress) {
		super();
		this.collageld = collageld;
		this.collageName = collageName;
		this.collageAddress = collageAddress;
	}
	public int getCollageld() {
		return collageld;
	}
	public void setCollageld(int collageld) {
		this.collageld = collageld;
	}
	public String getCollageName() {
		return collageName;
	}
	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}
	public String getCollageAddress() {
		return collageAddress;
	}
	public void setCollageAddress(String collageAddress) {
		this.collageAddress = collageAddress;
	}
	@Override
	public String toString() {
		return "College [collageld=" + collageld + ", collageName=" + collageName + ", collageAddress=" + collageAddress
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(collageAddress, collageName, collageld);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Collage other = (Collage) obj;
		return Objects.equals(collageAddress, other.collageAddress) && Objects.equals(collageName, other.collageName)
				&& collageld == other.collageld;
	} 
	
	
	
	
	


}
