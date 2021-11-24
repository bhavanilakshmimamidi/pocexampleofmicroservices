package com.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Invoice_Tbl")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int in_id;
	private int o_id;
	private float totalamount;
	private String payment_status;
	
	public int getIn_id() {
		return in_id;
	}

	public void setIn_id(int in_id) {
		this.in_id = in_id;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public float getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(float totalamount) {
		this.totalamount = totalamount;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public Invoice(int in_id, int o_id, float totalamount, String payment_status) {
		super();
		this.in_id = in_id;
		this.o_id = o_id;
		this.totalamount = totalamount;
		this.payment_status = payment_status;
	}
	public String toString() {
		return "Invoice [in_id=" + in_id + ", o_id=" + o_id + ", totalamount=" + totalamount + ", payment_status="
				+ payment_status + "]";
	}

	public Invoice() {}
	
}
