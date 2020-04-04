package com.automation.tests.vytrack.actvities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.DateTimeUtilities;
import gherkin.lexer.Da;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class NewCalendarEventsTests extends AbstractTestBase {
    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
    /**
     * Test Case :Default options
     *
     */

    @Test
    public void defaultOptionsTest (){
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");

        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventsPage.getOwnerName(), calendarEventsPage.getCurrentUserName());
        Assert.assertEquals(calendarEventsPage.getStartDate(), DateTimeUtilities.getCurrentDate("MMM dd, yyyy"));
    }

    @Test
    public void timeDifferenceTest () throws ParseException {


        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();

        String startTime=calendarEventsPage.getStartTime();
        String endTime = calendarEventsPage.getEndTime();

        long actual =DateTimeUtilities.getTimeDifference(startTime,endTime,"h:mm a");
        Assert.assertEquals(actual,1);
    }

    @Test
    public void verifyColumnNamesTest(){
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        List<String> expected = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");
        Assert.assertEquals(calendarEventsPage.getColumnNames(), expected);
    }
    @Test(dataProvider = "calendarEvents")
    public void creaCalendarEventsTask(String title, String description){
        test = report.createTest("Create calendar event");
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.enterCalendarEventTitle(title);
        calendarEventsPage.enterCalendarEventDescription(description);
        calendarEventsPage.clickSaveAndClose();

        Assert.assertEquals(calendarEventsPage.getGeneralInfoDescription(), description);
        Assert.assertEquals(calendarEventsPage.getGeneralInfoTitle(),title);

        test.pass("Calendar event was created successfully");
    }

    @DataProvider
    public Object[][] calendarEvents(){
        return new Object[][]{
                {"Daily stand-up", "Scrum meeting to provide updates"}
        };
    }
}
