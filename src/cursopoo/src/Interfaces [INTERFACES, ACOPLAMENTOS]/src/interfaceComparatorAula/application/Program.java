package src.interfaceComparatorAula.application;

import src.interfaceComparatorAula.entities.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        String path = "C:\\Users\\Administrator\\Downloads\\teste";
        String inCsvArchive = "\\testetexto.txt";
        String outCsvArchive = "\\saidateste2.txt";

        try{
            List<Employee> employeeList = EmployeeReader(path, inCsvArchive);
            EmployeeWriter(path, outCsvArchive, employeeList);
        } catch (FileException e){
            System.out.println();
            System.out.println(e.getMessage());
        }

    }

    public static List<Employee> EmployeeReader(String path, String in){
        List<Employee> employeeList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path+in))){
            String lineEmployeeCsv = br.readLine();
            while (lineEmployeeCsv != null){
                String[] field = lineEmployeeCsv.split(",");
                String[] nome = field[0].split(" ");
                employeeList.add(new Employee(nome[0], nome[1], Double.parseDouble(field[1])));
                lineEmployeeCsv = br.readLine();
            }
        } catch (IOException | FileException e) {
            throw new FileException("Error in read the archive.");
        }
    return employeeList;
    }

    public static void EmployeeWriter(String path, String out, List<Employee> employeeList){
        Collections.sort(employeeList);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path+out))){
            for (Employee employee : employeeList){
                bw.write(employee.getName() + " " + employee.getLastname() + "," + employee.getSalary());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new FileException("Error in writer the employees in out archive.");
        }
    }

}



