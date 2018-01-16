package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.security.acl.Group;

public class MainActivity extends AppCompatActivity {

    /**
     * TODO The app exit without any error message if gender isn't choose.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Run methods to check every answers, and display the results.
     */
    public void submit(View view) {
        String summary = createSummary(firstQuestion(), femailMale(), getName(), secondQuestion(), thirdQuestion(), fourthQuestion(),
                fifthQuestionZirael(), fifthQuestionYennefer(), fifthQuestionTriss());

        Toast.makeText(MainActivity.this, summary, Toast.LENGTH_LONG).show();
    }

    /**
     * @param isFirstAnswerCorrect is for check the first question's answers.
     * @param genderText           is getting the text of the checked RadioButton in GENDER selection.
     * @return summary of all the answers.
     */
    private String createSummary(String isFirstAnswerCorrect, String genderText, String name, String isSecondAnswerCorrect,
                                 String isThirdAnswerCorrect, String isFourthAnswerCorrect, String fifthQuestionZirael,
                                 String fifthQuestionYennefer, String fifthQuestionTriss) {
        String summaryMessage = "Hi " + name + "!";
        summaryMessage += "\nYour gender is " + genderText;
        summaryMessage += "\n1. answer " + isFirstAnswerCorrect;
        summaryMessage += "\n2. answer is " + isSecondAnswerCorrect;
        summaryMessage += "\n3. answer is " + isThirdAnswerCorrect;
        summaryMessage += "\n4. answer " + isFourthAnswerCorrect;
        summaryMessage += "\n5. Zirael: " + fifthQuestionZirael + ", Yennefer: " + fifthQuestionYennefer + ", Triss " + fifthQuestionTriss;

        int points=0;
        if(isFirstAnswerCorrect.equals("correct")){
            points++;
        }if (isSecondAnswerCorrect.equals("correct")){
            points++;
        }if (isThirdAnswerCorrect.equals("correct")){
            points++;
        }if (isFourthAnswerCorrect.equals("correct")){
            points++;
        }
        if(points==1) {
            summaryMessage += "\nYou have "+points+" point from 4";
        }else{
            summaryMessage+="\nYou have "+points+" points from 4";
        }

        return summaryMessage;
    }

    /**
     * @return the answer for Triss's rate
     */

    private String fifthQuestionTriss() {
        RadioGroup trissRadioGroup = findViewById(R.id.triss_radio_group);

        int trissRadioButtonId = trissRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = trissRadioGroup.findViewById(trissRadioButtonId);
        int radioId = trissRadioGroup.indexOfChild(radioButton);
        RadioButton btn = (RadioButton) trissRadioGroup.getChildAt(radioId);

        String selection = "";
        selection = btn.getText().toString();

        if (selection.equals("")) {
            selection = "You didn't chose";
            return selection;
        } else {
            selection = (String) btn.getText();
            return selection;
        }
    }

    /**
     * @return the answer for Yennefer's rate
     */

    private String fifthQuestionYennefer() {
        RadioGroup yenneferRadioGroup = findViewById(R.id.yennefer_radio_group);

        int yenneferRadioButtonId = yenneferRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = yenneferRadioGroup.findViewById(yenneferRadioButtonId);
        int radioId = yenneferRadioGroup.indexOfChild(radioButton);
        RadioButton btn = (RadioButton) yenneferRadioGroup.getChildAt(radioId);

        String selection = "";
        selection = btn.getText().toString();

        if (selection.equals("")) {
            selection = "You didn't chose";
            return selection;
        } else {
            selection = (String) btn.getText();
            return selection;
        }
    }

    /**
     * @return the answer for Zirael's rate
     */

    private String fifthQuestionZirael() {
        RadioGroup ziraelRadioGroup = findViewById(R.id.zirael_radio_group);

        int ziraelRadioButtonId = ziraelRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = ziraelRadioGroup.findViewById(ziraelRadioButtonId);
        int radioId = ziraelRadioGroup.indexOfChild(radioButton);
        RadioButton btn = (RadioButton) ziraelRadioGroup.getChildAt(radioId);

        String selection = "";
        selection = btn.getText().toString();

        if (selection.equals("")) {
            selection = "You didn't chose";
            return selection;
        } else {
            selection = (String) btn.getText();
            return selection;
        }
    }

    /**
     * @return the answer for the fourth question
     */

    private String fourthQuestion() {
        String isAnswerCorrect;

        CheckBox philippaCorrect = findViewById(R.id.philippa_check_box);
        CheckBox trissCorrect = findViewById(R.id.triss_check_box);
        CheckBox yenneferCorrect = findViewById(R.id.yennefer_check_box);
        CheckBox keiraCorrect = findViewById(R.id.keira_check_box);

        boolean philippaIsCorrect = philippaCorrect.isChecked();
        boolean trissIsCorrect = trissCorrect.isChecked();
        boolean yenneferIsCorrect = yenneferCorrect.isChecked();
        boolean keiraIsCorrect = keiraCorrect.isChecked();

        if ((philippaIsCorrect == true && trissIsCorrect == true && yenneferIsCorrect == true && keiraIsCorrect == false) ||
                (philippaIsCorrect == true && trissIsCorrect == true && yenneferIsCorrect == false && keiraIsCorrect == true) ||
                (philippaIsCorrect == true && trissIsCorrect == false && yenneferIsCorrect == true && keiraIsCorrect == true) ||
                (philippaIsCorrect == false && trissIsCorrect == true && yenneferIsCorrect == true && keiraIsCorrect == true)) {
            isAnswerCorrect = "have three correct answers";
            return isAnswerCorrect;
        }
        if ((philippaIsCorrect == true && trissIsCorrect == true && yenneferIsCorrect == false && keiraIsCorrect == false) ||
                (philippaIsCorrect == true && trissIsCorrect == false && yenneferIsCorrect == true && keiraIsCorrect == false) ||
                (philippaIsCorrect == false && trissIsCorrect == true && yenneferIsCorrect == true && keiraIsCorrect == false) ||
                (philippaIsCorrect == true && trissIsCorrect == false && yenneferIsCorrect == false && keiraIsCorrect == true) ||
                (philippaIsCorrect == false && trissIsCorrect == true && yenneferIsCorrect == false && keiraIsCorrect == true) ||
                (philippaIsCorrect == false && trissIsCorrect == false && yenneferIsCorrect == true && keiraIsCorrect == true)) {
            isAnswerCorrect = "have two correct answers";
            return isAnswerCorrect;
        }
        if ((philippaIsCorrect == true && trissIsCorrect == false && yenneferIsCorrect == false && keiraIsCorrect == false) ||
                (philippaIsCorrect == false && trissIsCorrect == true && yenneferIsCorrect == false && keiraIsCorrect == false) ||
                (philippaIsCorrect == false && trissIsCorrect == false && yenneferIsCorrect == true && keiraIsCorrect == false) ||
                (philippaIsCorrect == false && trissIsCorrect == false && yenneferIsCorrect == false && keiraIsCorrect == true)) {
            isAnswerCorrect = "have one correct answer";
            return isAnswerCorrect;
        }
        if (philippaIsCorrect == false && trissIsCorrect == false && yenneferIsCorrect == false && keiraIsCorrect == false) {
            isAnswerCorrect = "empty";
            return isAnswerCorrect;
        } else {
            isAnswerCorrect = "correct";
            return isAnswerCorrect;
        }
    }

    /**
     * @return the answer of the third question
     */

    private String thirdQuestion() {
        EditText thirdAnswer = findViewById(R.id.third_answer_edit_text);
        String isThirdAnswerCorrect = thirdAnswer.getText().toString();
        String thirdAnswerResult;
        if (isThirdAnswerCorrect.equals("Emhyr var Emreis")) {
            thirdAnswerResult = "correct";
            return thirdAnswerResult;
        }
        if (isThirdAnswerCorrect.equals("")) {
            thirdAnswerResult = "empty";
            return thirdAnswerResult;
        } else {
            thirdAnswerResult = "not correct.";
            return thirdAnswerResult;
        }
    }

    /**
     * @return which RadioButton is cheched, and is it the correct answer.
     */
    private String secondQuestion() {
        RadioGroup secondQuestionGroup = findViewById(R.id.second_question_radio_group);
        RadioButton correctAnswer = findViewById(R.id.kaer_morhen_radio_button);

        int correctAnswerId = 0;

        int secondQuestionRadioButtonId = secondQuestionGroup.getCheckedRadioButtonId();
        correctAnswerId = correctAnswer.getId();

        String isSecondAnswerCorrect;

        if (secondQuestionRadioButtonId == correctAnswerId) {
            isSecondAnswerCorrect = "correct";
            return isSecondAnswerCorrect;
        }
        if (secondQuestionRadioButtonId <= 0) {
            isSecondAnswerCorrect = "empty";
            return isSecondAnswerCorrect;
        } else {
            isSecondAnswerCorrect = "not correct";
            return isSecondAnswerCorrect;
        }
    }

    /**
     * @return the question is correct or not.
     */
    private String firstQuestion() {
        String isAnswerCorrect;

        CheckBox geraltCorrect = findViewById(R.id.geralt_check_box);
        CheckBox eskelCorrect = findViewById(R.id.eskel_check_box);
        CheckBox ciriCorrect = findViewById(R.id.ciri_check_box);
        CheckBox emhyrCorrect = findViewById(R.id.emhyr_check_box);

        boolean geraltIsCorrect = geraltCorrect.isChecked();
        boolean eskelIsCorrect = eskelCorrect.isChecked();
        boolean ciriIsCorrect = ciriCorrect.isChecked();
        boolean emhyrIsCorrect = emhyrCorrect.isChecked();

        if (geraltIsCorrect == true && eskelIsCorrect == true && ciriIsCorrect == true && emhyrIsCorrect == true) {
            isAnswerCorrect = "have two more checked answers";
            return isAnswerCorrect;
        }
        if ((geraltIsCorrect == true && eskelIsCorrect == true && ciriIsCorrect == true) ||
                (geraltIsCorrect == true && eskelIsCorrect == true && emhyrIsCorrect == true)) {
            isAnswerCorrect = "have one more checked answer";
            return isAnswerCorrect;
        }
        if (geraltIsCorrect == true && eskelIsCorrect == true) {
            isAnswerCorrect = "correct";
            return isAnswerCorrect;
        }
        if ((geraltIsCorrect == true && eskelIsCorrect != true) || (geraltIsCorrect != true && eskelIsCorrect == true)) {
            isAnswerCorrect = "have one correct answer";
            return isAnswerCorrect;
        }
        if (geraltIsCorrect == false && eskelIsCorrect == false && ciriIsCorrect == false && emhyrIsCorrect == false) {
            isAnswerCorrect = "is empty";
            return isAnswerCorrect;
        } else {
            isAnswerCorrect = "is not correct";
            return isAnswerCorrect;
        }
    }

    /**
     * @return the values of the checked GENDER RadioGroup.
     */
    private String femailMale() {
        RadioGroup genderGroup = findViewById(R.id.female_male_radio_group);
        RadioButton femaleRadioButton = findViewById(R.id.female_radio_button);
        RadioButton maleRadioButton = findViewById(R.id.male_radio_button);

        int genderId = genderGroup.getCheckedRadioButtonId();
        int femaleGender = femaleRadioButton.getId();
        int maleGender = maleRadioButton.getId();

        String genderText;
        if (genderId == femaleGender) {
            genderText = "Female";
            return genderText;
        }
        if (genderId == maleGender) {
            genderText = "Male";
            return genderText;
        } else {
            genderText = "none";
            return genderText;
        }
    }

    /**
     * @return the name of the filler.
     */
    private String getName() {
        EditText nameEditText = findViewById(R.id.name_edit_text);
        String name = nameEditText.getText().toString();
        return name;
    }
}
