package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Entre com os dados da conta");
			System.out.println("number: ");
			int numberAccount = sc.nextInt();
			System.out.println("Nome: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.println("Saldo Inicial: ");
			double balance = sc.nextDouble();
			System.out.println("limite de saque: ");
			double withdraw = sc.nextDouble();
			Account account = new Account(numberAccount, holder, balance, withdraw);
	
			System.out.println();
			System.out.println("Insira o valor para saque: ");
			double value = sc.nextDouble();
		
		
			account.withdraw(value);
			System.out.println("New balance " + account.getBalance());

		} catch (DomainException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado :(");
		}

		sc.close();

	}

}
