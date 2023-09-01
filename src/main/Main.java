package main;

import bbdd.conexion;
import view.loginPage.LoginPageJF;

import java.awt.EventQueue;

import java.awt.Image;
import java.awt.Toolkit;





public class Main {
	



	public static void main(String[] args) {
		/*Connection to database*/
		conexion.Conectar();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new LoginPageJF();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
