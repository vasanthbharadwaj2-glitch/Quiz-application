package com.quizapp;

	import java.util.*;

	public class QuizService {
	    private List<Question> questions = new ArrayList<>();
	    private int score = 0;
	    private Scanner sc = new Scanner(System.in);

	    public QuizService() {
	        loadQuestions();
	    }

	    private void loadQuestions() {
	        // Hardcoded sample questions — can also be read from a file
	        questions.add(new Question(
	                "Which language is used for Android app development?",
	                new String[]{"C++", "Java", "Python", "Kotlin"},
	                4
	        ));
	        questions.add(new Question(
	                "What is the size of int in Java?",
	                new String[]{"2 bytes", "4 bytes", "8 bytes", "Depends on OS"},
	                2
	        ));
	        questions.add(new Question(
	                "Which keyword is used to inherit a class in Java?",
	                new String[]{"super", "this", "extends", "implements"},
	                3
	        ));
	    }

	    public void startQuiz() {
	        System.out.println("====== WELCOME TO JAVA QUIZ ======");
	        int questionNumber = 1;

	        for (Question q : questions) {
	            System.out.println("\nQ" + questionNumber + ": " + q.getQuestion());
	            String[] options = q.getOptions();
	            for (int i = 0; i < options.length; i++) {
	                System.out.println((i + 1) + ". " + options[i]);
	            }

	            System.out.print("Enter your answer (1-4): ");
	            int answer = sc.nextInt();

	            if (answer == q.getCorrectAnswer()) {
	                System.out.println("✅ Correct!");
	                score++;
	            } else {
	                System.out.println("❌ Wrong! Correct answer: " + options[q.getCorrectAnswer() - 1]);
	            }
	            questionNumber++;
	        }

	        System.out.println("\n====== QUIZ FINISHED ======");
	        System.out.println("Your score: " + score + "/" + questions.size());
	        System.out.println("============================");
	    }
	}



