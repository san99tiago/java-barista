// Santiago Garcia Arango

package com.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

/*
 * "@Configuration" tag will allow us to create the necessary settings that we...
 * ... used to create in the "applicationContext.xml" file.
 * "@ComponentScan(<...>)" tag is the base-package name to check project.
 * "@PropertySource(<...>)" tag is to find extra files for properties injection.
 */

@Configuration
@ComponentScan("com.annotations")
@PropertySource("classpath:com/annotations/extraData.txt")
public class ConfigEmployees {

	@Value("${designer_area:Design}")
	private String designersArea;

	@Value("${designer1: , , ,}")
	private String designerInfo1;
	
	@Value("${direction_area:Direction}")
	private String directorsArea;

	@Value("${director1: , , ,}")
	private String directorInfo1;

	@Bean
	@Scope("prototype")
	public Designer designer() {
		// Initialize object
		Designer createdDesigner = new Designer();

		// Get info from extraData.txt that loaded values
		String[] designerParams = designerInfo1.split(",", 5);

		// Apply setters for the important values
		createdDesigner.setArea(designersArea);
		createdDesigner.setName(designerParams[0]);
		createdDesigner.setSex(designerParams[1]);
		createdDesigner.setSalary(Double.parseDouble(designerParams[2]));
		createdDesigner.setJobEndsOn(designerParams[3]);
		createdDesigner.setMainDesignTool(designerParams[4]);

		return createdDesigner;
	}
	
	@Bean
	public Director director() {
		// Initialize object
		Director createdDirector = new Director();
		
		// Get info from extraData.txt that loaded values
		String[] directorParams = directorInfo1.split(",", 5);
		
		// Apply setters for the important values
		createdDirector.setArea(directorsArea);
		createdDirector.setName(directorParams[0]);
		createdDirector.setSex(directorParams[1]);
		createdDirector.setSalary(Double.parseDouble(directorParams[2]));
		createdDirector.setJobEndsOn(directorParams[3]);
		createdDirector.setMainAbility(directorParams[4]);
		
		return createdDirector;
	}
}
