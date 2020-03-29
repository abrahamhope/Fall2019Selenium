package com.automation.tests.vytrack.actvities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.DateTimeUtilities;
import gherkin.lexer.Da;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

public class NewCalendarEventsTests extends AbstractTestBase {

    /**
     * Test Case :Default options
     *
     */

    @Test
    public void defaultOptionsTest (){
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");

        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventsPage.getOwnerName(), calendarEventsPage.getCurrentUserName());
        Assert.assertEquals(calendarEventsPage.getStartDate(), DateTimeUtilities.getCurrentDate("MMM dd, yyyy"));
    }

    @Test
    public void timeDifferenceTest () throws ParseException {
        LoginPage loginPage = new LoginPage();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();

        String startTime=calendarEventsPage.getStartTime();
        String endTime = calendarEventsPage.getEndTime();

        long actual =DateTimeUtilities.getTimeDifference(startTime,endTime,"h:mm a");
        Assert.assertEquals(actual,1);


    }
}
