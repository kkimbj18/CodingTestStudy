class Solution {
    public String solution(String p) {
        String answer = "";
        
        return recur(p);
    }
    
    public static String recur(String input) {
        if (input.equals("")) return "";
        
        int open = 0;
        int close = 0;
        int index = 0;
        do {
            if (input.charAt(index++) == '(') open++;
            else close++;
        } while(open != close);
        
        String u = input.substring(0, index);
        String v = input.substring(index);
        
        if (checkCorrectWord(u)) return u + recur(v);
        else {
            StringBuilder sb = new StringBuilder();
            sb.append('(')
                .append(recur(v))
                .append(')');
            
            u = u.substring(1, u.length()-1);
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') sb.append(')');
                else sb.append('(');
            }
            return sb.toString();
        }
    }
    
    public static boolean checkCorrectWord(String u) {
        int diff = 0;
        
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == ')') diff--;
            else diff++;
            
            if (diff < 0) return false;
        }
        
        return true;
    }
}