package ro.ccpatrut.beelove.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "slider", schema = "beelove")
@Getter
@Setter
public class SliderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "imagelocation", nullable = false)
    private String imageLocation;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "alt", nullable = false)
    private String alt;

    @Column(name = "description", nullable = false)
    private String description;
}
