package za.co.discovery.assignment.francischinyanaga.algorithms;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import za.co.discovery.assignment.francischinyanaga.models.Planet;

public class ExcelReader {

	public static List<Planet> readPlanetsFromExcelFile(String fileName) {
		try {

			Resource resource = new ClassPathResource(fileName);

			InputStream inputStream = resource.getInputStream();

			Workbook workbook = new XSSFWorkbook(inputStream);

			Sheet planetsSheet = workbook.getSheet("Planets");
			Sheet routesSheet = workbook.getSheet("Routes");

			Iterator<Row> planetRows = planetsSheet.iterator();
			Iterator<Row> routesRows = routesSheet.iterator();

			Map<String, String> planetsMap = new HashMap<>();
			List<Planet> routes = new ArrayList<>();

			// reading planets from sheet 1
			int planetRowNumber = 0;
			System.out.println("Starting");
			while (planetRows.hasNext()) {
				Row row = planetRows.next();
				// skip header
				if (planetRowNumber == 0) {
					planetRowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = row.iterator();
				String planetLetter = "";
				String planetName = "";

				int cellNumber = 0;
				while (cellsInRow.hasNext()) {
					Cell cell = cellsInRow.next();
					switch (cellNumber) {
					case 0:
						planetLetter = cell.getStringCellValue().trim();
						break;
					case 1:
						planetName = cell.getStringCellValue().trim();
						break;
					default:
						break;
					}
					cellNumber++;
				}
				planetsMap.put(planetLetter, planetName);
			}
			System.out.println(planetsMap);

			// reading routes from sheet2
			int planetRoutesNumber = 0;
			while (routesRows.hasNext()) {
				Row row = routesRows.next();
				// skip header
				if (planetRoutesNumber == 0) {
					planetRoutesNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = row.iterator();
				String orgPlanetLetter = "";
				String distPlanetLetter = "";
				double distance = 0;
				int cellNumber = 0;
				while (cellsInRow.hasNext()) {
					Cell cell = cellsInRow.next();
					switch (cellNumber) {
					case 1:
						orgPlanetLetter = cell.getStringCellValue().trim();
						break;
					case 2:
						distPlanetLetter = cell.getStringCellValue().trim();
						break;
					case 3:
						distance = (double) cell.getNumericCellValue();
						break;
					default:
						break;
					}
					cellNumber++;

				}
				if(orgPlanetLetter!="") {
				routes.add(new Planet((long) 0, planetsMap.get(orgPlanetLetter), orgPlanetLetter,
						planetsMap.get(distPlanetLetter), distPlanetLetter, distance));
				}
			}

			workbook.close();
			
			return routes;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}
