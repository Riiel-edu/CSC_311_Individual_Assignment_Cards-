package com.example.csc_311_individual_assignment_cards;

import javafx.scene.image.Image;

public class Card  {

    private int value;
    private Image image;

    /**
     * Default constructor for the Card class
     */
    public Card() {
        image = null;
        value = 0;
    }

    /**
     * Parameterized constructor for the card class, assigns value to the image and card number value
     * @param image the image of the card
     * @param value the value of the card
     */
    public Card(String image, int value) {
        this.image = new Image(image);
        this.value = value;
    }

    /**
     * Getter method for image param
     * @return the image of the card
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * Setter for the image param
     * @param image the new image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Getter method for value param
     * @return the value of the card
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Setter for the value param
     * @param value the new value
     */
    public void setValue(int value) {
        this.value = value;
    }


}
