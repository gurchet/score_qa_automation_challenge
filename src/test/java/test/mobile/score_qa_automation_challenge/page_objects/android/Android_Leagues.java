package test.mobile.score_qa_automation_challenge.page_objects.android;

import org.openqa.selenium.By;
import test.mobile.score_qa_automation_challenge.page_objects.common.Leagues;

import java.util.concurrent.TimeUnit;

public class Android_Leagues extends Leagues {

    By titleText = By.id("com.fivemobile.thescore:id/title_onboarding");

    By chipsElements = By.xpath("//*[@resource-id='com.fivemobile.thescore:id/chips_container']//android.view.ViewGroup");

    By btn_allow = By.id("com.fivemobile.thescore:id/btn_allow");
    By btn_permission_allow = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");

    By btnContinue = By.xpath("//*[@text='Continue']");

    By btnBack = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");

    public Android_Leagues(){
        super();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Override
    public String getScreenTitle() {
        return getText(titleText);
    }

    @Override
    public void navigateBack() {
        click(btnBack);
    }

    @Override
    public void selectLeague(String leagueCode) {
        click(By.xpath("//android.widget.TextView[contains(@text,'"+leagueCode+"')]"));
    }

    @Override
    public boolean isLeagueSelected(String leagueCode) {
        return isElementPresent(By.xpath("//*[@resource-id='com.fivemobile.thescore:id/chips_container']//android.widget.TextView[contains(@text,'"+leagueCode+"')]"));
    }

    @Override
    public int getTotalLeaguesSelected() {
        return getTotalMatchedNoOfElements(chipsElements) - 1;
    }

    @Override
    public void continueNext() {
        click(btnContinue);
        handleLocationPopUp();
    }

    public void handleLocationPopUp(){
        if(isElementPresent(btn_allow)){
            click(btn_allow);
            click(btn_permission_allow);
        }else if(isElementPresent(btn_permission_allow)){
            click(btn_permission_allow);
        }else{
            return;
        }

    }

}
