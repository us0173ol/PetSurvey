package com.miked;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static com.sun.glass.ui.Cursor.setVisible;

/**
 * Created by miked on 10/25/2016.
 */
public class PetSurvey extends JFrame{
    //variable linked to components in GUI
    private JCheckBox catsCheckBox;
    private JPanel rootPanel;
    private JCheckBox dogsCheckBox;
    private JCheckBox fishSCheckBox;
    private JButton quitButton;
    private JLabel surveyResultsLabel;
    //boolean variables
    private boolean fishS, cats, dogs;

    PetSurvey(){
        setContentPane(rootPanel);
        pack();
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //if the cats checkbox is checked then update results
        catsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cats= catsCheckBox.isSelected();
                updateResults();

            }
        });
        //if the dogs checkbox is checked then update results
        dogsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dogs = dogsCheckBox.isSelected();
                updateResults();

            }
        });
        //if the fish checkbox is checked then update results
        fishSCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fishS = fishSCheckBox.isSelected();
                updateResults();

            }
        });
        //when the user clicks Quit button, ask if they are sure with an options dialog
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(PetSurvey.this, "Are you sure you want to quit?",
                        "Quit?", JOptionPane.OK_CANCEL_OPTION);

                if (quit == JOptionPane.OK_OPTION){
                    System.exit(0);
                }


            }
        });


    }
    //update results method for when checkboxes are checked/unchecked
    //so if checked(true)display string on left, if unchecked(false) display string on right
    private void updateResults(){

        String hasDogs = dogs ? "a dog" : "no dogs";
        String hasCats = cats ? "a cat" : "no cats";
        String hasFishS = fishS ? "a fish" : "no fish";
        //final results string displayed in results label
        String Results = "You have " + hasCats + ", " + hasDogs + ", and " + hasFishS;
        surveyResultsLabel.setText(Results);
    }
}
