package Controller;

import MVC.GoalsMVC;
import MVC.HomeMVC;
import MVC.TabunganMVC;
import Model.UserModel;
import View.DashboardView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardController {
    UserModel model;
    DashboardView view;
    String data[][];

    public DashboardController(UserModel model, DashboardView view, String[][] data) {
        this.model = model;
        this.view = view;
        this.data = data;
        view.setTitle("Hello, " + data[0][2]);

        view.logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                HomeMVC homeMVC = new HomeMVC();
            }
        });

        view.btntabungan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                TabunganMVC tabunganMVC = new TabunganMVC(data);
            }
        });

        view.btngoals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                GoalsMVC goalsMVC = new GoalsMVC(data);
            }
        });
    }
}
