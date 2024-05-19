package practice.extentReport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Test_1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./test-output/ExtentReport/AutomationReport.html");
		
		extentSparkReporter.config().setReportName("Automation Report");
		extentSparkReporter.config().setDocumentTitle("Automation test report");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setEncoding("UTF-8");
		extentSparkReporter.config().setCss(new String(new FileInputStream("./src/test/java/practice/extentReport/style.css").readAllBytes()));
		
		ExtentReports extentReports = new ExtentReports();
		
		extentReports.setSystemInfo("User", System.getProperty("user.name"));
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Environment", "Test");
		
		extentReports.attachReporter(extentSparkReporter);
		
		ExtentTest extentTest = extentReports.createTest("Test-1");
//		extentTest.assignAuthor("aventstack");
		
		extentTest.pass(MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
		extentTest.fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
		extentTest.skip(MarkupHelper.createLabel("Test Skipped", ExtentColor.ORANGE));
		extentTest.info(MarkupHelper.createLabel("Test Info", ExtentColor.BLUE));
		
		String json = "{'foo' : 'bar', 'foos' : ['b','a','r'], 'bar' : {'foo':'bar', 'bar':false,'foobar':1234}}";
		extentTest.info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
		
		String[][] tableData = new String[][] {
				{"Name", "Age", "Designation"},
				{"Nagaraj", "55", "Formar"},
				{"Sudha", "50", "House wife"},
				{"Chethan", "25", "Civil Engineer"},
				{"Sachin", "27", "Software Developer"},
				{"Vidya", "26", "House wife"}
		};
		
		extentTest.log(Status.PASS, MarkupHelper.createTable(tableData, "custom-table"));
		extentTest.log(Status.PASS, ReporterUtils.getHtmlTable("Horizontal Table Details", "horizontal-table", tableData));
		extentTest.log(Status.PASS, ReporterUtils.getHtmlTable("Vertical Table Details", "vertical-table", tableData));
		
		try {
			int x = 2 / 0;
		} catch(Exception e) {
			extentTest.log(Status.INFO, e);
		}
		
		ExtentTest logs = extentTest.createNode("logs");
		
		logs.log(Status.INFO, "Test Passed");
		logs.log(Status.INFO, "Test Failed");
		logs.log(Status.INFO, "Test Skipped");
		logs.log(Status.INFO, "Test Info");
		
		extentReports.flush();
		System.out.println("Completed");
		
	}
}


class ReporterUtils {
	public static String getHtmlTable(String tableHeader, String tableType, String[][] tableData) {
		
		String htmlTable = "<table class='custom-table " + tableType + "'>";
		htmlTable += " <caption>" + tableHeader.toUpperCase() + "</caption>";
		
		for (int i=0; i<tableData.length; i++) {
			htmlTable += "<tr>";
			for (int j=0; j<tableData[i].length; j++) {
				htmlTable += "<td>" + tableData[i][j] + "</td>";
			}
			htmlTable += "</tr>";
		}
		
		return htmlTable += "</table>";
		
	}
	
	public static void printAsTable(String[][] data) {
		/*
		  Input:
		  ------
			String[][] data = {
	                {"Type", "Amount", "DueDate"},
	                {"0", "1000.0", "28-Jul-2023 23:59:00"},
	                {"1", "5143.43", "02-Sep-2023 23:59:00"}
	        };

		  Output:
		  -------
			+----------------------------------------------+
			| Type	| Amount       	| DueDate              |
			+----------------------------------------------+
			| 0   	| 1000.0       	| 28-Jul-2023 23:59:00 |
			| 1   	| 5143.4       	| 02-Sep-2023 23:59:00 |
			+----------------------------------------------+

		*/
        List<Integer> wordsLengthsCount = new ArrayList<Integer>(Collections.nCopies(data[0].length, 0));

        for (String[] innerArr : data) {
            for (int j = 0; j < innerArr.length; j++) {
                if (wordsLengthsCount.get(j) < innerArr[j].length())
                    wordsLengthsCount.set(j, innerArr[j].length());
            }
        }

        int total = wordsLengthsCount.stream().reduce(0, Integer::sum) + (data[0].length * 3) - 1;
        String lineSeparator = String.format("+%-" + total + "s+", "").replaceAll(" ", "-");

        for (int i = 0; i < data.length; i++) {
            if (i < 2)
                System.out.println(lineSeparator);
            System.out.print("|");
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf(" %-" + wordsLengthsCount.get(j) + "s |", data[i][j]);
            }
            System.out.println();
            if (i == data.length - 1)
                System.out.print(lineSeparator);
        }
    }
}


