package vn.edu.iuh.fit.ongiuaky_www.backend.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "candidate")
public class Candidate implements Serializable {
    @Id

    @Column(name = "can_id", columnDefinition = "bigint(20)", nullable = false)
    private long id;
    @Column(name = "full_name", columnDefinition = "varchar(255)")
    private String fullName;
    @Column(name = "email", columnDefinition = "varchar(255)")
    private String email;
    @Column(name = "phone", columnDefinition = "varchar(15)")
    private String phone;
    @OneToMany(mappedBy = "candidate",fetch = FetchType.LAZY)
    private List<Experience> experiences;

    public Candidate() {
    }

    public Candidate(long id, String fullName, String email, String phone, List<Experience> experiences) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.experiences = experiences;
    }

    public Candidate(long id, String fullName, String email, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", experiences=" + experiences +
                '}';
    }
}
