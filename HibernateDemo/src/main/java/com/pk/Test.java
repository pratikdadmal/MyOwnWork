package com.pk;

import java.util.List;
import java.util.Scanner;

import com.pk.entity.User;
import com.pk.service.Services;
import com.pk.service.ServicesTest;

public class Test {

	public static void main(String[] args) {
		
		Services service = new Services();
		User user = new User();
		Scanner sc = new Scanner(System.in);
	    boolean data1=false;
		char ch;
	    do
	    {
	    	System.out.println("Data Base Operation");
	    	System.out.println("1:- Insert Record");
	    	System.out.println("2:- Get Record By ID");
	    	System.out.println("3:- Delete Record By ID");
	    	System.out.println("4:- Get All Record");
	    	System.out.println("5:- Update Record");
	    	System.out.println("6:- Update The Particular Record");
	    	System.out.println("7:- Get The Highest Salary by User");
	    	System.out.println("8:- Salary by Department");
	    	System.out.println("9:- Sorted Order Ascending");
	    	System.out.println("10:-Sorted Order ");
	    	System.out.println("20:-Sum of Salary Department");
	    	System.out.println("21:-Avg of Salary Department");
	    	System.out.println("0: Exit");
	    	int data=sc.nextInt();
	    	
	    switch(data)
	 	    {
	 	    case 1 :
	 			String msg=service.saveData(user);
	 			System.out.println(msg);
	 		break;	
	 		
	 	    case 2:
	 	    	System.out.println("Enter the ID");
	 	    	int id=sc.nextInt();
	 	    	User user1 =service.getUserID(id);
	 	    	System.out.println(user1);
	 	    	break;
	 	    	
	 	    case 3:
	 	   	    System.out.println("Enter the Numbers to Delete Record");
 	    	    int id1=sc.nextInt();
 	    	    String user2 = service.deleteData(id1);
 	    	    System.out.println(user2);
 	    	    System.out.println("After Deleted the Record");
 	    	    List<User> list1 = service.getAllUser();
	    	     for(User userList : list1)
	    	     {
	    	    	 System.out.println(userList);
	    	     }
 	    	break;
 	    	
	 	   case 4:
	    	     List<User> list = service.getAllUser();
	    	     for(User userList : list)
	    	     {
	    	    	 System.out.println(userList);
	    	     }
	    	     break;
	    	     
	 	   case 5:
	 		    System.out.println("Enter the ID to Update Particular Record");
	 		    int id2=sc.nextInt();
	 	    	String msg1 =service.updateUserData(id2);
	 	    	System.out.println(msg1);
	 		 break;
	 		 
	 	   case 6 : 
	 		   
	 			Scanner sc1 = new Scanner(System.in);
	 		     int ch1;
	 		     do
	 		     {
	 		    	System.out.println("11:- Update ID");
	 		    	System.out.println("12:- Update Name");
	 		    	System.out.println("13:- Update Department");
	 		    	System.out.println("14:- Update Phone");
	 		    	System.out.println("15:- Update City");
	 		    	System.out.println("16:- Update Salary");
	 		    	 int up=sc1.nextInt();
	 		    	 switch(up)
	 		    	 {
	 		    	 case 11:
	 		    		  System.out.println("Enter the Old ID to Update Particular ID");
	 			 		   int iid=sc.nextInt();
	 			 	       String mssg =service.updateID(iid);
	 			 	       System.out.println(mssg);
	 		    		 break;
	 		    	case 12:
	 		    		System.out.println("Enter the Particular Id to Update Name");
 			 		    int upName=sc.nextInt();
 			 	    	String mssg1 =service.updateName(upName);
 			 	    	System.out.println(mssg1);
	 		    		 break;
	 		    	case 13:
	 		    		System.out.println("Enter the Particular Id to Update Department");
 			 		    int upDepart=sc.nextInt();
 			 	    	String mssg2 =service.updateDepartment(upDepart);
 			 	    	System.out.println(mssg2);
	 		    		 break;
	 		    	case 14:
	 		    		System.out.println("Enter the Particular Id to Update Phone");
 			 		    int upPhone=sc.nextInt();
 			 	    	String mssg3 =service.updatePhone(upPhone);
 			 	    	System.out.println(mssg3);
	 		    		break;
	 		    		
	 		    	case 15:
	 		    		System.out.println("Enter the Particular Id to Update City");
 			 		    int upCity=sc.nextInt();
 			 	    	String mssg4 =service.updateCity(upCity);
 			 	    	System.out.println(mssg4);
	 		    		 break;
	 		    	
	 		    	 
	 		       case 16:
 		    		    System.out.println("Enter the Particular Id to Update Salary");
			 		    int upSalary=sc.nextInt();
			 	    	String mssg5 =service.updateSalary(upSalary);
			 	    	System.out.println(mssg5);
 		    		 break;
	 		    	}
	 		    	System.out.println("Do you want to continue Case? Y/N");
	 		    	ch1 = sc.next().charAt(0);
	 		     }while(ch1=='y' || ch1=='Y'); 
	 		     
               //break;
	 		   
	 		     
	 	    case 7:
	 	    	    System.out.println("Enter the Salary");
	 	    	    String salary  = sc.next();
	 	    	    List<User> listUser = service.getHighestSalary(salary);
	 	    	    for(User ListOfSal : listUser)
	 	    	    {
	 	    	    System.out.println(ListOfSal);
	 	    	    }
	 	    	    
	 	    	break;
	 	    	
	 	    case 8:
	 	    	  System.out.println("Enter the Department Name");
	 	    	  String depStr = sc.next();
	 	    	  List<User> depList = service.departSal(depStr);
	 	    	 
	 	    	 for(User depOfSal : depList)
	 	    	    {
	 	    	    System.out.println(depOfSal);
	 	    	    }
	 	    	 break;
	 	    	 
	 	    	 
	 	   case 9:
	    	    List<User> orderlist = service.getOrderList();
	    	    for(User orderList : orderlist)
	    	    {
	    	    System.out.println(orderList);
	    	    }
	    	    
	    	break;
	    	
	 	   case 10:
	 		      List<User> ll = service.getOrder();
	 		      for(User ul : ll)
	 		      {
	 		    	  System.out.println(ul);
	 		      }
	 		   break;
	 		   
	 	  case 20:
 		      String sumList = service.maxSalary();
 		      System.out.println(sumList);
 		   break;
	 	    
	 	 case 21:
		      double avgList = service.avgSalary();
		      System.out.println(avgList); 
		   break;
 		   
 		   
	 	    case 0 :
	 	    	data1=true;
	 	    	break;
	 	   }
	     
	    System.out.println("Do you want to continue Operation? Y/N");
        ch = sc.next().charAt(0);
	   }while(ch=='y' || ch=='Y');   
	    
	  System.out.println("Terminated...");
	 	  
		
	}
}
