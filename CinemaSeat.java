/* A cinema has n rows of seats, numbered from 1 to n and there are ten seats in each row, labelled from 1 to 10 as shown in the figure above... Given the array reservedSeats containing the numbers of seats already reserved, for example, reservedSeats[i] = [3,8] means the seat located in row 3 and labelled with 8 is already reserved... Return the maximum number of four-person groups you can assign on the cinema seats... A four-person group occupies four adjacent seats in one single row... Seats across an aisle (such as [3,3] and [3,4]) are not considered to be adjacent, but there is an exceptional case on which an aisle split a four-person group, in that case, the aisle split a four-person group in the middle, which means to have two people on each side...
 * Eg 1:    n = 3    reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]           Output = 4
 * Eg 2:    n = 2    reservedSeats = [[2,1],[1,8],[2,6]]                              Output = 2
 * Eg 3:    n = 4    reservedSeats = [[4,3],[1,4],[4,6],[1,7]]                        Output = 4
 */
import java.util.*;
public class CinemaSeat
{
    public int MaximumGrouping(int m, int reserved[][])
    {
        int cinema[][] = new int[m][10];
        for(int i = 0; i < reserved[0].length; i++)   // Every reservation seat is set to 1...
            cinema[reserved[0][i]][reserved[1][i]] = 1;
        System.out.println("The Reserved Seats are marked as 1 ");
        for(int i = 0; i < m; i++)
        {   // Printing the Cinema Hall Seats...
            for(int j = 0; j < 10; j++)
                System.out.print(cinema[i][j]+", ");
            System.out.println();
        }
        int count = 0;    
        for(int i = 0; i < m; i++)
        {
            if(cinema[i][1] != 1 && cinema[i][2] != 1 && cinema[i][3] != 1 && cinema[i][4] != 1)
            {   // If seats are available at the given indices...
                count++;
                if(cinema[i][5] != 1 && cinema[i][6] != 1 && cinema[i][7] != 1 && cinema[i][8] != 1)
                    count++;    // Sub condition of above if statement...
            }
            else if(cinema[i][3] != 1 && cinema[i][4] != 1 && cinema[i][5] != 1 && cinema[i][6] != 1)
                count++;
            else if(cinema[i][5] != 1 && cinema[i][6] != 1 && cinema[i][7] != 1 && cinema[i][8] != 1)
                count++;
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m, k, ky, kx;
        System.out.print("Enter the number of rows in the Cinema hall : ");
        m = sc.nextInt();
        System.out.print("Enter the number of seats reserved : ");
        k = sc.nextInt();
        int reserved[][] = new int[2][k];
        System.out.println("The Rows and Columns are beginning from 1 !!");
        for(int i = 0; i < k; i++)
        {
            System.out.print("Enter Row of "+(i+1)+" th Reservation : ");
            kx = sc.nextInt();
            reserved[0][i] = kx - 1;
            System.out.print("Enter Column of "+(i+1)+" th Reservation : ");
            ky = sc.nextInt();
            reserved[1][i] = ky - 1;
        }
        System.out.println("The Seat Reservations : ");
        for(int i = 0; i < k; i++)
            System.out.print("["+reserved[0][i]+", "+reserved[1][i]+"] ,");
        System.out.println();
        CinemaSeat cinemaseat = new CinemaSeat();         // Object creation...
        k = cinemaseat.MaximumGrouping(m, reserved);      // Function call...
        System.out.println("The total number of four seat groups possible : "+k);
        sc.close();
    }
}

// Time Complexity  - O(m + n) time...      m = number of rows, n = number of reservations...
// Space Complexity - O(n^2) space...

/* DEDUCTIONS :- 
 * 1. We create a matrix and check for the grouping...
 * 2. Use Greedy with divide and conquer policy, since the number of columns are constant, the subproblem set is limited...
*/