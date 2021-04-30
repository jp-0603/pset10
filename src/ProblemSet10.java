import java.util.Arrays;
import java.util.HashMap;

public class ProblemSet10 {

public static void main (String[] args){
    ProblemSet10 stuff = new ProblemSet10();
    System.out.println(Arrays.toString(stuff.fizzBuzz(1, 6)));
}

    public String[] fizzBuzz(int start, int end) {
        if (start >= end) {
            return null;
        }

        String[] result = new String[end - start];
        int value = 0;

        for (int i = start; i < end; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result[value] = "FizzBuzz";
                value++;
            } else if (i % 3 == 0) {
                result[value] = "Fizz";
                value++;
            } else if (i % 5 == 0) {
                result[value] = "Buzz";
                value++;
            } else {
                result[value] = Integer.toString(i);
                value++;
            }
        }
        return result;
    }

    public int maxSpan(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        if (numbers.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> firstAppearance = new HashMap<Integer, Integer>();
        int length = 1;
        int maxLength = 1;

        for (int i = 0; i < numbers.length; i++) {
            Integer r = firstAppearance.get(numbers[i]);
            if (r == null) {
                firstAppearance.put(numbers[i], i);
            }
            else {
                length = i - r + 1;
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }

        return maxLength;

    }

    public int[] fix34(int[] numbers) {

        if (numbers == null) {
            return null;
        }

        int numThree = 0;
        int numFour = 0;
        int threeIdx = -1;
        int fourIdx = -1;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == 3) {
                if (threeIdx == -1) {
                    threeIdx = i;
                }
                if (i != numbers.length-1 && numbers[i+1] == 3) {
                    return null;
                }
                numThree++;
            }
            else if (numbers[i] == 4) {
                if (fourIdx == -1) {
                    fourIdx = i;
                }
                numFour++;
            }
        }

        if (numThree != numFour) {
            return null;
        }

        for (int j = threeIdx; j < numbers.length; j++) {
            if (numbers[j] == 4) {
                for (int k = 0; k < numbers.length; k++) {
                    if ((numbers[k] == 3)) {
                        int t = numbers[k + 1];
                        numbers[k + 1] = numbers[j];
                        numbers[j] = t;
                    }
                }
            }
        }
        return numbers;
    }

    public int[] fix45(int[] numbers ) {
        if (numbers == null) {
            return null;
        }
        int numFour = 0;
        int numFive = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 4) {
                if (i != numbers.length-1 && numbers[i+1] == 4) {
                    return null;
                }
                numFour++;
            }
            else if (numbers[i] == 5) {
                numFive++;
            }
        }

        if (numFour == 0 && numFive == 0) {
            return null;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 5) {
                for (int k = 0; k < numbers.length; k++) {
                    if (numbers[k] == 4 && numbers[k + 1] != 5) {
                        int m = numbers[k+1];
                        numbers[k + 1] = numbers[i];
                        numbers[i] = m;
                    }
                }
            }
        }
        return numbers;
    }

    public boolean canBalance(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return false;
        }

        int leftBal = 0;
        int rightBal = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j >= 0; j--) {
                leftBal += numbers[j];
            }
            for (int k = i+1; k < numbers.length; k++) {
                rightBal += numbers[k];
            }
            if (rightBal == leftBal) {
                return true;
            }
            leftBal = 0;
            rightBal = 0;
        }
        return false;
    }

    public boolean linearIn(int[] outer, int[] inner) {
        if (outer == null || inner == null || outer.length == 0 || inner.length == 0) {
            return false;
        }
        for (int i = 0; i< outer.length-1; i++) {
            if (outer[i] > outer[i+1]) {
                return false;
            }
        }
        for (int k = 0; k < inner.length-1; k++) {
            if (inner[k] > inner[k+1]) {
                return false;
            }
        }
        boolean found = true;
        for (int j = 0; j < inner.length; j++) {
            int test = 0;
            for (int m = 0; m < outer.length; m++) {
                if (outer[m] == inner[j]) {
                    test += 1;
                }
            }
            if (test == 0) {
                return false;
            }
        }
        return true;
    }

    public int[] squareUp(int n) {
        if (n < 0) {
            return null;
        }
        int[] result = new int[n*n];
        for (int j = 1; j <= n; j++ ) {
            for (int k = 1; k <= n; k++) {

                if (k > n-j) {
                    result[(j-1)*n+k-1] = n-k+1;
                }
            }
        }
        return result;
    }

    public int[] seriesUp(int n) {
        if (n < 0) {
            return null;
        }
        int length = 0;
        for (int k = 1; k <= n; k++) {
            length += k;
        }
        int[] answer = new int[length];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                answer[index] = j + 1;
                index++;
            }
        }
        return answer;
    }

    public int maxMirror(int[] numbers) {

        if (numbers == null) {
            return -1;
        }

        int lowIndex = 0;
        int highIndex = 0;
        int current = 0;
        int max = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int k = numbers.length - 1; k >= 0; k--) {
                if (numbers[i] == numbers[k]) {
                    current = 1;
                    lowIndex = i + 1;
                    highIndex = k - 1;
                    while
                    ((lowIndex <= numbers.length - 1 && highIndex >= 0) &&
                            (numbers[lowIndex] == numbers[highIndex])) {
                        highIndex-=1;
                        lowIndex+=1;
                        current+=1;
                    }

                    if (current > max) {
                        max = current;
                    }
                }
            }
        }
        return max;
    }

    public int countClumps(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        int numOfClumps = 0;
        boolean insideClump = false;
        for (int i = 0; i < numbers.length-1; i++) {
            if ((numbers[i] == numbers[i + 1]) && !insideClump) {
                numOfClumps+=1;
                insideClump = true;
            }
            else if (insideClump && (numbers[i] != numbers[i - 1])) {
                insideClump = false;
            }
        }
        return numOfClumps;
    }
}