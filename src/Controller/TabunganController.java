package Controller;

import MVC.AddSaldoTabunganMVC;
import MVC.DashboardMVC;
import MVC.WithdrawalSaldoTabunganMVC;
import Model.TabunganModel;
import Model.UserModel;
import View.TabunganView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabunganController {
    TabunganModel model;
    TabunganView view;
    String data[][],dataTabungan[][];

    public TabunganController(TabunganModel model, TabunganView view, String[][] data) {
        this.model = model;
        this.view = view;
        this.data = data;
        int indexTerakhir;
        String dataTabungan[][] = model.readTabungan(data[0][0]);
        if (model.getBanyakDataTabungan(data[0][0]) != 0){
            if (dataTabungan[model.getBanyakDataTabungan(data[0][0])-1][5].equals("0")) {
                view.btnWithdraw.setEnabled(false);
            }
        } else{
            view.btnWithdraw.setEnabled(false);
        }

        if (model.getBanyakDataTabungan(data[0][0]) != 0){
            dataTabungan = model.readTabungan(data[0][0]);
            view.tabel.setModel(new JTable(dataTabungan, view.namaKolom).getModel());
            view.setlAmountDB(dataTabungan[model.getBanyakDataTabungan(data[0][0])-1][5]);
        } else{
            view.setlAmountDB("0");
            JOptionPane.showMessageDialog(null,"Data Tidak Ada");
        }

        view.back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                DashboardMVC dashboardMVC = new DashboardMVC(data);
            }
        });

        view.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                AddSaldoTabunganMVC addSaldoTabunganMVC = new AddSaldoTabunganMVC(data);
            }
        });

        view.btnWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                WithdrawalSaldoTabunganMVC withdrawalSaldoTabunganMVC = new WithdrawalSaldoTabunganMVC(data);
            }
        });
    }
}
