package viosystems.digitaltest.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features"
        , glue = {"coop.coopbank.testAutomation.hybrid.applications.digital" }
        , strict = false
        ,monochrome = true
        //, dryRun = true
)
public class Acceptance {

    @BeforeClass
    public static void junitsetup() {
        System.out.println("@beforeclass");
    }

    @AfterClass
    public static void junitendup() {
        System.out.println("@Afterclass");
        /*
         * File reportOutputDirectory = new File("target/"); List<String>
         * jsonFiles = new ArrayList<>(); jsonFiles.add(
         * "Y:\\Test Automation Solutions\\DigitalRegression\\target\\cucumber-report.json"
         * ); //jsonFiles.add("cucumber-report-2.json");
         *
         * String buildNumber = "1"; String projectName =
         * "Digital Authorization"; boolean runWithJenkins = false;
         *
         * Configuration configuration = new
         * Configuration(reportOutputDirectory, projectName); // optional
         * configuration - check javadoc
         * configuration.setRunWithJenkins(runWithJenkins);
         * configuration.setBuildNumber(buildNumber); // addidtional metadata
         * presented on main page configuration.addClassifications("Platform",
         * "Windows"); configuration.addClassifications("Browser", "Firefox");
         * configuration.addClassifications("Branch", "release/1.0");
         *
         * // optionally add metadata presented on main page via properties file
         * List<String> classificationFiles = new ArrayList<>();
         * //classificationFiles.add("properties-1.properties");
         * //classificationFiles.add("properties-2.properties");
         * configuration.addClassificationFiles(classificationFiles);
         *
         * ReportBuilder reportBuilder = new ReportBuilder(jsonFiles,
         * configuration); Reportable result = reportBuilder.generateReports();
         */

        // CreateReport.generateReportForJsonFiles(new File("target"), Arrays.asList("target/cucumber-report.json"));
    }


}
