Write a Java program to Evaluation of postfix expression.

Aim:To Write a Java program to Evaluation of postfix expression.     

Description:
In normal algebra we use the infix notation like a+b*c. The corresponding postfix notation is abc*+. The algorithm for the conversion is as follows : 

–	Scan the Postfix string from left to right. 
–	Initialise an empty stack. 
–	If the scannned character is an operand, add it to the stack 
–	If the scanned character is an Operator, then pop two elements from stack. Store them to x and y. Now evaluate x operator y. Let the result of this operation be retVal. Push retVal into the stack. 
–	Repeat the step till all the characters are scanned. 
–	After all characters are scanned, we will have only one element in the stack. Return that element. 

Program:

import java.util.*;
class Stack1
{
    int top = -1;
    int stk[] = new int[10];
    void push(int x)
    {
        stk[++top] = x;
    }
    int pop()
    {
        return stk[top--];
    }
}
class PfxEval
   {
       public static void main(String[] args)
       {
           Scanner s=new Scanner(System.in);
           Stack1 x=new Stack1();
           String pfx;
           int p,q,reval=0;
           System.out.println("Enter the postfix expression");
           pfx=s.nextLine();
           for(int i=0;i<pfx.length();i++)
           {
               if(Character.isDigit(pfx.charAt(i)))
                   x.push(pfx.charAt(i)-'0');
               else
               {
                   q=x.pop();
                   p=x.pop();
                   switch(pfx.charAt(i))
                   {
                       case '+':reval=p+q;
                       break;
                       case '-':reval=p-q;
                           break;
                       case '*':reval=p*q;
                           break;
                       case '/':reval=p/q;
                           break;
                       case '%':reval=p%q;
                           break;
                       case '^':reval=(int)Math.pow(p,q);
                           break;
                       default:break;
                   }
                   x.push(reval);
               }
           }
           System.out.println(x.pop());
       }
   }

Input and Output:

Enter the postfix expression
1234*+5/-
-1
