package chataps;

import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author iagocolodetti
 */
public class ServidorForm extends javax.swing.JFrame {

    private final int MIN_PORTA = 0;
    private final int MAX_PORTA = 65535;

    private Servidor servidor;
    private List<Cliente> clientes;
    
    private final DefaultTableModel jtParticipantesModel;

    /**
     * Creates new form ServidorForm
     */
    public ServidorForm() {
        initComponents();

        txfIP.setEditable(false);
        txfIP.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        
        txfPorta.setEditable(false);
        txfPorta.setText("1010");

        btnLigar.requestFocus();

        jtaChat.setEditable(false);
        jtaChat.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        DefaultCaret caret = (DefaultCaret) jtaChat.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        jtParticipantesModel = (DefaultTableModel) jtParticipantes.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        lblIP = new javax.swing.JLabel();
        txfIP = new javax.swing.JTextField();
        lblPorta = new javax.swing.JLabel();
        txfPorta = new javax.swing.JTextField();
        btnLigar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaChat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaMensagem = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        btnLimparChat = new javax.swing.JButton();
        btnLimparMensagem = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtParticipantes = new javax.swing.JTable();
        lblDenuncie = new javax.swing.JLabel();
        lblSlogan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SOS Queimadas - Agente");
        setName("ServidorForm"); // NOI18N
        setResizable(false);

        lblIP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblIP.setText("IP");

        txfIP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblPorta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPorta.setText("Porta");

        txfPorta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfPorta.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnLigar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLigar.setText("LIGAR");
        btnLigar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLigarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chat", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jtaChat.setColumns(20);
        jtaChat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtaChat.setLineWrap(true);
        jtaChat.setRows(5);
        jtaChat.setWrapStyleWord(true);
        jtaChat.setFocusable(false);
        jScrollPane1.setViewportView(jtaChat);

        jtaMensagem.setColumns(20);
        jtaMensagem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtaMensagem.setLineWrap(true);
        jtaMensagem.setRows(3);
        jtaMensagem.setWrapStyleWord(true);
        jtaMensagem.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jtaMensagemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                jtaMensagemKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtaMensagem);

        btnEnviar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEnviar.setText("Enviar");
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEnviar.setEnabled(false);
        btnEnviar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnEnviarActionPerformed(evt);
            }
        });

        btnLimparChat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLimparChat.setText("Limpar Chat");
        btnLimparChat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimparChat.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLimparChatActionPerformed(evt);
            }
        });

        btnLimparMensagem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLimparMensagem.setText("Limpar Mensagem");
        btnLimparMensagem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimparMensagem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLimparMensagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimparChat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimparMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnLimparChat)
                    .addComponent(btnLimparMensagem))
                .addContainerGap())
        );

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chataps/images/sos queimadas.png"))); // NOI18N
        lblLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblLogo.setMaximumSize(null);
        lblLogo.setMinimumSize(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Participantes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jtParticipantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "IP", "Nome"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jtParticipantes.setRowSelectionAllowed(false);
        jScrollPane3.setViewportView(jtParticipantes);
        if (jtParticipantes.getColumnModel().getColumnCount() > 0)
        {
            jtParticipantes.getColumnModel().getColumn(0).setMinWidth(30);
            jtParticipantes.getColumnModel().getColumn(0).setPreferredWidth(50);
            jtParticipantes.getColumnModel().getColumn(1).setMinWidth(50);
            jtParticipantes.getColumnModel().getColumn(1).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblDenuncie.setFont(new java.awt.Font("Bodoni MT Black", 1, 18)); // NOI18N
        lblDenuncie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDenuncie.setText("Denuncie");

        lblSlogan.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        lblSlogan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSlogan.setText("Sistema de denúncias de queimadas ilegais nas matas brasileiras");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblDenuncie)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txfPorta)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(lblPorta))
                        .addComponent(txfIP, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addComponent(lblIP)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLigar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(lblSlogan))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblSlogan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDenuncie)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPorta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLigar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLigarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigarActionPerformed
        if (btnLigar.getText().equals("LIGAR")) {
            String sPorta = txfPorta.getText().trim();
            if (!sPorta.isEmpty()) {
                try {
                    int porta = Integer.parseInt(sPorta);
                    if (porta >= MIN_PORTA && porta <= MAX_PORTA) {
                        setServidorLigado(porta);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "O número da porta deve ser um inteiro positivo de no mínimo " + MIN_PORTA + " e no máximo " + MAX_PORTA + ".", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "A porta deve ser um número inteiro positivo de no mínimo " + MIN_PORTA + " e no máximo " + MAX_PORTA + ".", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Digite a porta em que deseja ligar o serviço.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            setServidorLigado(-1);
        }
    }//GEN-LAST:event_btnLigarActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        enviarMensagem();
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnLimparChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparChatActionPerformed
        jtaChat.setText("");
    }//GEN-LAST:event_btnLimparChatActionPerformed

    private void btnLimparMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparMensagemActionPerformed
        jtaMensagem.setText("");
    }//GEN-LAST:event_btnLimparMensagemActionPerformed

    private void jtaMensagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaMensagemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            enviarMensagem();
        }
    }//GEN-LAST:event_jtaMensagemKeyPressed

    private void jtaMensagemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaMensagemKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && btnLigar.getText().equals("DESLIGAR") && servidor != null) {
            jtaMensagem.setText(jtaMensagem.getText().trim());
        }
    }//GEN-LAST:event_jtaMensagemKeyReleased

    private void addMensagem(String text) {
        if (jtaChat.getText().toString().isEmpty()) {
            jtaChat.append(text);
        } else {
            jtaChat.append("\n" + text);
        }
    }
    
    private void addParticipante(String ip, String nome) {
        jtParticipantesModel.addRow(new Object[]{ ip, nome });
    }
    
    private void removerParticipante(String ip, String nome) {
        for (int i = 0; i < jtParticipantesModel.getRowCount(); i++) {
            if (jtParticipantesModel.getValueAt(i, 0).equals(ip) && jtParticipantesModel.getValueAt(i, 1).equals(nome)) {
                jtParticipantesModel.removeRow(i);
                break;
            }
        }
    }
    
    private String getParticipantes() {
        String participantes = "";
        for (int i = 0; i < jtParticipantesModel.getRowCount(); i++) {
            participantes += jtParticipantesModel.getValueAt(i, 1) + " ";
        }
        return participantes;
    }

    private void setServidorLigado(int porta) {
        if (porta != -1) {
            txfPorta.setEditable(false);
            txfPorta.setCursor(new Cursor(Cursor.TEXT_CURSOR));
            btnLigar.setText("DESLIGAR");
            btnEnviar.setEnabled(true);
            clientes = new ArrayList<>();
            servidor = new Servidor(porta);
            Thread thread = new Thread(servidor);
            thread.start();
        } else {
            for (Cliente cliente : clientes) {
                cliente.fechar();
            }
            if (servidor != null) {
                servidor.fechar();
            }
            servidor = null;
            jtParticipantesModel.setRowCount(0);
            txfPorta.setEditable(true);
            txfIP.setText("");
            btnLigar.setText("LIGAR");
            btnEnviar.setEnabled(false);
        }
    }
    
    private void enviarMensagem() {
        if (btnLigar.getText().equals("DESLIGAR") && servidor != null) {
            String mensagem = jtaMensagem.getText();
            if (!mensagem.trim().isEmpty()) {
                try {
                    jtaMensagem.setText("");
                    jtaMensagem.requestFocus();
                    servidor.enviar(mensagem.trim());
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível enviar a mensagem.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                jtaMensagem.setText("");
                JOptionPane.showMessageDialog(rootPane, "O campo destinado a mensagem está vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class Servidor implements Runnable {
        
        private ServerSocket serverSocket;
        private Socket socket;
        
        private volatile boolean ligado;

        private final int porta;

        public Servidor(int porta) {
            ligado = true;
            this.porta = porta;
        }

        public void fechar() {
            ligado = false;
            try {
                if (socket != null) {
                    socket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                socket = null;
                serverSocket = null;
            }
        }
        
        public void enviar(String mensagem) throws IOException {
            if (ligado) {
                try {
                    for (Cliente cliente : clientes) {
                        cliente.enviar("m", "Agente Ambiental: " + mensagem.trim());
                    }
                    addMensagem("Você: " + mensagem.trim());
                } catch (IOException e) {
                    throw e;
                }
            }
        }

        @Override
        public void run() {
            try {
                try {
                    serverSocket = new ServerSocket(porta);
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível ligar o serviço, verifique se a porta já está em uso ou se a rede está funcionando.", "Erro", JOptionPane.ERROR_MESSAGE);
                    setServidorLigado(-1);
                    return;
                }

                txfIP.setText(InetAddress.getLocalHost().getHostAddress());
                addMensagem("Chat ligado.");

                while (ligado) {
                    socket = serverSocket.accept();
                    Cliente cliente = new Cliente(socket);
                    clientes.add(cliente);
                    Thread thread = new Thread(cliente);
                    thread.start();
                }
            } catch (HeadlessException | IOException e) {
                addMensagem("Chat desligado.");
                setServidorLigado(-1);
            }
        }
    }
    
    private class Cliente implements Runnable {
        
        private Socket socket;
        
        private final String ip;
        private String nome;

        private volatile boolean conectado;
        
        public Cliente(Socket socket) {
            conectado = true;
            ip = (((InetSocketAddress) socket.getRemoteSocketAddress()).getAddress()).toString().replace("/", "");
            this.socket = socket;
        }
        
        public String getNome() {
            return nome;
        }
        
        public void fechar() {
            conectado = false;
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                socket = null;
            }
        }
        
        public void enviar(String tipo, String mensagem) throws IOException {
            if (conectado) {
                try {
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF(tipo + mensagem);
                } catch (IOException e) {
                    throw e;
                }
            }
        }

        @Override
        public void run() {
            try {
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                nome = dis.readUTF();
                if (nome.isEmpty()) {
                    enviar("m", "Você precisa fornecer um nome.");
                    clientes.remove(this);
                    fechar();
                    return;
                }
                if (nome.length() < 3 || nome.length() > 20 || nome.contains(" ")) {
                    enviar("m", "O nome deve ter de 3 à 20 caracteres e não pode ter espaços.");
                    clientes.remove(this);
                    fechar();
                    return;
                }
                if (nome.toLowerCase().equals("Agente Ambiental")) {
                    enviar("m", "O nome 'Agente Ambiental' é reservado.");
                    clientes.remove(this);
                    fechar();
                    return;
                }
                for (Cliente cliente : clientes) {
                    if (!this.equals(cliente) && nome.toLowerCase().equals(cliente.getNome().toLowerCase())) {
                        enviar("m", "O nome '" + nome + "' já está em uso.");
                        clientes.remove(this);
                        fechar();
                        return;
                    }
                }
                addMensagem(nome + " entrou no chat. (" + ip + ")");
                addParticipante(ip, nome);
                enviar("p", getParticipantes());
                for (Cliente cliente : clientes) {
                    if (!this.equals(cliente)) {
                        cliente.enviar("e", nome + " entrou no chat.");
                    }
                }
            } catch (Exception e) {
                clientes.remove(this);
                fechar();
            }
            
            while (conectado) {
                try {
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    String mensagem = dis.readUTF();
                    addMensagem(nome + ": " + mensagem);
                    for (Cliente cliente : clientes) {
                        if (!this.equals(cliente)) {
                            cliente.enviar("m", nome + ": " + mensagem);
                        }
                    }
                } catch (IOException e) {
                    if (conectado) {
                        addMensagem(nome + " saiu do chat. (" + ip + ")");
                        clientes.remove(this);
                        removerParticipante(ip, nome);
                        try {
                            for (Cliente cliente : clientes) {
                                cliente.enviar("s", nome + " saiu do chat.");
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } finally {
                            fechar();
                        }
                    }
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServidorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServidorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServidorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServidorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                ServidorForm serverForm = new ServidorForm();
                serverForm.setSize(800, 540);
                serverForm.setLocation(
                        (Toolkit.getDefaultToolkit().getScreenSize().width - serverForm.getWidth()) / 2,
                        (Toolkit.getDefaultToolkit().getScreenSize().height - serverForm.getHeight()) / 2);
                serverForm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnLigar;
    private javax.swing.JButton btnLimparChat;
    private javax.swing.JButton btnLimparMensagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtParticipantes;
    private javax.swing.JTextArea jtaChat;
    private javax.swing.JTextArea jtaMensagem;
    private javax.swing.JLabel lblDenuncie;
    private javax.swing.JLabel lblIP;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPorta;
    private javax.swing.JLabel lblSlogan;
    private javax.swing.JTextField txfIP;
    private javax.swing.JTextField txfPorta;
    // End of variables declaration//GEN-END:variables
}
