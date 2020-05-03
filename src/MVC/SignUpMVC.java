package MVC;

import Controller.SignUpController;
import Model.TabunganModel;
import Model.UserModel;
import View.SignUpView;

public class SignUpMVC {
    UserModel userModel = new UserModel();
    TabunganModel tabunganModel = new TabunganModel();
    SignUpView view = new SignUpView();
    SignUpController controller = new SignUpController(userModel,tabunganModel,view);
}
