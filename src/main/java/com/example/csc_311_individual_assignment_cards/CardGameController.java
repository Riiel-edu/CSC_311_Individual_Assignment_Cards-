package com.example.csc_311_individual_assignment_cards;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.util.*;

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
    private int val1;

    @FXML
    private int val2;

    @FXML
    private int val3;

    @FXML
    private int val4;

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

                        val1 = cards[rand1].getValue();
                        val2 = cards[rand2].getValue();
                        val3 = cards[rand3].getValue();
                        val4 = cards[rand4].getValue();

                        break;
                    }
                }
            }
        }

    }

    /**
     * Finds whether a solution exists for the current set of cards
     */
    @FXML
    protected void findSolution() {

        boolean valid = true;

        //Create a priority queue to sort the values
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(val1);
        pq.add(val2);
        pq.add(val3);
        pq.add(val4);

        int[] checker = new int[4];

        for(int i = 0; i < 4; i++) {
            checker[i] = pq.remove();
        }

        //Check all cases where there is no solution
        if(checker[0] == 1 && checker[1] == 1 && checker[2] == 1 && checker[3] == 1) {
            valid = false;
        }

        if(checker[0] == 2 && checker[1] == 2 && checker[2] == 2 && checker[3] == 2) {
            valid = false;
        }

        if(checker[0] == 3 && checker[1] == 10 && checker[2] == 10 && checker[3] == 10) {
            valid = false;
        }

        if(checker[0] == 3 && checker[1] == 4 && checker[2] == 6 && checker[3] == 7) {
            valid = false;
        }

        if(checker[0] == 13 && checker[1] == 13 && checker[2] == 13 && checker[3] == 13) {
            valid = false;
        }

        //Display different output if the output field has a solution or not
        if(valid) {
            outField.setText("This hand has a solution.");
        } else {
            outField.setText("This hand does not possess a solution");
        }

    }

    /**
     * Verifies whether the inputted solution is correct
     */
    @FXML
    protected void verifySolution() {
        String equation = inField.getText();
        LinkedList<String> holder = new LinkedList<>();

        for(int i = 0; i < equation.length(); i++) {
            holder.add(equation.substring(i, i + 1));
        }

        if(checkNumbers(holder)) {
            try {
                System.out.println(eval(equation));

                if (eval(equation) == 24) {
                    outField.setText("This solution is correct as the cards add to 24");
                }

                if (eval(equation) != 24) {
                    outField.setText("This solution is incorrect as the cards add to " + eval(equation));
                }
            } catch (EmptyStackException e) {
                outField.setText("The inputted text is not an equation. Please try again.");
            }
        } else {
            outField.setText("Invalid numbers. Please try again.");
        }
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

    //------------------------------------------------------------------------------------------------------------------------------------------
    //                                                           Helper Methods
    //------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Evaluate the string into an expression
     * @param expression the expression being evaluated
     * @return the number the equation equates to
     */
    public int eval(String expression) {

        LinkedList<Integer> operands = new LinkedList<>();
        LinkedList<Character> operators = new LinkedList<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // skip spaces
            if (ch == ' ') {
                continue;
            }

            // obtain numbers
            if (Character.isDigit(ch)) {

                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(expression.charAt(i));
                    i++;
                }
                i--;
                operands.push(num);
            }

            // check for operators
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(') {
                if(ch == '(') {
                    operators.pop();
                    operands.push(doMath(operators.pop(), operands.pop(), operands.pop()));
                } else {
                    while (!operators.isEmpty() && goesFirst(ch, operators.peek())) {
                        operands.push(doMath(operators.pop(), operands.pop(), operands.pop()));
                    }
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            operands.push(doMath(operators.pop(), operands.pop(), operands.pop()));
        }

        return operands.pop();
    }


    /**
     * Orders the operations within the bounds of PEMDAS (minus the parathesis)
     * @param op1 first operator
     * @param op2 second operator
     * @return whether the first op has priority over the second one
     */
    public boolean goesFirst(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Returns the math equations
     * @param op the operation being used
     * @param b the first int
     * @param a the second int
     * @return the total value
     */
    public int doMath(char op, int b, int a) {

        if(op == '+') {
            return a + b;
        } if(op == '-') {
            return a - b;
        } if(op == '*') {
            return a * b;
        } if(op == '/') {
            if (b == 0) {
                throw new UnsupportedOperationException("Cannot divide by zero");
            }
            return a / b;
        }
        return 0;
    }

    /**
     * Checks that all 4 card values are in and not repeated
     * @param holder Stack with the characters within
     * @return true if the card values are in and not repeated else false
     */
    private boolean checkNumbers(LinkedList<String> holder) {

        //Creating pass vars to check if all values are included and a count variable to make sure there are only 4 numbers
        boolean pass1 = false, pass2 = false, pass3 = false, pass4 = false;
        int count = 0;

        //traverse through holder and find all ints
        for(int i = 0; i < holder.size(); i++) {
            try{

                int a = Integer.parseInt(holder.get(i));

                //check if all 4 ints match the cards
                if(!pass1) {
                    if(a == val1) {
                        pass1 = true;
                    }
                }

                if(!pass2) {
                    if(a == val2) {
                        pass2 = true;
                    }
                }

                if(!pass3) {
                    if(a == val3) {
                        pass3 = true;
                    }
                }

                if(!pass4) {
                    if(a == val4) {
                        pass4 = true;
                    }
                }

                count++;

            } catch(NumberFormatException _) { }
        }

        //returns true if the specified conditions are all correct
        if(pass1 && pass2 && pass3 && pass4 && count == 4) {
            return true;
        }
        return false;
    }
}