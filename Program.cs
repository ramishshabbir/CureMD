using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace project
{
    class Consumer
    {
        public double TotalUnit;
        public double unitbill;
        public double TotalBill;
        public string UserType;
        public string taxType;
        
      

        public void bill()
        {
            if (UserType == "R")
            {

                if (TotalUnit > 1 && TotalUnit < 100)
                {
                    unitbill = TotalUnit * 5;
                    TotalBill = unitbill * 13 / 100 + (unitbill);
                    Console.WriteLine("bill is: {0}", TotalBill);
                    Console.ReadLine();


                }

                if (TotalUnit > 100 && TotalUnit < 200)
                {
                    unitbill = (TotalUnit - 100) * 17 + (100 * 5);
                    TotalBill = unitbill * 13 / 100 + (unitbill);
                    Console.WriteLine("bill is: {0}", TotalBill);
                    Console.ReadLine();
                }

                if (TotalUnit > 200 && TotalUnit < 500)
                {

                    if (taxType == "TP")
                    {
                        unitbill = (TotalUnit - 200) * 17 + (100 * 17) + (100 * 5);
                        TotalBill = unitbill * 13 / 100 + (unitbill);
                        Console.WriteLine("bill is: {0}", TotalBill);
                        Console.ReadLine();
                    }
                    else
                    {
                        unitbill = (TotalUnit - 200) * 23 + (100 * 17) + (100 * 5);
                        TotalBill = unitbill * 13 / 100 + (unitbill);
                        Console.WriteLine("bill is: {0}", TotalBill);
                        Console.ReadLine();
                    }
                    
                }

                if (TotalUnit > 500)
                {
                    unitbill = (TotalUnit - 500) * 69 + (300 * 23) + (100 * 17) + (100 * 5);
                    TotalBill = unitbill * 13 / 100 + (unitbill);
                    Console.WriteLine("bill is: {0}", TotalBill);
                    Console.ReadLine();
                }
            }



            else
            {
                if (TotalUnit > 1 && TotalUnit < 100)
                {
                        unitbill = TotalUnit * 8;
                        TotalBill = unitbill * 17 / 100 + (unitbill);
                        Console.WriteLine("bill is: {0}", TotalBill);
                        Console.ReadLine();


                    }

                    if (TotalUnit > 100 && TotalUnit < 200)
                    {
                        unitbill = (TotalUnit - 100) * 21 + (100 * 8);
                        TotalBill = unitbill * 17 / 100 + (unitbill);
                        Console.WriteLine("bill is: {0}", TotalBill);
                        Console.ReadLine();
                    }

                    if (TotalUnit > 200 && TotalUnit < 500)
                    {
                        if (taxType == "TP")
                        {
                            unitbill = (TotalUnit - 200) * 21 + (100 * 21) + (100 * 8);
                            TotalBill = unitbill * 17 / 100 + (unitbill);
                            Console.WriteLine("bill is: {0}", TotalBill);
                            Console.ReadLine();
                        }
                        else
                        {
                            unitbill = (TotalUnit - 200) * 23 + (100 * 21) + (100 * 8);
                            TotalBill = unitbill * 17 / 100 + (unitbill);
                            Console.WriteLine("bill is: {0}", TotalBill);
                            Console.ReadLine();
                        }
                        
                    }

                    if (TotalUnit > 500)
                    {
                        unitbill = (TotalUnit - 500) * 79 + (300 * 23) + (100 * 21) + (100 * 8);
                        TotalBill = unitbill * 13 / 100 + (unitbill);
                        Console.WriteLine("bill is: {0}", TotalBill);
                        Console.ReadLine();
                    }
            }
                
         }
       }
  
        
    

   


  




    class Program
    {
        static void Main(string[] args)
        {
            Consumer consumer = new Consumer();
            Console.Write("Enter user type (R for Residential or C for Commertial) : ");
            consumer.UserType = Console.ReadLine();
            
            Console.Write("Enter the units consumed: ");
            consumer.TotalUnit = Convert.ToDouble(Console.ReadLine());

            Console.Write("Enter tax type (TP for Tax-Payer or NP for Non-Tax Payer) : ");
            consumer.taxType = Console.ReadLine();
           
            
            consumer.bill();



        }
        
    }

}
