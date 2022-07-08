package com.company;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.concurrent.Semaphore;

public class AddContact {

    Scanner sc = new Scanner(System.in);

    static ArrayList<User> allUsers = new ArrayList<>();
    static ArrayList<ContactPojo> contact = new ArrayList<>();
    public void addContact(User newUser){
        ArrayList<Long> phoneNumbers = new ArrayList<>();
        System.out.println("Enter Name");
        String name = sc.nextLine();
        System.out.println("Enter title");
        String title = sc.nextLine();
        System.out.println("Enter Company");
        String comapany = sc.nextLine();
        System.out.println("Enter How many Phone Number");
        int phoneNumberCount = sc.nextInt();
        if(phoneNumberCount <= 1 || phoneNumberCount >=5 ){
            System.err.println("Invalid Input ");
            System.out.println("Phone NumberCount should be <= 5 and >= 1");
            System.out.println("press 1 to continue");
            System.out.println("press 2 to exit");
            int firstExit = sc.nextInt();
            if (firstExit == 1){
                System.out.println("Please Again Enter How many Phone Number ");
                phoneNumberCount = sc.nextInt();
                while(phoneNumberCount <=1 || phoneNumberCount >=5){
                    System.err.println("Invalid Input ");
                    System.out.println("Phone NumberCount should be <= 5 and >= 1");
                    System.out.println("press 1 to continue");
                    System.out.println("press 2 to exit");
                    int exitChoice = sc.nextInt();
                    if (exitChoice ==2){
                        System.out.println("Thank You");
                        System.exit(0);
                    }
                }

            }

        }
        System.out.println("Enter Phone Numbers");
        for (int i=0;i<phoneNumberCount;i++){
            long phone = sc.nextLong();
            if (phoneNumbers.isEmpty()){
                phoneNumbers.add(phone);
            }
            else if(phoneNumbers.contains(phone)){
                    System.out.println("PhoneNumber Already Exits");
                    System.out.println("press 1 to continue");
                    System.out.println("press 2 to exit");
                    int firstExit = sc.nextInt();
                    if(firstExit==1){
                        System.out.println("Please Enter Again PhoneNumber ");
                        phone = sc.nextLong();
                        while(phoneNumbers.contains(phone)){
                            System.err.println("Phone Number Already Exits");
                            System.out.println("please enter different phone Number");
                            System.out.println("press 1 to continue");
                            System.out.println("press 2 to exit");
                            int secondExit = sc.nextInt();
                            if (secondExit==2){
                                System.exit(0);
                            }
                        }
                        phoneNumbers.add(phone);
                    }
                    else{
                        System.out.println("Thanks You");
                        System.exit(0);
                    }

                }
            }
            ContactPojo newContact = new ContactPojo(name,title,comapany,phoneNumbers);
            contact.add(newContact);
            newUser.setContacts(contact);
            System.out.println("Contact Added SuccessFully");
        }

        public void addUser(){
            System.out.println("how many User Do You Wants To Create");
            int userCount = sc.nextInt();
            if (userCount==0){
                System.err.println("userCount cannot be zero");
                System.exit(0);
            }

            for (int i=0;i<userCount;i++){
                sc.nextLine();
                System.out.println("Enter UserName");
                String userName = sc.nextLine();
                System.out.println("Enter EmailID");
                String emailID = sc.nextLine();
                System.out.println("Enter password");
                String password = sc.nextLine();
                User newUser = new User(userName,emailID,password);
                System.out.println("User Created SuccessFully");
                System.out.println("lets Add Some Contacts");
                addContact(newUser);
                allUsers.add(newUser);

            }
            System.out.println("press 1 to finding mutual Contacts");
            int mutualChoice = sc.nextInt();
            if (mutualChoice == 1){
                mutualUser();
            }
        }
        public void mutualUser(){
            sc.nextLine();
            System.out.println("Enter First User Name");
            String firstUserName = sc.nextLine();
            System.out.println("Enter Second user Name");
            String secondUserName = sc.nextLine();
            if(allUsers.isEmpty() ){
                System.err.println("Sorry ALL USER list is Empty");
            }
            else{
                boolean firstNameFound = false;
                boolean secondNameFound = false;
                int  firstIndex = 0;
                int secondIndex =0 ;
                for (int i=0;i<allUsers.size();i++){
                    ArrayList<ContactPojo> contact = allUsers.get(i).getContacts();

                    if (contact.get(i).getName().equals(firstUserName)){
                        firstNameFound = true;
                        firstIndex = i;
                    }

                }
                for (int i=0;i<allUsers.size();i++){
                    ArrayList<ContactPojo> contact1 = allUsers.get(i).getContacts();
                    if (contact1.get(i).getName().equals(firstUserName)){
                        secondNameFound = true;
                        secondIndex  = i;
                    }
                }
                if (firstNameFound && secondNameFound){
                    ArrayList<ContactPojo> firstUserContacts = allUsers.get(firstIndex).getContacts();
                    ArrayList<ContactPojo> secondUserContacts = allUsers.get(secondIndex).getContacts();
                    long currentPhoneNumber;
                    System.out.println("Mutual Contacts Numbers : ");
                    for(int i=0;i<firstUserContacts.size();i++){
                        ArrayList<Long> phoneNumber = firstUserContacts.get(i).getPhoneNumbers();
                        currentPhoneNumber = phoneNumber.get(i);
                        matchingPhoneNumber(currentPhoneNumber , secondUserContacts);
                    }
                }
                else{
                    System.out.println("user name not found");
                }
            }
        }

        public void matchingPhoneNumber(long phoneNumber , ArrayList<ContactPojo> secondUserContacts){
        for(int i=0;i<secondUserContacts.size()-1;i++){
            ArrayList<Long> phoneNumbers = secondUserContacts.get(i).getPhoneNumbers();
            if (phoneNumbers.contains(phoneNumber)){
                System.out.println(phoneNumber);

            }
            else{
                System.out.println("No Mutual Contacts Found");
            }
        }

        }


}
