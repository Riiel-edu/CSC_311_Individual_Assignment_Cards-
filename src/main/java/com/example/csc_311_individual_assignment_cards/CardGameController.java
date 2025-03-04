package com.example.csc_311_individual_assignment_cards;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class CardGameController {

    //------------------------------------------------------------------------------------------------------------------------------------------
    //                                                       Declarations
    //------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button solutionButton;

    @FXML
    private TextField outField;

    @FXML
    private Button refreshButton;

    @FXML
    private TextField inField;

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

    @FXML
    private int card1Val;

    @FXML
    private int card2Val;

    @FXML
    private int card3Val;

    @FXML
    private int card4Val;

    //------------------------------------------------------------------------------------------------------------------------------------------
    //                                                          Events
    //------------------------------------------------------------------------------------------------------------------------------------------


    /**
     * Reloads the images on the cards to a new set of cards
     */
    @FXML
    protected void refresh() {

        //Initialize the list if the cards aren't placed in yet
        if(size != 0) {
            initialize();
        }

        //Obtain random numbers between 0 and 51
        Random random = new Random();

        while(true) {
            int rand1 = random.nextInt(0, 51);
            int rand2 = random.nextInt(0, 51);
            int rand3 = random.nextInt(0, 51);
            int rand4 = random.nextInt(0, 51);

            //Check whether a card is repeated
            if(rand1 != rand2 || rand1 != rand3 || rand1 == rand4) {
                if(rand2 != rand3 || rand2 != rand4) {
                    if(rand3 != rand4) {
                        //if the checks are passed set the images to the new cards set the new values and stop the loop
                        card1.setImage(cards[rand1].getImage());
                        card2.setImage(cards[rand2].getImage());
                        card3.setImage(cards[rand3].getImage());
                        card4.setImage(cards[rand4].getImage());

                        card1Val = cards[rand1].getValue();
                        card2Val = cards[rand2].getValue();
                        card3Val = cards[rand3].getValue();
                        card4Val = cards[rand4].getValue();

                        break;
                    }
                }
            }
        }

    }

    /**
     * Finds a solution for the current set of cards
     */
    @FXML
    protected void findSolution() {

    }

    /**
     * Verifies whether the inputted solution is correct
     */
    @FXML
    protected void verifySolution() {
    }

    //------------------------------------------------------------------------------------------------------------------------------------------
    //                                                           Card Array
    //------------------------------------------------------------------------------------------------------------------------------------------

    public Card[] cards = new Card[52];

    private int size = 0;

    /**
     * Sets values within the cards array
     */
    public void initialize() {

        //brute force method after losing code for easy implementation
        cards[0] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\ace_of_clubs.png", 1);
        cards[1] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\ace_of_diamonds.png", 1);
        cards[2] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\ace_of_hearts.png", 1);
        cards[3] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\ace_of_spades.png", 1);

        cards[4] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\2_of_clubs.png", 2);
        cards[5] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\2_of_diamonds.png", 2);
        cards[6] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\2_of_hearts.png", 2);
        cards[7] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\2_of_spades.png", 2);

        cards[8] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\3_of_clubs.png", 3);
        cards[9] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\3_of_diamonds.png", 3);
        cards[10] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\3_of_hearts.png", 3);
        cards[11] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\3_of_spades.png", 3);

        cards[12] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\4_of_clubs.png", 4);
        cards[13] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\4_of_diamonds.png", 4);
        cards[14] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\4_of_hearts.png", 4);
        cards[15] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\4_of_spades.png", 4);

        cards[16] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\5_of_clubs.png", 5);
        cards[17] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\5_of_diamonds.png", 5);
        cards[18] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\5_of_hearts.png", 5);
        cards[19] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\5_of_spades.png", 5);

        cards[20] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\6_of_clubs.png", 6);
        cards[21] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\6_of_diamonds.png", 6);
        cards[22] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\6_of_hearts.png", 6);
        cards[23] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\6_of_spades.png", 6);

        cards[24] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\7_of_clubs.png", 7);
        cards[25] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\7_of_diamonds.png", 7);
        cards[26] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\7_of_hearts.png", 7);
        cards[27] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\7_of_spades.png", 7);

        cards[28] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\8_of_clubs.png", 8);
        cards[29] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\8_of_diamonds.png", 8);
        cards[30] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\8_of_hearts.png", 8);
        cards[31] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\8_of_spades.png", 8);

        cards[32] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\9_of_clubs.png", 9);
        cards[33] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\9_of_diamonds.png", 9);
        cards[34] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\9_of_hearts.png", 9);
        cards[35] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\9_of_spades.png", 9);

        cards[36] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\10_of_clubs.png", 10);
        cards[37] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\10_of_diamonds.png", 10);
        cards[38] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\10_of_hearts.png", 10);
        cards[39] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\10_of_spades.png", 10);

        cards[40] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\jack_of_clubs.png", 11);
        cards[41] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\jack_of_diamonds.png", 11);
        cards[42] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\jack_of_hearts.png", 11);
        cards[43] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\jack_of_spades.png", 11);

        cards[44] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\queen_of_clubs.png", 12);
        cards[45] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\queen_of_diamonds.png", 12);
        cards[46] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\queen_of_hearts.png", 12);
        cards[47] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\queen_of_spades.png", 12);

        cards[48] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\king_of_clubs.png", 13);
        cards[49] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\king_of_diamonds.png", 13);
        cards[50] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\king_of_hearts.png", 13);
        cards[51] = new Card("C:\\Users\\nycpu\\IdeaProjects\\CSC_311_Individual_Assignment_Cards\\src\\main\\resources\\com\\example\\csc_311_individual_assignment_cards\\Images\\king_of_spades.png", 13);

        size = 52;
    }
}