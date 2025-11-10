import java.util.*;
public class PatientSearch {
    public static void main(String[] args) {
        int[] patientIDs = {101, 104, 108, 112, 118, 125};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Patient ID to search: ");
        int id = sc.nextInt();
        int low = 0, high = patientIDs.length - 1, mid, found = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (patientIDs[mid] == id) { found = mid; break; }
            else if (patientIDs[mid] < id) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println(found == -1 ? "Patient not found" : "Patient record found at index " + found);
    }
}
