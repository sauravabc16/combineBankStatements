package test1;
// make sure you have the files as per the required format or else program will fail to execute.

// this file needs to be taken out of output folder
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Read {

	static final String cr="INR";
	static Pattern p = Pattern.compile("\\s*[,\\n]\\s*");
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	public static String cardname="";

	static class Transection implements Comparable<Transection>{
		Date Date;
		String description;
		String location;
		float credit;
		float debit;
		String currency; //here java.util.Currency format would be better but due to less time I have used string.
		String type;
		String nameOnCard;


		@Override
		public int compareTo(Transection t) {
			if (Date == null || t.Date == null) {
				return 0;
			}
			return Date.compareTo(t.Date);
		}

	}


	public static void main(String[] args) throws IOException {
		File case1=new File("Y:\\SEM 8\\OneBanc\\HDFC-Input-Case1.csv");
		File case2=new File("Y:\\SEM 8\\OneBanc\\ICICI-Input-Case2.csv");
		File case3=new File("Y:\\SEM 8\\OneBanc\\Axis-Input-Case3.csv");

		ArrayList<Transection> domestic=new ArrayList<>();
		ArrayList<Transection> international=new ArrayList<>();


		Scanner hdfc = new Scanner(case1);  
		hdfc.useDelimiter(p); 
		while (hdfc.hasNext())   
		{  
			String s=hdfc.next();
			if(s.equals("International Transactions")) {
				break;
			}
			if(s.contentEquals("Rahul")) {
				cardname="Rahul";
				s=hdfc.next();
			}
			if(s.contentEquals("Ritu")) {
				cardname="Ritu";
				s=hdfc.next();
			}
			if(isValidDate(s)) {
				Transection t=new Transection();
				t.Date=convertStringToDate(s);
				t.description=hdfc.next();
				String[] arr=t.description.split(" ");
				t.location=arr[arr.length-1];
				String amount=hdfc.next();
				if(amount.contains(" cr")) {
					amount=amount.substring(0,amount.length()-3);
					t.credit=(float)Float.parseFloat(amount);
				}
				else {
					t.debit=(float)Float.parseFloat(amount);
				}
				t.currency=cr;
				t.type="Domestic";
				t.nameOnCard=cardname;
				domestic.add(t);
			}
		}
		while (hdfc.hasNext()) {
			String s=hdfc.next();
			if(s.contentEquals("Rahul")) {
				cardname="Rahul";
				s=hdfc.next();
			}
			if(s.contentEquals("Ritu")) {
				cardname="Ritu";
				s=hdfc.next();
			}
			if(isValidDate(s)) {
				Transection t=new Transection();
				t.Date=convertStringToDate(s);
				String temp=hdfc.next();
				t.description=temp.substring(0,temp.length()-3);
				String[] arr=t.description.split(" ");
				t.location=arr[arr.length-1];
				t.currency=temp.substring(temp.length()-3);
				String amount=hdfc.next();
				if(amount.contains(" cr")) {
					amount=amount.substring(0,amount.length()-3);

					t.credit=(float)Float.parseFloat(amount);
				}
				else {
					t.debit=(float)Float.parseFloat(amount);
				}
				t.type="International";
				international.add(t);
				t.nameOnCard=cardname;
			}
		}
		hdfc.close();
		Scanner icici = new Scanner(case2);  
		icici.useDelimiter(p);
		while (icici.hasNext())   
		{  
			String s=icici.next();
			if(s.equals("International Transactions")) {
				break;
			}
			if(s.contentEquals("Rahul")) {
				cardname="Rahul";
				s=icici.next();
			}
			if(s.contentEquals("Ritu")) {
				cardname="Ritu";
				s=icici.next();
			}
			if(isValidDate(s)) {
				Transection t=new Transection();
				t.Date=convertStringToDate(s);
				t.description=icici.next();
				String[] arr=t.description.split(" ");
				t.location=arr[arr.length-1];
				String temp=icici.next();
				if(temp.contentEquals("")) {
					t.credit=(float)Float.parseFloat(icici.next());
				}
				else {
					t.debit=(float)Float.parseFloat(temp);
				}
				t.currency=cr;
				t.type="Domestic";
				t.nameOnCard=cardname;
				domestic.add(t);
			}
		}
		while (icici.hasNext()) {
			String s=icici.next();
			if(s.contentEquals("Rahul")) {
				cardname="Rahul";
				s=icici.next();
			}
			if(s.contentEquals("Ritu")) {
				cardname="Ritu";
				s=icici.next();
			}
			if(isValidDate(s)) {
				Transection t=new Transection();
				t.Date=convertStringToDate(s);
				String temp=icici.next();
				t.description=temp.substring(0,temp.length()-3);
				String[] arr=t.description.split(" ");
				t.location=arr[arr.length-1];
				t.currency=temp.substring(temp.length()-3);
				String temp1=icici.next();
				if(temp1.contentEquals("")) {
					t.credit=(float)Float.parseFloat(icici.next());
				}
				else {
					t.debit=(float)Float.parseFloat(temp1);
				}
				t.type="International";
				t.nameOnCard=cardname;
				international.add(t);
			}
		}
		icici.close();
		Scanner axis = new Scanner(case3);  
		axis.useDelimiter(p);
		while (axis.hasNext())   
		{  
			String s=axis.next();
			if(s.equals("International Transactions")) {
				break;
			}
			if(s.contentEquals("Rahul")) {
				cardname="Rahul";
				s=axis.next();
			}
			if(s.contentEquals("Ritu")) {
				cardname="Ritu";
				s=axis.next();
			}
			if(isValidDate(s)) {
				Transection t=new Transection();
				t.Date=convertStringToDate(s);
				String temp=axis.next();
				if(temp.contentEquals("0")) {
					t.credit=(float)Float.parseFloat(axis.next());
				}
				else {
					t.debit=(float)Float.parseFloat(temp);
					axis.next();
				}
				t.description=axis.next();
				String[] arr=t.description.split(" ");
				t.location=arr[arr.length-1];
				t.currency=cr;
				t.type="Domestic";
				t.nameOnCard=cardname;
				domestic.add(t);
			}
		}
		while (axis.hasNext()) {
			String s=axis.next();
			if(s.contentEquals("Rahul")) {
				cardname="Rahul";
				s=axis.next();
			}
			if(s.contentEquals("Ritu")) {
				cardname="Ritu";
				s=axis.next();
			}
			if(isValidDate(s)) {
				Transection t=new Transection();
				t.Date=convertStringToDate(s);

				String temp1=axis.next();
				if(temp1.contentEquals("0")) {
					t.credit=(float)Float.parseFloat(axis.next());
				}
				else {
					t.debit=(float)Float.parseFloat(temp1);
					axis.next();
				}
				String temp=axis.next();
				t.description=temp.substring(0,temp.length()-3);
				String[] arr=t.description.split(" ");
				t.location=arr[arr.length-1];
				t.currency=temp.substring(temp.length()-3);
				international.add(t);
				t.type="International";
				t.nameOnCard=cardname;
				//System.out.println(t.credit);
			}
		}
		System.out.println("Combining "+ international.size()+ " International and "+ domestic.size() +
				" Domestic transactions......");
		axis.close();
		ArrayList<Transection> mergedList=mergeLists(domestic,international);//merges domestic and international lists.
		combineBankStatements(mergedList);//outputs the mergedList as csv file.
	}


	private static ArrayList<Transection> mergeLists(ArrayList<Transection> domestic,
			ArrayList<Transection> international) {
		ArrayList<Transection> mergedList=new ArrayList<>();
		for(int i=0;i<domestic.size();i++) {
			mergedList.add(domestic.get(i));
		}
		for(int i=0;i<international.size();i++) {
			mergedList.add(international.get(i));
		}
		Collections.sort(mergedList);
		return mergedList;
	}


	private static void combineBankStatements(ArrayList<Transection> mergedList) throws IOException {

		FileWriter writer = new FileWriter("combinedBankStatement.csv");
		writer.append(",,,");
		writer.append("Combined Bank Statement");
		writer.append(",\n");
		writer.append('\n');
		writer.append("Date,Transaction Description,Debit,Credit,Currency,Name on Card,Transection type,Location\n");

		for(int i=0;i<mergedList.size();i++) {
			String datet = dateFormat.format(mergedList.get(i).Date);
			writer.append(datet+',');
			writer.append(mergedList.get(i).description+",");
			writer.append(mergedList.get(i).debit+",");
			writer.append(mergedList.get(i).credit+",");
			writer.append(mergedList.get(i).currency+",");
			writer.append(mergedList.get(i).nameOnCard+",");
			writer.append(mergedList.get(i).type+",");
			writer.append(mergedList.get(i).location+"\n");
		}
		writer.flush();
		writer.close();
	}
	public static Date convertStringToDate(String dateString)
	{
		Date date = null;
		//Date formatteddate = null;
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		try{
			date = df.parse(dateString);
			//formatteddate = df.format(date);
		}
		catch ( Exception ex ){
			System.out.println(ex);
		}
		return date;
	}


	/*
	 * The function below checks if date is valid according to the given application
	 * 	System.out.println(isValidDate("20-01-2014"));
	 * System.out.println(isValidDate("11-04-2015 22:01:33:023"));
	 * System.out.println(isValidDate("32476347656435"));
	 */
	public static boolean isValidDate(String inDate) {
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}
}

