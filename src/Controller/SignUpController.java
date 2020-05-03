package Controller;

import MVC.DashboardMVC;
import MVC.HomeMVC;
import Model.TabunganModel;
import Model.UserModel;
import View.SignUpView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpController {
    UserModel userModel;
    TabunganModel tabunganModel;
    SignUpView view;

    public SignUpController(UserModel userModel, TabunganModel tabunganModel, SignUpView view) {
        this.userModel = userModel;
        this.tabunganModel = tabunganModel;
        this.view = view;

        view.back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                HomeMVC homeMVC = new HomeMVC();
            }
        });

        view.btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sEmail = view.getTfemail();
                String sUser = view.getTfuser();
                String sPass = view.getPfpass();

                userModel.insertUser(sEmail,sUser,sPass);
                String data[][] = userModel.login(sUser,sPass);
                tabunganModel.insertTabungan(data[0][0]);
                view.setVisible(false);
                DashboardMVC dashboardMVC = new DashboardMVC(data);
            }
        });
    }
}
