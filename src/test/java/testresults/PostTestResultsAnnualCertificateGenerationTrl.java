package testresults;

import data.GenericData;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestResultsSteps;
import util.JsonPathAlteration;

import java.util.*;

@RunWith(SerenityParameterizedRunner.class)
public class PostTestResultsAnnualCertificateGenerationTrl {

    @Steps
    TestResultsSteps testResultsSteps;

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"First test", "First test", "41", 1, "pass", 1, "fft1"},
//                {"First test", "First test", "95", 2, "pass", 1, "fft2"},
//                {"First test", "First test", "95", 3, "pass", 1, "fft3"},
//                {"First test", "First test", "95", 4, "pass", 1, "fft4"},
//                {"First test", "First test", "95", 5, "pass", 1, "fft5"},
//                {"First test", "First test", "95", 6, "pass", 1, "fft5"},
//                {"First test", "First test", "95", 7, "pass", 1, "fft5"},
//                {"First test", "First test", "95", 8, "pass", 1, "fft5"},
//                {"First test", "First test", "95", 9, "pass", 1, "fft5"},
//                {"First test", "First test", "95", 10, "pass", 1, "fft5"},
//                {"Paid", "Paid first test retest", "103", 1, "pass", 1, "rgt1"},
//                {"Paid", "Paid first test retest", "65", 2, "pass", 1, "rgt2"},
//                {"Paid", "Paid first test retest", "65", 3, "pass", 1, "rgt3"},
//                {"Paid", "Paid first test retest", "65", 4, "pass", 1, "rgt4"},
//                {"Paid", "Paid first test retest", "65", 5, "pass", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", 6, "pass", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", 7, "pass", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", 8, "pass", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", 9, "pass", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", 10, "pass", 1, "rgt5"},
//                {"Part paid", "Part paid first test retest", "104", 1, "pass", 1, "rit1"},
//                {"Part paid", "Part paid first test retest", "66", 2, "pass", 1, "rit2"},
//                {"Part paid", "Part paid first test retest", "66", 3, "pass", 1, "rit3"},
//                {"Part paid", "Part paid first test retest", "66", 4, "pass", 1, "rit4"},
//                {"Part paid", "Part paid first test retest", "66", 5, "pass", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", 6, "pass", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", 7, "pass", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", 8, "pass", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", 9, "pass", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", 10, "pass", 1, "rit5"},
//                {"Free", "Free first test retest", "67", 3, "pass", 1, "rht"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "119", 1, "pass", 1, "p7t1"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 2, "pass", 1, "p7t2"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 3, "pass", 1, "p7t3"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 4, "pass", 1, "p7t4"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 5, "pass", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 6, "pass", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 7, "pass", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 8, "pass", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 9, "pass", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 10, "pass", 1, "p7t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "120", 1, "pass", 1, "p4t1"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 2, "pass", 1, "p4t2"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 3, "pass", 1, "p4t3"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 4, "pass", 1, "p4t4"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 5, "pass", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 6, "pass", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 7, "pass", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 8, "pass", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 9, "pass", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 10, "pass", 1, "p4t5"},
//                {"Annual test", "Annual test", "40", 1, "pass", 1, "aat1"},
//                {"Annual test", "Annual test", "94", 2, "pass", 1, "aat2"},
//                {"Annual test", "Annual test", "94", 3, "pass", 1, "aat3"},
//                {"Annual test", "Annual test", "94", 4, "pass", 1, "aat4"},
//                {"Annual test", "Annual test", "94", 5, "pass", 1, "aat5"},
//                {"Annual test", "Annual test", "94", 6, "pass", 1, "aat5"},
//                {"Annual test", "Annual test", "94", 7, "pass", 1, "aat5"},
//                {"Annual test", "Annual test", "94", 8, "pass", 1, "aat5"},
//                {"Annual test", "Annual test", "94", 9, "pass", 1, "aat5"},
//                {"Annual test", "Annual test", "94", 10, "pass", 1, "aat5"},
//                {"Paid", "Paid annual test retest", "98", 1, "pass", 1, "rpt1"},
//                {"Paid", "Paid annual test retest", "53", 2, "pass", 1, "rpt2"},
//                {"Paid", "Paid annual test retest", "53", 3, "pass", 1, "rpt3"},
//                {"Paid", "Paid annual test retest", "53", 4, "pass", 1, "rpt4"},
//                {"Paid", "Paid annual test retest", "53", 5, "pass", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", 6, "pass", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", 7, "pass", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", 8, "pass", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", 9, "pass", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", 10, "pass", 1, "rpt5"},
//                {"Part paid", "Part paid annual test retest", "99", 1, "pass", 1, "rst1"},
//                {"Part paid", "Part paid annual test retest", "54", 2, "pass", 1, "rst2"},
//                {"Part paid", "Part paid annual test retest", "54", 3, "pass", 1, "rst3"},
//                {"Part paid", "Part paid annual test retest", "54", 4, "pass", 1, "rst4"},
//                {"Part paid", "Part paid annual test retest", "54", 5, "pass", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", 6, "pass", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", 7, "pass", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", 8, "pass", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", 9, "pass", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", 10, "pass", 1, "rst5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "107", 1, "pass", 1, "p1t1"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 2, "pass", 1, "p1t2"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 3, "pass", 1, "p1t3"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 4, "pass", 1, "p1t4"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 5, "pass", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 6, "pass", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 7, "pass", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 8, "pass", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 9, "pass", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "113", 1, "pass", 1, "p3t1"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 2, "pass", 1, "p3t2"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 3, "pass", 1, "p3t3"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 4, "pass", 1, "p3t4"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 5, "pass", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 6, "pass", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 7, "pass", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 8, "pass", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 9, "pass", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 10, "pass", 1, "p3t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "116", 1, "pass", 1, "p6t1"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 2, "pass", 1, "p6t2"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 3, "pass", 1, "p6t3"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 4, "pass", 1, "p6t4"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 5, "pass", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 6, "pass", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 7, "pass", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 8, "pass", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 9, "pass", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 10, "pass", 1, "p6t5"},
//
//                {"First test", "First test", "41", 1, "prs", 1, "fft1"},
//                {"First test", "First test", "95", 2, "prs", 1, "fft2"},
//                {"First test", "First test", "95", 3, "prs", 1, "fft3"},
//                {"First test", "First test", "95", 4, "prs", 1, "fft4"},
//                {"First test", "First test", "95", 5, "prs", 1, "fft5"},
//                {"First test", "First test", "95", 6, "prs", 1, "fft5"},
//                {"First test", "First test", "95", 7, "prs", 1, "fft5"},
//                {"First test", "First test", "95", 8, "prs", 1, "fft5"},
//                {"First test", "First test", "95", 9, "prs", 1, "fft5"},
//                {"First test", "First test", "95", 10, "prs", 1, "fft5"},
//                {"Paid", "Paid first test retest", "103", 1, "prs", 1, "rgt1"},
//                {"Paid", "Paid first test retest", "65", 2, "prs", 1, "rgt2"},
//                {"Paid", "Paid first test retest", "65", 3, "prs", 1, "rgt3"},
//                {"Paid", "Paid first test retest", "65", 4, "prs", 1, "rgt4"},
//                {"Paid", "Paid first test retest", "65", 5, "prs", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", 6, "prs", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", 7, "prs", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", 8, "prs", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", 9, "prs", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", 10, "prs", 1, "rgt5"},
//                {"Part paid", "Part paid first test retest", "104", 1, "prs", 1, "rit1"},
//                {"Part paid", "Part paid first test retest", "66", 2, "prs", 1, "rit2"},
//                {"Part paid", "Part paid first test retest", "66", 3, "prs", 1, "rit3"},
//                {"Part paid", "Part paid first test retest", "66", 4, "prs", 1, "rit4"},
//                {"Part paid", "Part paid first test retest", "66", 5, "prs", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", 6, "prs", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", 7, "prs", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", 8, "prs", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", 9, "prs", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", 10, "prs", 1, "rit5"},
//                {"Free", "Free first test retest", "67", 3, "prs", 1, "rht"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "119", 1, "prs", 1, "p7t1"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 2, "prs", 1, "p7t2"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 3, "prs", 1, "p7t3"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 4, "prs", 1, "p7t4"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 5, "prs", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 6, "prs", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 7, "prs", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 8, "prs", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 9, "prs", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", 10, "prs", 1, "p7t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "120", 1, "prs", 1, "p4t1"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 2, "prs", 1, "p4t2"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 3, "prs", 1, "p4t3"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 4, "prs", 1, "p4t4"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 5, "prs", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 6, "prs", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 7, "prs", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 8, "prs", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 9, "prs", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", 10, "prs", 1, "p4t5"},
//                {"Annual test", "Annual test", "40", 1, "prs", 1, "aat1"},
//                {"Annual test", "Annual test", "94", 2, "prs", 1, "aat2"},
//                {"Annual test", "Annual test", "94", 3, "prs", 1, "aat3"},
//                {"Annual test", "Annual test", "94", 4, "prs", 1, "aat4"},
//                {"Annual test", "Annual test", "94", 5, "prs", 1, "aat5"},
//                {"Annual test", "Annual test", "94", 6, "prs", 1, "aat5"},
//                {"Annual test", "Annual test", "94", 7, "prs", 1, "aat5"},
//                {"Annual test", "Annual test", "94", 8, "prs", 1, "aat5"},
//                {"Annual test", "Annual test", "94", 9, "prs", 1, "aat5"},
//                {"Annual test", "Annual test", "94", 10, "prs", 1, "aat5"},
//                {"Paid", "Paid annual test retest", "98", 1, "prs", 1, "rpt1"},
//                {"Paid", "Paid annual test retest", "53", 2, "prs", 1, "rpt2"},
//                {"Paid", "Paid annual test retest", "53", 3, "prs", 1, "rpt3"},
//                {"Paid", "Paid annual test retest", "53", 4, "prs", 1, "rpt4"},
//                {"Paid", "Paid annual test retest", "53", 5, "prs", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", 6, "prs", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", 7, "prs", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", 8, "prs", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", 9, "prs", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", 10, "prs", 1, "rpt5"},
//                {"Part paid", "Part paid annual test retest", "99", 1, "prs", 1, "rst1"},
//                {"Part paid", "Part paid annual test retest", "54", 2, "prs", 1, "rst2"},
//                {"Part paid", "Part paid annual test retest", "54", 3, "prs", 1, "rst3"},
//                {"Part paid", "Part paid annual test retest", "54", 4, "prs", 1, "rst4"},
//                {"Part paid", "Part paid annual test retest", "54", 5, "prs", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", 6, "prs", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", 7, "prs", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", 8, "prs", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", 9, "prs", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", 10, "prs", 1, "rst5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "107", 1, "prs", 1, "p1t1"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 2, "prs", 1, "p1t2"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 3, "prs", 1, "p1t3"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 4, "prs", 1, "p1t4"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 5, "prs", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 6, "prs", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 7, "prs", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 8, "prs", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", 9, "prs", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "113", 1, "prs", 1, "p3t1"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 2, "prs", 1, "p3t2"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 3, "prs", 1, "p3t3"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 4, "prs", 1, "p3t4"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 5, "prs", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 6, "prs", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 7, "prs", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 8, "prs", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 9, "prs", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", 10, "prs", 1, "p3t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "116", 1, "prs", 1, "p6t1"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 2, "prs", 1, "p6t2"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 3, "prs", 1, "p6t3"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 4, "prs", 1, "p6t4"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 5, "prs", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 6, "prs", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 7, "prs", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 8, "prs", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 9, "prs", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", 10, "prs", 1, "p6t5"}

        });
    }

    private String name;
    private String testTypeName;
    private String testTypeId;
    private int noOfAxles;
    private String testResult;
    private String testCode;

    public PostTestResultsAnnualCertificateGenerationTrl(String name, String testTypeName, String testTypeId, int noOfAxles, String testResult, String testCode) {
        this.name = name;
        this.testTypeName = testTypeName;
        this.testTypeId = testTypeId;
        this.noOfAxles = noOfAxles;
        this.testResult = testResult;
        this.testCode = testCode;
    }

    @WithTag("In_Test")
    @Title("CVSB-8798 - Annual certificate is generate for all Trl tests ")
    @Test
    public void testResults_Annual_Certificate_Generation_Trl() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_post_expiry_date_trl_8684.json", "$");

        String randomVin = GenericData.generateRandomVin();
        String randomTestResultId = UUID.randomUUID().toString();


        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", randomVin, "", "REPLACE");
        JsonPathAlteration alterationTestResultId = new JsonPathAlteration("$.testResultId", randomTestResultId, "", "REPLACE");
        JsonPathAlteration alterationTestName = new JsonPathAlteration("$.testTypes[0].name", name,"","REPLACE");
        JsonPathAlteration alterationTestTypeId = new JsonPathAlteration("$.testTypes[0].testTypeId", testTypeId,"","REPLACE");
        JsonPathAlteration alterationTestTypeName = new JsonPathAlteration("$.testTypes[0].testTypeName", testTypeName,"","REPLACE");
        JsonPathAlteration alterationTestResult = new JsonPathAlteration("$.testTypes[0].testResult", testResult,"","REPLACE");
        JsonPathAlteration alterationNoOfAxles = new JsonPathAlteration("$.noOfAxles", noOfAxles,"","REPLACE");

        // Collate the list of alterations.
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationVin,
                alterationTestResultId,
                alterationTestName,
                alterationTestTypeId,
                alterationTestTypeName,
                alterationNoOfAxles,
                alterationTestResult
        ));

        // Post the results, together with any alterations, and verify that they are accepted.
        testResultsSteps.postVehicleTestResultsWithAlterations(testResultRecord, alterations);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        testResultsSteps.getTestResults(randomVin);
        testResultsSteps.statusCodeShouldBe(200);
        testResultsSteps.valueForFieldInPathShouldBe("[0].testTypes[0].testCode", testCode);

        //Verify that the certificate is generated in S3 bucket
        testResultsSteps.validateCertificateIsGenerated(randomTestResultId,randomVin);

    }
}
