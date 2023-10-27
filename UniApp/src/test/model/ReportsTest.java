package test.model;
import org.junit.Test;
import static org.junit.Assert.*;
import model.Reports;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import exceptions.ExceptionFormatOfValueNotAllowed;

public class ReportsTest {

    private Reports reports;

    private void setUpScenary1(){

        String title="Illustration of quantitative data of nutritional statuses ";
        String category[]={"low weight","normal" ,"overweight", "obesity", "morbid obesity"};
        Object value[]={2,4,7,10,7};
        reports = new Reports(title,new ArrayList<>(Arrays.asList(category)), new ArrayList<>(List.of(value)));

    }
    private void setUpScenary2(){
        String title="Illustration of quanlitative data of nutritional statuses ";
        String category[]={"low weight","normal" ,"overweight", "obesity", "morbid obesity"};
        ArrayList<Object> values = new ArrayList<>();
        values.add(new ArrayList<>(Arrays.asList("Juan Perez", "Maria Garcia")));
        values.add(new ArrayList<>(Arrays.asList("Carlos Lopez", "Laura Martinez", "Pedro Ramirez")));
        values.add(new ArrayList<>(Arrays.asList("Ana Gonzalez", "Diego Rodriguez", "Luisa Herrera")));
        values.add(new ArrayList<>(Arrays.asList("Sofia Jimenez", "Ricardo Castro", "Elena Diaz")));
        values.add(new ArrayList<>(Arrays.asList("Julia Vargas", "Manuel Soto")));
        values.add(new ArrayList<>(Arrays.asList("Isabella Torres", "Andres Ortiz")));
        reports = new Reports(title, new ArrayList<>(Arrays.asList(category)), values);
    }

    /**
     * Test of gets testOfTheClassReports method, of class Reports.
     */
    @Test
    public void getsTestOfTheClassReports(){
        setUpScenary1();
        assertEquals(reports.getTitle(),"Illustration of quantitative data of nutritional statuses ");
        assertEquals(reports.getCategory().get(0),"low weight");
        assertEquals(reports.getCategory().get(1),"normal");
        assertEquals(reports.getCategory().get(2),"overweight");
        assertEquals(reports.getCategory().get(3),"obesity");
        assertEquals(reports.getCategory().get(4),"morbid obesity");
        assertEquals(reports.getValues().get(0),2);
        assertEquals(reports.getValues().get(1),4);
        assertEquals(reports.getValues().get(2),7);
        assertEquals(reports.getValues().get(3),10);
        assertEquals(reports.getValues().get(4),7);
        assertEquals(reports.getValues().size(),5);
        assertEquals(reports.getCategory().size(),5);
    }


    /**
     * Test of sets testOfTheClassReports method, of class Reports.
     */
    @Test
    public void setstestOfTheClassReports(){
        setUpScenary1();
        String title="new title of the report";
        String newCategory[]={"new low weight","new normal" ,"new overweight", "new obesity", "new morbid obesity"};
        Object newValue[]={3,5,8,12,9};
        reports.setTitle(title);
        reports.setCategory(new ArrayList<>(Arrays.asList(newCategory)));
        reports.setValues(new ArrayList<>(List.of(newValue)));
        assertEquals(reports.getTitle(),"new title of the report");
        assertEquals(reports.getCategory().get(0),"new low weight");
        assertEquals(reports.getCategory().get(1),"new normal");
        assertEquals(reports.getCategory().get(2),"new overweight");
        assertEquals(reports.getCategory().get(3),"new obesity");
        assertEquals(reports.getCategory().get(4),"new morbid obesity");
        assertEquals(reports.getValues().get(0),3);
        assertEquals(reports.getValues().get(1),5);
        assertEquals(reports.getValues().get(2),8);
        assertEquals(reports.getValues().get(3),12);
        assertEquals(reports.getValues().get(4),9);

    }

    /**
     * This test method checks that all the elements added in your instance are correctly represented in the instogram.
     * represented in the instogram, and verifies that the histogram is generated correctly.
     * to the dimensions of the aggregated values in your instance in your bars.
     */
    @Test
    public void histogramGeneratorTest(){
        setUpScenary1();
        try {
            String histogram = reports.histogramGenerator();
            assertTrue(histogram.contains("Illustration of quantitative data of nutritional statuses "));
            assertTrue(histogram.contains("category low weight:\t2"));
            assertTrue(histogram.contains("category normal:\t4"));
            assertTrue(histogram.contains("category overweight:\t7"));
            assertTrue(histogram.contains("category obesity:\t10"));
            assertTrue(histogram.contains("category morbid obesity:\t7"));
            String bar= "low weight\n██\n██\n";
            assertTrue(histogram.contains(bar));
            bar= "normal\n████\n████\n";
            assertTrue(histogram.contains(bar));
            bar= "overweight\n███████\n███████\n";
            assertTrue(histogram.contains(bar));
            bar= "obesity\n██████████\n██████████\n";
            assertTrue(histogram.contains(bar));
            bar= "morbid obesity\n███████\n███████\n";
            assertTrue(histogram.contains(bar));
        } catch (ExceptionFormatOfValueNotAllowed e) {
            fail();
        }
    }

    /**
     * This test method verifies, that histograms cannot be made when
     * the study variables are qualitative, so it throws the exception ExceptionFormatOfValueAllowed.
     */
    @Test
    public void exceptionOfHistogramGeneratorTest(){
        setUpScenary2();
        try {
            String histogram = reports.histogramGenerator();
            fail();
        } catch (ExceptionFormatOfValueNotAllowed e) {
            assertNotNull(e.getMessage());
        }
    }

    /**
     * This test method checks that all the elements added in your instance are correctly represented in the list.
     * represented in the list, and verifies that the list is generated correctly.
     * to the dimensions of the aggregated values in your instance.
     */
    @Test
    public void statesIndicatorReportsTest(){
        setUpScenary1();
        try {
            String statesIndicator = reports.statesIndicatorReports();
            assertTrue(statesIndicator.contains("Illustration of quantitative data of nutritional statuses "));
            assertTrue(statesIndicator.contains("*Category low weight:\t2"));
            assertTrue(statesIndicator.contains("*Category normal:\t4"));
            assertTrue(statesIndicator.contains("*Category overweight:\t7"));
            assertTrue(statesIndicator.contains("*Category obesity:\t10"));
            assertTrue(statesIndicator.contains("*Category morbid obesity:\t7"));
            assertTrue(statesIndicator.contains("The average of the nutritional states is: 6.0"));

        }catch (ExceptionFormatOfValueNotAllowed e) {
            fail();
        }
    }


    /**
     * This test method verifies, that the list cannot be made when
     * the study variables are quantitative, so it throws the exception ExceptionFormatOfValueAllowed.
     */
    @Test
    public void exceptionOfStatesIndicatorReports(){
        setUpScenary2();
        try {
            String statesIndicator = reports.statesIndicatorReports();
            fail();
        } catch (ExceptionFormatOfValueNotAllowed e) {
            assertNotNull(e.getMessage());
        }
    }

    /**
     * This test method checks that all the elements added in your instance are correctly represented in the list.
     * represented in the list, and verifies that the list is generated correctly.
     * to the dimensions of the aggregated values in your instance.
     */
    @Test
    public void listIndicatorReportsTest(){
        setUpScenary2();
        try {
            String listIndicator = reports.listIndicatorReports();
            assertTrue(listIndicator.contains("Illustration of quanlitative data of nutritional statuses "));
            assertTrue(listIndicator.contains("*Category low weight:\n\tJuan Perez\n\tMaria Garcia"));
            assertTrue(listIndicator.contains("*Category normal:\n\tCarlos Lopez\n\tLaura Martinez\n\tPedro Ramirez"));
            assertTrue(listIndicator.contains("*Category overweight:\n\tAna Gonzalez\n\tDiego Rodriguez\n\tLuisa Herrera"));
            assertTrue(listIndicator.contains("*Category obesity:\n\tSofia Jimenez\n\tRicardo Castro\n\tElena Diaz"));
            assertTrue(listIndicator.contains("*Category morbid obesity:\n\tJulia Vargas\n\tManuel Soto"));

        } catch (ExceptionFormatOfValueNotAllowed e) {
            fail();
        }
    }

    /**
     *This test method, verifies that the exception of listIndicatorReports works.
     *Since in the lists, each category will have a list, so it will be stored in an array,
     * each array of the array will have the listing
     */
    @Test
    public void exceptionOfListIndicatorReportsTest(){
        setUpScenary1();
        try {
            String listIndicator = reports.listIndicatorReports();
            fail();
        } catch (ExceptionFormatOfValueNotAllowed e) {
            assertNotNull(e.getMessage());
        }
    }

}
