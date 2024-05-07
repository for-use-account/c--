package leetcode;
import java.util.*;

// This File consists of all the problems solved in May Daily Leetcode Challenge 2024
public class MayDailyProblems {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val; this.next = next;
        }
    }
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to May Daily Leetcode Problems");
        System.out.println("This is Yasaswin Palukuri, with solutions to the Daily Problems of May 2024");
        System.out.println("So, without any further ado, let's get started");
        do{
            System.out.println("Enter the day of the problem you want the answer for or 88 to Exit:");
            System.out.println("Day 1: Reverse Prefix of Word");
            System.out.println("Day 2: Largest Positive Integer That Exists With Its Negative");
            System.out.println("Day 3: Compare Version Numbers");
            System.out.println("Day 4: Boats to Save People");
            System.out.println("Day 5: Delete Node in a Linked List");
            System.out.println("Day 6: Remove Nodes From Linked List");
            System.out.println("Day 7: Double a Number Represented as a Linked List");
            System.out.println("88: Exit");
            int day = scan.nextInt();
            switch(day){
                case 1:
                    System.out.println("Enter the word and the character you want to reverse the prefix of:");
                    String word = scan.next();
                    char ch = scan.next().charAt(0);
                    System.out.println("The word after reversing the prefix of the character is: " + reversePrefix(word, ch));
                    break;
                case 2:
                    System.out.println("Enter the number of elements in the array:");
                    int n = scan.nextInt();
                    int[] nums = new int[n];
                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < n; i++) {
                        nums[i] = scan.nextInt();
                    }
                    System.out.println("The largest positive integer that exists with its negative is(Using HashSet): " + findMaxK(nums));
                    System.out.println("The largest positive integer that exists with its negative is(Using Arrays.sort and Arrays.binarySearch): " + findMaxKSorting(nums));
                    System.out.println("The largest positive integer that exists with its negative is(Using Two Pointer Technique): " + findMaxK2Pointers(nums));
                    break;
                case 3:
                    System.out.println("Enter the two version numbers you want to compare:");
                    String version1 = scan.next();
                    String version2 = scan.next();
                    System.out.println("The comparison of the two version numbers is: " + compareVersion(version1, version2));
                    break;
                case 4:
                    System.out.println("Enter the number of people and the limit of the boat:");
                    int n1 = scan.nextInt();
                    int[] people = new int[n1];
                    for (int i = 0; i < n1; i++) {
                        people[i] = scan.nextInt();
                    }
                    int limit = scan.nextInt();
                    System.out.println("The number of boats required to save the people is: " + numRescueBoats(people, limit));
                    break;
                case 5:
                    System.out.println("Enter the number of elements in the linked list:");
                    int n2 = scan.nextInt();
                    System.out.println("Enter the elements of the linked list:");
                    ListNode head = new MayDailyProblems().new ListNode(scan.nextInt());
                    ListNode temp = head;
                    for (int i = 1; i < n2; i++) {
                        temp.next = new MayDailyProblems().new ListNode(scan.nextInt());
                        temp = temp.next;
                    }
                    System.out.println("Enter the node value you want to delete:");
                    int nodeVal = scan.nextInt();
                    ListNode node = head;
                    while (node.val != nodeVal) {
                        node = node.next;
                    }
                    deleteNode(node);
                    System.out.println("The linked list after deleting the node is:");
                    while (head != null) {
                        System.out.print(head.val + " ");
                        head = head.next;
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Enter the number of elements in the linked list:");
                    int n3 = scan.nextInt();
                    System.out.println("Enter the elements of the linked list:");
                    ListNode head1 = new MayDailyProblems().new ListNode(scan.nextInt());
                    ListNode temp1 = head1;
                    for (int i = 1; i < n3; i++) {
                        temp1.next = new MayDailyProblems().new ListNode(scan.nextInt());
                        temp1 = temp1.next;
                    }
                    ListNode res = removeNodes(head1);
                    System.out.println("The linked list after removing the nodes is:");
                    while (res != null) {
                        System.out.print(res.val + " ");
                        res = res.next;
                    }
                    System.out.println();
                    break;
                case 7:
                    break;
                case 88:
                    System.out.println("Thank you for using the May Daily Leetcode Problems :)");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry, the problem for the day you entered is not available");
                    break;
            }
        }while(true);
    }

    // 2000 May 1: Reverse Prefix of Word - Easy
    /*
    Example 1:

    Input: word = "abcdefd", ch = "d"
    Output: "dcbaefd"
    Explanation: The first occurrence of "d" is at index 3. 
    Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
    Example 2:

    Input: word = "xyxzxe", ch = "z"
    Output: "zxyxxe"
    Explanation: The first and only occurrence of "z" is at index 3.
    Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
    Example 3:

    Input: word = "abcd", ch = "z"
    Output: "abcd"
    Explanation: "z" does not exist in word.
    You should not do any reverse operation, the resulting string is "abcd".
     */
    static public String reversePrefix(String word, char ch) {
        int index = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                index = i;
                break;
            }
        }
        String fh = word.substring(0, index + 1);
        String sh = word.substring(index + 1);
        
        StringBuilder sb = new StringBuilder(fh);
        sb.reverse();
        sb.append(sh);
        
        return sb.toString();
    }

    // 2441 - Largest Positive Integer That Exists With Its Negative - Easy
    /*
    Example 1:
    Input: nums = [-1,2,-3,3]
    Output: 3
    Explanation: 3 is the only valid k we can find in the array.
   
    Example 2:
    Input: nums = [-1,10,6,7,-7,1]
    Output: 7
    Explanation: Both 1 and 7 have their corresponding negative values in the array. 7 has a larger value.
    
    Example 3:
    Input: nums = [-10,8,6,7,-2,-3]
    Output: -1
    Explanation: There is no a single valid k, we return -1.
    */
    // Here I am inputing three methods for this problem.
    // Method 1: Using HashSet
    static public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxK = Integer.MIN_VALUE;
        for (int num : nums) {
            if (set.contains(-num)) {
                maxK = Math.max(maxK, num);
            }
        }
        return maxK != Integer.MIN_VALUE ? maxK : -1;
    }
    // Method 2: Using Sorting
    static public int findMaxKSorting(int[] nums) {
        Arrays.sort(nums);
        int maxK = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (Arrays.binarySearch(nums, -nums[i]) >= 0) {
                maxK = Math.max(maxK, nums[i]);
            }
        }
        return maxK != Integer.MIN_VALUE ? maxK : -1;
    }
    // Method 3: Using Two Pointers
    static public int findMaxK2Pointers(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int maxK = Integer.MIN_VALUE;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == 0) {
                maxK = Math.max(maxK, nums[right]);
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        return maxK != Integer.MIN_VALUE ? maxK : -1;
    }

    // Day 3: Compare Version Numbers - Q165(Medium)
    /*
    Example 1:
    Input: version1 = "1.01", version2 = "1.001"
    Output: 0
    Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
    
    Example 2:
    Input: version1 = "1.0", version2 = "1.0.0"
    Output: 0
    Explanation: version1 does not specify revision 2, which means it is treated as "0".

    Example 3:
    Input: version1 = "0.1", version2 = "1.1"
    Output: -1
    Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
    */
    static public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i=0;i<Math.max(v1.length,v2.length);i++){
            int num1 = i<v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i<v2.length ? Integer.parseInt(v2[i]) : 0;
            if(num1<num2){
                return -1;
            }
            if(num1>num2){
                return 1;
            }
        }
        return 0;
    }

    // Day 4: Boats to Save People - Q881(Medium)
    /*
    Example 1:
    Input: people = [1,2], limit = 3
    Output: 1
    Explanation: 1 boat (1, 2)
    
    Example 2:
    Input: people = [3,2,2,1], limit = 3
    Output: 3
    Explanation: 3 boats (1, 2), (2) and (3)
    
    Example 3:
    Input: people = [3,5,3,4], limit = 5
    Output: 4
    Explanation: 4 boats (3), (3), (4), (5)
    */

    static public int numRescueBoats(int[] p, int limit) {
        Arrays.sort(p);
        int l = 0, ans = 0, r = p.length-1;
        while(l <= r){
            ans++;
            if(p[l] + p[r] <= limit) l++;
            r--;
        }
        return ans;
    }

    // Day 5: Delete Node in a Linked List - Q237(Easy)
    /*
    Example 1:
    Input: head = [4,5,1,9], node = 5
    Output: [4,1,9]
    Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

    Example 2:
    Input: head = [4,5,1,9], node = 1
    Output: [4,5,9]
    Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
    */
    static public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    // Day 6: Remove Nodes From Linked List - Q2487(Medium)
    /*
    Example 1:
    Input: head = [5,2,13,3,8]
    Output: [13,8]
    Explanation: The nodes that should be removed are 5, 2 and 3.
    - Node 13 is to the right of node 5.
    - Node 13 is to the right of node 2.
    - Node 8 is to the right of node 3.

    Example 2:
    Input: head = [1,2,3,4,5]
    Output: [1,2,3,4,5]
    Explanation: There are no nodes to remove.
    */
    static public ListNode removeNodes(ListNode head) {
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        
        while (cur != null) {
            while (!stack.isEmpty() && stack.peek().val < cur.val) {
                stack.pop();
            }
            stack.push(cur);
            cur = cur.next;
        }
        
        ListNode nxt = null;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            cur.next = nxt;
            nxt = cur;
        }
        
        return cur;
    }


    // Day 7: Double a Number Represented as a Linked List - Q2816(Medium)
    /*
    Example 1:
    Input: head = [1,8,9]
    Output: [3,7,8]
    Explanation:
    The figure above corresponds to the given linked list which represents the number 189. 
    Hence, the returned linked list represents the number 189 * 2 = 378.

    Example 2:
    Input: head = [1,2,3,4]
    Output: [2,4,6,8]
    Explanation:
    The figure above corresponds to the given linked list which represents the number 1234.
    Hence, the returned linked list represents the number 1234 * 2 = 2468.
    */
    static public ListNode doubleIt(ListNode head) {
        if (head.val > 4) {
            head = new MayDailyProblems().new ListNode(0, head);
        }
        ListNode temp = head;
        while (temp != null) {
            temp.val = (temp.val * 2) % 10;
            if (temp.next != null && temp.next.val > 4) {
                temp.val++;
            }
            temp = temp.next;
        }
        return head;
    }
}
