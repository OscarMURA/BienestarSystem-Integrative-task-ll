# BIENESTAS SYSTEM AP0 II - TASK 2


[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/n79VROXG)
# TareaIntegradora2-232

# [Table of Content](https://github.com/APO-2/tarea-integradora-2-2023-2-equipo-serio/blob/develop/UniApp%20Requirement.md)

## Integrantes:

- Ricardo Andres Chamorro Martinez  A00399846

- Oscar Stiven Muñoz Ramirez A00399922


[Link del enunciado](https://docs.google.com/document/d/1Hw4UQA-riwi4d3a7AGtKQrOgWnJowk73/edit?usp=sharing&ouid=109415827520879394849&rtpof=true&sd=true)

This Java terminal application is a continuation of the Bienestar Universitario project. It aims to assist in the promotion and prevention efforts of university wellness programs. This second phase of the project expands upon the initial version by introducing new features and improvements, including data management, comprehensive reporting, data persistence, and exception handling.

## Features

### Data Management
- **Student Records**: The application allows for the input, editing, and deletion of student data, which now includes student code, age, name, surname, and height.
- **File Handling**: Adjustments have been made to the reading and writing functionalities for text files, bytecode, and JSON to accommodate the new data structure.

### Reports
- **September 2022 and April 2023 BMI Reports**:
  - **Histogram Mode**: Displays the number of students in categories such as underweight, normal weight, overweight, obesity, and morbid obesity, along with a histogram.
  - **List Mode**: Provides a detailed list of students in each category, sorted by BMI, with options to sort by age or alphabetically by surname and name.
- **Nutritional Status Change Reports**:
  - **Indicator Mode**: Shows the number of students whose nutritional status changed between September 2022 and April 2023.
  - **List Mode**: Provides detailed data on students whose nutritional status changed, sorted by BMI, with options to sort by age or alphabetically by surname and name.

### Data Persistence
- **JSON Serialization**: Ensures data integrity by storing student records in JSON files, allowing data to persist even after the application is closed.
- **Report Exporting**: Reports can be exported as text files (.txt).

### Exception Handling
- The application includes robust exception handling to prevent unexpected states during data entry and report generation. Informative error messages guide users in case of unexpected errors.

## Development Process

### Test-Driven Development (TDD)
- The project follows TDD principles, with tests written before the implementation of features.
- A minimum of 10 commits are required, with each commit accompanied by reports on three quality indicators.


## Deliverables

### Week 11 (15% of the Grade)
- **Requirements + Test Cases + Initial UML Design**:
  - Specify requirements based on the task description.
  - Propose an initial class diagram for the application.
  - Design at least two tests per functionality, focusing solely on the application model (excluding console or user interaction).
  - Report the initial test list using the provided markdown format.

### Directory Structure
- **`doc/`**: 
  - Markdown file with the requirements specification.
  - Image of the initial class diagram.
  - Markdown file with the test design.
- **`src/`**:
  - Initial implementation of the class diagram in the `model` package.
- **`test/`**:
  - Test classes and methods corresponding to the initial test design.

---
