import java.util.*;
class icetstudentmanagementsystem{
	
//////////// Batch status///////////////////////////////////
    public static final int ENROLLMENTOPEN = 1;
    public static final int ENROLLMENTCLOSED = 0;

/////////////---------GLOBAL ARRAYS--------/////////
	public static String[] studentIDs ={
		"PR26108001", "PR26109001", "PR26110001", "OR26108001", "PR26108002", "PR26100001", "PR26110003", "OR26109002"
		
	};
	
	public static String[] studentNames ={
		"Nethra", "Pawani", "Kaweena", "Nefeli", "Charthuri", "Hansika", "Sachini", "Menoly"
	
	};
	
	public static String[] NICs = {
		"2006778811", "2006778814", "2001778811", "2006788812", "2006778847", "2006773366", "2001779944", "2000778811"
	};
	 
	public static int[] PRFMarks = {
		85, 27, -1, -2, -2, 36, 100, 78
	};
	
	public static int[] DBMSMarks = {
		95, 65, 89, -1, -1, 57, 100, -2
	};
	
///////////////////////parallel arrays/////////////////////
	public static int[] batchNos = {100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
	public static int[] batchStatus = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}; 
	
	
	
////////////////////////METHODS/////////////////////////////////////////////////
	public final static void clearConsole() {   
		try {  
			final String os = System.getProperty("os.name");   
			if (os.contains("Windows")) {  
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  
			} else {  
				System.out.print("\033[H\033[2J");   
				System.out.flush();  
			}  
		} catch (final Exception e) {  
			e.printStackTrace();  
			// Handle any exceptions.  
		}  
	}
	
	public static void extendBatchArrays(){
		int[] tempBatchNos = new int[batchNos.length+1];
		int[] tempBatchStatus = new int[batchStatus.length+1];
		
		for (int i = 0; i < batchNos.length; i++){
			tempBatchNos[i] = batchNos[i];
			tempBatchStatus[i] = batchStatus[i];
		}
		
		batchNos = tempBatchNos;
		batchStatus = tempBatchStatus;
		
	}
	
	public static void extendArrays(){
		String[] tempStudentIDs= new String[studentIDs.length+1];
		String[] tempStudentNames= new String[studentNames.length+1];
		String[] tempNICs= new String[NICs.length+1];
		int[] tempPRFMarks= new int[PRFMarks.length+1];
		int[] tempDBMSMarks= new int[DBMSMarks.length+1];
		
		
		
		for (int i = 0; i < studentIDs.length; i++){
			tempStudentIDs[i] = studentIDs[i];
			tempStudentNames[i] = studentNames[i];
			tempNICs[i] = NICs[i];
			tempPRFMarks[i] = PRFMarks[i];
			tempDBMSMarks[i] = DBMSMarks[i];

		}
		
		studentIDs = tempStudentIDs;
		studentNames = tempStudentNames;
		NICs = tempNICs;
		PRFMarks = tempPRFMarks;
		DBMSMarks = tempDBMSMarks; 

	}

	public static boolean checkBatchStatus(int batchNO){
		
		for (int i = 0; i < batchNos.length; i++){
			if(batchNO == batchNos[i]){
				if(batchStatus[i] == 1){
					return true;
				}				
			}
		}
		return false;
	}
	
	public static boolean checkNICIsExists(String NIC){
		for (int i = 0; i < NICs.length; i++){
			if(NIC.equals(NICs[i])){
				return true;
			}
		}
		return false;
	}

	public static int checkBatchExists(int batchNO){
		for(int i=0; i<batchNos.length; i++){
			if(batchNos[i] == batchNO){
				return i;
			}
		}
		return -1;
	}
	
	public static int getStudentCount(int batchNO){
		
		int count =0;
		for(int i=0; i<studentIDs.length; i++){
			String batchNumber = studentIDs[i].substring(4,7);
			int studentBatch = Integer.parseInt(batchNumber);
			if(studentBatch == batchNO){
				count++;
			}
		}
		return count;
		
	}
	
	public static void deleteStudentFromArrays(int index){
		String[] tempStudentIDs= new String[studentIDs.length-1];
		String[] tempStudentNames= new String[studentNames.length-1];
		String[] tempNICs= new String[NICs.length-1];
		
		int[] tempPRFMarks= new int[PRFMarks.length-1];
		int[] tempDBMSMarks= new int[DBMSMarks.length-1];
		
		int j = 0;
		for(int i = 0; i<studentIDs.length; i++){
			if(i != index){
				tempStudentIDs[j] = studentIDs[i];
				tempStudentNames[j] = studentNames[i];
				tempNICs[j] = NICs[i];
				
				tempPRFMarks[j] = PRFMarks[i];
				tempDBMSMarks[j] = DBMSMarks[i];
				
				j++;
			}
		}
		studentIDs = tempStudentIDs;
		studentNames = tempStudentNames;
		NICs = tempNICs;
		
		PRFMarks = tempPRFMarks;
		DBMSMarks = tempDBMSMarks;
		
	}
	
	public static String generateStudentId(int userInputBatchNo, int mode){
		
		//student count
		int studentCount = 0;
		
		for (int i = 0; i < studentIDs.length; i++){
			String studentId = studentIDs[i];
			String batchNO = studentId.substring(4,7); // OR24110520 -> 110
			
			int batchNo = Integer.parseInt(batchNO);
			
			if(batchNo == userInputBatchNo){
				studentCount++;
			}
		}
		
		String studentId = "";
		
		if(mode == 1){
			studentId = studentId + "PR" + 26 + userInputBatchNo + String.format("%03d" , (studentCount+1)); //PR 26 110 120
		}else{
			studentId = studentId + "OR" + 26 + userInputBatchNo + String.format("%03d" , (studentCount+1));
		}
		
		return studentId;
	}
	
	public static void addStudentDetailsToArrays(String studentId, String name, String NIC){
		studentIDs[studentIDs.length-1] = studentId;
		studentNames[studentNames.length-1] = name;
		NICs[NICs.length-1] = NIC;
		PRFMarks[PRFMarks.length-1] = -2;
		DBMSMarks[DBMSMarks.length -1] = -2;
	}

	public static int isRegistrationNoExists(String registrationNO){
			for (int i = 0; i < studentIDs.length; i++){
				if(registrationNO.equals(studentIDs[i])){
					return i;
				}
			}
		return -1;
			
	}
	
	public static void printStudentFullDeatils(int index){
		System.out.println("\tRegistration No     : " + studentIDs[index]);
		System.out.println("\tStudent Name        : " + studentNames[index]);
		System.out.println("\tStudent NIC         : " + NICs[index]);
		
		if(PRFMarks[index] == -2){
			System.out.println("\tStudent PRF Marks   : Not Conducted");
		}else if(PRFMarks[index] == -1){
			System.out.println("\tStudent PRF Marks   : Absent");
		}else{
			System.out.println("\tStudent PRF Marks   : " + PRFMarks[index]);
		}
		
		if(DBMSMarks[index] == -2){
			System.out.println("\tStudent DBMS Marks   : Not Conducted");
		}else if(DBMSMarks[index] == -1){
			System.out.println("\tStudent DBMS Marks   : Absent");
		}else{
			System.out.println("\tStudent DBMS Marks   : " + DBMSMarks[index]);
		}
	
		System.out.println("\tStudent GPA         : " +calculateGPA(index));
	}
	
	public static double getGPA(int marks){
		if(marks >= 90){
			return 4.25;
		}else if(marks >= 80){
			return 4.00;
		}else if(marks >= 75){
			return 3.70;
		}else if(marks >= 70){
			return 3.30;
		}else if(marks >= 65){
			return 3.00;
		}else if(marks >= 60){
			return 2.70;
		}else if(marks >= 55){
			return 2.30;
		}else if(marks >= 50){
			return 2.00;
		}else if(marks >= 45){
			return 1.70;
		}else if(marks >= 40){
			return 1.30;
		}else if(marks >= 30){
			return 1.00;
		}else{
			return 0.70;
		}
	}
	
	public static double calculateGPA(int index){
		
		int prfMarks = PRFMarks[index];
		int dbmsMarks = DBMSMarks[index];
		
		double prfGPA = 0.0;
		double dbmsGPA = 0.0;
		
		if(prfMarks >= 0){
			prfGPA = getGPA(prfMarks);
		} 
		
		if(dbmsMarks >= 0){
			dbmsGPA = getGPA(dbmsMarks);
		} 
			
		double GPA = (prfGPA + dbmsGPA)/2;
		
		return GPA;
	}
	
	public static int getStudentBatch(int index) {

		String batchNumber = studentIDs[index].substring(4, 7);

		return Integer.parseInt(batchNumber);
	}
	
	public static void sortStudentsByName() {

		for (int i = 0; i < studentIDs.length - 1; i++) {

			for (int j = 0; j < studentIDs.length - 1 - i; j++) {

				if (studentNames[j].compareToIgnoreCase(studentNames[j + 1]) > 0) {


					String tempID = studentIDs[j];
					studentIDs[j] = studentIDs[j + 1];
					studentIDs[j + 1] = tempID;


					String tempName = studentNames[j];
					studentNames[j] = studentNames[j + 1];
					studentNames[j + 1] = tempName;


					String tempNIC = NICs[j];
					NICs[j] = NICs[j + 1];
					NICs[j + 1] = tempNIC;


					int tempPRF = PRFMarks[j];
					PRFMarks[j] = PRFMarks[j + 1];
					PRFMarks[j + 1] = tempPRF;

	
	 				int tempDBMS = DBMSMarks[j];
					DBMSMarks[j] = DBMSMarks[j + 1];
					DBMSMarks[j + 1] = tempDBMS;
				}
			}
		}
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////	
	public static void addStudent(){
		
		Scanner input = new Scanner(System.in);
		
		do{
			System.out.println("-----------------------------------------------------------------");
			System.out.println("|\t\t\t\tAdd Student\t\t\t|");
			System.out.println("-----------------------------------------------------------------\n");
			
			System.out.println();
			
			System.out.print("Enter batch Number(Student should be added): ");
			int batchNO = input.nextInt();
			
			System.out.println();
			
			if(checkBatchStatus(batchNO)){
				
				System.out.print("Enter Student NIC : ");
				String NIC = input.next();
				
				System.out.println();
				
				if(checkNICIsExists(NIC)){
					System.out.println("\tThis student is already added to the system...");
					continue;
				}else{
					System.out.print("Enter Student name : ");
					String studentName = input.next();
					
					System.out.println();
					
					System.out.print("Enter Lecturer Mode(1 - PHYSICAL / 0 - ONLINE) : ");
					int lecturerMode = input.nextInt();
					
					System.out.println();
					
					String studentId = generateStudentId(batchNO, lecturerMode);
					
					System.out.println("\tStudent Registration No - " + studentId);
					

					
					extendArrays();
					
					//NIC,studentName,studentId
					addStudentDetailsToArrays(studentId, studentName, NIC);
					
					System.out.println();
					
					System.out.print("Do you want to add another student (Y/N): ");
					char retryOption = input.next().charAt(0);
					
					if(retryOption == 'Y' || retryOption == 'y'){
						clearConsole();
						continue;
					}else{
						clearConsole();
						studentManagement();
					}
					
				}
				
			}else{
				System.out.println();
				System.out.println("\t Student cannot be added to this course because enrollment is closed....");
				
				System.out.println();
				System.out.print("Do you want to add student to another  batch (Y/N): ");
				char retryOption = input.next().charAt(0);
				
				if(retryOption == 'Y' || retryOption == 'y'){
					clearConsole();
					continue;
				}else{
					clearConsole();
					return;
				}
			}
		}while(true);
        
	}
	
	public static void viewStudentProfile(){
		Scanner input = new Scanner(System.in);
		
		do{
			System.out.println("------------------------------------------------");
			System.out.println("|\t\tView Student's Profile \t\t|");
			System.out.println("------------------------------------------------\n");
			
			System.out.println();
			
			System.out.print("Enter Student Registration No : ");
			String registrationNo = input.next().toUpperCase();
			
			System.out.println();
			
			int index = isRegistrationNoExists(registrationNo);
			
			if(index >= 0){
				
				printStudentFullDeatils(index);	
				
				System.out.println();
				
				System.out.print("Do you want to search another student details(Y/N): ");
				char retryOption = input.next().charAt(0);	
				
				if(retryOption == 'Y' || retryOption == 'y'){
					clearConsole();
					continue;
				}else{
					clearConsole();
					studentManagement();;
				}		
				
			}else{
				System.out.println();
				System.out.println("\t This student does not exists in the system...");
				
				System.out.println();
				System.out.print("Do you want to search another student details (Y/N): ");
				char retryOption = input.next().charAt(0);
				
				if(retryOption == 'Y' || retryOption == 'y'){
					clearConsole();
					continue;
				}else{
					studentManagement();
					return;
				}
			}
		}while(true);
        
        
	}
	
	public static void updateStudent(){
		Scanner input = new Scanner(System.in);
		
		do{
			
			clearConsole();
			System.out.println("------------------------------------------------");
			System.out.println("|\t\tUpdate students\t\t|");
			System.out.println("------------------------------------------------\n");
			
			System.out.println();
			
			System.out.print("Enter Student Registration No : ");
			String registrationNo = input.next().toUpperCase();
			
			int index = isRegistrationNoExists(registrationNo);
			
			if (index == -1) {
				
				System.out.println("\t\nThis student not exist in the system...");
				
				System.out.print("\n\nDo you want to try again (Y/N) : ");
				char option = input.next().charAt(0);
				if(option == 'Y'|| option == 'y' ){
					continue;
				}else{
					return ;
				}
				
			}
			
			System.out.println();
			
			System.out.println("\tCurrent Student Details");
			System.out.println("\t===========================");
			
			System.out.println("\tRegistation NO : "+studentIDs[index]);	
			System.out.println("\tStudent Name : "+studentNames[index]);
			System.out.println("\tStudent NIC : "+NICs[index]);
			System.out.println();
			System.out.println("\t[1] Update Student Name");
			System.out.println("\t[2] Update Student NIC");
			
			System.out.print("Enter an option : ");
			int option = input.nextInt();
			
			switch (option){
				
				case 1:
					System.out.print("Enter new Student Name : ");
					String newName = input.next();
					
					studentNames[index] = newName;
					
					System.out.println("\n\tStudent name updated successfully...");
					
					break;
					
				case 2:
					System.out.print("Enter new Student NIC : ");
					String newNIC = input.next();
					
					boolean nicExists = false;
					
					for(int i=0; i<NICs.length; i++){
						if(i !=index && newNIC.equals(NICs[i])){
							nicExists = true;
							break;
						}
					}
					if(nicExists){
						System.out.println();
						System.out.println("\tThis NIC already exists in the system....");
						
					}else{
						NICs[index] = newNIC;
						System.out.println();
						System.out.println("\n\tStudent NIC updated successfully...");
					
					}
					
					break;
					
				default:
					System.out.println("\n\t Invalid option...");
					
			}
			
			System.out.print("\n\nDo you want to try again (Y/N) : ");
			char retry = input.next().charAt(0);
				if(retry == 'Y'|| retry == 'y' ){
					continue;
				}else{
					return;
				}
			
			
			
			
		}while(true);
	}
	
	public static void deleteStudent(){
		Scanner input = new Scanner(System.in);
		
		do{
			
			clearConsole();
			
			System.out.println("------------------------------------------------");
			System.out.println("|\t\tDelete Students\t\t|");
			System.out.println("------------------------------------------------\n");
			
			System.out.println();
			System.out.print("Enter Student Registration No : ");
			String registrationNo = input.next().toUpperCase();
			
			int index = isRegistrationNoExists(registrationNo);
			
			if (index == -1) {
				
				System.out.println("\t\nThis student not exist in the system...");
				
				System.out.print("\n\nDo you want to try again (Y/N) : ");
				char option = input.next().charAt(0);
				if(option == 'Y'|| option == 'y' ){
					continue;
				}else{
					return;
				}
				
			}
			
			System.out.println("Student Details");
			System.out.println("=========================");
			
			System.out.print("Do you want to delete this student (Y/N) : ");
			char deleteOption = input.next().charAt(0);
			
			if(deleteOption == 'Y' || deleteOption == 'y'){
				deleteStudentFromArrays(index);
				
				System.out.println();
				System.out.println("\tStudent Delete successfully...");
				
			}else{
				System.out.println();
				System.out.println("\tDelete cancelled...");
			
			
			}
			
			
			System.out.print("\n\nDo you want to try again (Y/N) : ");
				char option = input.next().charAt(0);
				if(option == 'Y'|| option == 'y' ){
					continue;
				}else{
					return;
				}
		
		}while(true);
	}	


//student management
	public static void studentManagement(){
		Scanner input = new Scanner(System.in);
		
		System.out.println("-----------------------------------------------------------------");
        System.out.println("|\t\t\tStudent Management\t\t\t|");
        System.out.println("-----------------------------------------------------------------\n");
        
        System.out.println("[1] Add Student");
        System.out.println("\n[2] Update Student ");
        System.out.println("\n[3] View Student Profile");
        System.out.println("\n[4] Delete Student Profile");
        System.out.println("\n[5] Exit");
        
        System.out.println();
        
        System.out.print("Enter an option to continue : ");
        int studentOption = input.nextInt();
        
        
        switch(studentOption){
			case 1:{
				clearConsole();
				addStudent();
			}break;
			case 2:{
				clearConsole();
				updateStudent();
				
				
			}break;
			case 3:{
				clearConsole();
				viewStudentProfile();
				
			}break;
			case 4:{
				clearConsole();
				deleteStudent();
				
			}break;
			case 5:{
				clearConsole();
				main(null);
			}break;
			
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////	
	
		
	public static void addBatch(){
		Scanner input = new Scanner(System.in);
		
		do{
			
			clearConsole();
			
			System.out.println("------------------------------------------------");
			System.out.println("|\t\tAdd Batch\t\t|");
			System.out.println("------------------------------------------------\n");
			
			
			//System.out.print("Enter batch Number : ");
			//int batchNO = input.nextInt(); 
			
			int newBatch;
			
			if (batchNos.length == 0){
				newBatch = 1;
			}else {
				int lastBatch = batchNos[batchNos.length - 1];
				newBatch = lastBatch + 1;
			}
			
			extendBatchArrays();
			
			batchNos[batchNos.length-1]= newBatch;
			batchStatus[batchStatus.length-1] = 1;
			
			System.out.println("\tBatch"+ newBatch +" added successfully...");
			System.out.println();
			System.out.println("\tBatch Status : ENROLLMENTOPEN");
			System.out.println();
			
			System.out.print("Do you want to add another batch (Y/N) : ");
			char option = input.next().charAt(0);
			
			if(option == 'Y' || option == 'y'){
				continue;
			}else{
				return;
			}
			
			
			
		
		}while(true);
		
	}

	public static void updateBatch(){
		Scanner input = new Scanner(System.in);
		
		do{
			
			clearConsole();
			
			System.out.println("------------------------------------------------");
			System.out.println("|\t\tUpdate Batch\t\t|");
			System.out.println("------------------------------------------------\n");
			
			System.out.print("Enter Batch ID : ");
			int batchNO = input.nextInt();
			
			int index = checkBatchExists(batchNO);
			
			if(index == -1){
				System.out.println();
				System.out.println("\tThis batch does not exist in the system");
				System.out.println();
				
				System.out.print("Do you want to try again (Y/N) : ");
				char option = input.next().charAt(0);
				
				if(option == 'Y' || option == 'y'){
					continue;
				}else{
					return;
				}
				
			}
			System.out.println();
			System.out.println("\tBatch ID : " + batchNos[index]);
			
			if(batchStatus[index] == 1){
				
				System.out.println("\tCurrent Status : ENROLLMENTOPEN");
				
			}else{
				System.out.println("\tCurrent Status : ENROLLMENTCLOSED");
				
			}
			System.out.println();
			
			System.out.println("[1] Open Enrollment");
			System.out.println("[0] Close Enrollment");
			
			System.out.println();
			
			System.out.println("Enter new status : ");
			int newStatus = input.nextInt();
			
			if(newStatus == 1 || newStatus == 0){
				
				System.out.print("Are you sure you want to change batch status (Y/N) : ");
				char comfirm = input.next().charAt(0);
				
				if(comfirm == 'Y' || comfirm == 'y'){
					
					batchStatus[index] = newStatus;
					System.out.println();
					
					if(newStatus == 1){
						
						System.out.println("\tBatch status changed to ENROLLMENTOPEN successfully");
						
						
					}else{
						System.out.println("\tBatch status changed to ENROLLMENTCLOSED successfully");
						
					}
					
				}else{
					
					System.out.println();
					System.out.println("\tStatus change cancelled...");
					
				}
				
				
			}else{
				
				System.out.println();
				System.out.println("\tInvalid status...");
				
			}
			
			System.out.println();
			
			System.out.println("Do you want to update another batch (Y/N) : ");
			char retry = input.next().charAt(0);
			
			if(retry == 'Y' || retry == 'y'){
				continue;
			}else {
				return;
			}
			
			
			
			
			
		}while(true);
	}	

	public static void viewBatches(){
		Scanner input = new Scanner(System.in);
		
		do{
			
			clearConsole();
			
			System.out.println("------------------------------------------------");
			System.out.println("|\t\tView Batch\t\t|");
			System.out.println("------------------------------------------------\n");
			
			System.out.println(
					"Batch ID\tStudent Count\t\tStatus");

			System.out.println(
					"-------------------------------------------------------------");


			for (int i = 0; i < batchNos.length; i++) {

				int count = getStudentCount(batchNos[i]);


				String status;


				if (batchStatus[i] == 1) {

					status = "ENROLLMENTOPEN";

				} else {

					status = "ENROLLMENTCLOSED";
				}


				System.out.println(batchNos[i] + "\t\t"+ count + "\t\t\t"+ status);
			}


			System.out.println();

			System.out.print(
					"Do you want to view batches again (Y/N) : ");

			char option = input.next().charAt(0);


			if (option == 'Y' || option == 'y') {

				continue;

			} else {

				return;
			}



			
		}while(true);
	}
	

//batch management	
	public static void batchManagement(){
		Scanner input = new Scanner(System.in);
		do{
			clearConsole();
			System.out.println("-----------------------------------------------------------------");
			System.out.println("|\t\t\tBatch Management\t\t\t|");
			System.out.println("-----------------------------------------------------------------\n");
			
			System.out.println("[1] Add Batch");
			System.out.println("\n[2] Update Batch ");
			System.out.println("\n[3] View Batches");
			System.out.println("\n[4] Exit");
			
			
			System.out.println();
			
			System.out.print("\nEnter an option to continue > ");
			int batchOption = input.nextInt();
			
			
			switch(batchOption){
				case 1:{
					clearConsole();
					addBatch();
					
				}break;
				case 2:{
					clearConsole();
					updateBatch();
				}break;
				case 3:{
					clearConsole();
					viewBatches();
				
				}break;
				case 4:{
					return ;
					
				}
				
					
				
			}
		}while(true);
	}
////////////////////////////////////////////////////////////////////////////////////////////


	public static void updatePRFMarks() {

		Scanner input = new Scanner(System.in);


		do {

			clearConsole();

			System.out.println("-----------------------------------------------------------------");
			System.out.println("|\t\t\tUpdate PRF Marks\t\t\t|");
			System.out.println("-----------------------------------------------------------------\n");


			System.out.print("Enter Student Registration No : ");

			String registrationNo = input.next().toUpperCase();


			int index = isRegistrationNoExists(registrationNo);


			if (index == -1) {

				System.out.println();
				System.out.println("\tThis student does not exist in the system...");

				System.out.println();

				System.out.print("Do you want to try again (Y/N) : ");
				char option = input.next().charAt(0);

				if (option == 'Y' || option == 'y') {

					continue;

				} else {

					return;
				}
			}


			System.out.println();

			printStudentFullDeatils(index);


			System.out.println();

			System.out.println("Enter PRF marks (-1 for Absent, 0 - 100 for marks) : ");
			int marks = input.nextInt();


			while (marks < -1 || marks > 100) {
				System.out.println();
				System.out.println("\tInvalid marks...");

				System.out.print("Enter PRF marks (-1 for Absent, 0 - 100 for marks) : ");
				marks = input.nextInt();
			}


			PRFMarks[index] = marks;


			System.out.println();

			System.out.println("\tPRF marks updated successfully...");


			System.out.println();

			System.out.print("Do you want to update another student (Y/N) : ");

			char retry = input.next().charAt(0);


			if (retry == 'Y' || retry == 'y') {

				continue;

			} else {

				return;
			}


		} while (true);
	}

	public static void updateDBMSMarks() {

		Scanner input = new Scanner(System.in);


		do {

			clearConsole();

			System.out.println("-----------------------------------------------------------------");
			System.out.println("|\t\t\tUpdate DBMS Marks\t\t\t|");
			System.out.println("-----------------------------------------------------------------\n");


			System.out.print("Enter Student Registration No : ");

			String registrationNo = input.next().toUpperCase();


			int index = isRegistrationNoExists(registrationNo);


			if (index == -1) {

				System.out.println();
				System.out.println("\tThis student does not exist in the system...");

				System.out.println();

				System.out.print("Do you want to try again (Y/N) : ");

				char option = input.next().charAt(0);


				if (option == 'Y' || option == 'y') {

					continue;

				} else {

					return;
				}
			}


			System.out.println();

			printStudentFullDeatils(index);


			System.out.println();

			System.out.println("Enter DBMS marks (-1 for Absent, 0 - 100 for marks) : ");

			int marks = input.nextInt();


			while (marks < -1 || marks > 100) {

				System.out.println();
				System.out.println("\tInvalid marks...");

				System.out.print("Enter DBMS marks (-1 for Absent, 0 - 100 for marks) : ");

				marks = input.nextInt();
			}


			DBMSMarks[index] = marks;


			System.out.println();

			System.out.println("\tDBMS marks updated successfully...");


			System.out.println();

			System.out.print("Do you want to update another student (Y/N) : ");

			char retry = input.next().charAt(0);


			if (retry == 'Y' || retry == 'y') {

				continue;

			} else {

				return;
			}


		} while (true);
	}

//grade management
	public static void gradeManagement() {

		Scanner input = new Scanner(System.in);


		do {

			clearConsole();

			System.out.println("-----------------------------------------------------------------");
			System.out.println("|\t\t\tGrade Management\t\t\t|");
			System.out.println("-----------------------------------------------------------------\n");


			System.out.println("[1] PRF Marks Update");
			System.out.println();
			System.out.println("[2] DBMS Marks Update");
			System.out.println();
			System.out.println("[3] Back to Main Menu");


			System.out.println();

			System.out.print("Enter an option : ");

			int option = input.nextInt();


			switch (option) {

				case 1:
					updatePRFMarks();
					break;

				case 2:
					updateDBMSMarks();
					break;

				case 3:
					return;

				default:

					System.out.println();
					System.out.println("\tInvalid option...");
			}


		} while (true);
	}

    
////////////////////////////////////////////////////////////////////////////////////////////

// Report Generator
   
	public static void printReportStudent(int index) {

		int batch = getStudentBatch(index);


		String prf;

		if (PRFMarks[index] == -2) {
			prf = "Not Conducted";
		} else if (PRFMarks[index] == -1) {
			prf = "Absent";
		} else {
			prf = "" + PRFMarks[index];
		}


		String dbms;

		if (DBMSMarks[index] == -2) {
			dbms = "Not Conducted";
		} else if (DBMSMarks[index] == -1) {
			dbms = "Absent";
		} else {
			dbms = "" + DBMSMarks[index];
		}


		System.out.println(batch + "\t\t"+ studentIDs[index] + "\t"+ studentNames[index] + "\t"+ prf + "\t"+ dbms + "\t"+ calculateGPA(index));
	}

	public static void studentRegistrationReport() {

		Scanner input = new Scanner(System.in);


		do {

			clearConsole();

			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("|\t\t\tStudent Registration Report\t\t\t\t|");
			System.out.println("--------------------------------------------------------------------------------\n");

		
			if (studentIDs.length == 0) {
				System.out.println("\tNo students available in the system.");
			} else {
				
				sortStudentsByName();

				System.out.println("Student ID\tStudent Name\tNIC\tPRFmarks\tDBMSmarks");
				System.out.println("--------------------------------------------------------------------------------");
				for (int i = 0; i < studentIDs.length; i++) {
						
					
					//System.out.println(studentIDs[i]+"\t\t"+studentNames[i]);
					System.out.printf("%-7s	%-8s	%s	%d	%-5d \n",studentIDs[i],studentNames[i],NICs[i],PRFMarks[i],DBMSMarks[i]);
					//System.out.print(fs);
						
						
				}
			}
			


			System.out.println();

			System.out.print(
					"Do you want to view the report again (Y/N) : ");

			char option = input.next().charAt(0);


			if (option == 'Y' || option == 'y') {

				continue;

			} else {

				return;
			}


		} while (true);
	}

	public static void batchWiseStudentReport() {

		Scanner input = new Scanner(System.in);


		do {

			clearConsole();

			System.out.println("-----------------------------------------------------------------");
			System.out.println("|\t\t\tBatch-wise Student Report\t\t|");
			System.out.println("-----------------------------------------------------------------\n");


			System.out.print("Enter Batch ID : ");

			int batchNO = input.nextInt();


			int batchIndex = checkBatchExists(batchNO);


			if (batchIndex == -1) {

				System.out.println();
				System.out.println(
						"\tThis batch does not exist in the system.");

			} else {

				System.out.println();

				System.out.println(
						"Batch\tRegistration No\tName\tPRF\tDBMS\tGPA");

				System.out.println(
						"-----------------------------------------------------------------");


				boolean found = false;


				for (int i = 0; i < studentIDs.length; i++) {

					if (getStudentBatch(i) == batchNO) {

						printReportStudent(i);

						found = true;
					}
				}


				if (!found) {

					System.out.println(
							"\tNo students registered in this batch.");
				}
			}


			System.out.println();

			System.out.print(
					"Do you want to view another batch report (Y/N) : ");

			char option = input.next().charAt(0);


			if (option == 'Y' || option == 'y') {

				continue;

			} else {

				return;
			}


		} while (true);
	}

	public static void industryTrainingEligibilityReport() {

		Scanner input = new Scanner(System.in);


		do {

			clearConsole();

			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("|\t\tIndustry Training Eligibility Report\t\t\t|");
			System.out.println("--------------------------------------------------------------------------------\n");


			System.out.println("Eligibility Criteria:");

			System.out.println("1. GPA must be greater than 3.25");

			System.out.println("2. PRF and DBMS marks must be greater than 50");


			System.out.println();

			System.out.println("Batch\tRegistration No\tName\tPRF\tDBMS\tGPA");

			System.out.println("--------------------------------------------------------------------------------");


			boolean found = false;


			for (int i = 0; i < studentIDs.length; i++) {
				double GPA = calculateGPA(i);


				if (PRFMarks[i] > 50 && DBMSMarks[i] > 50 && GPA > 3.25) {

					printReportStudent(i);

					found = true;
				}
			}


			if (!found) {

				System.out.println("\tNo students are eligible for Industry Training.");
			}


			System.out.println();

			System.out.print("Do you want to view the report again (Y/N) : ");

			char option = input.next().charAt(0);


			if (option == 'Y' || option == 'y') {

				continue;

			} else {

				return;
			}


		} while (true);
	}

	public static void reportManagement() {

		Scanner input = new Scanner(System.in);


		do {

			clearConsole();

			System.out.println("-----------------------------------------------------------------");
			System.out.println("|\t\t\tReport Management\t\t\t|");
			System.out.println("-----------------------------------------------------------------\n");


			System.out.println("[1] Student Registration Report");
			System.out.println();
			System.out.println("[2] Batch-wise Student Report");
			System.out.println();
			System.out.println("[3] Industry Training Eligibility Report");
			System.out.println();
			System.out.println("[4] Back to Main Menu");


			System.out.println();

			System.out.print("Enter an option : ");

			int option = input.nextInt();


			switch (option) {

				case 1:
					studentRegistrationReport();
					break;

				case 2:
					batchWiseStudentReport();
					break;

				case 3:
					industryTrainingEligibilityReport();
					break;

				case 4:
					return;

				default:

					System.out.println();
					System.out.println("\tInvalid option...");
			}


		} while (true);
	}


/////////////////////////////////////////////////////////////////////////////////////////////

//home page	
	public static void homePage(){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("-----------------------------------------------------------------");
        System.out.println("|\t\t\tiCET Student Management System\t\t|");
        System.out.println("-----------------------------------------------------------------\n");
        
        System.out.println("[1] Student Management");
        System.out.println("\n[2] Batch Management ");
        System.out.println("\n[3] Grade Management");
        System.out.println("\n[4] Report Generator");
        System.out.println("\n[5] Exit");
        
        System.out.println();
        
        System.out.print("Enter an option to continue : ");
        int mainOption = input.nextInt();
        
        switch(mainOption){
			case 1:{
				clearConsole();
				studentManagement();
			}break;
			case 2:{
				clearConsole();
				batchManagement();
				
			}break;
			case 3:{
				clearConsole();
				gradeManagement();
				
			}break;
			case 4:{
				clearConsole();
				reportManagement();
				
			}break;
			case 5:{
				System.exit(0);
			}break;
			default:{
				System.out.println("Invalid Option.....");
				System.exit(0);
			}
		}
        
	}
	
	
// main method
    public static void main(String args[]) {
        homePage();
       
    }
	
	
	
}

