package test;
import org.junit.Test;
import static org.junit.Assert.*;
import model.Reports;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.List;

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

    }

    @Test
    public void setstestOfTheClassReports(){
    }

    @Test
    public void histogramGeneratorTest(){


    }

    @Test
    public void exceptionOfHistogramGeneratorTest(){

    }

    @Test
    public void statesIndicatorReportsTest(){

    }

    @Test
    public void exceptionOfStatesIndicatorReports(){

    }
    @Test
    public void listIndicatorReportsTest(){

    }
    @Test
    public void exceptionOfListIndicatorReportsTest(){

    }

}
