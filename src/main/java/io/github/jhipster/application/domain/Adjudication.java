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
    @JoinTable(name = "adjudication_amount",
               joinColumns = @JoinColumn(name = "adjudication_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "amount_id", referencedColumnName = "id"))
    private Set<Enrollment> amounts = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "adjudication_amount",
               joinColumns = @JoinColumn(name = "adjudication_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "amount_id", referencedColumnName = "id"))
    private Set<Patient> amounts = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "adjudication_amount",
               joinColumns = @JoinColumn(name = "adjudication_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "amount_id", referencedColumnName = "id"))
    private Set<Claim> amounts = new HashSet<>();

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

    public Set<Enrollment> getAmounts() {
        return amounts;
    }

    public Adjudication amounts(Set<Enrollment> enrollments) {
        this.amounts = enrollments;
        return this;
    }

    public Adjudication addAmount(Enrollment enrollment) {
        this.amounts.add(enrollment);
        enrollment.getAdjudications().add(this);
        return this;
    }

    public Adjudication removeAmount(Enrollment enrollment) {
        this.amounts.remove(enrollment);
        enrollment.getAdjudications().remove(this);
        return this;
    }

    public void setAmounts(Set<Enrollment> enrollments) {
        this.amounts = enrollments;
    }

    public Set<Patient> getAmounts() {
        return amounts;
    }

    public Adjudication amounts(Set<Patient> patients) {
        this.amounts = patients;
        return this;
    }

    public Adjudication addAmount(Patient patient) {
        this.amounts.add(patient);
        patient.getAdjudications().add(this);
        return this;
    }

    public Adjudication removeAmount(Patient patient) {
        this.amounts.remove(patient);
        patient.getAdjudications().remove(this);
        return this;
    }

    public void setAmounts(Set<Patient> patients) {
        this.amounts = patients;
    }

    public Set<Claim> getAmounts() {
        return amounts;
    }

    public Adjudication amounts(Set<Claim> claims) {
        this.amounts = claims;
        return this;
    }

    public Adjudication addAmount(Claim claim) {
        this.amounts.add(claim);
        claim.getAdjudications().add(this);
        return this;
    }

    public Adjudication removeAmount(Claim claim) {
        this.amounts.remove(claim);
        claim.getAdjudications().remove(this);
        return this;
    }

    public void setAmounts(Set<Claim> claims) {
        this.amounts = claims;
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
