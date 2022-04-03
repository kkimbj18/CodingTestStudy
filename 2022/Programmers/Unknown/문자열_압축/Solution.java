package Programmers.Unknown.문자열_압축;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        
        char[] sarr = s.toCharArray();
        
        if (sarr.length == 1) return 1;
        
        for (int i = 1; i <= sarr.length / 2; i++) {
            int startIdx = 0;
            StringBuilder sb = new StringBuilder();
            
            while(true) {
                if (startIdx + i > sarr.length) {
                    sb.append(s.substring(startIdx));
                    break;
                }
                    
                int count = 1;
                
                String prev = s.substring(startIdx, i + startIdx);
                // System.out.println(prev);
                
                while(true) {
                    if (startIdx + (count+1)*i > sarr.length) break;
                    
                    String next = s.substring(startIdx + count*i, startIdx + (count+1)*i);
                    // System.out.println(next);
                    
                    if (prev.equals(next)) count++;
                    else break;
                }
                
                if (count > 1) {
                    sb.append(count + prev);
                    startIdx += count * i;
                } else {
                    sb.append(prev);
                    startIdx += i;
                }
                
            }
            
            int localMin = sb.toString().length();
            // System.out.println(i + " " + sb.toString());

            if (localMin < min) min = localMin;
        }
        
        answer = min;
        
        return answer;
    }
}
