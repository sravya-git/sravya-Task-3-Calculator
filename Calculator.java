package calculator;
import java.util.*;

/*** GetInput class is defined to read the inputs from the user
 */
class GetInput
{
	Scanner sc=new Scanner(System.in);
	//method for reading first operand
	public double getOperand1()
	{
		System.out.println("enter the operand 1:");
		double op1=sc.nextDouble();
		return op1;
	}
	//method for reading second operand
	public double getOperand2()
	{
		System.out.println("enter the operand 2:");
		double op2=sc.nextDouble();
		return op2;
	}
	//method for reading the operation to be performed on the given inputs
	public String getOperator()
	{
		System.out.println("Choose the any operation from the following operations:");
        System.out.println("1.+");
        System.out.println("2.-");
        System.out.println("3.*");
        System.out.println("4./");
        
		String op=sc.next();
		return op;
	}
}
/* Operation is an abstract class which is implemented by other classes to perform 
 * different operations based on the user requirement
 */
abstract class Operation
{
	abstract public double doOperation(double a,double b);
}
class Add extends Operation
{
	public double doOperation(double a,double b)
	{
		return a+b;
	}
}
class Subract extends Operation
{
	public double doOperation(double a,double b)
	{
		return a-b;
	}
}
class Multiply extends Operation
{
	public double doOperation(double a,double b)
	{
		return a*b;
	}
}
class Division extends Operation
{
	public double doOperation(double a,double b)
	{
		return a/b;
	}
}

public class Calculator extends GetInput
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Calculator calc=new Calculator();
          double operand1,operand2,result=0;
          operand1=calc.getOperand1();
          operand2=calc.getOperand2();
          String op;
          op=calc.getOperator();
          try
          {
          
              switch(op)
              {
              case "+": Add add=new Add();
                        result=add.doOperation(operand1, operand2);
                        break;
              case "-": Subract sub=new Subract();
                        result=sub.doOperation(operand1, operand2);
                        break;
              case "*": Multiply mul=new Multiply();
                        result=mul.doOperation(operand1, operand2);
                        break;
              case "/": Division div =new Division();
                        if(operand2==0)
                        {
                        	throw new ArithmeticException();
                        }
                        result=div.doOperation(operand1, operand2);
                        break;
              default:  throw new Exception("Invalid operation");
              }
          
	      }
          catch(ArithmeticException e)
          {
        	  System.out.println(e);
        	  
          }
          
          catch(Exception e)
          {
        	  System.out.println(e);
        	  
          }     
          finally
          {
        	  System.exit(0);
          }
         System.out.print(result);
         
}
}

