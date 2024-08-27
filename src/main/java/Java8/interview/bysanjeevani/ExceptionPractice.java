package Java8.interview.bysanjeevani;

/**
 *
 * This Class consist of many scenarios of Exception handling , You can uncomment each section and observer
 *
 */

public class ExceptionPractice {

    public static void main(String[] args) {

        //Example 1
        /*try{
            int i= 10/0;
            return;
        }catch(Exception ex){
            System.out.println("exception caught");
            return ;
        }finally{
            System.out.println("finally");
        }*/

        //Example 2 -> it gives complile time error as we hae writtern return in try block
       /* try{
            int i= 10/0;
            return;
        }catch(Exception ex){
            System.out.println("exception caught");
            return ;
        }finally{
            System.out.println("finally");
        }
        System.out.println("after code");*/

        //Example 3 -> it will complile
       /* try{
            int i= 10/0;

        }catch(Exception ex){
            System.out.println("exception caught");
            return ;
        }finally{
            System.out.println("finally");
        }
        System.out.println("after code");*/

        //Example 4 ->
       /* String result = checkFlowFromReturnTry();
        System.out.println(result);*/

        //Example 5 ->
       /* String result = checkFlowFromReturnFinally();
        System.out.println(result);*/


        //Example 6->
       /* String result = checkFlowFromReturnCatch();
        System.out.println(result);*/

        //Example 7->
     /*   try
        {
            System.out.print("A");
            int num = 99/0;
            System.out.print("B");
        }
        catch(ArithmeticException ex)
        {
            System.out.print("C");
        }
        catch(Exception ex)
        {
            System.out.print("D");
        }
        System.out.print("E");
        */

        //Example -8
        /*try
        {
            System.out.print("A");
            int num = 99/0;
            System.out.print("B");
        }
        catch(ArithmeticException ex)
        {
            System.out.print("C");
        }
        catch(Exception ex)
        {
            System.out.print("D");
        }
        finally
        {
            System.out.print("E");
        }*/

        //Example -9 -> It will give compile error as catch/finally must come just after try
        /*try
        {
            System.out.print("A");
            int num = 99/0;
            System.out.print("B");
        }

        System.out.print("C");

        catch(ArithmeticException ex)
        {
            System.out.print("D");
        }*/
        //Example -10 :
        //
        //Using System.exit(0) in the try/catch block results in  finally block
        // does not execute. You can see above program does not print E.
        // This is because System.exit(0) command terminates running java
        // virtual machine. Hence no more execution of current program after
        // this line. This is the only scenario where finally block does not execute.
       /* try
        {
            System.out.print("A");
            int num = 99/0;
            System.out.print("B");
        }
        catch(ArithmeticException ex)
        {
            System.out.print("C");
            System.exit(0);
        }
        catch(Exception ex)
        {
            System.out.print("D");
        }
        finally
        {
            System.out.print("E");
        }
        System.out.print("F");
        */
        //Example - 11
        //An overriding method can not throw a broader
        // exception (Exception is broader than SubException) than the method it's overriding.

       /* class SubException extends Exception { }
        class SubSubException extends SubException { }
         class JH
        {
            public void doStuff() throws SubException {}
        }
        class JH2 extends JH
        {
            public  void doStuff() throws SubSubException {}
        }
        class JH3 extends JH
        {
            public  void doStuff() throws Exception {}
        }
        class JH4 extends JH
        {
            public  void doStuff(int x) throws Exception {}
        }
        class JH5 extends JH
        {
            public  void doStuff()  {}
        }
*/
        //Example - 12
     /*   try
        {
            System.out.print("A");
            throw new Exception();
        }
        catch (Exception e)
        {
            System.out.print("B");
        }
        finally
        {
            System.out.print("C");
            int num = 7/0;
            System.out.print("D");
        }
        System.out.print("E");*/

        //Example - 13
        /*try
        {
            System.out.print("A");
            throw new Exception();
        }
        catch (Exception e)
        {
            try
            {
                try
                {
                    throw new Exception();
                }
                catch (Exception ex)
                {
                    System.out.print("B");
                }
                throw new Exception();
            }
            catch (Exception exc)
            {
                System.out.print("C");
            }
            finally
            {
                System.out.print("D");
            }
        }
        finally
        {
            System.out.print("E");
        }
        System.out.print("F");*/

        //Example - 14

      /*  try
        {
            System.out.print("A");
            throw 99;
        }
        catch (int ex)
        {
            System.out.print("B");
        }*/

        //Example - 15
     /*   try
        {
            int arr[]= {1, 2, 3, 4, 5};
            for (int i = 0; i <= 5; i++)
            {
                System.out.print ("Array elements are : " + arr[i] + "\n");
            }
        }
        catch (Exception e)
        {
            System.out.println ("Exception : " + e);
        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
            System.out.println ("ArrayIndexOutOfBoundsException : "+ ex);
        }*/



   /* public static String checkFlowFromReturnTry() {
        try {
            int i = 20;
            System.out.println(i);
            return "returning from try";
        } catch (Exception e) {
            System.out.println("exception caught");
            return " returning from catch";
        } finally {
            System.out.println("finally block executing");
        }
    }

    public static String checkFlowFromReturnFinally() {
        try {
            int i = 20;
            System.out.println(i);
            return "returning from try";
        } catch (Exception e) {
            System.out.println("exception caught");
            return " returning from catch";
        } finally {
            System.out.println("finally block executing");
            return "returning from finally";
        }
    }

    public static String checkFlowFromReturnCatch() {
        try {
            int i = 20/0;
            System.out.println(i);
        } catch (Exception e) {
            System.out.println("exception caught");
            return " returning from catch";
        } finally {
            System.out.println("finally block executing");
        }
        System.out.println("end");
        return "from end";
    }
*/
      /*  ExceptionPractice ex = new ExceptionPractice();
        System.out.println(ex.callReturnMethod());*/

    }

    public int callReturnMethod(){
        System.out.println("inside callReturnMethod");
        try{
            int number=100/10;
            System.out.println("inside try");
            return 10/0 ;

        }catch(Exception e){
            return 5;

        }finally{
            return 0;

        }
    }
}
