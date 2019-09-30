package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		 Scanner sc = new Scanner(System.in);
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 System.out.print("Entre comn o nome do departamento ");
		 String departmentName = sc.nextLine();
		 System.out.println("Entre dados do trabalhador ");
		 System.out.print("Nome ");
		 String workerName = sc.nextLine();
		 System.out.print("Nivel ");
		 String workerLevel = sc.nextLine();
		 System.out.print("Salario ");
		 double baseSalary = sc.nextDouble();
		 Worker worker = new Worker (workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		 System.out.print("Quantos contratos tem o trabalhador ? ");
		 int n = sc.nextInt();
		 for (int i=1; i<=n; i++) {
			 System.out.println("Entre contrato #" + i + "data:");
			 System.out.print("Data");
			 Date contractDate = sdf.parse(sc.next());
			 System.out.print("VAlor por hora");
			 double valuePerHour = sc.nextDouble();
			 System.out.print("Duração em horas");
			 int hours = sc.nextInt();
			 HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			 worker.addContract(contract);
		 			 
		 }
		 System.out.println();
		 System.out.print("Entre mes e ano para calcular salario ");
		 String monthAndYear = sc.next();
		 int month = Integer.parseInt(monthAndYear.substring(0, 2));
		 int year = Integer.parseInt(monthAndYear.substring(3));
		 System.out.println("Name" + worker.getName());
		 System.out.println("Departmento " + worker.getDepartment().getName());
		 System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		 
		 
		 sc.close();
	}

}
