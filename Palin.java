package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Palin implements Runnable {
	//String fileName;
	//File file;
	String arr [];
	int cont=0;
	int fin;
	int start;
	
	public Palin( String arreglo[], int inicio, int end){
		//this.fileName=s;
		this.start=inicio;
		this.fin=end;
		this.arr=arreglo;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=start;
		if(fin>arr.length){
			fin=arr.length;
		}
		while(i<fin){
			
			File f=new File(arr[i]);
		if(f.exists()){
			try {
				BufferedReader reader=new BufferedReader(new FileReader(f.getName()));
				String line=null;
				while((line=reader.readLine())!=null){
					String rev = new StringBuilder(line).reverse().toString();
                    if(line.equals(rev)){
                    	
                    	cont ++;
                    }
					}
				System.out.println(f.getName() + "Aqui somos: " +cont);
				 
				}
			
			 catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			}
		i++;
		cont=0;
		
		}
			
	}

}
