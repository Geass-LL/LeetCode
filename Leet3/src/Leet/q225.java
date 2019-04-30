package Leet;

import java.util.*;

public class q225 {
	public Queue<Integer> q1;
	/** Initialize your data structure here. */
    public q225() {
        q1=new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	Queue<Integer> qtemp=new LinkedList<Integer>();
    	while(!q1.isEmpty()) {
    		qtemp.add(q1.poll());
    	}
    	q1.add(x);
    	while(!qtemp.isEmpty()) {
    		q1.add(qtemp.poll());
    	}
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
