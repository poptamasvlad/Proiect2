package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplicatie extends JFrame {
    private magazin.Magazin magazin = new magazin.Magazin();
    private DefaultTableModel tableModel;
    private JPanel specificPanel;
    private JTextField specificField1;
    private JTextField specificField2;
    private JLabel specificLabel1;
    private JLabel specificLabel2;

    public Aplicatie() {
        super("Magazin de Produse Electronice");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panelAdaugaProdus = new JPanel(new GridLayout(8, 2, 10, 10));
        panelAdaugaProdus.setBorder(BorderFactory.createTitledBorder("Adaugare Produs"));

        JPanel panelAfiseazaProduse = new JPanel(new BorderLayout());

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        JLabel numeLabel = new JLabel("Nume produs:");
        numeLabel.setFont(labelFont);
        JTextField numeField = new JTextField(15);

        JLabel pretLabel = new JLabel("Pret:");
        pretLabel.setFont(labelFont);
        JTextField pretField = new JTextField(15);

        JLabel stocLabel = new JLabel("Stoc:");
        stocLabel.setFont(labelFont);
        JTextField stocField = new JTextField(15);

        JLabel tipProdusLabel = new JLabel("Tip produs:");
        tipProdusLabel.setFont(labelFont);
        JComboBox<String> tipProdusCombo = new JComboBox<>(new String[]{"Telefon", "Laptop", "PC", "Consola"});

        specificPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        specificLabel1 = new JLabel("Specificatie 1:");
        specificLabel1.setFont(labelFont);
        specificField1 = new JTextField(15);

        specificLabel2 = new JLabel("Specificatie 2:");
        specificLabel2.setFont(labelFont);
        specificField2 = new JTextField(15);

        specificPanel.add(specificLabel1);
        specificPanel.add(specificField1);
        specificPanel.add(specificLabel2);
        specificPanel.add(specificField2);

        JButton adaugaProdusButton = new JButton("Adauga Produs");
        adaugaProdusButton.setBackground(Color.GREEN);
        adaugaProdusButton.setForeground(Color.WHITE);

        panelAdaugaProdus.add(numeLabel);
        panelAdaugaProdus.add(numeField);
        panelAdaugaProdus.add(pretLabel);
        panelAdaugaProdus.add(pretField);
        panelAdaugaProdus.add(stocLabel);
        panelAdaugaProdus.add(stocField);
        panelAdaugaProdus.add(tipProdusLabel);
        panelAdaugaProdus.add(tipProdusCombo);
        panelAdaugaProdus.add(specificPanel);
        panelAdaugaProdus.add(adaugaProdusButton);

        tabbedPane.add("Adaugare Produs", panelAdaugaProdus);

        String[] coloane = {"Nume", "Pret", "Stoc", "Tip", "Specificatie 1", "Specificatie 2"};
        tableModel = new DefaultTableModel(coloane, 0);
        JTable produseTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(produseTable);
        panelAfiseazaProduse.add(scrollPane, BorderLayout.CENTER);
        JButton afiseazaProduseButton = new JButton("Afiseaza Produse");
        panelAfiseazaProduse.add(afiseazaProduseButton, BorderLayout.SOUTH);

        tabbedPane.add("Afisare Produse", panelAfiseazaProduse);

        add(tabbedPane, BorderLayout.CENTER);

        tipProdusCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipProdus = (String) tipProdusCombo.getSelectedItem();
                configureSpecificFields(tipProdus);
            }
        });

        adaugaProdusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = numeField.getText();
                double pret = Double.parseDouble(pretField.getText());
                int stoc = Integer.parseInt(stocField.getText());
                String tipProdus = (String) tipProdusCombo.getSelectedItem();

                String specific1 = specificField1.getText();
                String specific2 = specificField2.getText();

                switch (tipProdus) {
                    case "Telefon":
                        magazin.Telefon telefon = new magazin.Telefon(nume, pret, stoc, specific1, specific2);
                        magazin.adaugaProdus(telefon);
                        break;
                    case "Laptop":
                        magazin.Laptop laptop = new magazin.Laptop(nume, pret, stoc, Double.parseDouble(specific1), Integer.parseInt(specific2));
                        magazin.adaugaProdus(laptop);
                        break;
                    case "PC":
                        magazin.PC pc = new magazin.PC(nume, pret, stoc, specific1, Integer.parseInt(specific2), 500); // Capacitate stocare default 500GB
                        magazin.adaugaProdus(pc);
                        break;
                    case "Consola":
                        magazin.Consola consola = new magazin.Consola(nume, pret, stoc, Integer.parseInt(specific1), specific2);
                        magazin.adaugaProdus(consola);
                        break;
                }

                JOptionPane.showMessageDialog(null, "Produs adaugat!");
                actualizeazaTabela();
            }
        });

        afiseazaProduseButton.addActionListener(e -> actualizeazaTabela());
    }

    private void configureSpecificFields(String tipProdus) {
        switch (tipProdus) {
            case "Telefon":
                specificLabel1.setText("Sistem de operare:");
                specificLabel2.setText("Model:");
                break;
            case "Laptop":
                specificLabel1.setText("Greutate (kg):");
                specificLabel2.setText("Autonomie (ore):");
                break;
            case "PC":
                specificLabel1.setText("Procesor:");
                specificLabel2.setText("Memorie RAM (GB):");
                break;
            case "Consola":
                specificLabel1.setText("Stocare (GB):");
                specificLabel2.setText("Generatie:");
                break;
        }
    }

    private void actualizeazaTabela() {
        tableModel.setRowCount(0);

        for (magazin.Produs produs : magazin.getProduse()) {
            Object[] rowData = new Object[]{
                    produs.getNume(),
                    produs.getPret(),
                    produs.getStoc(),
                    produs.getClass().getSimpleName(),
                    produs instanceof magazin.Telefon ? ((magazin.Telefon) produs).getSistemOperare() :
                            produs instanceof magazin.Laptop ? ((magazin.Laptop) produs).getGreutate() + " kg" :
                                    produs instanceof magazin.PC ? ((magazin.PC) produs).getProcesor() :
                                            produs instanceof magazin.Consola ? ((magazin.Consola) produs).getStocare() + " GB" : "",
                    produs instanceof magazin.Telefon ? ((magazin.Telefon) produs).getModel() :
                            produs instanceof magazin.Laptop ? ((magazin.Laptop) produs).getAutonomie() + " ore" :
                                    produs instanceof magazin.PC ? ((magazin.PC) produs).getMemorieRAM() + " GB" :
                                            produs instanceof magazin.Consola ? ((magazin.Consola) produs).getGeneratie() : ""
            };
            tableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Aplicatie().setVisible(true));
    }
}
