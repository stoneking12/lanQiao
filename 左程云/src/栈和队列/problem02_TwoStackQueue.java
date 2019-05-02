package ջ�Ͷ���;

import java.util.Stack;

/**
 * @author ����
 * @date 2019/4/17 - 20:57
 */
public class problem02_TwoStackQueue {
        public static class TwoStacksQueue {
            public Stack<Integer> stackPush;
            public Stack<Integer> stackPop;

            public TwoStacksQueue() {
                stackPush = new Stack<Integer>();
                stackPop = new Stack<Integer>();
            }

            public void add(int pushInt) {
                stackPush.push(pushInt);
            }

            public int poll() {
                if (stackPop.empty() && stackPush.empty()) {
                    throw new RuntimeException("Queue is empty!!");
                } else if (stackPop.empty()) {
                    while (!stackPush.empty()) {
                        stackPop.push(stackPush.pop());
                    }
                }
                return stackPop.pop();
            }

            public int peek() {
                if (stackPop.empty() && stackPush.empty()) {
                    throw new RuntimeException("Queue is empty!!!");
                } else if (stackPop.empty()) {
                    while (!stackPush.empty()) {
                        stackPop.push(stackPush.pop());
                    }
                }
                return stackPop.peek();
            }
        }

        public static void main(String[] args) {
            TwoStacksQueue test = new TwoStacksQueue();
            test.add(1);
            test.add(2);
            test.add(3);
            System.out.println(test.peek());
            System.out.println(test.poll());
            System.out.println(test.peek());
            System.out.println(test.poll());
            System.out.println(test.peek());
            System.out.println(test.poll());
           // System.out.println(test.poll());
        }
}
