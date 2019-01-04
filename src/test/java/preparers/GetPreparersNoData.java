package preparers;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.PreparersSteps;


@WithTags(
        {
                @WithTag(type = "Preparers", name = "All"),
                @WithTag(type = "Preparers", name = "Negative"),
                @WithTag(type = "Suite", name = "Negative"),

        }
)

@RunWith(SerenityRunner.class)
public class GetPreparersNoData {

    @Steps
    PreparersSteps preparersSteps;

    @Title("CVSB-579 / CVSB-743 - AC2 - The preparers IDs are not retrieved")
    @Test
    public void preparersNoData() {
        preparersSteps.getPreparersWithNoData();
        preparersSteps.statusCodeShouldBe(404);
        preparersSteps.validateData("Preparers not found");
    }


}

