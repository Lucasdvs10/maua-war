package UI;

import Adapters.DependencyInjector;
import Adapters.IQuestionDAO;
import UI.UIEntitites.BlockButton;
import UI.UIEntitites.NeighboursMapper;
import UI.UIEntitites.RoundCounterDisplay;
import UI.UIEntitites.WhooseTurnItIsDisplay;
import domain.entities.Block;
import domain.entities.Player;
import domain.entities.eventsystem.EventManager;
import domain.entities.eventsystem.IEventListener;
import domain.entities.eventsystem.IPlayerEventListener;
import domain.usecase.ManagePlayersTurnUseCase;
import domain.usecase.ManageRoundsUseCase;
import domain.usecase.objectivesystem.ObjectivesContainer;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class GameScreen extends javax.swing.JFrame implements IPlayerEventListener {

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

    int _numberOfPlayers;

    ObjectivesContainer objectivesContainer;
    Block[] _allBlocksContainer;
    BlockButton[] _allBlockButtonsContainer;

    NeighboursMapper _neighboursMapper;



    public GameScreen() {
        _numberOfPlayers = 2;
        _questionDAO = DependencyInjector.GetQuestionDAO();
        _managePlayersTurnUseCase = new ManagePlayersTurnUseCase(_numberOfPlayers);
        _manageRoundsUseCase = new ManageRoundsUseCase("EV_LAST_PLAYER_PLAYED");

        _activePlayersArray = new Player[_numberOfPlayers];

        for (int i = 0; i<_numberOfPlayers; i++){
            _activePlayersArray[i] = _allPlayersArray[i];
        }


        initComponents();
    }

    public GameScreen(int numberOfPlayers) {
        _numberOfPlayers = numberOfPlayers;
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
        blocoJBtn = new BlockButton(new Block("Bloco J", 1));
        blocoRBtn = new BlockButton(new Block("Bloco R", 1));
        ginasioBtn = new BlockButton(new Block("Ginasio", 1));
        blocoHBtn = new BlockButton(new Block("Bloco H", 1));
        blocoFBtn = new BlockButton(new Block("Bloco F", 1));
        blocoEBtn = new BlockButton(new Block("Bloco E", 1));
        blocoSBtn = new BlockButton(new Block("Bloco S", 1));
        blocoWBtn = new BlockButton(new Block("Bloco W", 1));
        blocoGBtn = new BlockButton(new Block("Bloco G", 1));
        blocoVBtn = new BlockButton(new Block("Bloco V", 1));
        blocoLBtn = new BlockButton(new Block("Bloco L", 1));
        blocoABtn = new BlockButton(new Block("Bloco A", 1));
        whooseTurnItIsDisplay = new WhooseTurnItIsDisplay();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        roundCounterUI = new RoundCounterDisplay(_manageRoundsUseCase);
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        _allBlocksContainer = new Block[]{
                blocoJBtn.get_blockEntity(), //0
                blocoRBtn.get_blockEntity(), //1
                ginasioBtn.get_blockEntity(),//2
                blocoHBtn.get_blockEntity(), //3
                blocoFBtn.get_blockEntity(), //4
                blocoEBtn.get_blockEntity(), //5
                blocoSBtn.get_blockEntity(), //6
                blocoWBtn.get_blockEntity(), //7
                blocoGBtn.get_blockEntity(), //8
                blocoVBtn.get_blockEntity(), //9
                blocoLBtn.get_blockEntity(), //10
                blocoABtn.get_blockEntity()  //11
        };

        _allBlockButtonsContainer = new BlockButton[]{
                blocoJBtn,
                blocoRBtn,
                ginasioBtn,
                blocoHBtn,
                blocoFBtn,
                blocoEBtn,
                blocoSBtn,
                blocoWBtn,
                blocoGBtn,
                blocoVBtn,
                blocoLBtn,
                blocoABtn
        };

        _neighboursMapper = new NeighboursMapper(_allBlocksContainer);

        objectivesContainer = new ObjectivesContainer(_activePlayersArray, _allBlocksContainer);

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

        blocoJBtn.setText(blocoJBtn.get_blockEntity().get_blockNameAndLife());
        blocoJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blocoJActionPerformed(evt);
            }
        });
        getContentPane().add(blocoJBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 200, 110));

        blocoRBtn.setText(blocoRBtn.get_blockEntity().get_blockNameAndLife());
        blocoRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blocoRActionPerformed(evt);
            }
        });
        getContentPane().add(blocoRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, 150, 150));

        ginasioBtn.setText(ginasioBtn.get_blockEntity().get_blockNameAndLife());
        ginasioBtn.setAlignmentX(3.0F);
        ginasioBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        ginasioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ginasioBtnActionPerformed(evt);
            }
        });
        getContentPane().add(ginasioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 260, 110));

        blocoHBtn.setText(blocoHBtn.get_blockEntity().get_blockNameAndLife());
        blocoHBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blocoHBtnActionPerformed(evt);
            }
        });
        getContentPane().add(blocoHBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 470, 160, 100));

        blocoFBtn.setText(blocoFBtn.get_blockEntity().get_blockNameAndLife());
        blocoFBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blocoFBtnActionPerformed(evt);
            }
        });
        getContentPane().add(blocoFBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 200, 120));

        blocoEBtn.setText(blocoEBtn.get_blockEntity().get_blockNameAndLife());
        blocoEBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blocoEBtnActionPerformed(evt);
            }
        });
        getContentPane().add(blocoEBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 260, 140));

        blocoSBtn.setText(blocoSBtn.get_blockEntity().get_blockNameAndLife());
        blocoSBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blocoSBtnActionPerformed(evt);
            }
        });
        getContentPane().add(blocoSBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 460, 180, 100));

        blocoWBtn.setText(blocoWBtn.get_blockEntity().get_blockNameAndLife());
        blocoWBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blocoWBtnActionPerformed(evt);
            }
        });
        getContentPane().add(blocoWBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 280, 110, 200));

        blocoGBtn.setText(blocoGBtn.get_blockEntity().get_blockNameAndLife());
        blocoGBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blocoGBtnActnPerformed(evt);
            }
        });
        getContentPane().add(blocoGBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 200, 120));

        blocoVBtn.setText(blocoVBtn.get_blockEntity().get_blockNameAndLife());
        blocoVBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blocoVBtnActionPerformed(evt);
            }
        });
        getContentPane().add(blocoVBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 90, 190));

        blocoLBtn.setText(blocoLBtn.get_blockEntity().get_blockNameAndLife());
        blocoLBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blocoLBtnActionPerformed(evt);
            }
        });
        getContentPane().add(blocoLBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 200, 110));

        blocoABtn.setText(blocoABtn.get_blockEntity().get_blockNameAndLife());
        blocoABtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blocoABtnActionPerformed(evt);
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

        roundCounterUI.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
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

        EventManager.SubscribeInPlayerEvent("PL_COMPLETED_OBJ", this);

        GiveAllPlayersARandomBlock();
        pack();
    }

    @Override
    public void OnPlayerEventRaised(Player player) {
        JOptionPane.showMessageDialog(null, String.format("Parabéns, %s!\nVocê ganhou!", player.GetPlayerName()));

        EndGame();
    }

    private void EndGame(){

        telainicial jgame = new telainicial(null, false);
        jgame.show();
        dispose();
    }

    private void DominateBlock(Player playerDominator, BlockButton blockButton){
        Block block = blockButton.get_blockEntity();
        block.set_isDominated(true);
        block.set_playerWhoDominated(playerDominator);

        blockButton.setBackground(playerDominator.get_playerColor());
    }

    private BlockButton GetRandomNotDominatedBlockFromArray(){
        Random random = new Random();
        BlockButton blockBtnToReturn = null;

        BlockButton initialBlocksPool[] = new BlockButton[]{
                _allBlockButtonsContainer[1],
                _allBlockButtonsContainer[2],
                _allBlockButtonsContainer[5],
                _allBlockButtonsContainer[6],
        };

        while (blockBtnToReturn == null){
            int randomIndex = random.nextInt(initialBlocksPool.length);
            BlockButton randomBlockBtn = initialBlocksPool[randomIndex];

            if(!randomBlockBtn.get_blockEntity().get_isDominated()){
                blockBtnToReturn = randomBlockBtn;
            }
        }
        return blockBtnToReturn;
    }

    private void GiveAllPlayersARandomBlock(){
        for (Player player : _activePlayersArray){
            DominateBlock(player, GetRandomNotDominatedBlockFromArray());
        }
    }

    private boolean CheckIfNeibourIsDominatedByCurrentPlayer(BlockButton blockButton) {
        HashMap<String, Block[]> neigboursMap = _neighboursMapper.get_neighboursMap();
        Block[] neighboursArray = neigboursMap.get(blockButton.get_blockEntity().get_blockName());


        for(Block neighbour : neighboursArray){
            if(neighbour.get_isDominated() && neighbour.get_playerWhoDominated() == get_CurrentPlayerInstance()){
                return true;
            }
        }

        JOptionPane.showMessageDialog(null, "Movimento inválido!\nAtaque apenas blocos vizinhos!");

        return false;
    }


    private void blocoJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!CheckIfNeibourIsDominatedByCurrentPlayer(blocoJBtn))
            return;

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance(), blocoJBtn);
        jquestion.show(); //mostra a questão

    }


    private void blocoWBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(!CheckIfNeibourIsDominatedByCurrentPlayer(blocoWBtn))
            return;

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance(), blocoWBtn);
        jquestion.show(); //mostra a questão
    }

    private void ginasioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(!CheckIfNeibourIsDominatedByCurrentPlayer(ginasioBtn))
            return;

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance(), ginasioBtn);
        jquestion.show(); //mostra a questão
        
    }

    private void blocoGBtnActnPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(!CheckIfNeibourIsDominatedByCurrentPlayer(blocoGBtn))
            return;
        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance(), blocoGBtn);
        jquestion.show(); //mostra a questão
        
    }

    private void blocoFBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(!CheckIfNeibourIsDominatedByCurrentPlayer(blocoFBtn))
            return;

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance(), blocoFBtn);
        jquestion.show(); //mostra a questão
    }

    private void blocoEBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(!CheckIfNeibourIsDominatedByCurrentPlayer(blocoEBtn))
            return;


        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance(), blocoEBtn);
        jquestion.show(); //mostra a questão
    }

    private void blocoABtnActionPerformed(java.awt.event.ActionEvent evt) {

        if(!CheckIfNeibourIsDominatedByCurrentPlayer(blocoABtn))
            return;

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance(), blocoABtn);
        jquestion.show(); //mostra a questão
    }

    private void blocoVBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        if(!CheckIfNeibourIsDominatedByCurrentPlayer(blocoVBtn))
            return;

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance(), blocoVBtn);
        jquestion.show(); //mostra a questão
    }

    private void blocoHBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(!CheckIfNeibourIsDominatedByCurrentPlayer(blocoHBtn))
            return;

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance(), blocoHBtn);
        jquestion.show(); //mostra a questão
    }

    private void blocoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!CheckIfNeibourIsDominatedByCurrentPlayer(blocoRBtn))
            return;

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance(), blocoRBtn);
        jquestion.show(); //mostra a questão
    }

    private void blocoLBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(!CheckIfNeibourIsDominatedByCurrentPlayer(blocoLBtn))
            return;

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance(), blocoLBtn);
        jquestion.show(); //mostra a questão
    }

    private void blocoSBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(!CheckIfNeibourIsDominatedByCurrentPlayer(blocoSBtn))
            return;

        QuestionScreen jquestion = new QuestionScreen(_questionDAO, get_CurrentPlayerInstance(), blocoSBtn);
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

    private BlockButton blocoJBtn;
    private BlockButton blocoVBtn;
    private BlockButton blocoLBtn;
    private BlockButton blocoABtn;
    private BlockButton blocoRBtn;
    private BlockButton ginasioBtn;
    private BlockButton blocoHBtn;
    private BlockButton blocoFBtn;
    private BlockButton blocoEBtn;
    private BlockButton blocoSBtn;
    private BlockButton blocoWBtn;
    private BlockButton blocoGBtn;
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
    private RoundCounterDisplay roundCounterUI;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextPane jTextPane1;
    RoundCounterDisplay display;

}
