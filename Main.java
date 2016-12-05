package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;

//import lab3.Filtro;

public class Main {
	
	ArrayList<Thread> hilos=new ArrayList<Thread>();
	 class Filtro implements FilenameFilter{

		@Override
		
			public boolean accept(File dir, String name) {
				return name.matches(".+(\\.txt)");
				// TODO Auto-generated method stub
				//return false;
			}
	 }
			

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File directorio=new File(".");
		Main m=new Main();
		String [] fileNames=directorio.list(m.new Filtro());
		int i=0;
		long start=0, finish=0;
		//int increment=4;
		int size=fileNames.length;
		
		start=System.currentTimeMillis();;
		while(i<size){
			//if(i+1>=size){
			//	break;
			//}
			if(size<4){
				Thread t=new Thread(new Palin(fileNames, i, i+1));
				
				m.hilos.add(t);
//				try {
//					t.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				t.start();
				i=i+1;
			}
			Thread t=new Thread(new Palin(fileNames, i, i+4));
			m.hilos.add(t);
//			try {
//				t.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			t.start();
			i=i+4;
			
		}
		
		finish=System.currentTimeMillis();
		Thread base=new Thread(new Palin(fileNames, 0, 4));
		try {
			base.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("El tiempo fue de:" +( finish - start) +" milisegundos ");
		 
	}
	 }


