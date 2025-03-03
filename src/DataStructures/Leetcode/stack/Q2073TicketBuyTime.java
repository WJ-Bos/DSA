package DataStructures.Leetcode.stack;

import java.util.Arrays;

/**
 * There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and the (n - 1)th person is at the back of the line.
 * You are given a 0-indexed integer array tickets of length n where the number of tickets that the ith person would like to buy is tickets[i].
 * Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and has
 * to go back to the end of the line (which happens instantaneously) in order to buy more tickets. If a person does not have any tickets left to buy.
 * The person will leave the line.
 * <p>
 * Return the time taken for the person initially at position k (0-indexed) to finish buying tickets.
 * <p>
 * Input: tickets = [2,3,2], k = 2
 * Output: 6
 * Explanation:
 * <p>
 * The queue starts as [2,3,2], where the kth person is underlined.
 * After the person at the front has bought a ticket, the queue becomes [3,2,1] at 1 second.
 * Continuing this process, the queue becomes [2,1,2] at 2 seconds.
 * Continuing this process, the queue becomes [1,2,1] at 3 seconds.
 * Continuing this process, the queue becomes [2,1] at 4 seconds. Note: the person at the front left the queue.
 * Continuing this process, the queue becomes [1,1] at 5 seconds.
 * Continuing this process, the queue becomes [1] at 6 seconds. The kth person has bought all their tickets, so return 6.
 */

public class Q2073TicketBuyTime {

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int kVal = tickets[k];
        int seconds = 0;
        while (kVal > 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] != 0) {
                    tickets[i]--;
                    seconds++;
                    if (i == k) {
                        kVal = tickets[i];
                        if (tickets[i] == 0) {
                            break;
                        }
                    }
                }
            }
        }
        return seconds;
    }

    public static void main(String[] args) {
        int[] tickets = new int[]{2, 3, 2};
        System.out.println(timeRequiredToBuy(tickets, 2));
    }
}
