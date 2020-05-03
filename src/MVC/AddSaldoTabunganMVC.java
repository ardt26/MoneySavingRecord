package MVC;

import Controller.AddSaldoTabunganController;
import Model.TabunganModel;
import View.AddSaldoTabunganView;

public class AddSaldoTabunganMVC {
    String data[][];

    public AddSaldoTabunganMVC(String[][] data) {
        this.data = data;
        TabunganModel model = new TabunganModel();
        AddSaldoTabunganView view = new AddSaldoTabunganView();
        AddSaldoTabunganController controller = new AddSaldoTabunganController(model,view,data);
    }
}
