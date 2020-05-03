package MVC;

import Controller.GoalsDetailController;
import Model.GoalsModel;
import View.GoalsDetailView;

public class GoalsDetailMVC {
    String data[][], dataGoalsTerpilih[];

    public GoalsDetailMVC(String[][] data,String dataGoalsTerpilih[]) {
        this.data = data;
        this.dataGoalsTerpilih = dataGoalsTerpilih;
        GoalsModel model = new GoalsModel();
        GoalsDetailView view = new GoalsDetailView();
        GoalsDetailController controller = new GoalsDetailController(model,view,data,dataGoalsTerpilih);
    }
}
