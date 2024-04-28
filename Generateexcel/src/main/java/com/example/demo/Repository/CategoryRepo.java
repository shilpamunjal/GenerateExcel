package com.example.demo.Repository;

import java.lang.System.Logger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category,String>{
	

}
