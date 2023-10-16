|Client  |  University Welfare |
|--|--|
|User| University Welfare Employees |
|Fuctional Requeriments|- FR1.Add Students <br> - FR2.Modify Student Data<br>- FR3.Delete student registration<br>- FR4.Generate BIM Histogram reports<br>- FR5.Generate BIM listing reports<br>- FR6.Generate indicators of changes in nutritional status<br>- FR7.Generate lists of nutritional status changes|
| Context of the Problems | This University Welfare project involves managing data of students from Icesi University and their nutritional status. Information such as student code, age, first name, last name, and height is collected from the students to gather data for a promotion and prevention campaign related to their physical health.<br><br>The system will have functionalities to allow data entry, editing, and deletion of records, and improvements are made to the reports to provide more information about the students' nutritional status. Reports can be displayed in Histogram or List modes, with sorting options in the case of the report showing the number of students per category (underweight, normal weight, overweight, obesity, and morbid obesity). There are also Indicators or List reports with sorting options for students who had a nutritional change from one month to another (Sep 2022 and April 2023).<br><br>Data persistence is achieved through JSON serialization, and exception handling is incorporated to provide a better user experience during interaction with the application and error handling. |
|No-Fuctional Requeriments|RNF9: The application must have data persistence through JSON serialization.<br>-  RNF10: It should be capable of storing product information in files so that the data remains available even after the program is closed.<br>- RNF11: Reports are exported as text files with the ".txt"extension<br>- RNF12: The program must handle exceptions to prevent unexpected states during data entry and report generation.<br>- RNF13: It should provide informative error messages to guide the user in case an unexpected error occurs.|

---

| Indentifier and Name |FR1.Add Students  |
|--|--|
|Summary  | The system must provide users with the ability to add new students to the University Welfare database. To achieve this, the following information will be requested: the student's institutional code, age, gender, full name, and last name, as well as details related to their nutritional status. Initially, the student's height and weight will be required for the dates of September 2022, and subsequently in April 2023, with the purpose of evaluating and recording changes in their nutritional status. |



|Inputs|Output name|DataType|Format|
|--|--|--|--|
| Input|name |String | A character string with a maximum size of 30 is allowed.
|Input |Last name|String|A character string with a maximum size of 30 is allowed.|
|Input|year|int|Integers greater than 13 and less than 100 are allowed|
|Input|id|String|The code allowed by the institution is added|
|Input|Sex|int|Only 3 listed options will be allowed:<br>1. Masculine<br>2. Feminine<br>3. Others|
|Input|weight|double|A minimum value of 25 and maximum 500|
|Input|height|double|A minimum value of 0.3 and maximum of 3.0|


|||
|-|-|
|Result or PostCondition|El software will store student data in memory as long as the institutional code is not repeated. Additionally, it will provide notifications to inform whether the student has been successfully added or if they could not be added due to a repeated institutional code.|

||Output name|DataType|Format|
|--|--|--|--|
|Output | message| String|-A text string with the student message was added or not |
---

| Indentifier and Name |-   FR2.Modify Student Data  |
|--|--|
|Summary  | the system should offer users the ability to modify student data in case an error was made previously. To achieve this, it will allow editing of a student's information by searching for their identification (ID). This way, users will be able to update data such as age(1), gender(2), name(3), and last name(4), as well as data related to nutritional status measurements in September 2022 and April 2023, whether it's weight or height data. Additionally, users will have the freedom to make changes by selecting modification options. |

|Inputs|Output name|DataType|Format|
|--|--|--|--|
| Input|name |String | A character string with a maximum size of 30 is allowed.
|Input |Last name|String|A character string with a maximum size of 30 is allowed.|
|Input|year|int|Integers greater than 13 and less than 100 are allowed|
|Input|id|String|The code allowed by the institution is added|
|Input|Sex|int|Only 3 listed options will be allowed:<br>1. Masculine<br>2. Feminine<br>3. Others|
|Input|weight|double|A minimum value of 25 and maximum 500|
|Input|height|double|A minimum value of 0.3 and maximum of 3.0|

|||
|-|-|
|Resultt or postcondition|The system will search for the user in the database through their ID, and if it cannot find them, it will provide a notification accordingly. Additionally, when the system makes modifications to the student's data, it will display the changes made so that the user can review the updates made to the student's information.|

||Output name|DataType|Format|
|--|--|--|--|
|Output | message| String|-A text string with the student message was modified or not |

---
| Indentifier and Name |-   FR3.Delete student registration  |
|--|--|
|Summary  |The system should be able to delete a student's record. |

|Inputs|Output name|DataType|Format|
|--|--|--|--|
|Input|id|String|The code allowed by the institution is added|

|||
|--|--|
|Resultt or postcondition|El software will search for the student through their ID, and if it doesn't exist in the database, it will notify the absence. However, once the student is found, the system will proceed to delete them from the database, making them inaccessible for future searches as they will no longer be available in the system.|

||Output name|DataType|Format|
|--|--|--|--|
|Output | message| String|-A text string with the student message was removed or not |

---

| Indentifier and Name |-   FR4. Generate BIM Histogram report  |
|--|--|
|Summary  |The system must allow the user to generate a report through two histograms represented in the two months (September 2022 and April 2023). The number of students who are within the possible categories (low weight, normal, overweight, obese and morbidly obese) must be shown, represented in small asterisks (*) that represent the number of a student in that category. |

|Inputs|Output name|DataType|Format|
|--|--|--|--|
|Input| - | - | - |

|||
|--|--|
|Result or postcondition|Se mostrará el histograma con la cantidad de estudiantes por apartado de categoría.|

||Output name|DataType|Format|
|--|--|--|--|
|Output | - | - | - |
---
| Indentifier and Name |-   FR5.Generate BIM listing reports  |
|--|--|
|Summary |The system must allow the user to generate a report through a list of the two months evaluated (September 2022 and April 2023). The list must be shown with the complete data of the students who are within the possible categories (low weight, normal, overweight, obese and morbidly obese). The user will be able to choose how the list order format will be: BMI, alphabetical order or student age. |

|Inputs|Output name|DataType|Format|
|--|--|--|--|
| Inputs | Output name | DataType | Format |
| Input  | orderList   | int      | Numeric character only |
|        |             |          | You can choose only three order options: |
|        |             |          | 1. BMI |
|        |             |          | 2. alphabetical|
|        |             |          | 3. Age |

|||
|--|--|
|Result or postcondition|The list will be displayed with the number of students per category section.|

||Output name|DataType|Format|
|--|--|--|--|
|Output | - |  - | - |
---
| Indentifier and Name |-   FR6.Generate indicators of changes in nutritional status  |
|--|--|
|Summary |The system must allow the user to generate a report through indicators of the number of students whose nutritional status changed. The report, in addition to having the number of students who changed their nutritional status, will have a favorable and unfavorable change section, in the favorable section the number of students who lost weight or gained weight to a normal weight will appear, and in the unfavorable section those students who gained weight or lost weight, both underweight and overweight and obese. |

|Inputs|Output name|DataType|Format|
|--|--|--|--|
|Input| -  | - | - |

|||
|--|--|
|Result or postcondition|The report will be shown by indicators of the number of students who changed their nutritional status by category.|

||Output name|DataType|Format|
|--|--|--|--|
|Output | - |  - | - |
---
| Indentifier and Name |-   FR7. Generate lists of nutritional status changes  |
|--|--|
|Summary |The system must allow the user to generate a report through indicators of the number of students whose nutritional status changed between September 2022 and April 2023. The report, in addition to having the number of students who changed their nutritional status, will show their complete data added. in the registry. On the other hand, the user will be able to choose how the list order format will be: BMI, alphabetical order or age of the student.|

|Inputs|Output name|DataType|Format|
|--|--|--|--|
| Inputs | Output name | DataType | Format |
| Input  | orderList   | int      | Numeric character only |
|        |             |          | You can choose only three order options: |
|        |             |          | 1. BMI |
|        |             |          | 2. alphabetical|
|        |             |          | 3. Age |

|||
|--|--|
|Result or postcondition|The report will be displayed by listing the number of students who changed their nutritional status with their complete data.|

||Output name|DataType|Format|
|--|--|--|--|
|Output | - |  - | - |
---
