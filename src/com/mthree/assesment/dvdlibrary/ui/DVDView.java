package com.mthree.assesment.dvdlibrary.ui;

import com.mthree.assesment.dvdlibrary.ui.UserIO;
import com.mthree.assesment.dvdlibrary.dto.DVD;

import java.util.List;

/**
 *
 * DVDView.java - The view class of the DVD library, handling the UI of the application
 *
 * @author Dhalham Mohamed-Ajaz
 * @version 1.0
 *
 */
public class DVDView {

    // Declare UserIO object
    private UserIO io;

    // Constructor for UserIO dependency injection
    public DVDView(UserIO io) {
        this.io = io;
    }

    // Prints the menu of the application, and asks the user for a choice between 1 - 6
    public int printMenuAndGetSelection() {
        io.print("");
        io.print("DVD Library: Main Menu");
        io.print("");
        io.print("1. List DVD's");
        io.print("2. Add New DVD to Library");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Edit a DVD");
        io.print("6. Exit");
        io.print("");

        // Returns int between 1 - 6 based on user choice
        return io.readInt("Please select from the above choices.", 1, 6);
    }

    // Asks user for details of a new DVD being added to the library
    // Returns DVD object based on user input
    public DVD getNewDVDInfo() {
        io.print("");
        String dvdId = io.readString("Please enter the title:");
        String releaseDate = io.readString("Please enter the release date:");
        String directorName = io.readString("Please enter the director's name:");
        float mpaaRating = io.readFloat("Please enter the MPAA rating:");
        String studio = io.readString("Please enter the DVD studio:");
        String userNote = io.readString("Please enter any thoughts or ratings you have for the DVD:");
        DVD currentDVD = new DVD(dvdId);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setDirectorName(directorName);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setStudio(studio);
        currentDVD.setUserNote(userNote);
        return currentDVD;
    }

    // Prints Add DVD banner
    public void displayCreateDVDBanner() {
        io.print("=== Add DVD ===");
    }

    // Prints success banner
    public void displayCreateSuccessBanner() {
        io.print("");
        io.readString("DVD added successfully.  Please hit enter to continue");
    }

    // Prints all the DVDs within the library
    public void displayDVDList(List<DVD> DVDList) {
        for (DVD currentDVD : DVDList) {
            io.print("");
            io.print("Title: " + currentDVD.getDVDId());
            io.print("Release Date: " + currentDVD.getReleaseDate());
            io.print("Director's Name: " + currentDVD.getDirectorName());
            io.print("MPAA Rating: " + currentDVD.getMpaaRating());
            io.print("Studio: " + currentDVD.getStudio());
            io.print("User Notes: " + currentDVD.getUserNote());
        }
        io.print("");
        io.readString("Please hit enter to continue.");
    }

    // Prints display All DVDs banner
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    // Prints display a DVD banner
    public void displayDisplayDVDBanner() {
        io.print("=== Display A DVD ===");
        io.print("");
    }

    // Asks the user to type a DVD title, and returns as a string
    public String getDVDIdChoice() {
        return io.readString("Please enter the DVD title:");
    }

    // Asks the user to type a DVD title to be edited, and returns as a string
    public String getEditDVDIdChoice() {
        return io.readString("Please enter the DVD title you wish to edit:");
    }

    // If DVD exists, displays information about a specific DVD the user has requested for
    public void displayDVD(DVD DVD) {
        if (DVD != null) {
            io.print("");
            io.print("Title: " + DVD.getDVDId());
            io.print("Release Date: " + DVD.getReleaseDate());
            io.print("Director's Name: " + DVD.getDirectorName());
            io.print("MPAA Rating: " + DVD.getMpaaRating());
            io.print("Studio: " + DVD.getStudio());
            io.print("User Notes: " + DVD.getUserNote());
        } else {
            io.print("");
            io.print("No such DVD exists in the library.");
        }
        io.print("");
        io.readString("Please hit enter to continue.");
    }

    // Prints remove DVD banner
    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
        io.print("");
    }

    // Displays the success result of removing a DVD from the library
    public void displayRemoveResult(DVD DVDRecord) {
        if(DVDRecord != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such DVD.");
        }
        io.print("");
        io.readString("Please hit enter to continue.");
    }

    // Prints exit message
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    // Prints unknown command message
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    // Displays error message
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print("");
        io.print(errorMsg);
    }

    // Displays edit DVD banner
    public void displayEditBanner () {
        io.print("=== Edit DVD ===");
        io.print("");
    }

    // If DVD exists, asks user to enter new details for the DVD being edited
    // Returns DVD object with new details
    public DVD checkDVDExists(DVD editedDVD) {
        if (editedDVD != null) {
            io.print("");
            io.print("Please enter new details for the DVD named: " + editedDVD.getDVDId());
            return getNewDVDInfo();
        }
        else {
            io.print("DVD does not exist.");
            io.print("");
            io.readString("Please hit enter to continue.");
            return null;
        }
    }

    // Prints edit success message
    public void editSuccess () {
            io.print("");
            io.readString("DVD edited successfully! Please press enter to continue.");
    }
}
