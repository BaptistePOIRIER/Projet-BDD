package main;

public class Main {

	public static void main(String[] args) {
		System.out.println("--- Projet ---");

		System.out.println(args[0] + " " + args[1] + " " + args[2]);
		DataAccess conn = new DataAccess(args[0],args[1],args[2]);
		conn.close();
	}
}
