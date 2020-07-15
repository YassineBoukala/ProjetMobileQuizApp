package com.example.quizapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.Model.Quiz;
import com.example.quizapp.R;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    RadioGroup radiogroup_quiz;
    Button btn_next;
    ArrayList<Quiz> quizArrayList = new ArrayList<>();
    ImageView img_quiz;
    TextView txt_question;
    int cpt = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        radiogroup_quiz = findViewById(R.id.radiogroup_quiz);
        btn_next = findViewById(R.id.btn_next);
        img_quiz = findViewById(R.id.img_quiz);
        txt_question = findViewById(R.id.txt_question);

        //if(!Config.IsStatic) {
            remplirList();
            changeElement(quizArrayList.get(cpt));
        //}


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radiogroup_quiz.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuizActivity.this, "Select an answer", Toast.LENGTH_SHORT).show();
                } /*else {
                    //For Static App
                    if (Config.IsStatic) {
                        int score = 0;
                        if (radiogroup_quiz.getCheckedRadioButtonId() == R.id.radio_answer1) {
                            score++;
                        }
                        Intent intent = new Intent(QuizActivity.this, Quiz1Activity.class);

                        intent.putExtra("score", score);
                        startActivity(intent);
                    }*/ else {
                        RadioButton radio_check = findViewById(radiogroup_quiz.getCheckedRadioButtonId());
                        int index = radiogroup_quiz.indexOfChild(radio_check);

                        if (quizArrayList.get(cpt).getAnswertrue() == index) {
                            score++;
                        }


                        if(btn_next.getText().toString()=="FINISH")
                        {
                            Intent intent=new Intent(QuizActivity.this,ScoreActivity.class);
                            double scorepercentage=((double) score/(double) quizArrayList.size())*100;
                            intent.putExtra("FinalScore",(int)scorepercentage);
                            startActivity(intent);
                        }else {
                            //Change Element
                            radiogroup_quiz.clearCheck();
                            cpt++;
                            changeElement(quizArrayList.get(cpt));
                        }


                }
            }
        });


    }

    private void remplirList() {
        Quiz q1 = new Quiz(R.drawable.image1, "Je souhaite continuer tout droit. Je dois m'arrêter au feu", "Oui", "Non", 0);
        Quiz q2 = new Quiz(R.drawable.image2, "Je souhaite continuer à droite", "Je m'arrête immédiatement", "Je ralentis", "Je serre à droite", "Je serre à gauche", 0);
        Quiz q3 = new Quiz(R.drawable.image3, "Dans cette situation", "Je m'arrête", "Je serre à droite et je passe",  1);
        Quiz q4 = new Quiz(R.drawable.image4, "Je continue tout droit. Pour franchir cette intersection, je dois obligatoirement", "Ralentir", "M'arrêter", "Conserver mon allure", 0);
        Quiz q5 = new Quiz(R.drawable.image5, "La vitesse est limitée à 50 km/h. Face à ce piéton arrêté",  "Je klaxonne", "Je m'arrête", "Je ralentis et serre à droite", 1);
        Quiz q6 = new Quiz(R.drawable.image6, "Dans cette situation, je peux faire signe aux piétons de passer", "Oui", "Non", 1);
        Quiz q7 = new Quiz(R.drawable.image7, "Je souhaite aller tout droit. Je passe", "Après le camion", "Après la voiture blanche et le scooter", "En premier", 2);
        Quiz q8 = new Quiz(R.drawable.image8, "Dans cette situation", "Je m'arrête", "Je klaxonne", "Je dépasse", 2);
        Quiz q9 = new Quiz(R.drawable.image9, "La signalisation m'interdit de ", "Continuer tout droit", "Dépasser la vitesse de 70 km/h", "M'arrêter sur la droite", 1);
        Quiz q10 = new Quiz(R.drawable.image10, "Je souhaite dépasser ce cycliste", "Je klaxonne", "Je monte sur le trottoir à gauche", "Je passe en serrant à la chaussée", "Je reste derrière lui", 3);
        Quiz q11 = new Quiz(R.drawable.image11, "Dans cette situation", "Je m'arrête avant le passage piétons", "Je vais jusq'au véhicule qui me précède", 0);
        Quiz q12 = new Quiz(R.drawable.image12, "Placé où je suis, je peux encore tourner à gauche" , "Oui", "Non", 1);
        Quiz q13 = new Quiz(R.drawable.image13, "Je roule à 70 km/h", "Je ralentis", "Je maintiens mon allure", 0);
        Quiz q14 = new Quiz(R.drawable.image14, "La signalisation annonce un danger permanent", "Oui", "Non", 0);
        Quiz q15 = new Quiz(R.drawable.image15, "Je souhaite continuer à droite", "Je passe par la droite", "Je patiente dans la file",  1);
        Quiz q16 = new Quiz(R.drawable.image16, "La rue d'en face est en sens interdit pour", "Les automobilistes", "Les cyclistes",0);
        Quiz q17 = new Quiz(R.drawable.image17, "Après la voiture noire, je vais pouvoir dépasser ce bus", "Oui", "Non", 0);
        Quiz q18 = new Quiz(R.drawable.image18, "Dans cette situation", "Je ralentis", "Je m'arrête", "Je passe", "Je laisse passer la voiture grise", 0);
        Quiz q19 = new Quiz(R.drawable.image19, "A cette intersection", "Je passe", "Je m'arrête", 0);
        Quiz q20 = new Quiz(R.drawable.image20, "Le feu ne fonctionnant pas", "Je ralentis et je passe", "Je passe sans ralentir", "Je cède la priorité à droite", "Je cède la priorité à gauche", 0);
        quizArrayList.add(q1);
        quizArrayList.add(q2);
        quizArrayList.add(q3);
        quizArrayList.add(q4);
        quizArrayList.add(q5);
        quizArrayList.add(q6);
        quizArrayList.add(q7);
        quizArrayList.add(q8);
        quizArrayList.add(q9);
        quizArrayList.add(q10);
        quizArrayList.add(q11);
        quizArrayList.add(q12);
        quizArrayList.add(q13);
        quizArrayList.add(q14);
        quizArrayList.add(q15);
        quizArrayList.add(q16);
        quizArrayList.add(q17);
        quizArrayList.add(q18);
        quizArrayList.add(q19);
        quizArrayList.add(q20);
    }

    private void changeElement(Quiz quiz) {
        img_quiz.setImageResource(quiz.getImage());

        txt_question.setText(quiz.getQuestion());

        RadioButton radio = null;

        radio = findViewById(R.id.radio_answer1);
        if(quiz.getQuiz1()==null){
            radio.setVisibility(View.GONE);
        }else{
         radio.setVisibility(View.VISIBLE);
        radio.setText(quiz.getQuiz1());}

        radio = findViewById(R.id.radio_answer2);
        if(quiz.getQuiz2()==null){
            radio.setVisibility(View.GONE);
        }else{
            radio.setVisibility(View.VISIBLE);
        radio.setText(quiz.getQuiz2());}

        radio = findViewById(R.id.radio_answer3);
        if(quiz.getQuiz3()==null){
            radio.setVisibility(View.GONE);
        }else{
            radio.setVisibility(View.VISIBLE);
        radio.setText(quiz.getQuiz3());}

        radio = findViewById(R.id.radio_answer4);
        if(quiz.getQuiz4()==null){
            radio.setVisibility(View.GONE);
        }else{
            radio.setVisibility(View.VISIBLE);
        radio.setText(quiz.getQuiz4());}

        if(cpt== quizArrayList.size()-1)
        {
            btn_next.setText("FINISH");
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}
