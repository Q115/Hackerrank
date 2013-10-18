/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/fraud-prevention
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FraudPrevention {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        in.nextLine();
        Hashtable<String,StringBuilder> emailHash = new Hashtable<String,StringBuilder>();
        Hashtable<String,Integer> emailIDHash = new Hashtable<String,Integer>();
        
        Hashtable<String,StringBuilder> addressHash = new Hashtable<String,StringBuilder>();
        Hashtable<String,Integer> addressIDHash = new Hashtable<String,Integer>();
        
        PriorityQueue<Integer> fraud= new PriorityQueue<Integer>();
        for(int i =0;i<num;i++)
        {
            String s = in.nextLine();
            //String[]ary = s.split(",");

            int orderID = i+1;
            int commaIndex=1;
            while(s.charAt(commaIndex)!=','){commaIndex++;}
            commaIndex++;

            StringBuilder dealID = new StringBuilder();
            while(s.charAt(commaIndex)!=','){dealID.append(s.charAt(commaIndex));commaIndex++;}
            commaIndex++;

            StringBuilder email = new StringBuilder();
            //get absolute and type cast to speed up
            for(;s.charAt(commaIndex)!='@';commaIndex++) // check if . is > 'A'
            {
                if(s.charAt(commaIndex)=='.')
                    continue;
                else if (s.charAt(commaIndex)=='+')
                    break;
                else if (s.charAt(commaIndex) < 'a')
                    email.append((char)(s.charAt(commaIndex)+32));
                else
                    email.append(s.charAt(commaIndex));
            }
            email.append("@");

            for(;s.charAt(commaIndex)!='@';commaIndex++);
            commaIndex++;

            for(;s.charAt(commaIndex)!=',';commaIndex++)
            {
                if (s.charAt(commaIndex) < 'a' && s.charAt(commaIndex) != '.')
                    email.append((char)(s.charAt(commaIndex)+32));
                else
                    email.append(s.charAt(commaIndex));
            }

            StringBuilder address = new StringBuilder();
            commaIndex++;
            for(;s.charAt(commaIndex)!=',';commaIndex++)
            {
                if(s.charAt(commaIndex)=='.')
                {
                    int size = address.length();
                    if(address.charAt(size-2)=='s' &&address.charAt(size-1)=='t' && (s.charAt(commaIndex+1)==' '|| s.charAt(commaIndex+1)==','))
                    {
                        address.append("reet");
                        continue;
                    }
                    else if (address.charAt(size-2)=='r' &&address.charAt(size-1)=='d' && (s.charAt(commaIndex+1)==' '|| s.charAt(commaIndex+1)==','))
                    {
                        address.deleteCharAt(size-1);
                        address.append("oad");
                        continue;
                    }
                }
                if (s.charAt(commaIndex) < 'a' && s.charAt(commaIndex) > '@'){
                    address.append((char)(s.charAt(commaIndex)+32));
                }
                else
                    address.append(s.charAt(commaIndex));
            }

            commaIndex++;
            address.append('_');
            for(;s.charAt(commaIndex)!=',';commaIndex++) //city
            {
                if (s.charAt(commaIndex) < 'a' && s.charAt(commaIndex) > '@'){
                    address.append((char)(s.charAt(commaIndex)+32));
                }
                else
                    address.append(s.charAt(commaIndex));
            }

            commaIndex++; //state
            switch(s.charAt(commaIndex))
            {
            case 'C':
            case 'c':
                address.append("_ca");
                break;
            case 'I':
            case 'i':
                address.append("_il");
                break;
            case 'n':
            case 'N':
                address.append("_ny");
                break;
            default: System.out.println("something went wrong");
            }

            for(;s.charAt(commaIndex)!=',';commaIndex++);
            commaIndex++;
            
            address.append('_');
            for(;s.charAt(commaIndex)!=',';commaIndex++){address.append(s.charAt(commaIndex));}
            
            StringBuilder creditID = new StringBuilder();
            commaIndex++;
            int size = s.length();
            for(;commaIndex<size;commaIndex++){
                creditID.append(s.charAt(commaIndex));
            }
            
            String email_deal = new String(email.append('_').append(dealID));
            if(emailHash.containsKey(email_deal))
            {
                if(!emailHash.get(email_deal).equals(creditID))
                {
                    fraud.add(emailIDHash.get(email_deal));
                    fraud.add(orderID);
                    continue;
                }
                //same email_deal but different credit card
            }
            else
            {
                emailHash.put(email_deal, creditID);
                emailIDHash.put(email_deal, orderID);
            }
            
            String address_deal = new String(address.append('_').append(dealID));
            if(addressHash.containsKey(address_deal))
            {
                if(!addressHash.get(address_deal).equals(creditID))
                {
                    fraud.add(addressIDHash.get(address_deal));
                    fraud.add(orderID);
                    continue;
                }
                //same email_deal but different credit card
            }
            else
            {
                addressHash.put(address_deal, creditID);
                addressIDHash.put(address_deal, orderID);
            }
        }
        
        int size = fraud.size();
        
        for(int i =0; i< size-1;i++)
        {
            System.out.print(fraud.poll()+",");
        }
        System.out.print(fraud.poll());
    }
}
