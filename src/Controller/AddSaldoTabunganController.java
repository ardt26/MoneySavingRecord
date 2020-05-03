package Controller;

import MVC.TabunganMVC;
import Model.TabunganModel;
import View.AddSaldoTabunganView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSaldoTabunganController {
    TabunganModel model;
    AddSaldoTabunganView view;
    String data[][];

    public AddSaldoTabunganController(TabunganModel model, AddSaldoTabunganView view, String[][] data) {
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
                try{
                    String desc = view.getTfdesc();
                    String amount = view.getTfamount();
                    String dataTabungan[][] = model.readTabungan(data[0][0]);
                    int total;
                    if (model.getBanyakDataTabungan(data[0][0]) != 0){
                        total = Integer.parseInt(dataTabungan[model.getBanyakDataTabungan(data[0][0])-1][5].trim()) + Integer.parseInt(amount.trim());
                    } else{
                        total = 0 + Integer.parseInt(amount.trim());
                    }
                    model.insertTabunganAdd(desc,amount,String.valueOf(total),data[0][0]);
                    view.setVisible(false);
                    TabunganMVC tabunganMVC = new TabunganMVC(data);
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        });
    }
}
