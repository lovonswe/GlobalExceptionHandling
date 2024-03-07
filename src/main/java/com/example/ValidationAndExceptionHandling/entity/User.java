package com.example.ValidationAndExceptionHandling.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user_table")
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private String nationality;
    private int age;
}

//
//Caused by: org.h2.jdbc.JdbcSQLSyntaxErrorException: Syntax error in SQL statement "drop table if exists [*]user cascade "; expected "identifier"; SQL statement:
//
//here  is my .yml file :
//spring:
//h2:
//console:
//enabled: true
//datasource:
//url: jdbc:h2:mem:testdb
//        ChatGPT
//The error you're encountering is likely due to the use of the reserved keyword "user" as a table name in your SQL statements. "User" is a reserved keyword in many SQL databases, including H2.
//
//To resolve this issue, you can either change the table name to something other than a reserved keyword, or you can use backticks (`) to escape the reserved keyword in your SQL statements. Here's how you can modify your SQL statement:
//
//sql
//Copy code
//drop table if exists `user` cascade;
//By using backticks around the table name "user", you're telling the database engine to treat it as a literal identifier rather than a reserved keyword.
//
//Additionally, you may want to consider renaming your table to avoid using reserved keywords altogether, as it can lead to confusion and potential issues in the future. For example, you could rename the table to something like "app_user" or "customer".
//
//Make sure to update all your SQL statements, including table creation, insertion, selection, and deletion queries, to use the correct table name or escape reserved keywords as needed.