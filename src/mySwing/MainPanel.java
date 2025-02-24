package mySwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class MainPanel extends JFrame {
    private JPanel externalPanel;
    private JPanel pnNorth;
    private JPanel pnWest;
    private JPanel pnEast;
    private JPanel pnSouth;
    private JPanel pnCenter;
    private JButton btn0;
    private JButton btnPointer;
    private JButton btnPorcentage;
    private JButton btnAdd;
    private JButton btn1;
    private JButton btnIgual;
    private JButton btn2;
    private JButton btn3;
    private JButton btnSub;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btnMult;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnDiv;
    private JLabel lbEspaco1;
    private JLabel lbOperacao;
    private JLabel lbEspaco2;
    private JLabel lbResultado;
    private JButton cButton;

    List<String> listaNums1 = new LinkedList<>();
    List<String> listaNums2 = new LinkedList<>();
    String operacao;
    String regexString;
    Double resultado;
    boolean verificacao = false;


    public static String sRegex(String regex) {
        return regex.replaceAll("[\\[\\],\\s]", "");
    }

    public static void funcClear(List<String> l1, List<String> l2, JLabel lb1, JLabel lb2, JLabel lb3, JLabel lb4) {
        l1.clear();
        l2.clear();
        lb1.setText("");
        lb2.setText("");
        lb3.setText("");
        lb4.setText("");
    }


    public static void funcResultado(JLabel lbEspaco1, JLabel lbEspaco2, JLabel lbOperacao, JLabel lbResultado, double resultado, List<String> l1, List<String> l2) {
        l1.clear();
        l2.clear();
        lbEspaco1.setText("");
        lbEspaco2.setText("");
        lbOperacao.setText("");
        lbResultado.setText(String.valueOf(resultado));
    }

    public void botoes(JButton btn) {
        if (operacao == null) {
            if (verificacao) {
                verificacao = false;
                funcClear(listaNums1, listaNums2, lbEspaco1, lbEspaco2, lbOperacao, lbResultado);
                operacao = null;
                resultado = null;
            }
            listaNums1.add(btn.getText());
            regexString = sRegex(listaNums1.toString());
            lbEspaco1.setText(regexString);
        } else {
            listaNums2.add(btn.getText());
            regexString = sRegex(listaNums2.toString());
            lbEspaco2.setText(regexString);
        }
    }
    public void botaoOperacao(JButton btn) {
        if (resultado == null && !lbEspaco1.getText().isEmpty()) {
            operacao = btn.getText();
            lbOperacao.setText(operacao);
        } else if(resultado != null){
            operacao = btn.getText();
            lbResultado.setText("");
            lbEspaco1.setText(regexString);
            lbOperacao.setText(operacao);
        }
    }

    public MainPanel() {

        setSize(530, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Calculadora");

        pnNorth.setBackground(Color.decode("#78866b"));
        pnWest.setBackground(Color.decode("#0d0c00"));
        pnEast.setBackground(Color.decode("#0d0c00"));
        pnSouth.setBackground(Color.decode("#0d0c00"));
        pnCenter.setBackground(Color.decode("#260101"));

        pnNorth.setPreferredSize(new Dimension(100, 170));
        pnWest.setPreferredSize(new Dimension(10, 100));
        pnEast.setPreferredSize(new Dimension(10, 100));
        pnSouth.setPreferredSize(new Dimension(10, 10));

        setContentPane(externalPanel);

        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botoes(btn0);
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botoes(btn1);
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botoes(btn2);
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botoes(btn3);
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botoes(btn4);
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botoes(btn5);
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botoes(btn6);
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botoes(btn8);
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botoes(btn7);
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botoes(btn9);
            }
        });

        btnIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String espaco1 = null;
                String espaco2 = null;
                Double resultado1Db = 0.0;
                Double resultado2Db = 0.0;
                try {
                    for (String s : listaNums1) {
                        espaco1 += s;
                    }
                    System.out.println("Espaco 1: " + espaco1);

                    for (String s : listaNums2) {
                        espaco2 += s;
                    }
                    System.out.println("Espaco 2: " + espaco2);
                    String re1[] = espaco1.split("null");
                    String re2[] = espaco2.split("null");
                    resultado1Db = Double.parseDouble(re1[1]);
                    resultado2Db = Double.parseDouble(re2[1]);
                    switch (operacao) {
                        case "+":
                            resultado = resultado1Db + resultado2Db;
                            funcResultado(lbEspaco1, lbOperacao, lbEspaco2, lbResultado, resultado, listaNums1, listaNums2);
                            listaNums1.add(String.valueOf(resultado));
                            regexString = sRegex(listaNums1.toString());
                            verificacao = true;
                            operacao = null;
                            break;
                        case "-":
                            resultado = resultado1Db - resultado2Db;
                            funcResultado(lbEspaco1, lbOperacao, lbEspaco2, lbResultado, resultado, listaNums1, listaNums2);
                            listaNums1.add(String.valueOf(resultado));
                            regexString = sRegex(listaNums1.toString());
                            verificacao = true;
                            operacao = null;
                            break;
                        case "*":
                            resultado = resultado1Db * resultado2Db;
                            funcResultado(lbEspaco1, lbOperacao, lbEspaco2, lbResultado, resultado, listaNums1, listaNums2);
                            listaNums1.add(String.valueOf(resultado));
                            regexString = sRegex(listaNums1.toString());
                            verificacao = true;
                            operacao = null;
                            break;
                        case "/":
                            resultado = resultado1Db / resultado2Db;
                            funcResultado(lbEspaco1, lbOperacao, lbEspaco2, lbResultado, resultado, listaNums1, listaNums2);
                            listaNums1.add(String.valueOf(resultado));
                            regexString = sRegex(listaNums1.toString());
                            verificacao = true;
                            operacao = null;
                    }
                } catch (NullPointerException ex) {
                    throw new ExMainPanel(ex.getMessage());
                } finally {
                    System.out.println("----------------- testes igual");
                    System.out.println("Operacao: " + operacao);
                    System.out.println("Resultado: " + resultado);
                    System.out.println(listaNums1.toString());
                    System.out.println(listaNums2.toString());
                }

            }
        });


        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botaoOperacao(btnAdd);
            }
        });


        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcClear(listaNums1, listaNums2, lbEspaco1, lbEspaco2, lbOperacao, lbResultado);
                operacao = null;
                resultado = null;
            }
        });

        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botaoOperacao(btnSub);
            }
        });


        btnMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botaoOperacao(btnMult);
            }
        });

        btnDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botaoOperacao(btnDiv);
            }
        });


        btnPorcentage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botaoOperacao(btnPorcentage);
            }
        });
    }
}