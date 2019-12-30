package com.dj.boot.student;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("/myfilter")
public class StudentFilter {
	
	@GetMapping("/getFilterSample")
	public FilterSample getFilterSample() {
		
		return new FilterSample("111","name","desc");
	}
	
	//Dynamic Filter
	
	@GetMapping("/getFilterSampleD")
	public MappingJacksonValue getFilterSampleD() {
		
	    //EmployeeVO result = restTemplate.getForObject(uri, EmployeeVO.class, params);
		FilterSample data=new FilterSample("111","name","desc");
		MappingJacksonValue value=new MappingJacksonValue(data);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name","desc");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SampleFilter", filter);
		
		value.setFilters(filters);
				
		return value;
	}

}
