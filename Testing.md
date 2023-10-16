# Testing

----

## NutritionalStatesTest


|Name|Class|                                           Scenery                                            |
| :-: | :-: |:------------------------------------------------------------------------------------------------:|
|setUpWeightNormal|NutritionalStates|  [Diagram](https://drive.google.com/file/d/1o_5r5eqwIH03XEkCcFUfoIDXUdQUrhG5/view?usp=sharing)   |
|setUpLowWeight|NutritionalStates| [Diagram](https://drive.google.com/file/d/1mYfrsiFRFBDmsD2NO_IwkZOuML0IHPhA/view?usp=drive_link) |
|setUpOverweight|NutritionalStates|        [Diagram](https://drive.google.com/file/d/1jJFtASEO3u3624BWrFZXudb67v1Hdher/view)         |
|setUpObesity|NutritionalStates|  [Diagram](https://drive.google.com/file/d/13jZ_tH1Ttk1_Xn7L4mpTr2gdIeRReBfT/view?usp=sharing)   |
|setUpMorbidObesity|NutritionalStates|                                           [Diagram](https://drive.google.com/file/d/1GM8a16j-d0axWik71NVq8JRuNXHbKMfR/view?usp=sharing)                                            |

|Objective: Test that all attributes can be obtained correctly|
| :- |


|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|NutritionalStates|Gets\*|setUpWeightNormal|void|All returned values ​​must be equal to the attributes of the NutritionalStates Object|

-------

|Objective: That when the values ​​of the NutrionalStates object are changed, it must return the modified values|
| :- |


|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|NutritionalStates|<p>Sets\*</p><p>Gets\*</p><p></p>|setUpWeightNormal|<p>weight=80</p><p>height=1.75</p><p>date=22-05-2023</p>|All the values ​​that were modified, when the values ​​are returned these must be the changed values|


|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|NutritionalStates|<p>CalculateTypeStates</p><p>calcularteBIM</p><p></p>|setUpWeightNormal|<p>weight=80</p><p>height=1.75</p><p>date=22-05-2023</p>|<p>All the values ​​that were modified, when the values ​​are returned these must be the changed values. Such as the BIM and nutritional status values returned must be equal to:</p><p>BIM=26.1</p><p>Type: Overweight</p>|


-----

|Objective: The BIM data and the type of nutritional status must be returned correctly, according to each category.|
| :- |


|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|NutritionalStates|<p>CalculateTypeStates</p><p>calcularteBIM</p>|setUpWeightNormal|void|<p>The BIM and nutritional status values returned must be equal to:</p><p>BIM=23.9</p><p>Type: Normal Weight</p>|
|NutritionalStates|<p>CalculateTypeStates</p><p>calcularteBIM</p>|setUpLowWeight|void|<p>The BIM and nutritional status values returned must be equal to:</p><p>BIM=17.3</p><p>Type: Low Weight</p>|
|NutritionalStates|<p>CalculateTypeStates</p><p>calcularteBIM</p>|setUpOverweight|void|<p>The BIM and nutritional status values returned must be equal to:</p><p>BIM=26.1</p><p>Type: Overweight</p>|
|NutritionalStates|<p>CalculateTypeStates</p><p>calcularteBIM</p>|setUpObesity|void|<p>The BIM and nutritional status values returned must be equal to:</p><p>BIM=37.0</p><p>Type: Obesity</p>|
|NutritionalStates|<p>CalculateTypeStates</p><p>calcularteBIM</p>|setUpMorbidObesity|void|<p>he BIM and nutritional status values returned must be equal to:</p><p>BIM=37.0</p><p>Type: Morbid Obesity</p>|


## Reports Testing




|Name|Class|Scenery|
| :-: | :-: | :-: |
|setUp1Reports|ReportsTest|<p>-String tittle=”Illustration of quantitative data of nutritional statuses ”</p><p>-String Category[]={low weight, normal, overweight, obesity, morbid obesity}</p><p></p><p>-Object value[]={2,4,7,10,7}</p>|
|setUp2Reports|ReportsTest|<p>-String tittle=” Indicator Student Nutritional States”</p><p>-String Category[]={low weight, normal, overweight, obesity, morbid obesity}</p><p>-value -></p><p>values.add(new ArrayList<>(Arrays.asList("Juan Perez", "Maria Garcia")));</p><p>`        `values.add(new ArrayList<>(Arrays.asList("Carlos Lopez", "Laura Martinez", "Pedro Ramirez")));</p><p>`        `values.add(new ArrayList<>(Arrays.asList("Ana Gonzalez", "Diego Rodriguez", "Luisa Herrera")));</p><p>`        `values.add(new ArrayList<>(Arrays.asList("Sofia Jimenez", "Ricardo Castro", "Elena Diaz")));</p><p>`        `values.add(new ArrayList<>(Arrays.asList("Julia Vargas", "Manuel Soto")));</p><p>`        `values.add(new ArrayList<>(Arrays.asList("Isabella Torres", "Andres Ortiz")));</p><p></p>|

----

|Objective: Test that all attributes can be obtained correctly|
| :- |



|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|ReportsTest|Gets\*|setUp1Reports|void|All returned values ​​must be equal to the attributes of the Reports Object|

----
|Objective: That when the values ​​of the Reports object are changed, it must return the modified values|
| :- |


|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|ReportsTest|<p>Sets\*</p><p>Gets\*</p>|setUp1Reports|void|All the values ​​that were modified, when the values ​​are returned these must be the changed values|

----
|Objective: Verify if the method generates correctly the histogram and that it contains all the values entered, such as the String data category and values as Integers.|
| :- |


|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|ReportsTest|histogramGenerator|setUp1Reports|void|<p>To check that you generated the histogram correctly, you must contain in this form each category and value that you entered. It must also contain the number of histogram bars reflected in the values. </p><p>In this case we will use the String method to search and work with subStrings to verify that it is true.</p><p></p>|


|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|ReportsTest|<p>histogramGenerator</p><p></p>|setUp2Reports|void|It must show an exception that the values are not allowed to generate the histogram, because they are String data and not Integer.|


----

|Objective: The objective of the statesIndicatorReports method, is to correctly generate the text on the categories that are String, and the values that will be Integer. This second one will have the information of the amount of changes of each category, besides in the object value it cannot be a String, because it would answer an exception.|
| :- |


|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|ReportsTest|statesIndicatorReports |setUp1Reports|void|<p>The result is that it should contain the data of the categories and the integer values concerning the changes.</p><p></p><p>In this case we will use the String method to search and work with subStrings to verify that it is true.</p>|


|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|ReportsTest|statesIndicatorReports |setUp2Reports|void|An exception must be pressed because the format does not allow String by Integer, to present the number of changes in the categories.|

----
|Objective: The ListIndicator method should correctly generate a text listing of the changes in the categories (nutritional status) and String values (student data that changed in each category). Therefore, if in values an Integer data is entered, it will generate an exception because it is not in the format of this method.|
| :- |


|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|ReportsTest|listIndicatorReports|setUp2Reports|void|<p>This method must generate the lists with the categories and each String element as well as the String values. With its structure.</p><p>In this case we will use the String method to search and work with subStrings to verify that it is true.</p><p></p>|


|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|ReportsTest|listIndicatorReports|setUp1Reports|void|<p>You must generate an exception for having in values type Integer and not String, to generate the list of category changes (Changes of nutritional status with their respective students).</p><p></p>|


----