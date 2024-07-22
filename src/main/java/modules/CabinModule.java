package modules;

import libs.WebDriverActions;
import modules.Pages.CabinPage;
import modules.Pages.NewCabinPage;
import modules.Pages.OldCabinPage;
import objects.PackageObject;

public class CabinModule {
    WebDriverActions actions;
    CabinPage cabinPage;

    public CabinModule(WebDriverActions actions) {
        this.actions = actions;
    }

    public  void initiatePageReference (PackageObject packageObject){
        if (packageObject.getSiid() == 130386)
            cabinPage = new NewCabinPage(actions);
        else if (packageObject.getSiid() == 130385 )
            cabinPage = new OldCabinPage(actions);

    }

    public void waitForPageToLoad(PackageObject packageObject){
        initiatePageReference(packageObject);
        cabinPage.waitForPageToLoad();}

    public void bookCabin(){cabinPage.bookCabin();}

    public void confirmLandedOnCheckoutPage(){cabinPage.confirmLandedOnCheckoutPage();}

}
