package Leet;

import java.util.Stack;

public class q155 {

	private Stack<Integer> stk;
    private Stack<Integer> min;

    public q155() 
    {
        stk = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) 
    {
        stk.push(x);
        if(min.isEmpty() || x <= min.peek())
            min.push(x);
    }

    /*
     * 注意这里必须要使用equals，因为Integer是一个整数对象
     * */
    public void pop() 
    {
        if(stk.peek().equals(min.peek()))
        {
            stk.pop();
            min.pop();
        }else
            stk.pop();
    }

    public int top() 
    {
        return stk.peek();
    }

    public int getMin() 
    {
        return min.peek();

    }
}
