package com.app.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="chef")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Chef extends BaseEntity {
	@Column(name="chef_name")
	private String chefName;
	@Column(name="chef_email")
	private String chefEmail;
	@Column(name="chef_password")
	private String chefPassword;
	@Column(name="chef_image")
	private byte[] chefImage;
	@Column(name="image_path")
	private String imagePath;
	@Column(name="chef_contact")
	private String chefContact;
	@Column(name="chef_availability")
	private boolean chefAvailability;
	@Column(name="chef_experience")
	private int chefExperience;
	@Column(name="chef_age")
	private int chefAge;
	@Enumerated(EnumType.STRING) // col : varchar => enum constant name
	@Column(name="chef_speciality")
	private Speciality chefSpeciality;
	
	
	
	// one to many for chef s reviews and ratings 
	
	@OneToOne(cascade = CascadeType.ALL)
    private RatingAndReviews ratingsAndReviews;
   
//    @ManyToOne
//    @JoinColumn(name = "speciality_id")
//	private Speciality speciality;     //Chef Has-A-Speciality
//	
	
	//If we want one chef has many Speciality
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "chef")
	
	

    //private Set<Speciality> specialities;
	// one to one association chef ----> location
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
	private Location chefLocation;
	
}
