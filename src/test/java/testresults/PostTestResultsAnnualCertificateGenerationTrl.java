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
                {"First test", "First test", "41", "centre axle drawbar", 1, "pass", 1, "fft1"},
//                {"First test", "First test", "95", "centre axle drawbar", 2, "pass", 1, "fft2"},
//                {"First test", "First test", "95", "centre axle drawbar", 3, "pass", 1, "fft3"},
//                {"First test", "First test", "95", "centre axle drawbar", 4, "pass", 1, "fft4"},
//                {"First test", "First test", "95", "centre axle drawbar", 5, "pass", 1, "fft5"},
//                {"First test", "First test", "95", "centre axle drawbar", 6, "pass", 1, "fft5"},
//                {"First test", "First test", "95", "centre axle drawbar", 7, "pass", 1, "fft5"},
//                {"First test", "First test", "95", "centre axle drawbar", 8, "pass", 1, "fft5"},
//                {"First test", "First test", "95", "centre axle drawbar", 9, "pass", 1, "fft5"},
//                {"First test", "First test", "95", "centre axle drawbar", 10, "pass", 1, "fft5"},
//                {"Paid", "Paid first test retest", "103", "centre axle drawbar", 1, "pass", 1, "rgt1"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 2, "pass", 1, "rgt2"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 3, "pass", 1, "rgt3"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 4, "pass", 1, "rgt4"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 5, "pass", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 6, "pass", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 7, "pass", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 8, "pass", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 9, "pass", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 10, "pass", 1, "rgt5"},
//                {"Part paid", "Part paid first test retest", "104", "centre axle drawbar", 1, "pass", 1, "rit1"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 2, "pass", 1, "rit2"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 3, "pass", 1, "rit3"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 4, "pass", 1, "rit4"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 5, "pass", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 6, "pass", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 7, "pass", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 8, "pass", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 9, "pass", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 10, "pass", 1, "rit5"},
//                {"Free", "Free first test retest", "67", "centre axle drawbar", 3, "pass", 1, "rht"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "119", "centre axle drawbar", 1, "pass", 1, "p7t1"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 2, "pass", 1, "p7t2"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 3, "pass", 1, "p7t3"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 4, "pass", 1, "p7t4"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 5, "pass", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 6, "pass", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 7, "pass", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 8, "pass", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 9, "pass", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 10, "pass", 1, "p7t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "120", "centre axle drawbar", 1, "pass", 1, "p4t1"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 2, "pass", 1, "p4t2"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 3, "pass", 1, "p4t3"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 4, "pass", 1, "p4t4"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 5, "pass", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 6, "pass", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 7, "pass", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 8, "pass", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 9, "pass", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 10, "pass", 1, "p4t5"},
//                {"Annual test", "Annual test", "40", "centre axle drawbar", 1, "pass", 1, "aat1"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 2, "pass", 1, "aat2"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 3, "pass", 1, "aat3"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 4, "pass", 1, "aat4"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 5, "pass", 1, "aat5"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 6, "pass", 1, "aat5"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 7, "pass", 1, "aat5"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 8, "pass", 1, "aat5"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 9, "pass", 1, "aat5"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 10, "pass", 1, "aat5"},
//                {"Paid", "Paid annual test retest", "98", "centre axle drawbar", 1, "pass", 1, "rpt1"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 2, "pass", 1, "rpt2"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 3, "pass", 1, "rpt3"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 4, "pass", 1, "rpt4"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 5, "pass", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 6, "pass", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 7, "pass", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 8, "pass", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 9, "pass", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 10, "pass", 1, "rpt5"},
//                {"Part paid", "Part paid annual test retest", "99", "centre axle drawbar", 1, "pass", 1, "rst1"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 2, "pass", 1, "rst2"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 3, "pass", 1, "rst3"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 4, "pass", 1, "rst4"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 5, "pass", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 6, "pass", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 7, "pass", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 8, "pass", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 9, "pass", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 10, "pass", 1, "rst5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "107", "centre axle drawbar", 1, "pass", 1, "p1t1"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 2, "pass", 1, "p1t2"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 3, "pass", 1, "p1t3"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 4, "pass", 1, "p1t4"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 5, "pass", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 6, "pass", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 7, "pass", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 8, "pass", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 9, "pass", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "113", "centre axle drawbar", 1, "pass", 1, "p3t1"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 2, "pass", 1, "p3t2"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 3, "pass", 1, "p3t3"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 4, "pass", 1, "p3t4"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 5, "pass", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 6, "pass", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 7, "pass", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 8, "pass", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 9, "pass", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 10, "pass", 1, "p3t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "116", "centre axle drawbar", 1, "pass", 1, "p6t1"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 2, "pass", 1, "p6t2"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 3, "pass", 1, "p6t3"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 4, "pass", 1, "p6t4"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 5, "pass", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 6, "pass", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 7, "pass", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 8, "pass", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 9, "pass", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 10, "pass", 1, "p6t5"},
//
//                {"First test", "First test", "41", "centre axle drawbar", 1, "prs", 1, "fft1"},
//                {"First test", "First test", "95", "centre axle drawbar", 2, "prs", 1, "fft2"},
//                {"First test", "First test", "95", "centre axle drawbar", 3, "prs", 1, "fft3"},
//                {"First test", "First test", "95", "centre axle drawbar", 4, "prs", 1, "fft4"},
//                {"First test", "First test", "95", "centre axle drawbar", 5, "prs", 1, "fft5"},
//                {"First test", "First test", "95", "centre axle drawbar", 6, "prs", 1, "fft5"},
//                {"First test", "First test", "95", "centre axle drawbar", 7, "prs", 1, "fft5"},
//                {"First test", "First test", "95", "centre axle drawbar", 8, "prs", 1, "fft5"},
//                {"First test", "First test", "95", "centre axle drawbar", 9, "prs", 1, "fft5"},
//                {"First test", "First test", "95", "centre axle drawbar", 10, "prs", 1, "fft5"},
//                {"Paid", "Paid first test retest", "103", "centre axle drawbar", 1, "prs", 1, "rgt1"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 2, "prs", 1, "rgt2"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 3, "prs", 1, "rgt3"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 4, "prs", 1, "rgt4"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 5, "prs", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 6, "prs", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 7, "prs", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 8, "prs", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 9, "prs", 1, "rgt5"},
//                {"Paid", "Paid first test retest", "65", "centre axle drawbar", 10, "prs", 1, "rgt5"},
//                {"Part paid", "Part paid first test retest", "104", "centre axle drawbar", 1, "prs", 1, "rit1"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 2, "prs", 1, "rit2"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 3, "prs", 1, "rit3"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 4, "prs", 1, "rit4"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 5, "prs", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 6, "prs", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 7, "prs", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 8, "prs", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 9, "prs", 1, "rit5"},
//                {"Part paid", "Part paid first test retest", "66", "centre axle drawbar", 10, "prs", 1, "rit5"},
//                {"Free", "Free first test retest", "67", "centre axle drawbar", 3, "prs", 1, "rht"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "119", "centre axle drawbar", 1, "prs", 1, "p7t1"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 2, "prs", 1, "p7t2"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 3, "prs", 1, "p7t3"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 4, "prs", 1, "p7t4"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 5, "prs", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 6, "prs", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 7, "prs", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 8, "prs", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 9, "prs", 1, "p7t5"},
//                {"Full Inspection/ Fee - With certification", "Paid prohibition clearance on first test (full inspection with certification)", "82", "centre axle drawbar", 10, "prs", 1, "p7t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "120", "centre axle drawbar", 1, "prs", 1, "p4t1"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 2, "prs", 1, "p4t2"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 3, "prs", 1, "p4t3"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 4, "prs", 1, "p4t4"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 5, "prs", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 6, "prs", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 7, "prs", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 8, "prs", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 9, "prs", 1, "p4t5"},
//                {"Retest - Paid", "Paid retest prohibition clearance on first test", "83", "centre axle drawbar", 10, "prs", 1, "p4t5"},
//                {"Annual test", "Annual test", "40", "centre axle drawbar", 1, "prs", 1, "aat1"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 2, "prs", 1, "aat2"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 3, "prs", 1, "aat3"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 4, "prs", 1, "aat4"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 5, "prs", 1, "aat5"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 6, "prs", 1, "aat5"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 7, "prs", 1, "aat5"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 8, "prs", 1, "aat5"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 9, "prs", 1, "aat5"},
//                {"Annual test", "Annual test", "94", "centre axle drawbar", 10, "prs", 1, "aat5"},
//                {"Paid", "Paid annual test retest", "98", "centre axle drawbar", 1, "prs", 1, "rpt1"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 2, "prs", 1, "rpt2"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 3, "prs", 1, "rpt3"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 4, "prs", 1, "rpt4"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 5, "prs", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 6, "prs", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 7, "prs", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 8, "prs", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 9, "prs", 1, "rpt5"},
//                {"Paid", "Paid annual test retest", "53", "centre axle drawbar", 10, "prs", 1, "rpt5"},
//                {"Part paid", "Part paid annual test retest", "99", "centre axle drawbar", 1, "prs", 1, "rst1"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 2, "prs", 1, "rst2"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 3, "prs", 1, "rst3"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 4, "prs", 1, "rst4"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 5, "prs", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 6, "prs", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 7, "prs", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 8, "prs", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 9, "prs", 1, "rst5"},
//                {"Part paid", "Part paid annual test retest", "54", "centre axle drawbar", 10, "prs", 1, "rst5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "107", "centre axle drawbar", 1, "prs", 1, "p1t1"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 2, "prs", 1, "p1t2"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 3, "prs", 1, "p1t3"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 4, "prs", 1, "p1t4"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 5, "prs", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 6, "prs", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 7, "prs", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 8, "prs", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (full inspection with certification)", "70", "centre axle drawbar", 9, "prs", 1, "p1t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "113", "centre axle drawbar", 1, "prs", 1, "p3t1"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 2, "prs", 1, "p3t2"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 3, "prs", 1, "p3t3"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 4, "prs", 1, "p3t4"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 5, "prs", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 6, "prs", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 7, "prs", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 8, "prs", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 9, "prs", 1, "p3t5"},
//                {"With certification", "Paid prohibition clearance (retest with certification)", "76", "centre axle drawbar", 10, "prs", 1, "p3t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "116", "centre axle drawbar", 1, "prs", 1, "p6t1"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 2, "prs", 1, "p6t2"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 3, "prs", 1, "p6t3"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 4, "prs", 1, "p6t4"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 5, "prs", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 6, "prs", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 7, "prs", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 8, "prs", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 9, "prs", 1, "p6t5"},
//                {"With certification", "Part paid prohibition clearance (retest with certification)", "79", "centre axle drawbar", 10, "prs", 1, "p6t5"},

        });
    }

    private String name;
    private String testTypeName;
    private String testTypeId;
    private String vehicleConfiguration;
    private int noOfAxles;
    private String testResult;
    private String testCode;

    public PostTestResultsAnnualCertificateGenerationTrl(String name, String testTypeName, String testTypeId, String vehicleConfiguration, int noOfAxles, String testResult, String testCode) {
        this.name = name;
        this.testTypeName = testTypeName;
        this.testTypeId = testTypeId;
        this.vehicleConfiguration = vehicleConfiguration;
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
        JsonPathAlteration alterationVehicleConfiguration = new JsonPathAlteration("$.vehicleConfiguration", vehicleConfiguration,"","REPLACE");

        // Collate the list of alterations.
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationVin,
                alterationTestResultId,
                alterationTestName,
                alterationTestTypeId,
                alterationTestTypeName,
                alterationNoOfAxles,
                alterationVehicleConfiguration,
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
