package UI;

import Adapters.IQuestionDAO;
import UI.UIEntitites.BlockButton;
import domain.entities.Block;
import domain.entities.Player;
import domain.entities.Question;
import domain.entities.eventsystem.EventManager;
import domain.usecase.CheckAnswerUseCase;
import domain.usecase.PullQuestionsUseCase;

import javax.swing.*;

public class QuestionScreen extends javax.swing.JFrame {
    PullQuestionsUseCase _pullQuestionsUseCase;
    Question _question;
    Player _player;
    CheckAnswerUseCase _checkAnswerUseCase;

    BlockButton _blockButton;

    public QuestionScreen(IQuestionDAO questionDAO, Player player, BlockButton blockButton) {
        this._player = player;
        _pullQuestionsUseCase = new PullQuestionsUseCase(questionDAO);
        _question = _pullQuestionsUseCase.GetNotAnsweredRandomQuestion();
        _checkAnswerUseCase = new CheckAnswerUseCase();
        _blockButton = blockButton;

        initComponents();
    }
    public QuestionScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        optionButtonA = new javax.swing.JButton();
        optionButtonB = new javax.swing.JButton();
        optionButtonC = new javax.swing.JButton();
        optionButtonD = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        alternativeAnswerA = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        alternativeAnswerB = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        alternativeAnswerD = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        alternativeAnswerC = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionStatement = new javax.swing.JTextArea();

        jScrollPane2.setViewportView(jTextPane2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        optionButtonA.setText("A");
        optionButtonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlternativeAButtonAction(evt);
            }
        });

        optionButtonB.setText("B");
        optionButtonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlternativeBButtonAction(evt);
            }
        });

        optionButtonC.setText("C");
        optionButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlternativeCButtonAction(evt);
            }
        });

        optionButtonD.setText("D");
        optionButtonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlternativeDButtonAction(evt);
            }
        });

        alternativeAnswerA.setText(_question.get_alternativesHashMap().get('A'));
        jScrollPane3.setViewportView(alternativeAnswerA);

        alternativeAnswerB.setText(_question.get_alternativesHashMap().get('B'));
        jScrollPane4.setViewportView(alternativeAnswerB);

        alternativeAnswerD.setText(_question.get_alternativesHashMap().get('D'));
        jScrollPane5.setViewportView(alternativeAnswerD);

        alternativeAnswerC.setText(_question.get_alternativesHashMap().get('C'));
        jScrollPane6.setViewportView(alternativeAnswerC);

        questionStatement.setColumns(20);
        questionStatement.setRows(5);
        questionStatement.setText(_question.get_statement());
        jScrollPane1.setViewportView(questionStatement);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(optionButtonD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(optionButtonC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(optionButtonA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(optionButtonB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(jScrollPane5)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane3))))
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(optionButtonA)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(optionButtonB)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(optionButtonC)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optionButtonD, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }

    private void AlternativeAButtonAction(java.awt.event.ActionEvent evt) {
        boolean answerIsRight = _checkAnswerUseCase.VerifyPlayerAnswer(_player, _question, 'A');

        System.out.println("Alternativa A pressionada");
        System.out.println(_player.GetPlayerName());

        JOptionPane.showMessageDialog(null, String.format("A resposta está %s!", answerIsRight ? "correta" : "errada"));
        if(answerIsRight)
            ChangeButtonColorAndApplyDamage();
    }

    private void ChangeButtonColorAndApplyDamage() {
        Block blockEntity = _blockButton.get_blockEntity();
        blockEntity.ApplyDamage(1);

        if(blockEntity.get_currentLife() <= 0){
            blockEntity.set_isDominated(true);
            blockEntity.set_playerWhoDominated(_player);

            EventManager.RaiseAnPlayerEvent("PL_DOMINATED_A_BLOC", _player);
            if(blockEntity.get_playerWhoDominated() != null){
                _blockButton.setBackground(blockEntity.get_playerWhoDominated().get_playerColor());
                blockEntity.set_maxLife(blockEntity.get_maxLife() + 1);
                blockEntity.set_currentLife(blockEntity.get_maxLife());
            }
        }
        _blockButton.setText(blockEntity.get_blockNameAndLife());
        dispose();
    }

    private void AlternativeBButtonAction(java.awt.event.ActionEvent evt) {
        boolean answerIsRight = _checkAnswerUseCase.VerifyPlayerAnswer(_player, _question, 'B');

        System.out.println("Alternativa B pressionada");
        System.out.println(_player.GetPlayerName());

        JOptionPane.showMessageDialog(null, String.format("A resposta está %s!", answerIsRight ? "correta" : "errada"));

        if(answerIsRight)
            ChangeButtonColorAndApplyDamage();

        dispose();
    }

    private void AlternativeCButtonAction(java.awt.event.ActionEvent evt) {
        boolean answerIsRight = _checkAnswerUseCase.VerifyPlayerAnswer(_player, _question, 'C');

        System.out.println("Alternativa C pressionada");
        System.out.println(_player.GetPlayerName());

        JOptionPane.showMessageDialog(null, String.format("A resposta está %s!", answerIsRight ? "correta" : "errada"));

        if(answerIsRight)
            ChangeButtonColorAndApplyDamage();
        dispose();
    }

    private void AlternativeDButtonAction(java.awt.event.ActionEvent evt) {
        boolean answerIsRight = _checkAnswerUseCase.VerifyPlayerAnswer(_player, _question, 'D');

        System.out.println("Alternativa D pressionada");
        System.out.println(_player.GetPlayerName());

        JOptionPane.showMessageDialog(null, String.format("A resposta está %s!", answerIsRight ? "correta" : "errada"));

        if(answerIsRight)
            ChangeButtonColorAndApplyDamage();
        dispose();
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
            java.util.logging.Logger.getLogger(QuestionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuestionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuestionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuestionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuestionScreen().setVisible(true);
            }
        });
    }


    private javax.swing.JButton optionButtonA;
    private javax.swing.JButton optionButtonB;
    private javax.swing.JButton optionButtonC;
    private javax.swing.JButton optionButtonD;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea questionStatement;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane alternativeAnswerA;
    private javax.swing.JTextPane alternativeAnswerB;
    private javax.swing.JTextPane alternativeAnswerD;
    private javax.swing.JTextPane alternativeAnswerC;
}
