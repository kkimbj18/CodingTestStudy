class Solution {
    public int solution(String s) {
        int len = s.length();
        int min = Integer.MAX_VALUE;
        
        if (len == 1) return 1;
        // 글자 단위
        loop1:
        for (int i = 1; i <= len/2; i++) {
            String str = s.substring(0, i);
            int index = i;
            int count = 1;
            StringBuilder sb = new StringBuilder();
            while(index+i <= len) {
                String target = s.substring(index, index + i);
                
                if (str.equals(target)) {
                    count++;
                } else {
                    if (count == 1) {
                        sb.append(str);
                    } else {
                        sb.append(count)
                            .append(str);
                    }
                    
                    count = 1;
                    str = target;
                }
                
                index += i;
            }
            
            if (count != 1) {
                sb.append(count)
                    .append(str);
                sb.append(s.substring(index));
            } else {
                sb.append(s.substring(index-i));
            }
            
            // System.out.println(sb);
            
            min = Math.min(min, sb.length());
        }
        
        return min;
    }
}