package MVC;

import Controller.EditBudgetController;
import Model.GoalsModel;
import View.EditBudgetView;

public class EditBudgetMVC {
    String data[][];
    String dataGoalsTerpilih[];

    public EditBudgetMVC(String[][] data, String dataGoalsTerpilih[]) {
        this.data = data;
        this.dataGoalsTerpilih = dataGoalsTerpilih;
        GoalsModel model = new GoalsModel();
        EditBudgetView view = new EditBudgetView();
        EditBudgetController controller = new EditBudgetController(model,view,data,dataGoalsTerpilih);
    }
}
