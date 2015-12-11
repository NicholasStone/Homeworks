 import   java.text.*;   
  public   class   number   {   
      public   static   void   main(String   args[])   {   
          double   d   =   3.1415926;   
          DecimalFormat   df   =   new   DecimalFormat("#####.00");   
          System.out.println(df.format(d));   
          }   
      } 