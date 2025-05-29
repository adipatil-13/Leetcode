class StockSpanner {
    class Pair {
        int price;
        int span;
        Pair(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }
    Stack<Pair> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().span;
        }

        stack.push(new Pair(price, span));

        return span;
    }
}
/*
class StockSpanner {
    Stack<int[]> st;
    
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int days = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) {
            days += st.pop()[1];
        }
        st.push(new int[]{price, days});
        return days;    
    }
}
*/