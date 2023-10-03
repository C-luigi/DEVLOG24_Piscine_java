package fr.cnalps.projetPiscine.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//    private String imgPath;

    @Lob
    private byte[] image;

//    @OneToOne(mappedBy = "images", cascade = CascadeType.ALL)
//    private Candidate candidate;

    public Images (int id){
        this.id = id;
//        this.imgPath = imgPath;
    }

    public Images() {

    }
}
