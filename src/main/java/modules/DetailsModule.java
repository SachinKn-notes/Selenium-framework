package modules;

import io.restassured.path.json.JsonPath;
import libs.WebDriverActions;
import modules.Pages.DetailsPage;
import modules.Pages.NewDetailsPage;
import modules.Pages.OldDetailsPage;
import objects.PackageObject;

public class DetailsModule {
    WebDriverActions actions;
    DetailsPage detailsPage;


    public DetailsModule(WebDriverActions actions) {
        this.actions = actions;
    }
    public void initiatePageReference(PackageObject packageObject){
        if (packageObject.getSiid()==130386)
            detailsPage = new NewDetailsPage(actions);
        else if (packageObject.getSiid()==130385)
            detailsPage= new OldDetailsPage(actions);
    }

    public void waitForPageToLoad(PackageObject packageObject){
        initiatePageReference(packageObject);
        detailsPage.waitForPageToLoad();
    }

    public void FillDetailsPageParameters(JsonPath jsonPath){
        detailsPage.fillDetailsPageParameters(jsonPath);
    }

    public void ConfirmLandOnCategoryPage(){
        detailsPage.confirmLandOnCategoryPage();
    }


}
