package fr.M2L;

public class Cellule {
	private String v1, v2;
	private int id;
	public Cellule(String v1, String v2, int i) {
		this.v1=v1;
		this.v2=v2;
		this.id=i;
	}
	public String getV1() {
		return v1;
	}
	public String getV2() {
		return v2;
	}
	public int getId() {
		return id;
	}
}
