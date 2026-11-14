
import java.util.*;

public class Main {

    static class BusPass {
        String passId, regNo, name, route, amount;

        BusPass(String id, String reg, String n,
                String r, String a) {
            passId = id;
            regNo = reg;
            name = n;
            route = r;
            amount = a;
        }
    }

    static ArrayList<BusPass> database = new ArrayList<>();
    static ArrayList<String> failureReport = new ArrayList<>();

    // Validate and migrate records
    static void migrateRecords(ArrayList<BusPass> fileRecords) {

        for (BusPass p : fileRecords) {

            if (p.passId.isEmpty() || p.regNo.isEmpty()
                    || p.name.isEmpty() || p.route.isEmpty()) {

                failureReport.add(p.passId + " - Missing field");
                continue;
            }

            try {
                int amount = Integer.parseInt(p.amount);

                if (amount <= 0) {
                    failureReport.add(p.passId + " - Invalid amount");
                    continue;
                }

                database.add(p);
                System.out.println(p.passId + " - Migration Successful");

            } catch (NumberFormatException e) {
                failureReport.add(p.passId + " - Non-numeric amount");
            }
        }
    }

    // Display migrated records
    static void displayDatabase() {

        System.out.println("\nDATABASE RECORDS");

        System.out.println("PassID | RegNo | Name | Route | Amount");

        for (BusPass p : database) {
            System.out.println(
                p.passId + " | " + p.regNo + " | "
                + p.name + " | " + p.route + " | " + p.amount
            );
        }
    }

    // Display failed records
    static void displayFailureReport() {

        System.out.println("\nFAILURE REPORT");

        if (failureReport.isEmpty()) {
            System.out.println("No failed records");
        } else {
            for (String error : failureReport) {
                System.out.println(error);
            }
        }
    }

    // Display database metadata
    static void displayMetadata() {

        System.out.println("\nDATABASE METADATA");

        System.out.println("Database Name: MySQL");
        System.out.println("Database Version: Example Version");
        System.out.println("Driver Name: MySQL JDBC Driver");
        System.out.println("Driver Version: Example Version");

        System.out.println("\nTable Name: BusPass");

        System.out.println("Column 1: passId - VARCHAR");
        System.out.println("Column 2: regNo - VARCHAR");
        System.out.println("Column 3: passengerName - VARCHAR");
        System.out.println("Column 4: route - VARCHAR");
        System.out.println("Column 5: amount - INTEGER");
    }

    // Compare storage methods
    static void compareStorage() {

        System.out.println("\nSTORAGE COMPARISON");

        System.out.println("Text File:");
        System.out.println("Simple storage but slow searching for large data.");

        System.out.println("\nSerialization:");
        System.out.println("Stores Java objects but has limited sharing.");

        System.out.println("\nDatabase:");
        System.out.println("Supports efficient searching and multiple users.");
    }

    // Final engineering decision
    static void finalDecision() {

        System.out.println("\nFINAL ENGINEERING DECISION");

        System.out.println("Recommended Storage: MySQL Database");

        System.out.println("1. Suitable for 12 campuses.");
        System.out.println("2. Supports concurrent users.");
        System.out.println("3. Provides efficient searching.");
        System.out.println("4. Maintains data consistency.");
        System.out.println("5. Supports backup and recovery.");
    }

    public static void main(String[] args) {

        ArrayList<BusPass> fileRecords = new ArrayList<>();

        // Sample file records
        fileRecords.add(new BusPass(
            "P101", "R101", "Arun", "Chennai", "500"));

        fileRecords.add(new BusPass(
            "P102", "R102", "Divya", "Avadi", "600"));

        fileRecords.add(new BusPass(
            "P103", "R103", "Kumar", "Tambaram", "abc"));

        fileRecords.add(new BusPass(
            "P104", "", "Anu", "Chennai", "700"));

        fileRecords.add(new BusPass(
            "P105", "R105", "Priya", "Ambattur", "800"));

        System.out.println("BUS PASS DATA MIGRATION");

        migrateRecords(fileRecords);

        displayDatabase();

        displayFailureReport();

        displayMetadata();

        compareStorage();

        finalDecision();

        System.out.println("\nMigration Process Completed");
    }
}
