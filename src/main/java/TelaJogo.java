import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author hlima
 */
public class TelaJogo extends javax.swing.JFrame {
    
    int QtAlimentos=100, QtPessoas=10, QtVilas=1, QtRiquezas, QtArmas, QtSoldados, Status, Vt,VtPrimeirosPassos=0, Valor, debug=0, QtDias;
    int a=10000000, b=4000;     // variaveis do delay

    double c= QtVilas+QtPessoas;

    
   /*  long totalMilisegundos = System.currentTimeMillis()-10800000;
    long totalSegundos = totalMilisegundos / 1000;
    long segundoAtual = totalSegundos % 60;
    long totalMinutos = totalSegundos / 60;
    long minutoAtual = totalMinutos % 60;
    long totalHora = totalMinutos / 60;
    long horaAtual = totalHora % 24; */

    Random aleatorio = new Random();    //gerador de numeros
                  
    public TelaJogo() {
        initComponents();
        Jogo();
    }
    
    public void ContagemTempo(){
    
        Timer timer = new Timer();
        
        TimerTask tarea = new TimerTask(){
            @Override
            public void run(){
               QtDias++;
               QtAlimentos-=(((QtVilas+QtPessoas)/QtAlimentos)*1000);   //valor gerado proporcional a quantidade de pessoas e vilas
            }
        };
        timer.schedule(tarea, 0, 500000);
    }
    
    void IniciarAtualizar(){

        if (VtPrimeirosPassos==0) {
            
            QtAlimentos = 100;
            QtPessoas = 10;
            QtRiquezas = 0;
            QtArmas = 0;
            QtSoldados = 0;
            QtVilas = 1;
            QtDias = 0;
            Vt = 0;
            btnOp1.setEnabled(true);
            btnOp2.setEnabled(true);
            btnOp3.setEnabled(true);
            btnCentral.setEnabled(true);
            btnCentral.setText("Abrir Central de Tarefas");
            btnSair.setText("Sair do Jogo");
            
        } else {
            if (QtAlimentos > 100) {
                QtAlimentos=100;
            }

            lblValoresAlimentos.setText(Integer.toString(QtAlimentos)+"%");
            lblValoresPessoas.setText(Integer.toString(QtPessoas));
            lblValoresRiquezas.setText(Integer.toString(QtRiquezas));
            lblValoresArmas.setText(Integer.toString(QtArmas));
            lblValoresSoldados.setText(Integer.toString(QtSoldados));
            lblValoresVilas.setText(Integer.toString(QtVilas));
            lblValoresDias.setText(Integer.toString(QtDias));
        }
        LimparOp();
        
    }
        
    void LimparOp(){            // limpar as opções 
        btnOp1.setText("-");
        btnOp2.setText("-");
        btnOp3.setText("-");
    }
 
    void PrimeirosPassos(){
       
        if (Vt==2) {
            btnOp1.setText("Ok");
            lblMsg.setText("<html>No canto direito podemos observa<br/> a quantidade de pessoas que <br/>temos em nossa vila.<br/><br/> Atualmente temos 10 Pessoas.</html>");
            
            switch (VtPrimeirosPassos) {
                case 1:
            
                lblMsg.setText("<html>Abaixo temos os alimentos das vilas,<br/> nunca deixe abaixo da metade.<br/> Isso pode gerar um pouco de <br/> confusão nas cidades!<br/><br/></html>");
                    
                break;
                case 2:
                    
                lblMsg.setText("<html>Como estamos começando,<br/> temos apenas uma vila... <br/>mas tenho certeza que vamos<br/> conseguir muito mais!</html>");

                break;
                case 3:

                lblMsg.setText("<html>E não podemos esquecer<br/> as nossas riquezas! <br/> quanto maior for o nosso posicionamento<br/> mais feliz os cidadões ficam! <br/> mas cuidado, isso tambem pode atrair latroes!</html>");

                break;
                case 4:

                lblMsg.setText("<html>Ao lado esquerdo<br/> podemos observar quantos </br> soltados temos.<br/> Quanto mais melhor! <br/> isso deixa as vilas mais seguras </html>");

                break;
                case 5:

                lblMsg.setText("<html>Abaixo temos as armas,<br/> precisamos sempre estar<br/> armados para futuros confrontos.</html>");

                break;
                case 6:

                lblMsg.setText("<html>E por fim, temos o status<br/> fique de olhada para saber como as<br/> coisas estão indo.</html>");

                break;
                case 7:

                lblMsg.setText("<html>Agora vamos trabalhar!</html>");
                btnOp1.setText("Vamos la!");

                break;
            }
          
        }else{
        lblMsg.setText("<html>Ola, seja bem vindo! <br/> estou aqui para te ensinar meu lorde!<br/><br/>Gostaria de um tutorial?</html>");
        btnOp1.setText("Sim");
        btnOp3.setText("Não");
        Vt=1;           //variavel para tutorial
        }
    }
   
    void Historia(){

        Valor = aleatorio.nextInt(5)+1;

        switch (Valor) {
            case 1:
                lblMsg.setText("<html>Ola meu Sr.<br/>Estamos aqui pois chegou alguns nomades<br/> que querem viver aqui.<br/><br/>Eles podem fica?</html>");
                btnOp1.setText("Sim");
                btnOp3.setText("Não");
                Vt=11;              //Numero da historia nos botões
            break;
            case 2:
                lblMsg.setText("<html>Ola meu Sr.<br/>um grupo de pessoas estão<br/>indo embora, o que devemos fazer?</html>");
                btnOp1.setText("Deixar eles irem");
                btnOp2.setText("Pedir para ficar");
                btnOp3.setText("Não deixar ninguem ir");
                Vt=12;              //Numero da historia nos botões
            break;
            case 3:
                lblMsg.setText("<html>Meu Sr.<br/>um tigre esta atacando a vila, <br/>o que devemos fazer?</html>");
                btnOp1.setText("O importante é proteger as pessoas!");
                btnOp2.setText("O importante é matar o tigre");
                btnOp3.setText("Espera ele ir embora");
                Vt=13;              //Numero da historia nos botões
            break;
            case 4:
                lblMsg.setText("<html>Meu Sr.<br/>um forasteiro chegou na vila<br/>pedindo para ficar</html>");
                btnOp1.setText("Pode deixar ele fica");
                btnOp2.setText("Fica de olho nele");
                btnOp3.setText("Não quero ele aqui");
                Vt=14;              //Numero da historia nos botões
            break;
            case 5:
                lblMsg.setText("<html>Meu Sr.<br/>Uma vila vizinha esta<br/>querendo forma uma aliança<br/><br/>Devemos forma uma aliança?</html>");
                btnOp1.setText("Sim, vamos fazer uma festa!");
                btnOp2.setText("Ok");
                btnOp3.setText("Não");
                Vt=15;              //Numero da historia nos botões
            break;
            
        }

    }

    void Jogo(){

        if (QtPessoas <= 0 || QtAlimentos <=0 || QtVilas <= 0) {
            lblMsg.setText("<html>Infelizmente seu reino <br/> não deu certo <br/><br/> Boa sorte na proxima! </html>");
            LimparOp();
            QtPessoas=0;
            btnOp1.setEnabled(false);
            btnOp2.setEnabled(false);
            btnOp3.setEnabled(false);
            btnCentral.setEnabled(false);
            btnCentral.setText("-");
            btnSair.setText("Jogar novamente");
            System.out.println(VtPrimeirosPassos);
            IniciarAtualizar();
        }else{
        
        IniciarAtualizar();
        
        if (VtPrimeirosPassos <= 7) {
        PrimeirosPassos();
        } else {
        
        Historia();
        ContagemTempo(); // fazer contagem dos dias

        }
        
        //analise das variaveis
        debug++;
        System.out.println("----/Inicio/----- "+debug);
        /*
        System.out.println("VtPrimeirosPassos "+VtPrimeirosPassos);
        System.out.println("Vt "+Vt);
        System.out.println("Variavel "+Valor);
        */
        System.out.println(c);
        System.out.println("----/Fim/-----");
        }

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("Generated Code")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblMsg = new javax.swing.JLabel();
        btnOp1 = new javax.swing.JButton();
        btnOp2 = new javax.swing.JButton();
        btnOp3 = new javax.swing.JButton();
        lblPessoas = new javax.swing.JLabel();
        lblValoresPessoas = new javax.swing.JLabel();
        lblAlimentos = new javax.swing.JLabel();
        lblValoresAlimentos = new javax.swing.JLabel();
        lblVilas = new javax.swing.JLabel();
        lblValoresVilas = new javax.swing.JLabel();
        lblRiquezas = new javax.swing.JLabel();
        lblValoresRiquezas = new javax.swing.JLabel();
        lblSoldados = new javax.swing.JLabel();
        lblValoresSoldados = new javax.swing.JLabel();
        lblArmas = new javax.swing.JLabel();
        lblValoresArmas = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblMsgStatus = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnCentral = new javax.swing.JButton();
        lblDias = new javax.swing.JLabel();
        lblValoresDias = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        lblMsg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMsg.setForeground(new java.awt.Color(255, 255, 255));
        lblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMsg.setText("Mensagem");

        btnOp1.setForeground(new java.awt.Color(204, 204, 204));
        btnOp1.setText("Opção 1");
        btnOp1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(51, 51, 51), new java.awt.Color(102, 102, 102)));
        btnOp1.setContentAreaFilled(false);
        btnOp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp1ActionPerformed(evt);
            }
        });

        btnOp2.setForeground(new java.awt.Color(204, 204, 204));
        btnOp2.setText("Opção 2");
        btnOp2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(51, 51, 51), new java.awt.Color(102, 102, 102)));
        btnOp2.setContentAreaFilled(false);
        btnOp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp2ActionPerformed(evt);
            }
        });

        btnOp3.setForeground(new java.awt.Color(204, 204, 204));
        btnOp3.setText("Opção 3");
        btnOp3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(51, 51, 51), new java.awt.Color(102, 102, 102)));
        btnOp3.setContentAreaFilled(false);
        btnOp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOp3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOp1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOp2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOp3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblPessoas.setForeground(new java.awt.Color(255, 255, 255));
        lblPessoas.setText("Pessoas");

        lblValoresPessoas.setForeground(new java.awt.Color(255, 255, 255));
        lblValoresPessoas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValoresPessoas.setText("-");

        lblAlimentos.setForeground(new java.awt.Color(255, 255, 255));
        lblAlimentos.setText("Alimentos");

        lblValoresAlimentos.setForeground(new java.awt.Color(255, 255, 255));
        lblValoresAlimentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValoresAlimentos.setText("-");

        lblVilas.setForeground(new java.awt.Color(255, 255, 255));
        lblVilas.setText("Vilas");

        lblValoresVilas.setForeground(new java.awt.Color(255, 255, 255));
        lblValoresVilas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValoresVilas.setText("-");

        lblRiquezas.setForeground(new java.awt.Color(255, 255, 255));
        lblRiquezas.setText("Riquezas");

        lblValoresRiquezas.setForeground(new java.awt.Color(255, 255, 255));
        lblValoresRiquezas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValoresRiquezas.setText("-");

        lblSoldados.setForeground(new java.awt.Color(255, 255, 255));
        lblSoldados.setText("Soldados");

        lblValoresSoldados.setForeground(new java.awt.Color(255, 255, 255));
        lblValoresSoldados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValoresSoldados.setText("-");

        lblArmas.setForeground(new java.awt.Color(255, 255, 255));
        lblArmas.setText("Armas");

        lblValoresArmas.setForeground(new java.awt.Color(255, 255, 255));
        lblValoresArmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValoresArmas.setText("-");

        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setText("Status");

        lblMsgStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblMsgStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMsgStatus.setText("-");

        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair do Jogo");
        btnSair.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        btnSair.setContentAreaFilled(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnCentral.setForeground(new java.awt.Color(255, 255, 255));
        btnCentral.setText("Abrir central de tarefas");
        btnCentral.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        btnCentral.setContentAreaFilled(false);
        btnCentral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCentralActionPerformed(evt);
            }
        });

        lblDias.setForeground(new java.awt.Color(255, 255, 255));
        lblDias.setText("Dias");

        lblValoresDias.setForeground(new java.awt.Color(255, 255, 255));
        lblValoresDias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValoresDias.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblSoldados, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValoresSoldados, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValoresArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMsgStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDias, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValoresDias, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValoresPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValoresAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblVilas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValoresVilas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblRiquezas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValoresRiquezas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValoresSoldados, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoldados, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValoresArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMsgStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValoresDias, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDias, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCentral, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValoresPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValoresAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValoresVilas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVilas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValoresRiquezas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRiquezas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // #Sair
        if (QtPessoas==0) {
            VtPrimeirosPassos=0;
            QtPessoas=10;
            Jogo();
        } else {
            System.exit(0);
        }
        
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnOp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOp1ActionPerformed
        // #Opção 1
        switch(Vt){
            case 1:     //Iniviar Tutorial
                Vt=2;
                PrimeirosPassos();
                btnOp3.setText("Finalizar");
            break;
            case 2:     //Fazer o Tutorial
                VtPrimeirosPassos++;
                PrimeirosPassos();
            break;      //fim do tutorial  
            case 11:    //Inicio Historia
                lblMsg.setText("<html>Muito bem meu lorde.<br/>Eles ficam gratos!<html/>");
                QtPessoas+=6;
            break;
            case 12:    //Historia
                lblMsg.setText("Eles foram embora.");
                QtPessoas-=6;
            break;
            case 13:    //Historia
                lblMsg.setText("Conseguimos salvar todos!");
                QtAlimentos-=10;
            break;
            case 14:    //Historia
                lblMsg.setText("o forasteiro é grato.");
                QtPessoas+=1;
            break;
            case 15:    //Historia
                lblMsg.setText("<html>A vila e as pessoas<br/>Ficaram feliz!<html/>");
                QtAlimentos-=10;
            break;
            
        }
        LimparOp();

        Timer timer = new Timer();
        TimerTask tarea = new TimerTask(){
            @Override
            public void run(){
                Jogo();
            }
        };
        timer.schedule(tarea, b, a);
    }//GEN-LAST:event_btnOp1ActionPerformed

    private void btnOp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOp2ActionPerformed
        // #Opção 2

        switch(Vt){
            case 12:    //Inicio Historia
                lblMsg.setText("Alguns deles ficaram.");
                QtPessoas-=3;
            break;
            case 13:    //Historia
                lblMsg.setText("Pessoas morreram, mas matamos o tigre");
                QtPessoas-=3;
                QtAlimentos+=10;
            break;
            case 14:    //Historia
                lblMsg.setText("Ok Sr.");
                QtPessoas+=1;
            break;
            case 15:    //Historia
                lblMsg.setText("Otimo, vamos avisar eles");
            break;

        }
    
         LimparOp();

        Timer timer = new Timer();
        TimerTask tarea = new TimerTask(){
            @Override
            public void run(){
                Jogo();
            }
        };
        timer.schedule(tarea, b, a);
        
    }//GEN-LAST:event_btnOp2ActionPerformed

    private void btnOp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOp3ActionPerformed
        // #Opção 3

        switch(Vt){
            case 1:     //Não quero iniciar Tutorial?
                lblMsg.setText("Ok Sr. boa sorte!");
                VtPrimeirosPassos+=8;
            break;      //fim do tutorial
            case 11:    //Inicio Historia
                lblMsg.setText("<html>Muito bem meu lorde.<br/>Eles foram embora<html/>");
                QtPessoas-=6;
            break;
            case 12:    //Historia
                lblMsg.setText("Eles ficaram, mas estão reclamando.");
            break;
            case 13:    //Historia
                lblMsg.setText("<html>O tigre foi embora,<br/> mas matou algumas pessoas.</html>");
                QtPessoas-=5;
                QtAlimentos-=3;
            break;
            case 14:    //Historia
                lblMsg.setText("<html>Ele saiu reclamando e<br/>falou que deve se vingar.</html>");
            break;
            case 15:    //Historia
                lblMsg.setText("<html>O lider da vila,<br/> não entendeu o motivo da recusa.<br/> Mas devemos ficar bem.</html>");
            break;
            
        }
 
         LimparOp();

        Timer timer = new Timer();
        TimerTask tarea = new TimerTask(){
            @Override
            public void run(){
                Jogo();
            }
        };
        timer.schedule(tarea, b, a);
        
    }//GEN-LAST:event_btnOp3ActionPerformed

    private void btnCentralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCentralActionPerformed
        // Abrir Central de tarefas
        TelaTarefas tela = new TelaTarefas();
        tela.setVisible(true);
    }//GEN-LAST:event_btnCentralActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCentral;
    private javax.swing.JButton btnOp1;
    private javax.swing.JButton btnOp2;
    private javax.swing.JButton btnOp3;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAlimentos;
    private javax.swing.JLabel lblArmas;
    private javax.swing.JLabel lblDias;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblMsgStatus;
    private javax.swing.JLabel lblPessoas;
    private javax.swing.JLabel lblRiquezas;
    private javax.swing.JLabel lblSoldados;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblValoresAlimentos;
    private javax.swing.JLabel lblValoresArmas;
    private javax.swing.JLabel lblValoresDias;
    private javax.swing.JLabel lblValoresPessoas;
    private javax.swing.JLabel lblValoresRiquezas;
    private javax.swing.JLabel lblValoresSoldados;
    private javax.swing.JLabel lblValoresVilas;
    private javax.swing.JLabel lblVilas;
    // End of variables declaration//GEN-END:variables
}
