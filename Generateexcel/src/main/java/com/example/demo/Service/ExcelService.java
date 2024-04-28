package com.example.demo.Service;

import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Model.Category;
import com.example.demo.Repository.CategoryRepo;
import com.example.demo.helper.ConversionExcel;

@Service
public class ExcelService {
	
	@Autowired
	private CategoryRepo repo;
	
	public ByteArrayInputStream getActualData() {
		List<Category> all=repo.findAll();
		for(int i=0;i<all.size();i++) {
		System.out.println("printing list from database fetch in service "+all.get(i).getDescription());}
		ByteArrayInputStream bytes=ConversionExcel.datatoExcel(all);
				return bytes;
	}
	

}
