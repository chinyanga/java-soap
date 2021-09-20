package za.co.discovery.assignment.francischinyanaga;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import za.co.discovery.assignment.francischinyanaga.algorithms.ExcelReader;
import za.co.discovery.assignment.francischinyanaga.algorithms.PlanetsGraphGenerator;
import za.co.discovery.assignment.francischinyanaga.models.Planet;
import za.co.discovery.assignment.francischinyanaga.services.PlanetServiceImpl;

@Component
public class DBInitializer implements ApplicationRunner {

	private final PlanetServiceImpl planetService;

	private DBInitializer(PlanetServiceImpl planetService) {
		this.planetService = planetService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
	    planetService.ReadPlanetsFromExcelAndSaveToDb();
		//planetService.addPlanet(new Planet((long) 0, "", "", "", "", (long) 0));
	}
}
