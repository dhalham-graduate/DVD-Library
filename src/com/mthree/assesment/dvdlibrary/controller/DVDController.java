package com.mthree.assesment.dvdlibrary.controller;

import com.mthree.assesment.dvdlibrary.dao.DVDDao;
import com.mthree.assesment.dvdlibrary.dao.DVDDaoException;
import com.mthree.assesment.dvdlibrary.dto.DVD;
import com.mthree.assesment.dvdlibrary.ui.DVDView;

import java.util.List;

/**
 *
 * DVDController.java - The controller of the DVD Library application
 *
 * @author Dhalham Mohamed-Ajaz
 * @version 1.0
 *
 */
public class DVDController {

    // Declare view and dao objects
    private DVDView view;
    private DVDDao dao;

    // Constructor for view and dao injection
    public DVDController(DVDDao dao, DVDView view) {
        this.dao = dao;
        this.view = view;
    }

    // Run method - first method to run in the application
    public void run() {

        boolean keepGoing = true;    // Boolean for constant loop of the application, until user wants to end application (case 6)
        int menuSelection = 0;       // Number for user choice

        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();    // Gets number from user for choice of the menu

                switch (menuSelection) {
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        createDVD();
                        break;
                    case 3:
                        viewDVD();
                        break;
                    case 4:
                        removeDVD();
                        break;
                    case 5:
                        editDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (DVDDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    // Returns integer for user choice, between the range 1 - 6
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    // Adds DVD to library
    private void createDVD() throws DVDDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getDVDId(), newDVD);
        view.displayCreateSuccessBanner();
    }

    // Lists all DVD's within library
    private void listDVDs() throws DVDDaoException{
        view.displayDisplayAllBanner();
        List<DVD> DVDList = dao.getAllDVD();
        view.displayDVDList(DVDList);
    }

    // Views a specific DVD
    private void viewDVD() throws DVDDaoException{
        view.displayDisplayDVDBanner();
        String dvdId = view.getDVDIdChoice();
        DVD DVD = dao.getDVD(dvdId);
        view.displayDVD(DVD);
    }

    // Removes a specific DVD from library
    private void removeDVD() throws DVDDaoException{
        view.displayRemoveDVDBanner();
        String dvdId = view.getDVDIdChoice();
        DVD removedDVD = dao.removeDVD(dvdId);
        view.displayRemoveResult(removedDVD);
    }

    // Edits a DVD in the library
    private void editDVD() throws DVDDaoException{
        view.displayEditBanner();
        String dvdId = view.getEditDVDIdChoice();
        DVD editedDVD = dao.editDVD(dvdId);
        DVD newDVD = view.checkDVDExists(editedDVD);
        if(newDVD != null) {
            dao.addEditedDVD(newDVD.getDVDId(), newDVD);
            view.editSuccess();
        }
    }

    // Prints unknown command message
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    // Prints exit message
    private void exitMessage() {
        view.displayExitBanner();
    }
}

