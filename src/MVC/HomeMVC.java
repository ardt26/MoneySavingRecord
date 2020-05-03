package MVC;

import Controller.HomeController;
import Model.UserModel;
import View.*;

public class HomeMVC {
    HomeView homeview = new HomeView();
    UserModel model = new UserModel();
    HomeController controller = new HomeController(model,homeview);
}
