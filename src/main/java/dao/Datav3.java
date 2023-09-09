package dao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Datav3 {
	private String login;
	Map<String,List<String>> user_data = new HashMap<String,List<String>>();
	List<String> tables = new ArrayList<String>();
	List<List<String>> authentification = new ArrayList<List<String>>();
	List<Map<String,List<String>>> tables_data = new ArrayList<Map<String,List<String>>>();
	List<Map<String,List<String>>> tables_metadata = new ArrayList<Map<String,List<String>>>();

	
	public Datav3(String login) {
		super();
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public List<List<String>> authentification(String login){
		
		
	      File directoryPath = new File("C:\\SGBD\\\\"+login);
	      if(directoryPath.exists()) {
	      String contents[] = directoryPath.list();
	      for(int i=0; i<contents.length; i++) {
	    	  
	    	  if(contents[i].equals(login + ".txt")) {
	    		  File file = new File("C:\\SGBD\\\\"+login+"\\"+ contents[i]);
	    		  
	    		  try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	    		        String line = reader.readLine();
	    		        List<String> data ;
	    		        while (line != null) {
  		        		data = new ArrayList<String>();

	    		        	for(String auth:line.split(":")) {
	    		        		data.add(auth);
	    		        	}
	    		        	authentification.add(data);
	    		            line = reader.readLine();
	    	
	    		        }
	    		        

	    		    
	    			} catch (IOException e) {
	    			    e.printStackTrace();
	    			}
	    		  
	    		  
	    	  }
	      }
	      }else {
		        List<String> data = new ArrayList<String>();
		        data.add("not found");
		        data.add("not found");
	        	authentification.add(data);
	      }
	      
	      return authentification;
	      
	}
	
	
	
	public List<Map<String,List<String>>> tables_data(String login){
	      File directoryPath = new File("C:\\SGBD\\\\"+login);
	      String contents[] = directoryPath.list();
	      for(int i=0; i<contents.length; i++) {
	    	  if(!contents[i].endsWith(".txt")) {
	    	  File directoryPath2 = new File("C:\\SGBD\\\\"+login+"\\"+contents[i]);
    		  Map<String,List<String>> tab  =  new HashMap<String,List<String>>();

	    	  for(String table:directoryPath2.list()) {
	    		// tab  =  new HashMap<String,List<String>>();

		    		File file = new File("C:\\SGBD\\\\"+login+"\\"+ contents[i] + "\\" + table+"\\Data.csv");
		    		
		    		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	    		        String line = reader.readLine();
	    		        List<String> data  =  new ArrayList<String>();
	    		        while (line != null) {
	    		        	data.add(line);
	    		            line = reader.readLine();
	    	
	    		        }
	    		        
	    		        tab.put(table, data);
	    		    
	    			} catch (IOException e) {
	    			    e.printStackTrace();
	    			}
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	    	  }
	    	  
		        tables_data.add(tab);

	    	  }
	      }

		      return tables_data;

	      }
	
	

	public List<Map<String,List<String>>> tables_metadata(String login){
	      File directoryPath = new File("C:\\SGBD\\\\"+login);
	      String contents[] = directoryPath.list();
	      for(int i=0; i<contents.length; i++) {
	    	  if(!contents[i].endsWith(".txt")) {
	    	  File directoryPath2 = new File("C:\\SGBD\\\\"+login+"\\"+contents[i]);
    		  Map<String,List<String>> tab  =  new HashMap<String,List<String>>();

	    	  for(String table:directoryPath2.list()) {
	    		// tab  =  new HashMap<String,List<String>>();

		    		File file = new File("C:\\SGBD\\\\"+login+"\\"+ contents[i] + "\\" + table+"\\metaData.csv");
		    		
		    		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	    		        String line = reader.readLine();
	    		        List<String> data  =  new ArrayList<String>();
	    		        while (line != null) {
	    		        	data.add(line);
	    		            line = reader.readLine();
	    	
	    		        }
	    		        
	    		        tab.put(table, data);
	    			} catch (IOException e) {
	    			    e.printStackTrace();
	    			}
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	    	  }
		        tables_metadata.add(tab);

	    	  }
	      }

		      return tables_metadata;

	      }
	
	
	
	
	
	
	
	public Map<String,List<String>> user_data(String login){
		
	      File directoryPath = new File("C:\\SGBD\\\\"+login);
	      String contents[] = directoryPath.list();
	      for(int i=0; i<contents.length; i++) {
	    	  if(!contents[i].endsWith(".txt")) {
	    	  File directoryPath2 = new File("C:\\SGBD\\\\"+login+"\\"+contents[i]);
	    	  
	    	  for(String table:directoryPath2.list()) {
	        		tables.add(table);
	          }
	    	  user_data.put(contents[i],tables);
	    	  }
	    	  
	    	  tables = new ArrayList<String>();

	    	 
	      }
	      
	      return user_data;
		
	}
	      
	      
	public boolean uniqueLogin(String login) {
		boolean unique = true;
		
		 File directoryPath = new File("C:\\SGBD\\\\");
	      String contents[] = directoryPath.list();
	      for(int i=0; i<contents.length; i++) {
	    	  if(contents[i].equals(login)) {
	    		  unique = false;
	    	  }
	      }
	      
	      return unique;
		
	}
	
	

}