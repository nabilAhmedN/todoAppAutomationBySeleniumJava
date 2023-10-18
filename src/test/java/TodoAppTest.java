import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TodoAppTest {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    AndroidDriver<AndroidElement> driver = null;

    @BeforeSuite
    public void Start() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "Honor Play");
        desiredCapabilities.setCapability("appium:automationName", "appium");
        desiredCapabilities.setCapability("appium:appPackage", "com.microsoft.todos");
        desiredCapabilities.setCapability("appium:appActivity", "com.microsoft.todos.ui.LaunchActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    ExtentTest test;
    public void ApplicationPage(ExtentTest test) {
        PageFactory.initElements(driver, this);
        this.test = test;
    }


    @BeforeClass
    public void TodoAppTestReport() {
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Todo App Testing</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
    }

    @Test(priority = 1)

    public void LogIn() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Login Test</b></p>");
        try {

            driver.findElement(By.id("com.microsoft.todos:id/email_phone_edit_text")).sendKeys("nabilahmednahid@gmail.com");
            Thread.sleep(5000);

            driver.findElement(By.id("com.microsoft.todos:id/sign_in_button")).click();
            Thread.sleep(5000);

            driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText").sendKeys("");
            Thread.sleep(5000);

            driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[4]/android.widget.Button").click();
            Thread.sleep(5000);

            driver.findElement(By.id("com.microsoft.todos:id/action_bar_left_action")).click();
            Thread.sleep(5000);
        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>cant not Login</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "Login");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "Login.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.id("com.microsoft.todos:id/email_phone_edit_text")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 2)

    public void AddNewListButton() throws IOException{
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Add new list Button Test</b></p>");
        try {

            driver.findElement(By.id("com.microsoft.todos:id/create_list_text_view")).click();
            Thread.sleep(2000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>AddNewList button is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "AddNewListButton");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "AddNewListButton.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.xpath("com.microsoft.todos:id/create_list_text_view")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority=3)

    public void ListNameField() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>List Name Field Test</b></p>");
        try {

            driver.findElement(By.id("com.microsoft.todos:id/edit_text")).sendKeys("Mobile Automation");
            Thread.sleep(2000);
        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>ListNameField is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "ListNameField");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ListNameField.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.xpath("com.microsoft.todos:id/edit_text")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 4)

    public void ChoosesColor() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>ChoosesColor button Test</b></p>");
        try {

            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Dark rose\"]")).click();
            Thread.sleep(2000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>ChoosesColor button is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "TaskNameField");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "TaskNameField.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Dark rose\"]")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 5)

    public void CreateTask() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>CreateTask Test</b></p>");
        try {

            driver.findElement(By.id("android:id/button1")).click();
            Thread.sleep(2000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>CreateTask is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "TaskNameField");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "TaskNameField.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.id("android:id/button1")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 6)

    public void AddTaskButton() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>AddTask button Test</b></p>");
        try {

            driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Add a task\"]")).click();
            Thread.sleep(2000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>AddTask button is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "AddTaskButton");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "AddTaskButton.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Add a task\"]")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 7)

    public void TaskNameField() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>TaskName Field Test</b></p>");
        try {

            driver.findElement(By.id("com.microsoft.todos:id/create_task_edit_text")).sendKeys("Today's Task");
            Thread.sleep(2000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>AddTask button is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "AddTaskButton");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "AddTaskButton.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.id("com.microsoft.todos:id/create_task_edit_text")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 8)

    public void CreateTaskButton() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>CreateTask Button Test</b></p>");
        try {

            driver.findElement(By.id("com.microsoft.todos:id/create_task_image_button")).click();
            Thread.sleep(2000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>CreateTask button is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "CreateTaskButton");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "CreateTaskButton.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.id("com.microsoft.todos:id/create_task_image_button")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 9)

    public void SelectCreateTaskButton() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>SelectCreateTask Button Test</b></p>");

        try {
            driver.findElement(By.id("com.microsoft.todos:id/background_image")).click();
            Thread.sleep(2000);

            driver.findElement(By.id("com.microsoft.todos:id/task_content")).click();
            Thread.sleep(2000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>CreateTask button is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "CreateTaskButton");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "CreateTaskButton.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Item 1 of 1, task Today's Task, Added to My Day, Has due date\"]")).isEnabled());
            driver.quit();
        }
    }


    @Test(priority = 10)

    public void SelectTaskDescriptionField() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>SelectTaskDescription Field Test</b></p>");

        try {
            driver.findElement(By.id("com.microsoft.todos:id/note_card")).click();
            Thread.sleep(2000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>SelectTaskDescription Field is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "SelectTaskDescriptionField");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectTaskDescriptionField.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.id("com.microsoft.todos:id/note_card")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 11)
    public void WriteTaskDescriptionField() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>WriteTaskDescription Field Test</b></p>");

        try {
            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Italic\"]")).click();
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.EditText")).sendKeys("I have to finished this mobile automation testing ASAP");
            Thread.sleep(2000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>SelectTaskDescription Field is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "SelectTaskDescriptionField");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectTaskDescriptionField.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.id("com.microsoft.todos:id/note_card")).isEnabled());
            driver.quit();
        }
    }


    @Test(priority = 12)

    public void BackMainPage() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>WriteTaskDescription Field  Test</b></p>");

        try {
            driver.findElement(By.id("com.microsoft.todos:id/back")).click();
            Thread.sleep(2000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>WriteTaskDescription Field is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "WriteTaskDescriptionField");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "WriteTaskDescriptionField.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.id("com.microsoft.todos:id/back")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 13)

    public void AddStep() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>WriteTaskDescription Field  Test</b></p>");

        try {
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.ImageView")).click();
            Thread.sleep(1000);

            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.EditText")).sendKeys("Fixed the Automation Error");
            Thread.sleep(1000);

            driver.findElement(By.id("com.microsoft.todos:id/back")).click();

            driver.findElement(By.id("com.microsoft.todos:id/task_content")).click();

            driver.findElement(By.id("com.microsoft.todos:id/add_step_plus_ic")).click();

            driver.findElement(By.id("com.microsoft.todos:id/add_step_title_edit")).sendKeys("Finish the automation task");

            driver.findElement(By.id("com.microsoft.todos:id/back")).click();

            driver.findElement(By.id("com.microsoft.todos:id/task_content")).click();

            driver.findElement(By.id("com.microsoft.todos:id/add_step_plus_ic")).click();

            driver.findElement(By.id("com.microsoft.todos:id/add_step_title_edit")).sendKeys("Submit the assignment");

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>WriteTaskDescription Field is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "WriteTaskDescriptionField");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "WriteTaskDescriptionField.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.id("com.microsoft.todos:id/add_step_title_edit")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 14)

    public void RemindMeButton() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>RemindMe Button Test</b></p>");

        try {
            driver.findElement(By.id("com.microsoft.todos:id/reminder_row")).click();
            Thread.sleep(2000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>RemindMe Button is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "RemindMeButton");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "RemindMeButton.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.id("com.microsoft.todos:id/reminder_row")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 15)

    public void SelectDateAndTimeButton() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>SelectDateAndTime Button Test</b></p>");

        try {
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.LinearLayout")).click();
            Thread.sleep(2000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>SelectDateAndTime Button is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "SelectDateAndTimeButton");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectDateAndTimeButton.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.LinearLayout")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 16)

    public void SetTime() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>SetTime Button Test</b></p>");

        try {
            driver.findElement(By.xpath("//androidx.appcompat.app.a.c[@content-desc=\"Time\"]")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Switch to text input mode for the time input.\"]")).click();
            Thread.sleep(2000);

            AndroidElement timeInput = (AndroidElement) driver.findElementById("android:id/input_hour");
            timeInput.clear();
            timeInput.sendKeys("10");
            Thread.sleep(2000);

            driver.findElement(By.id("android:id/button1")).click();
            Thread.sleep(2000);

            driver.findElement(By.id("android:id/button2")).click();
            Thread.sleep(2000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>SelectDateAndTime Button is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "SelectDateAndTimeButton");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectDateAndTimeButton.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.LinearLayout")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 17)

    public void CompletedSteps() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>CompletedSteps Test</b></p>");

        try {
            driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Uncompleted, Fixed the Automation Error, step, Button\"]/android.widget.ImageView")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Uncompleted, Finish the automation task, step, Button\"]/android.widget.ImageView")).click();
            Thread.sleep(2000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>SelectDateAndTime Button is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "SelectDateAndTimeButton");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectDateAndTimeButton.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.LinearLayout")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 18)

    public void PromoteToTask() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>PromoteToTask Test</b></p>");

        try {
            driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"More Options\"])[3]")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout")).click();
            Thread.sleep(3000);

//            driver.findElement(By.id("com.microsoft.todos:id/back")).click();
        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>SelectDateAndTime Button is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "SelectDateAndTimeButton");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectDateAndTimeButton.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.LinearLayout")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 19)

    public void PriorityOfTask() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>PriorityOfTask Test</b></p>");

        try {
            AndroidElement star = (AndroidElement) driver.findElementByAccessibilityId("Normal task Today's Task, Button");
            star.click();
            Thread.sleep(2000);

            AndroidElement back = (AndroidElement) driver.findElementByAccessibilityId("Dismiss detail view");
            back.click();
            Thread.sleep(3000);
        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>SelectDateAndTime Button is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "SelectDateAndTimeButton");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectDateAndTimeButton.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Normal task Today's Task, Button\"]/android.widget.ImageView")).isEnabled());
            driver.quit();
        }
    }

    @Test(priority = 20)
    public void CompletedTask() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>CompletedTask Test</b></p>");

        try {

            AndroidElement task1 = (AndroidElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Incomplete task Today's Task, Button\"]/android.widget.ImageView");
            task1.click();
            Thread.sleep(2000);

            AndroidElement task2 = (AndroidElement) driver.findElementById("com.microsoft.todos:id/empty_circle");
            task2.click();
            Thread.sleep(2000);
        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>CompletedTask is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "CompletedTask");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "CompletedTask.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Incomplete task Today's Task, Button\"]/android.widget.ImageView")).isEnabled());
            driver.quit();
        }
    }



    @Test(priority = 21)
    public void DeleteSubmitAssignmentTask() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>DeleteSubmitAssignmentTask Test</b></p>");

        try {
            AndroidElement enter = (AndroidElement) driver.findElementByAccessibilityId("Item 1 of 2, Completed task Submit the assignment");
            enter.click();

            AndroidElement delete = (AndroidElement) driver.findElementByAccessibilityId("Delete task");
            delete.click();
            Thread.sleep(1000);

            AndroidElement ConfirmDelete = (AndroidElement) driver.findElementById("android:id/button1");
            ConfirmDelete.click();
            Thread.sleep(1000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>DeleteSubmitAssignmentTask is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "DeleteSubmitAssignmentTask");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "DeleteSubmitAssignmentTask.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.id("com.microsoft.todos:id/delete")).isEnabled());
            driver.quit();
        }
    }


    @Test(priority = 22)
    public void DuplicateAssignmentTask() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>DuplicateAssignmentTask Test</b></p>");

        try {
            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Duplicate list6 in 9\"]/android.widget.LinearLayout")).click();
            Thread.sleep(2000);

            driver.findElement(By.id("android:id/button1")).click();
            Thread.sleep(2000);

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>DeleteSubmitAssignmentTask is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "DeleteSubmitAssignmentTask");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "DeleteSubmitAssignmentTask.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.id("com.microsoft.todos:id/delete")).isEnabled());
            driver.quit();
        }
    }


    @Test(priority = 23)
    public void EditAssignmentTask() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>EditAssignmentTask Test</b></p>");

        try {
            AndroidElement selectTitle = (AndroidElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"My Day, 0 tasks\"]/android.view.View");
            selectTitle.click();
            Thread.sleep(2000);

            AndroidElement clearTitle = (AndroidElement) driver.findElementById("com.microsoft.todos:id/edit_text");
            clearTitle.clear();
            clearTitle.sendKeys("Mobile Automation Duplicate");
            Thread.sleep(2000);

            AndroidElement saveTitle = (AndroidElement) driver.findElementById("android:id/button1");
            saveTitle.click();

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>DeleteSubmitAssignmentTask is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "DeleteSubmitAssignmentTask");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "DeleteSubmitAssignmentTask.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.id("com.microsoft.todos:id/delete")).isEnabled());
            driver.quit();
        }
    }


    @Test(priority = 24)
    public void MyDay() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>MyDay Test</b></p>");

        try {
            AndroidElement backButton = (AndroidElement) driver.findElementByAccessibilityId("Back");
            backButton.click();

            AndroidElement myDay = (AndroidElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"My Day, 0 tasks\"]/android.view.View");
            myDay.click();

        }
        catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>DeleteSubmitAssignmentTask is not working</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(driver, "DeleteSubmitAssignmentTask");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "DeleteSubmitAssignmentTask.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue( driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"My Day, 1 tasks\"]/android.view.View")).isEnabled());
            driver.quit();
        }
    }


    @AfterClass
    public void afterClass() {
        report.flush();
    }

    @AfterSuite
    public void Close() {
        driver.quit();
    }

}



