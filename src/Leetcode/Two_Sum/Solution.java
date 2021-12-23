import java.util.*;

class Main {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        Element[] numArr = new Element[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numArr[i] = new Element(i, nums[i]);
        }

        Comparator<Element> comparator = new Comparator<Element>() {
            @Override
            public int compare(Element a, Element b) {
                return a.val - b.val;
            }
        };

        Arrays.sort(numArr, comparator);

        for (int i = 0; i < numArr.length; i++) {
            int left = i;
            int right = numArr.length - 1;

            int targetTemp = target - numArr[i].val;
            int mid = i;

            boolean check = false;

            while (left <= right) {
                mid = (left + right) / 2;

                int midVal = numArr[mid].val;

                if (mid == i || midVal < targetTemp) {
                    left = mid + 1;
                } else if (midVal > targetTemp) {
                    right = mid - 1;
                } else {
                    check = true;
                    break;
                }
            }

            if (check) {
                answer[0] = numArr[i].idx;
                answer[1] = numArr[mid].idx;
                break;
            }
        }

        return answer;
    }
}

class Element {
    int idx;
    int val;

    Element(int i, int v) {
        idx = i;
        val = v;
    }
}