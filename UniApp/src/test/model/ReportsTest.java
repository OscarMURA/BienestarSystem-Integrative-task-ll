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
        reports = new Reports(title, category,  new ArrayList<>(List.of(value)));
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
        reports = new Reports(title, category, values);
    }

    @Test
    public void getsTestOfTheClassReports(){
        setUpScenary1();
    }

    @Test
    public void setstestOfTheClassReports(){
        setUpScenary1();
    }

    @Test
    public void histogramGeneratorTest(){
        setUpScenary1();

    }

    @Test
    public void exceptionOfHistogramGeneratorTest(){
        setUpScenary2();
    }

    @Test
    public void statesIndicatorReportsTest(){
        setUpScenary1();
    }

    @Test
    public void exceptionOfStatesIndicatorReports(){
        setUpScenary2();
    }
    @Test
    public void listIndicatorReportsTest(){
        setUpScenary2();
    }
    @Test
    public void exceptionOfListIndicatorReportsTest(){
        setUpScenary1();
    }

}
