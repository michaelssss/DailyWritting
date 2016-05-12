import java.util.Stack;


public class RPN
{
    public Long Cal(String s){
        Stack a = this.Expression2Stack(s);
        Stack rpnstack = this.Turn2RPN(a);
        return this.Eval(rpnstack);
    }
    public Long Eval(Stack rpnStack){
        Stack<Long> num = new Stack();
        for(Object o:rpnStack){
            if(o instanceof Operate) 
            {
                Operate tmp = (Operate)o;
                Long num1 = num.pop();
                Long num2 = num.pop();
                switch (tmp){
                    case PLUS:{
                        num.push(num2+num1);
                        break;
                    }
                    case MINUS:{
                        num.push(num2-num1);
                        break;
                    }
                    case MUTIPLE:{
                        num.push(num1*num2);
                        break;
                    }
                    case DIVIE:{
                        num.push(num2/num1);
                        break;
                    }
                    case POWERDE:{
                        num.push((long)(Math.pow(num2.doubleValue(),num1.doubleValue())));
                        break;
                    }
                }
            }
            else{
                String tmp = (String) o;
                if(this.isNumberic(tmp))
                    num.push(Long.valueOf((String)o));
            }
        }
        return num.pop();
    }
    private boolean isNumberic(String s){
        for(char c:s.toCharArray()){
            if(!Character.isDigit(c))return false;
        }
        return true;
    }
    private Stack Turn2RPN(Stack Expression)
    {
        Stack s1 = new Stack();
        s1.push(Operate.NONE);
        Stack s2 = new Stack();
        for (Object x : Expression)
        {
            if (x instanceof Operate)
            {
                if (x == Operate.LEFTPARENTHESE)
                {
                    s1.push(x);
                }
                else if (x == (Operate.RIGHTPARENTHESE))
                {
                    while (true)
                    {
                        if (s1.lastElement() == Operate.LEFTPARENTHESE)
                        {
                            s1.pop();
                            break;
                        }
                        else
                        {
                            s2.push(s1.pop());
                            
                        }
                    }
                }
                else if (x instanceof Operate && s1.lastElement().equals(Operate.LEFTPARENTHESE))
                {
                    s1.push(x);
                }
                else if (x instanceof Operate && !s1.lastElement().equals(Operate.LEFTPARENTHESE))
                {
                    if (((Operate)s1.lastElement()).getPiority() < ((Operate)x).getPiority())
                    {
                        s1.push(x);
                    }
                    else
                    {

                        while (true)
                        {
                            if (((Operate)s1.lastElement()).getPiority() < ((Operate)x).getPiority())
                            {
                                break;
                            }
                            if (s1.lastElement().equals(Operate.LEFTPARENTHESE))
                            {
                                break;
                            }
                            s2.push(s1.pop());
                        }
                        s1.push(x);
                    }
                }
            }
            else
            {
                s2.push(x);
            }
        }
        while (!s1.empty())
        {
            s2.push(s1.pop());
        }
        s2.pop();
        return s2;
    }

    private Stack Expression2Stack(String Expression)
    {
        Stack expression = new Stack();
        StringBuffer numString = new StringBuffer();
        for (char charater : Expression.toCharArray())
        {

            switch (charater)
            {
                case '+':
                {
                    if (numString.length() != 0)
                        expression.push(numString.toString());
                    numString = new StringBuffer();
                    expression.push(Operate.PLUS);

                    break;
                }
                case '-':
                {
                    if (numString.length() != 0)
                        expression.push(numString.toString());
                    numString = new StringBuffer();
                    expression.push(Operate.MINUS);
                    break;
                }
                case '*':
                {
                    if (numString.length() != 0)
                        expression.push(numString.toString());
                    numString = new StringBuffer();
                    expression.push(Operate.MUTIPLE);
                    break;
                }
                case '/':
                {
                    if (numString.length() != 0)
                        expression.push(numString.toString());
                    numString = new StringBuffer();
                    expression.push(Operate.DIVIE);
                    break;
                }
                case '^':{
                    if (numString.length() != 0)
                        expression.push(numString.toString());
                    numString = new StringBuffer();
                    expression.push(Operate.POWERDE);
                    break;
                }
                case '(':
                {
                    if (numString.length() != 0)
                        expression.push(numString.toString());
                    numString = new StringBuffer();
                    expression.push(Operate.LEFTPARENTHESE);
                    break;
                }
                case ')':
                {
                    if (numString.length() != 0)
                        expression.push(numString.toString());
                    numString = new StringBuffer();
                    expression.push(Operate.RIGHTPARENTHESE);
                    break;
                }
                default:
                {
                    numString.append(charater);
                }
            }
        }
        if(numString.length()>0)expression.push(numString.toString());
        return expression;
    }
}

enum Operate
{
    NONE("#", 0),
    PLUS("PLUS", 1),
    MINUS("MINUS", 1),
    MUTIPLE("MUTIPLE", 2),
    DIVIE("DIVIE", 2),
    POWERDE("POWDE",3),
    LEFTPARENTHESE("LEFTPARENTHESE", 4),
    RIGHTPARENTHESE("RIGHTPARENTHESE", 4);

    private int piority;

    private String operate;

    Operate(String operate, int i)
    {
        this.piority = i;
        this.operate = operate;
    }

    public int getPiority()
    {
        return piority;
    }
}
