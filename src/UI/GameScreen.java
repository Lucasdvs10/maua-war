package UI;

import Adapters.DependencyInjector;
import Adapters.IQuestionDAO;
import UI.GameMessages.RoundCounterDisplay;
import UI.GameMessages.WhooseTurnItIsDisplay;
import domain.entities.Player;
import domain.entities.eventsystem.EventManager;
import domain.usecase.ManagePlayersTurnUseCase;
import domain.usecase.ManageRoundsUseCase;

import java.awt.*;

public class GameScreen extends javax.swing.JFrame {
    /*

    Ja que vamos instanciar um bloco para cada botão, podemos mostrar a vida apenas dando um getName na instancia do bloco
    EX: blocoLBtn.setText(blockLInstance.GetName())

    Aí no GetName do bloco a gente coloca "name + (currentLife)"
    *
    *
    *
    * */

    IQuestionDAO _questionDAO;
    Player[] _allPlayersArray = new Player[]{
            new Player(1, Color.BLUE),
            new Player(2, Color.RED),
            new Player(3, Color.GREEN),
            new Player(4, Color.yellow)
    };

    Player[] _activePlayersArray;

    ManagePlayersTurnUseCase _managePlayersTurnUseCase;
    ManageRoundsUseCase _manageRoundsUseCase;

    int _numberOfPlayers = 2;

    public GameScreen() {
        _questionDAO = DependencyInjector.GetQuestionDAO();
        _managePlayersTurnUseCase = new ManagePlayersTurnUseCase(_numberOfPlayers);
        _manageRoundsUseCase = new ManageRoundsUseCase("EV_LAST_PLAYER_PLAYED");

        _activePlayersArray = new Player[_numberOfPlayers];

        for (int i = 0; i<_numberOfPlayers; i++){
            _activePlayersArray[i] = _allPlayersArray[i];
        }

        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        display = new RoundCounterDisplay(_manageRoundsUseCase);

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        blocoJBtn = new javax.swing.JButton();
        blocoRBtn = new javax.swing.JButton();
        ginasioBtn = new javax.swing.JButton();
        blocoHBtn = new javax.swing.JButton();
        blocoFBtn = new javax.swing.JButton();
        blocoEBtn = new javax.swing.JButton();
        blocoSBtn = new javax.swing.JButton();
        blocoWBtn = new javax.swing.JButton();
        blocoGBtn = new javax.swing.JButton();
        blocoVBtn = new javax.swing.JButton();
        blocoLBtn = new javax.swing.JButton();
        blocoABtn = new javax.swing.JButton();
        whooseTurnItIsDisplay = new WhooseTurnItIsDisplay();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        roundCounterUI = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\lucas\\Downloads\\Design sem nome.png")); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setIconTextGap(3);
        jLabel1.setPreferredSize(new java.awt.Dimension(1440, 810));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\lucas\\Downloads\\maua_war_screen_2.png")); // NOI18N
        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        blocoJBtn.setText("Bloco J");
        blocoJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(blocoJBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 200, 110));

        blocoRBtn.setText("Bloco R");
        blocoRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(blocoRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, 150, 150));

        ginasioBtn.setText("Ginasio");
        ginasioBtn.setAlignmentX(3.0F);
        ginasioBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        ginasioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(ginasioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 260, 110));

        blocoHBtn.setText("Bloco H");
        blocoHBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(blocoHBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 470, 160, 100));

        blocoFBtn.setText("Bloco F");
        blocoFBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(blocoFBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 200, 120));

        blocoEBtn.setText("Bloco E");
        blocoEBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(blocoEBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 260, 140));

        blocoSBtn.setText("Bloco S");
        blocoSBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(blocoSBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 460, 180, 100));

        blocoWBtn.setText("Bloco W");
        blocoWBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(blocoWBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 280, 110, 200));

        blocoGBtn.setText("Bloco G");
        blocoGBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(blocoGBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 200, 120));

        blocoVBtn.setText("Bloco V");
        blocoVBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(blocoVBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 90, 190));

        blocoLBtn.setText("Bloco L");
        blocoLBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(blocoLBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 200, 110));

        blocoABtn.setText("Bloco A");
        blocoABtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(blocoABtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 170, 200, 100));

        EventManager.SubscribeInEvent("EV_PLAYER_ANSWERED_A_QUESTION", whooseTurnItIsDisplay);

        whooseTurnItIsDisplay.setPlayersArray(_activePlayersArray);
        whooseTurnItIsDisplay.OnEventRaised();
        whooseTurnItIsDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(whooseTurnItIsDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 180, 250, 50));

        jTextField2.setBackground(new java.awt.Color(0, 0, 255));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("Azul");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 250, 100, 50));

        jTextField3.setBackground(new java.awt.Color(255, 0, 0));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setText("Vermelho");
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 310, 100, 50));

        jTextField4.setBackground(new java.awt.Color(51, 153, 0));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setText("Verde");
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 370, 100, 50));

        jTextField5.setBackground(new java.awt.Color(255, 255, 51));
        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField5.setText("Amarelo");
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 430, 100, 50));

        roundCounterUI.setFont(new java.awt.Font("Segoe UI", 0, 72)); // NOI18N
        roundCounterUI.setText("30:00");
        roundCounterUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        getContentPane().add(roundCounterUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 60, -1, -1));

        jTextPane1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jTextPane1.setText("Objetivos");
        jScrollPane2.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 520, -1, -1));

        jTextField7.setText("Domine 4 blocos");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 600, 190, -1));

        jTextField8.setText("Responda 30 perguntas");
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 640, 190, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\lucas\\Desktop\\Projetos atuais\\maua-war\\src\\UI\\Images\\tabuleiro.png")); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1570, 890));

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance());
        jquestion.show(); //mostra a questão
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance());
        jquestion.show(); //mostra a questão
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance());
        jquestion.show(); //mostra a questão
        
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance());
        jquestion.show(); //mostra a questão
        
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance());
        jquestion.show(); //mostra a questão
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance());
        jquestion.show(); //mostra a questão
    }

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance());
        jquestion.show(); //mostra a questão
    }

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance());
        jquestion.show(); //mostra a questão
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance());
        jquestion.show(); //mostra a questão
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance());
        jquestion.show(); //mostra a questão
    }

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance());
        jquestion.show(); //mostra a questão
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance());
        jquestion.show(); //mostra a questão
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed

    }

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed

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
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameScreen().setVisible(true);
            }
        });
    }

    private Player get_CurrentPlayerInstance(){
        return _activePlayersArray[_managePlayersTurnUseCase.get_currentPlayerID()-1];
    }

    private javax.swing.JButton blocoJBtn;
    private javax.swing.JButton blocoVBtn;
    private javax.swing.JButton blocoLBtn;
    private javax.swing.JButton blocoABtn;
    private javax.swing.JButton blocoRBtn;
    private javax.swing.JButton ginasioBtn;
    private javax.swing.JButton blocoHBtn;
    private javax.swing.JButton blocoFBtn;
    private javax.swing.JButton blocoEBtn;
    private javax.swing.JButton blocoSBtn;
    private javax.swing.JButton blocoWBtn;
    private javax.swing.JButton blocoGBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private WhooseTurnItIsDisplay whooseTurnItIsDisplay;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField roundCounterUI;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextPane jTextPane1;
    RoundCounterDisplay display;
}
