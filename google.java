

import com.Reports.com.utilities.Base;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class google extends Base {

@FindBy(className = "//div[@class='_1kidPb']/span")
WebElement hi;
public void mo() throws InterruptedException {
    List<WebElement> eles=driver.findElements(By.xpath("//div[@class='_1kidPb']/span"));
    for (WebElement ele: eles)
    {
        Actions ac=new Actions(driver);
        ac.moveToElement(ele).build().perform();
        Thread.sleep(1000);

    }
}
    //div[@class='_4rR01T']---iphone name
    //div[@class='_30jeq3 _1_WHN1']---iphone Prize
    //input[@name='q']
    By SearchBox= By.xpath("//input[@name='q']");
By productNames=By.xpath("//div[@class='_4rR01T']");
By ProductPrices=By.xpath("//div[@class='_30jeq3 _1_WHN1']");
    @Test
    public void ain( ) throws InterruptedException, IOException {
        parenttest=extent.createTest("FlipKart");
        List<String>Phone_names=new ArrayList() ;
        List<String>Phone_priz=new ArrayList() ;
       /* System.setProperty("webdriver.chrome.driver","G:\\al  type\\firstMaven\\chromedriver.exe");
        WebDriver  driver=new ChromeDriver();*/
      // FileInputStream fis=new FileInputStream("C:\\Users\\phani\\Desktop\\test_cases.xlsx");
//       Workbook w1 = WorkbookFactory.create(fis);
        driver.get("https://www.flipkart.com/electronics-best-offers-store?fm=neo%2Fmerchandising&iid=M_96811cf5-8598-4dd7-90de-209c74ed39c3_1_372UD5BXDFYS_MC.KV8NA7Z3WYHI&otracker=hp_rich_navigation_1_1.navigationCard.RICH_NAVIGATION_Electronics~Audio_KV8NA7Z3WYHI&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_1_L1_view-all&cid=KV8NA7Z3WYHI");
      driver.manage().window().maximize();
        //Thread.sleep(4000);
//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
    Thread.sleep(4000);
    driver.findElement(SearchBox).sendKeys("Iphone");
    driver.findElement(SearchBox).sendKeys(Keys.ENTER);
    Thread.sleep(60000);//samsung mobiles

List<WebElement>PNs=driver.findElements(productNames);

        List<WebElement>PPs=driver.findElements(ProductPrices);


        Thread.sleep(8000);

        for (WebElement PN:PNs)
        {
            int r1=1;
          String s=PN.getText();
            Phone_names.add(s);

           // w1.getSheetAt(2).getRow(r1).getCell(1).setCellValue(s);
            r1++;
            driver.switchTo().activeElement().sendKeys(Keys.TAB);
        }
        System.out.println(Phone_names.size()+"  Phone_names.size()");
        for (WebElement PP:PPs)
        {
            int r2=1;
            String s=PP.getText();
            Phone_priz.add(s);

           // w1.getSheetAt(2).getRow(r2).getCell(2).setCellValue(s);
            r2++;
        }
        System.out.println(Phone_priz.size()+"  Phone_priz.size()");

      //  FileOutputStream fos=new FileOutputStream("C:\\Users\\phani\\Desktop\\test_cases.xlsx");
      //  w1.write(fos);

        for(int i=0;i<Phone_names.size()-1;i++)
        {
            System.out.println(Phone_names.get(i) +"  :  " +Phone_priz.get(i));

            parenttest.log(Status.INFO,Phone_names.get(i) +"  :  " +Phone_priz.get(i));

        }
        int rowcount=Phone_names.size()+1;
        String [][] twoD=new String[rowcount][2];
        twoD[0][0]="Phone Names";
        twoD[0][1]="Phone Prizes";

        int r1=0;
        for(int i=1;i<=Phone_names.size();i++)
        {
            for(int j=0;j<2;j++)
            {
                if( j==0)
                {
                    twoD[i][j] = Phone_names.get(r1);
                }
                if( j==1)
                {
                    twoD[i][j]= Phone_priz.get(r1);

                }

            }
            if(i>0) {
                r1++;
            }
        }
        parenttest.log(Status.INFO,  MarkupHelper.createTable(twoD));
    }

    @Test
    public void forreport( ) throws InterruptedException, IOException {
        parenttest=extent.createTest("FlipKart");
        List<String>Phone_names=new ArrayList() ;
        List<String>Phone_priz=new ArrayList() ;


        String [][] twoD=new String[5][2];
        Thread.sleep(8000);



       twoD[0][0]="Phone Names";
        twoD[0][1]="Phone Prizes";
int r1=0;
        for(int i=1;i<=Phone_names.size();i++)
        {
            for(int j=0;j<2;j++)
            {
                if( j==0)
                {
                    twoD[i][j] = Phone_names.get(r1);
                }
               if( j==1)
             {
                twoD[i][j]= Phone_priz.get(r1);

            }

        }
            if(i>0) {
                r1++;
            }
    }
     // String [][] twoD={Phone_names.toArray(new String[0]), Phone_priz.toArray(new String[0])};
        parenttest.log(Status.INFO,  MarkupHelper.createTable(twoD));

}
}
