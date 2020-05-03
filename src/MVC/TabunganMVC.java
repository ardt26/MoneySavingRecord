package MVC;

import Controller.TabunganController;
import Model.TabunganModel;
import Model.UserModel;
import View.TabunganView;

public class TabunganMVC {
    String data[][];

    public TabunganMVC(String[][] data) {
        this.data = data;
        TabunganModel model = new TabunganModel();
        TabunganView view = new TabunganView();
        TabunganController controller = new TabunganController(model,view,data);
    }
}
