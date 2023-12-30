package com.bway.springsecondproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="categories_tbl")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String categoryName;
	
}
