# Testing: UniApp Test Table

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
## Collection Testing 


|**Name**|**Class**|**Scenery**|
| :-: | :-: | :-: |
|**setUp1Collection**|**Collection Test**|**ArrayList={1,2,3,4,5,6,7,8,9,10}**|
|**setUp2Collection**|**Collection Test**|**ArrayList={10,9,8,7,6,5,4,3,2,1}**|

----
|**Objective:** That the selectionSort function works in its extreme case and in its best case in the correct way.|
| :- |


|**Class**|**Method**|**Scenary**|**Input value**|**Result**|
| :-: | :-: | :-: | :-: | :-: |
|CollectionTest|selecctionSort|setUp1Collection|void|The arrayList returned must be equal to ArrayList={{1,2,3,4,5,6,7,8,9,10}|
|CollectionTest|selecctionSort|setUp2Collection|void|The arrayList of Integers in this extreme case entered, must be sorted to return an ArrayList with the order of these elements {1,2,3,4,5,6,7,8,9,10}.|

----

|**Objective:** The binaryInsert() function should correctly insert items into an already sorted list in an efficient way.|
| :- |


|**Class**|**Method**|**Scenary**|**Input value**|**Result**|
| :-: | :-: | :-: | :-: | :-: |
|CollectionTest|binaryInsert|setUp1Collection|Add element=4|The arrayList with the inserted elements must return true (added), and the arrayList must be equal to {1,2,3,4,4,5,6,7,8,9,10}.|
|CollectionTest|binaryInsert|setUp2Collection|void|You must return the exception that the ArrayNo is not sorted, so you cannot add a new element.|

----

|**Objective:** The binarySearch() function can correctly find the elements efficiently, as long as the list is sorted.|
| :- |


|**Class**|**Method**|**Scenary**|**Input value**|**Result**|
| :-: | :-: | :-: | :-: | :-: |
|CollectionTest|binarySearch()|setUp1Collection|Search element=4|In the search you must return element 4, to verify that the search was successful..|
|CollectionTest|binarySearch()|setUp2Collection|Search element=4|You must return the exception that the ArrayNo is not sorted, so you cannot search a element.|

---


# File Manager Testing 


|**Name**|**Class**|**Scenery**|
| :-: | :-: | :-: |
|**setUpStudents**|**FileManager Test**|[Diagram](https://drive.google.com/file/d/1F_-4IlHyVATWtZaYP3fGdnFzjvK2qKK6/view?usp=drive_link)|
|setUpIntance|FileManager test|[FileManager.getIntance()](https://drive.google.com/file/d/1OlkmDUVxIlRbM5pxZrVoZKd_VxaPMMK9/view?usp=sharing)|

---

|**Objective:** Check that the singlaton method works correctly, despite the fact that 2 objects of the same class are being tried.|
| :- |

|**Class**|**Method**|**Scenary**|**Input value**|**Result**|
| :-: | :-: | :-: | :-: | :-: |
|**FileManager Test** |getIntance|setUpIntance|Intance1=FileManager.getIntance()|The two objects must be the same because they point to the same reference|

----

|**Objective:** Test that the save method correctly saves the array of students, as long as its nomenclature is correctly written, otherwise it returns an exception because that file type is not accepted in the json save.|
| :- |


|**Class**|**Method**|**Scenary**|**Input value**|**Result**|
| :-: | :-: | :-: | :-: | :-: |
|**FileManager Test**|saveStudents|<p>setUpIntance()</p><p>setUpStudents</p>|--|The system must save correctly and without errors the student data in json format in the assigned path.|
|**FileManager Test**|saveStudents|setUp2Collection|--|The system reports the exception ExceptionFormatFileNotAllowed, because the type of file that was tried to save the student data is not valid.|

----

|<p>**Objective: The objective is that the load method, load the files correctly and in case of loading a file with a different format, throw an exception for invalid format.**</p><p></p>|
| :- |


|**Class**|**Method**|**Scenary**|**Input value**|**Result**|
| :-: | :-: | :-: | :-: | :-: |
|**FileManager Test** t|loadStudent|setUpStudents|---|Student data uploaded to the system must have the same values as the students in the student scenario.|
|**FileManager Test** t|loadStudent|setUpStudents|---|The system must report the exception ExceptionFormatFileNotAllowed, for trying to load a file that is not valid in the json format..|

----

|**Objective:** The system must correctly save the students' data in CSV format without exceptions, in case of errors it is either because of IOexeption or because the format of the saving file is not valid.|
| :- |


|**Class**|**Method**|**Scenary**|**Input value**|**Result**|
| :-: | :-: | :-: | :-: | :-: |
|**FileManager Test** t|saveCSV|setUpStudents|---|The system must be able to save student data in a csv file, as long as the file format is valid, so it should not return IOExcepion errors.|
|**FileManager Test** t|saveCSV|setUpStudents|---|When trying to save student data in CSV format, and the nomenclature is not valid. You must return an exception for invalid file format.|

-----

|**Objective:** In the system the LoadCSV load method should work correctly, but if the load file does not exist or does not load it should return an exception.|
| :- |


|**Class**|**Method**|**Scenary**|**Input value**|**Result**|
| :-: | :-: | :-: | :-: | :-: |
|**FileManager Test** t|loadCSV|setUpStudents|---|The method must correctly load the student data without errors, and the student data must be the same as the setUpStudents data.|
|**FileManager Test** t|loadCSV|setUpStudents|---|When uploading student data and the file is not in CSV format, you must return the error ExceptionFormatFileNotAllowed, due to invalid upload format.|


----

|**Objective:** The system should work correctly the save method of saveFileTXT, when saving String type information, and it should not fail as long as it is a valid format and the file exists.|
| :- |


|**Class**|**Method**|**Scenary**|**Input value**|**Result**|
| :-: | :-: | :-: | :-: | :-: |
|**FileManager Test** t|saveFileTXT|setUpIntance|Massage=”This is a test”|the saveFileTXT method should correctly save the selected information without errors in the process, as long as the save format is valid.|
|**FileManager Test** t|saveFileTXT|setUpIntance|Massage=”This is a test”|When saving the file and it is saved in an invalid .txt format, the ExceptionFormatFileNotAllowed exception must be returned.|

----

|**Objective:** The system should be able to load TXT files correctly, as long as it has the valid format and the file exists.|
| :- |


|**Class**|**Method**|**Scenary**|**Input value**|**Result**|
| :-: | :-: | :-: | :-: | :-: |
|**FileManager Test** t|loadFileTXT|setUpIntance|Massage=”This is a test”|The system must be able to load the file test.txt, and its information must be equal to "This is a test".|
|**FileManager Test** t|loadFileTXT|setUpIntance|Massage=”This is a test”|The system must return an error when loading the data, because the file to load does not have the valid .txt format.|



---

## Student Testing 

-------
|**Name**|**Class**|**Scenery**|
| :-: | :-: | :-: |
|**setUpScenary1**|**Student**|[Diagram](https://drive.google.com/file/d/1ZzVKgOQnFmatmaBywhFGDmoaUrr83Fh2/view?usp=drive_link)|
|setUpScenary2|Student|[Diagram](https://drive.google.com/file/d/1ifBnhDFCUkamgmFEnArMZlqGszDGdUbd/view?usp=drive_link)|

---


|Objective: Test that all attributes can be obtained correctly|
| :- |

|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|StudentTest|Gets\*|SetupScenary1|void|All returned values ​​All returned values ​​must be equal to the attributes of the Student Object|

|Objective:That when a nutritional status value is added, it is correctly added to the student|
| :- |

|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|StudentTest|<p>Sets\*</p><p>Gets\*</p>|SetupScenary1|<p>name="Alice"</p><p>lastname="Smith"</p><p>years=25</p><p>Sex=M</p>
|All the values ​​that were modified, when the values ​​are returned these must be the changed values|
-------
|Objective: That when a nutritional status value is added, it is correctly added to the student|
| :- |

|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|StudentTest|AddNutritionalState|testAddNutritionalState|<p>weight=70</p><p>height=1.75</p><p>date=22-05-2023</p>|The addNutritionalState function works correctly by adding a NutritionalStates object to the list and the list is updated properly. 
|
-------
|Objective: Verify that the toString method of the Student class returns a correct text representation of a student.|
| :- |

|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|StudentTest|testToString|SetupScenary1|-|The result of the student's aggregation is expected to be "Jaime Smith 20 M". |
-------
|Objective: Verify that the compare method of the Student class compares two students based on a specific criterion and returns a correct value indicating the relationship between them.|
| :- |

|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|StudentTest|testCompare|SetupScenary1|-|The result of student 1.compare(student 1, student 2) is less than 0.|
-------
|Objective: Ensure that the methods of the Student class generate a text string in the required formats that contains the student's information and nutritional statuses. This scenario establishes specific dates for nutritional statuses.|
| :- |

|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|StudentTest|verifyDatesCVC|SetupScenary2|-|Expected result: "John;Jaimes;20;A00584485;M;70.0;75.0;1.82;21.1;22.6"|
-------
|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|StudentTest|testFormatList|SetupScenary2|-|Expected result: "Code: A00245865 Name: Alice Smith Age: 30 Sex:F weight:65.0 Height: 1.6 BMI: 25.4"|
-------
|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|StudentTest|testIndicatorList|SetupScenary2|-|Expected result: "Code: A00325486 Name: Bob Johnson Age: 35 Sex:M BIM (Sep)24.2 BIM(Apr)26.0 AverageBMI25.1"|
-------
|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|StudentTest|testAverageBMI|SetupScenary2|-|Expected result: The calculated value of the average BMI (average BMI) coincides with the expected value, with a margin of error of +/- 0.01.|
-------
## BienestarSystem Testing
-------

|**Name**|**Class**|**Scenery**|
| :-: | :-: | :-: |
|**setUpWithStudents**|**BienestarSystem**|[Diagram](https://drive.google.com/file/d/1jfPoIid9A3oKbf1-KbrMcFVDRbXxfFLa/view?usp=drive_link)|
|setUpWithNutritionalState|BienestarSystem|[Diagram](https://drive.google.com/file/d/1jfPoIid9A3oKbf1-KbrMcFVDRbXxfFLa/view?usp=drive_link)|

---
|Objective: These tests verify that a student can be added correctly to the well-beingSystem system. Checks if adding a student is done without errors and if the number of students in the system increases by 1.|
| :- |

|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|BienestarSystem|testAddStudentCorrecty|setUpWithStudents|<p>id:“A00000001”\*</p><p>name: Ana \*</p><p>Last name: Lopez\*</p><p>years: 18\*</p><p>Sex: F\*</p>|It is expected that this test will successfully add a student to the system and that the returned message will be "Student added successfully." The number of students in the system should increase by 1.|
-------
|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|BienestarSystem|testAddStudentAndNoPermitAddIdRepeated|setUpWithStudents|<p>id:“A00000001”\*</p><p>name: Ana \*</p><p>Last name: Lopez\*</p><p>years: 18\*</p><p>Sex: F\*</p>|This test should attempt to add a student with an ID that already exists in the system. The expected result is that a message saying "The id of the student already exists" is issued, and the number of students in the system should not change.|
-------
|Objective: These tests verify that nutritional statuses can be added to a student in the system. It checks if the addition of nutritional states is performed without errors and if the number of nutritional states of the student increases correctly.|
| :- |

|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|BienestarSystem|testAddNutritionalStates|setUpWithStudents|<p>id:“A00000001”*</p><p>Weight: 46,0*</p><p>Height: 1.70*</p><p>date: 2022,08,1*</p><p>-*</p><p>id:“A00000001”*</p><p>Weight: 58,0*</p><p>Height: 1.70*</p><p>date: 2023,04,1*</p>|This test is expected to add nutritional statuses to a student in the system and the message returned is "Nutritional status added correctly.". The number of nutritional statuses for the student should increase.|
-------

|Objective: Tests the behavior of the function that removes students from the system, when an attempt is made to remove a student that does not exist in the system. Checks if an error message is issued and if the number of students in the system does not change.|
| :- |

|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |

|BienestarSystem|testRemovedStutentThatNotExists|setUpWithStudents|Id: “A00000018”|It is expected that this test will attempt to delete a student that does not exist in the system and that the returned message will be "Student not found.". The number of students in the system should not change.|

|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|BienestarSystem|testRemovedStutentThatExists|setUpWithStudents|Id: “A00000001”|This test should attempt to remove a student that exists in the system and the message returned is expected to be "Student removed successfully.". The number of students in the system should decrease by 1.|
-------

|Objective: Tests the student modification function when modifying a student that exists in the system or does not exist in the system.|
| :- |

|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|BienestarSystem|testModifyStudentThatNoExist|setUpWithStudents|<p>id:“A00000018”\*</p><p>name: Ana\*</p><p>Last name: Lopez\*</p><p>years: 22\*</p><p>Sex: F\*</p>|It is expected that this test will attempt to modify a student that does not exist in the system and that the message returned will be "The student with the ID does not exist". The student information should not change.|

|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|BienestarSystem|testModifyStudentThatExist|setUpWithStudents|<p>id:“A00000018”\*</p><p>name: Ana Maria\*</p><p>Last name: Lopez Gonzales\*</p><p>years: 22\*</p><p>Sex: F\*</p>|This test should modify a student that exists in the system and the message returned is expected to indicate the modifications made. The number of students in the system should not change.|
-------
|Objective: Tests the function of modifying students' nutritional statuses in the two months when a student who exists in the system or does not exist in the system is modified.|
| :- |

|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|BienestarSystem|testModifyNutritionalStudentToStudentThatNoExist|setUpWithNutritionalStates|<p>id:“A00000018”\*</p><p>Weight: 46,0\*</p><p>Height: 1.70\*</p><p>date: 2022,08,1\*</p>|It is expected that this test will attempt to modify the nutritional status of a student who does not exist in the system and that the message returned will be "Student not found.".|
-------
|Objective: Tests the function of modifying students' nutritional statuses in the two months when a student who exists in the system or does not exist in the system is modified.|
| :- |

|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|BienestarSystem|testModifyNutritionalAtSeptember|setUpWithNutritionalStates|<p>id:“A00000018”\*</p><p>Weight: 46,0\*</p><p>Height: 1.70\*</p><p>date: 2022,08,1\*</p>|This test should modify a student's nutritional status on a specific date in September and the message returned is expected to be "Nutritional state modified successfully."|

|Class|Method|Scenary|Input value|Result|
| :-: | :-: | :-: | :-: | :-: |
|BienestarSystem|testModifyNutritionalAtAbril|setUpWithNutritionalStates|<p>id:“A00000018”\*</p><p>Weight: 58,0\*</p><p>Height: 1.70\*</p><p>date: 2022,04,1\*</p>|This test is expected to modify a student's nutritional status on a specific date and the message returned is "Nutritional state modified successfully."|

