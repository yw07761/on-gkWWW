package vn.edu.iuh.fit.ongiuaky_www.backend.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.ongiuaky_www.backend.converters.RoleConverter;
import vn.edu.iuh.fit.ongiuaky_www.backend.enums.Roles;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "experience")
public class Experience implements Serializable {
    @Id
    @Column(name = "exp_id", columnDefinition = "bigint(20)", nullable = false)
    private long id;
    @Column(name = "work_des", columnDefinition = "varchar(400)")
    private String workDescription;
    @Column(name = "company", columnDefinition = "varchar(120)")
    private String companyName;
    @Column(name = "role", columnDefinition = "tinyint(4)")
    @Convert(converter = RoleConverter.class)
    private Roles role;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Column(name = "from_date", columnDefinition = "date")
    private LocalDate fromDate;
    @Column(name = "to_date", columnDefinition = "date")
    private LocalDate toDate;


    public Experience() {
    }

    public Experience(long id, String workDescription, String companyName, Roles role, Candidate candidate, LocalDate fromDate, LocalDate toDate) {
        this.id = id;
        this.workDescription = workDescription;
        this.companyName = companyName;
        this.role = role;
        this.candidate = candidate;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", workDescription='" + workDescription + '\'' +
                ", companyName='" + companyName + '\'' +
                ", role=" + role +
                ", candidate=" + candidate +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
