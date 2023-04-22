/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectcrud;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author DYNABOOK
 */
@Entity
@Table(name = "SALARIES", catalog = "", schema = "ROOT")
@NamedQueries({
    @NamedQuery(name = "Salaries.findAll", query = "SELECT s FROM Salaries s")
    , @NamedQuery(name = "Salaries.findBySalaryId", query = "SELECT s FROM Salaries s WHERE s.salaryId = :salaryId")
    , @NamedQuery(name = "Salaries.findByEmpId", query = "SELECT s FROM Salaries s WHERE s.empId = :empId")
    , @NamedQuery(name = "Salaries.findByStartDate", query = "SELECT s FROM Salaries s WHERE s.startDate = :startDate")
    , @NamedQuery(name = "Salaries.findByEndDate", query = "SELECT s FROM Salaries s WHERE s.endDate = :endDate")
    , @NamedQuery(name = "Salaries.findByAmount", query = "SELECT s FROM Salaries s WHERE s.amount = :amount")})
public class Salaries implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SALARY_ID")
    private Integer salaryId;
    @Column(name = "EMP_ID")
    private Integer empId;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private BigDecimal amount;

    public Salaries() {
    }

    public Salaries(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        Integer oldSalaryId = this.salaryId;
        this.salaryId = salaryId;
        changeSupport.firePropertyChange("salaryId", oldSalaryId, salaryId);
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        Integer oldEmpId = this.empId;
        this.empId = empId;
        changeSupport.firePropertyChange("empId", oldEmpId, empId);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        Date oldStartDate = this.startDate;
        this.startDate = startDate;
        changeSupport.firePropertyChange("startDate", oldStartDate, startDate);
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        Date oldEndDate = this.endDate;
        this.endDate = endDate;
        changeSupport.firePropertyChange("endDate", oldEndDate, endDate);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        BigDecimal oldAmount = this.amount;
        this.amount = amount;
        changeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salaryId != null ? salaryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salaries)) {
            return false;
        }
        Salaries other = (Salaries) object;
        if ((this.salaryId == null && other.salaryId != null) || (this.salaryId != null && !this.salaryId.equals(other.salaryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projectcrud.Salaries[ salaryId=" + salaryId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
