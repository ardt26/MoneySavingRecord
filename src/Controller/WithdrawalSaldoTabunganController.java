package Controller;

import MVC.TabunganMVC;
import Model.TabunganModel;
import View.WithdrawalSaldoTabunganView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawalSaldoTabunganController {
    TabunganModel model;
    WithdrawalSaldoTabunganView view;
    String data[][];

    public WithdrawalSaldoTabunganController(TabunganModel model, WithdrawalSaldoTabunganView view, String[][] data) {
        this.model = model;
        this.view = view;
        this.data = data;

        view.btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                TabunganMVC tabunganMVC = new TabunganMVC(data);
            }
        });

        view.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String desc = view.getTfdesc();
                String amount = view.getTfamount();
                String dataTabungan[][] = model.readTabungan(data[0][0]);
                int total = Integer.parseInt(dataTabungan[model.getBanyakDataTabungan(data[0][0])-1][5].trim()) - Integer.parseInt(amount.trim());
                if (total < 0){
                    JOptionPane.showMessageDialog(null,"Uang Anda Tidak Mencukupi");
                } else{
                    model.insertTabunganWithdrawal(desc,amount,String.valueOf(total),data[0][0]);
                    view.setVisible(false);
                    TabunganMVC tabunganMVC = new TabunganMVC(data);
                }

            }
        });
    }
}
