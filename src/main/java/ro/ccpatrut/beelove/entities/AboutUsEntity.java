package ro.ccpatrut.beelove.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "aboutus", schema = "beelove")
@Getter
@Setter
public class AboutUsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "imagelocation", nullable = false)
    private String imgLocation;

    @Column(name = "alt", nullable = false)
    private String alt;

    @Column(name = "subtitle", nullable = false)
    private String subtitle;


    @Column(name = "text", nullable = false)
    private String text;
}
