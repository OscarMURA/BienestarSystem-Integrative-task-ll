# Testing: UniApp Test Table

----

## NutritionalStatesTest


|**Name**|**Class**|                                           **Scenery**                                            |
| :-: | :-: |:------------------------------------------------------------------------------------------------:|
|**setUpWeightNormal**|**NutritionalStates**|  [Diagram](https://drive.google.com/file/d/1o_5r5eqwIH03XEkCcFUfoIDXUdQUrhG5/view?usp=sharing)   |
|**setUpLowWeight**|**NutritionalStates**| [Diagram](https://drive.google.com/file/d/1mYfrsiFRFBDmsD2NO_IwkZOuML0IHPhA/view?usp=drive_link) |
|**setUpOverweight**|**NutritionalStates**|        [Diagram](https://drive.google.com/file/d/1jJFtASEO3u3624BWrFZXudb67v1Hdher/view)         |
|**setUpObesity**|**NutritionalStates**|  [Diagram](https://drive.google.com/file/d/13jZ_tH1Ttk1_Xn7L4mpTr2gdIeRReBfT/view?usp=sharing)   |
|**setUpMorbidObesity**|**NutritionalStates**|                                           [Diagram](https://drive.google.com/file/d/1GM8a16j-d0axWik71NVq8JRuNXHbKMfR/view?usp=sharing)                                            |

|**Objective:** Test that all attributes can be obtained correctly|
| :- |


|**Class**|**Method**|**Scenary**|**Input value**|**Result**|
| :-: | :-: | :-: | :-: | :-: |
|NutritionalStates|Gets\*|setUpWeightNormal|void|All returned values ​​must be equal to the attributes of the NutritionalStates Object|

-------

|**Objective:** That when the values ​​of the NutrionalStates object are changed, it must return the modified values|
| :- |


|**Class**|**Method**|**Scenary**|**Input value**|**Result**|
| :-: | :-: | :-: | :-: | :-: |
|NutritionalStates|<p>Sets\*</p><p>Gets\*</p><p></p>|setUpWeightNormal|<p>weight=80</p><p>height=1.75</p><p>date=22-05-2023</p>|All the values ​​that were modified, when the values ​​are returned these must be the changed values|


|**Class**|**Method**|**Scenary**|**Input value**|**Result**|
| :-: | :-: | :-: | :-: | :-: |
|NutritionalStates|<p>CalculateTypeStates</p><p>calcularteBIM</p><p></p>|setUpWeightNormal|<p>weight=80</p><p>height=1.75</p><p>date=22-05-2023</p>|<p>All the values ​​that were modified, when the values ​​are returned these must be the changed values. Such as the BIM and nutritional status values returned must be equal to:</p><p>BIM=26.1</p><p>Type: Overweight</p>|


-----

|**Objective:** The BIM data and the type of nutritional status must be returned correctly, according to each category.|
| :- |


|**Class**|**Method**|**Scenary**|**Input value**|**Result**|
| :-: | :-: | :-: | :-: | :-: |
|NutritionalStates|<p>CalculateTypeStates</p><p>calcularteBIM</p>|setUpWeightNormal|void|<p>The BIM and nutritional status values returned must be equal to:</p><p>BIM=23.9</p><p>Type: Normal Weight</p>|
|NutritionalStates|<p>CalculateTypeStates</p><p>calcularteBIM</p>|setUpLowWeight|void|<p>The BIM and nutritional status values returned must be equal to:</p><p>BIM=17.3</p><p>Type: Low Weight</p>|
|NutritionalStates|<p>CalculateTypeStates</p><p>calcularteBIM</p>|setUpOverweight|void|<p>The BIM and nutritional status values returned must be equal to:</p><p>BIM=26.1</p><p>Type: Overweight</p>|
|NutritionalStates|<p>CalculateTypeStates</p><p>calcularteBIM</p>|setUpObesity|void|<p>The BIM and nutritional status values returned must be equal to:</p><p>BIM=37.0</p><p>Type: Obesity</p>|
|NutritionalStates|<p>CalculateTypeStates</p><p>calcularteBIM</p>|setUpMorbidObesity|void|<p>he BIM and nutritional status values returned must be equal to:</p><p>BIM=37.0</p><p>Type: Morbid Obesity</p>|


