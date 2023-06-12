package UI;

import Adapters.DependencyInjector;
import Adapters.IQuestionDAO;
import domain.entities.Question;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class RegisterQuestionsScreen extends javax.swing.JDialog {
    IQuestionDAO _questionDAO;
    public RegisterQuestionsScreen() {
        _questionDAO = DependencyInjector.GetQuestionDAO();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        statement = new javax.swing.JTextField();
        correctAnswer = new javax.swing.JTextField();
        thirdAnswer = new javax.swing.JTextField();
        secondAnswer = new javax.swing.JTextField();
        fourthAnswer = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();

        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonPressedEvent(evt);
            }
        });

//        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        statement.setText("Digite a pergunta");

        correctAnswer.setText("Digite a resposta correta:");

        thirdAnswer.setText("Digite a terceira resposta");

        secondAnswer.setText("Digite a segunda resposta");

        fourthAnswer.setText("Digite a quarta resposta");

        submitButton.setText("Enviar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(statement)
                            .addComponent(correctAnswer)
                            .addComponent(secondAnswer)
                            .addComponent(thirdAnswer)
                            .addComponent(fourthAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(submitButton)))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(statement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(correctAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(secondAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(thirdAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fourthAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(submitButton)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        pack();
    }

    private void SubmitButtonPressedEvent(java.awt.event.ActionEvent evt) {
        HashMap<JTextField, Character> textFieldCharacterHashMap = new HashMap<>();
        Random rn = new Random();


        //Embaralhando a ordem das alternativas
        textFieldCharacterHashMap.put(correctAnswer, GetRandomCharacter(rn));
        textFieldCharacterHashMap.put(secondAnswer, GetRandomCharacter(rn));
        textFieldCharacterHashMap.put(thirdAnswer, GetRandomCharacter(rn));
        textFieldCharacterHashMap.put(fourthAnswer, GetRandomCharacter(rn));


        //Instanciando a question que enviaremos para o banco de dados
        Question question = new Question(statement.getText(), textFieldCharacterHashMap.get(correctAnswer), _questionDAO.GetDataBaseSize() + 1);
        question.AddAlternativeToHashMap(textFieldCharacterHashMap.get(correctAnswer), correctAnswer.getText());
        question.AddAlternativeToHashMap(textFieldCharacterHashMap.get(secondAnswer), secondAnswer.getText());
        question.AddAlternativeToHashMap(textFieldCharacterHashMap.get(thirdAnswer), thirdAnswer.getText());
        question.AddAlternativeToHashMap(textFieldCharacterHashMap.get(fourthAnswer), fourthAnswer.getText());


        //Enviando para o banco de dados
        _questionDAO.RegisterQuestion(question);


        //Printando no console para fins de teste
        Question questionReturned = _questionDAO.GetQuestionById(_questionDAO.GetDataBaseSize());
        System.out.println("Pergunta enviada ao banco de dados!");
        System.out.println(questionReturned.get_statement());
        System.out.println(questionReturned.get_alternativesHashMap().get(questionReturned.get_correctAlternative()));


        //Resetando a lista para poder adicionar mais itens
        charactersList = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D'));
    }

    private Character GetRandomCharacter(Random rn) {
        int randomIndex = rn.nextInt(0, charactersList.size());
        char randomChar = charactersList.get(randomIndex);
        charactersList.remove(randomIndex);

        return randomChar;
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterQuestionsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterQuestionsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterQuestionsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterQuestionsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegisterQuestionsScreen dialog = new RegisterQuestionsScreen();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private javax.swing.JButton submitButton;
    private javax.swing.JTextField statement;
    private javax.swing.JTextField correctAnswer;
    private javax.swing.JTextField thirdAnswer;
    private javax.swing.JTextField secondAnswer;
    private javax.swing.JTextField fourthAnswer;
    ArrayList<Character> charactersList = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D'));
}
