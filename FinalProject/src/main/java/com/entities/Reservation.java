package com.entities;
// Generated 6 avr. 2018 17:17:51 by Hibernate Tools 5.2.8.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Reservation generated by hbm2java
 */
@Entity
@Table(name = "reservation", catalog = "nursery")
public class Reservation implements java.io.Serializable {

	private Integer reservationId;
	private Integer contractId;
	private Integer absence;
	private Date atDate;
	private String periodOfDay;

	public Reservation() {
	}

	public Reservation(Integer contractId, Integer absence, Date atDate, String periodOfDay) {
		this.contractId = contractId;
		this.absence = absence;
		this.atDate = atDate;
		this.periodOfDay = periodOfDay;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "reservation_id", unique = true, nullable = false)
	public Integer getReservationId() {
		return this.reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	@Column(name = "contract_id")
	public Integer getContractId() {
		return this.contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	@Column(name = "absence")
	public Integer getAbsence() {
		return this.absence;
	}

	public void setAbsence(Integer absence) {
		this.absence = absence;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "at_date", length = 10)
	public Date getAtDate() {
		return this.atDate;
	}

	public void setAtDate(Date atDate) {
		this.atDate = atDate;
	}

	@Column(name = "period_of_day", length = 10)
	public String getPeriodOfDay() {
		return this.periodOfDay;
	}

	public void setPeriodOfDay(String periodOfDay) {
		this.periodOfDay = periodOfDay;
	}

}
