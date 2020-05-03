package MVC;

import Controller.DashboardController;
import Model.UserModel;
import View.DashboardView;

public class DashboardMVC {

    String data[][];

    public DashboardMVC(String[][] data) {
        this.data = data;
        UserModel model = new UserModel();
        DashboardView view = new DashboardView();
        DashboardController controller = new DashboardController(model,view,data);
    }


}
