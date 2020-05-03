package MVC;

import Controller.WithdrawalSaldoTabunganController;
import Model.TabunganModel;
import View.WithdrawalSaldoTabunganView;

public class WithdrawalSaldoTabunganMVC {
    String data[][];

    public WithdrawalSaldoTabunganMVC(String[][] data) {
        this.data = data;
        TabunganModel model = new TabunganModel();
        WithdrawalSaldoTabunganView view = new WithdrawalSaldoTabunganView();
        WithdrawalSaldoTabunganController controller = new WithdrawalSaldoTabunganController(model,view,data);
    }
}
