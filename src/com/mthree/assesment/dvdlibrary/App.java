package com.mthree.assesment.dvdlibrary;

import com.mthree.assesment.dvdlibrary.controller.DVDController;
import com.mthree.assesment.dvdlibrary.dao.DVDDao;
import com.mthree.assesment.dvdlibrary.dao.DVDDaoFileImpl;
import com.mthree.assesment.dvdlibrary.ui.DVDView;
import com.mthree.assesment.dvdlibrary.ui.UserIO;
import com.mthree.assesment.dvdlibrary.ui.UserIOImpl;

/**
 *
 * App.java - Main class for the DVD library application. Instantiates the controller
 *            and injects both the DAO and View dependencies.
 *
 * @author Dhalham Mohamed-Ajaz
 * @version 1.0
 *
 */

public class App {

    public static void main(String[] args) {
        // Create io, view and dao objects
        UserIO myIo = new UserIOImpl();
        DVDView myView = new DVDView(myIo);
        DVDDao myDao = new DVDDaoFileImpl();

        // Create controller object, inject dependencies and run application
        DVDController controller = new DVDController(myDao, myView);
        controller.run();
    }

}

