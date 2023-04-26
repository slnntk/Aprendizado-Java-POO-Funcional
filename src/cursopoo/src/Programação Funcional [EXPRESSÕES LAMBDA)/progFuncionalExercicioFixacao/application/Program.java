package progFuncionalExercicioFixacao.application;

import progFuncionalExercicioFixacao.entities.Employee;
import progFunncionalExercicioResolvido.application.FileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String path = "C:\\Users\\SLNNTK\\Documents\\T";
        String in = "\\PessoaIn.txt";

        List<Employee> employeeList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path+in))){
            String line = br.readLine();
            while (line != null){
                String[] parameters = line.split(",");
                employeeList.add(new Employee(parameters[0], parameters[1], Double.parseDouble(parameters[2])));
                line = br.readLine();
            }
        } catch (FileException | IOException e){
            System.out.println("Error in the read the archive");
        }

        System.out.print("Enter salary to search: ");
        double salary = sc.nextDouble();
        System.out.printf("Email of people whose salary is more than %.2f:%n", salary);
        List<String> emailList = employeeList.stream()
                        .filter(x -> x.getSalary() > 2000.0)
                        .map(x -> x.getEmail()).toList();
        Consumer<String> consumer = (x -> System.out.println(x));
        emailList.forEach(consumer);

        double tot = employeeList.stream()
                        .filter(x -> x.getName().charAt(0) == 'M')
                                .map(x -> x.getSalary())
                                        .reduce(0.0, (x,y) -> x + y);



        System.out.printf("Sum of salary of people whose name starts with 'M': %.2f", tot);


    }
}
