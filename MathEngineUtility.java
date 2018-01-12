package sample;

import java.util.Stack;

public class MathEngineUtility
{




    public String infixToPreFix(String infix)
    {
        Stack<String> opStack = new Stack();
        StringBuilder result = new StringBuilder();

        String[] infixParts = infix.split(" ");

        for(String token : infixParts)
        {
            System.out.println("token: " + token);
            if(Character.isDigit(token.charAt(0)))
            {
                result.append(token);
                System.out.println(result.toString());
            }
            else if((token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) && !opStack.isEmpty())
            {
                System.out.println("found operator: " + token);
               String peek = opStack.peek();
               while(compare(token.charAt(0), peek.charAt(0)) == 0 || (compare(token.charAt(0), peek.charAt(0)) == -1))
               {
                  String innerPop = opStack.pop();
                   result.append(innerPop);
                   System.out.println("append operator: " + innerPop);
                   peek = opStack.peek();
               }

                System.out.println(result.toString());
                opStack.push(token);
            }
            else if(token.equals("("))
            {
                opStack.push(token);
            }
            else if(token.equals(")"))
            {
                while(!opStack.empty())
                {
                    String newlyPopped = opStack.pop();
                    result.append(newlyPopped);


                    if(newlyPopped.equals("("))
                    {
                        break;
                    }
                }
                System.out.println(result.toString());
            }
        }

        while(!opStack.empty())
        {
            result.append(opStack.pop());
        }

        return result.toString();
    }





    public int compare(Character a, Character b)
    {
        switch(a)
        {
            case '*':
            case '/':
                switch (b)
                {
                    case '*':
                    case '/':
                        return 0;
                    case '+':
                    case '-':
                        return 1;
                }
                break;
            case '+':
            case '-':
                switch (b)
                {
                    case '*':
                    case '/':
                        return -1;
                    case '+':
                    case '-':
                        return 0;
                }
                break;
        }

        return -50;
    }
}
