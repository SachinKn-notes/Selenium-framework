package modules;

import libs.WebDriverActions;
import modules.Pages.CategoryPage;
import modules.Pages.NewCategoryPage;
import modules.Pages.OldCategoryPage;
import objects.PackageObject;

public class CategoryModule {
    WebDriverActions actions;
    CategoryPage categoryPage;

    public  CategoryModule(WebDriverActions actions) {
        this.actions = actions;
    }

    public  void initiatePageReference(PackageObject packageObject){
        if (packageObject.getSiid() == 130386)
            categoryPage = new NewCategoryPage(actions);
        else if (packageObject.getSiid() == 130385)
            categoryPage = new OldCategoryPage(actions);
    }

    public void waitForPageToLoad(PackageObject packageObject){
        initiatePageReference(packageObject);
        categoryPage.waitFoePageToLoad();
    }

    public void clickBookButton(){
        categoryPage.clickBookButton();
    }

    public void confirmLandOnCabinPage(){
        categoryPage.confirmLandedOnCabinPage();
    }
}
