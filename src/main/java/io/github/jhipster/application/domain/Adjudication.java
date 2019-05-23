package io.github.jhipster.application.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Adjudication.
 */
@Entity
@Table(name = "adjudication")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Adjudication implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "casenumber")
    private Long casenumber;

    @Column(name = "eob")
    private Long eob;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "adjudication_amount_enrollment",
               joinColumns = @JoinColumn(name = "adjudication_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "amount_enrollment_id", referencedColumnName = "id"))
    private Set<Enrollment> amountEnrollments = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "adjudication_amount_patient",
               joinColumns = @JoinColumn(name = "adjudication_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "amount_patient_id", referencedColumnName = "id"))
    private Set<Patient> amountPatients = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "adjudication_amount_claim",
               joinColumns = @JoinColumn(name = "adjudication_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "amount_claim_id", referencedColumnName = "id"))
    private Set<Claim> amountClaims = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCasenumber() {
        return casenumber;
    }

    public Adjudication casenumber(Long casenumber) {
        this.casenumber = casenumber;
        return this;
    }

    public void setCasenumber(Long casenumber) {
        this.casenumber = casenumber;
    }

    public Long getEob() {
        return eob;
    }

    public Adjudication eob(Long eob) {
        this.eob = eob;
        return this;
    }

    public void setEob(Long eob) {
        this.eob = eob;
    }

    public Set<Enrollment> getAmountEnrollments() {
        return amountEnrollments;
    }

    public Adjudication amountEnrollments(Set<Enrollment> enrollments) {
        this.amountEnrollments = enrollments;
        return this;
    }

    public Adjudication addAmountEnrollment(Enrollment enrollment) {
        this.amountEnrollments.add(enrollment);
        enrollment.getAdjudications().add(this);
        return this;
    }

    public Adjudication removeAmountEnrollment(Enrollment enrollment) {
        this.amountEnrollments.remove(enrollment);
        enrollment.getAdjudications().remove(this);
        return this;
    }

    public void setAmountEnrollments(Set<Enrollment> enrollments) {
        this.amountEnrollments = enrollments;
    }

    public Set<Patient> getAmountPatients() {
        return amountPatients;
    }

    public Adjudication amountPatients(Set<Patient> patients) {
        this.amountPatients = patients;
        return this;
    }

    public Adjudication addAmountPatient(Patient patient) {
        this.amountPatients.add(patient);
        patient.getAdjudications().add(this);
        return this;
    }

    public Adjudication removeAmountPatient(Patient patient) {
        this.amountPatients.remove(patient);
        patient.getAdjudications().remove(this);
        return this;
    }

    public void setAmountPatients(Set<Patient> patients) {
        this.amountPatients = patients;
    }

    public Set<Claim> getAmountClaims() {
        return amountClaims;
    }

    public Adjudication amountClaims(Set<Claim> claims) {
        this.amountClaims = claims;
        return this;
    }

    public Adjudication addAmountClaim(Claim claim) {
        this.amountClaims.add(claim);
        claim.getAdjudications().add(this);
        return this;
    }

    public Adjudication removeAmountClaim(Claim claim) {
        this.amountClaims.remove(claim);
        claim.getAdjudications().remove(this);
        return this;
    }

    public void setAmountClaims(Set<Claim> claims) {
        this.amountClaims = claims;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Adjudication)) {
            return false;
        }
        return id != null && id.equals(((Adjudication) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Adjudication{" +
            "id=" + getId() +
            ", casenumber=" + getCasenumber() +
            ", eob=" + getEob() +
            "}";
    }
}
