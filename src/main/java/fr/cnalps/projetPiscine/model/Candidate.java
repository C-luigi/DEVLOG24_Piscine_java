package fr.cnalps.projetPiscine.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * Classe des candidats
 */
@Getter
@Setter
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String firstname;
    @Column(nullable = false, length = 100)
    private String lastname;
    @Column(nullable = false, length = 100)
    private String email;

    public Candidate() {

    }
    public Candidate (int id, String firstname, String lastname, String email){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }


    @ManyToMany
    @JoinTable (name = "poolsHasCandidates",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "pools_id") )

    private List<Pools> candidateInPools;

    @OneToOne
//    @JoinColumn(name = "images_id", referencedColumnName = "id")
    private Images images;

    /**
     * Establishes a many-to-one relationship between this candidate and a group.
     * The foreign key column used in the database table for this relationship is 'groupgandidate_id'.
     */
    @ManyToOne
    @JoinColumn(name = "groupgandidate_id")
    private GroupCandidate groupcandidate;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
