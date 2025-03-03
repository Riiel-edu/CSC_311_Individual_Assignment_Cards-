package com.example.csc_311_individual_assignment_cards;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class CardGameController {

    //------------------------------------------------------------------------------------------------------------------------------------------
    //                                                       Declarations
    //------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button solutionButton;

    @FXML
    private TextArea outputField;

    @FXML
    private Button refreshButton;

    @FXML
    private ImageView inputField;

    @FXML
    private Button verifyButton;

    @FXML
    private ImageView card1;

    @FXML
    private ImageView card2;

    @FXML
    private ImageView card3;

    @FXML
    private ImageView card4;

    //Creating a list of Card objects

    //------------------------------------------------------------------------------------------------------------------------------------------
    //                                                          Events
    //------------------------------------------------------------------------------------------------------------------------------------------


    /**
     * Reloads the images on the cards to a new set of cards
     */
    @FXML
    protected void refresh() {

    }

    /**
     * Finds a solution for the current set of cards
     */
    @FXML
    protected void findSolution() { }

    /**
     * Verifies whether the inputted solution is correct
     */
    @FXML
    protected void verifySolution() { }
}