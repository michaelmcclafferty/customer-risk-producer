package com.example.customerriskproducer.models;

import java.util.Objects;

public class CustomerRisk {

	private int id;
	private boolean crypto;
	private boolean gambling;
	private boolean atRisk;
	
	public CustomerRisk() {
		// TODO Auto-generated constructor stub
	}
	public CustomerRisk(int id, boolean crypto, boolean gambling, boolean atRisk) {
		this.id = id;
		this.crypto = crypto;
		this.gambling = gambling;
		this.atRisk = atRisk;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isCrypto() {
		return crypto;
	}
	public void setCrypto(boolean crypto) {
		this.crypto = crypto;
	}
	public boolean isGambling() {
		return gambling;
	}
	public void setGambling(boolean gambling) {
		this.gambling = gambling;
	}
	public boolean isAtRisk() {
		return atRisk;
	}
	public void setAtRisk(boolean atRisk) {
		this.atRisk = atRisk;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, crypto, gambling, atRisk);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerRisk other = (CustomerRisk) obj;
		return crypto == other.crypto && gambling == other.gambling
				&& atRisk == other.atRisk && id == other.id;
	}
	@Override
	public String toString() {
		return "CustomerRisk [id=" + id + ", crypto=" + crypto + ", gambling=" + gambling + ", atRisk=" + atRisk + "]";
	}

}
	