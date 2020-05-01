import Model.MoneyModel;
import View.DashboardView;
import View.*;

public class MVC {
    MoneyModel model = new MoneyModel();
    HomeView homeview = new HomeView();
    SignUpView signUpView = new SignUpView();
    DashboardView dashboardView = new DashboardView();
    TabunganView tabunganView = new TabunganView();
    GoalsView goalsView = new GoalsView();
    GoalsDetailView goalsDetailView = new GoalsDetailView();
    AddSaldoTabunganView addSaldoTabunganView = new AddSaldoTabunganView();
    WithdrawalSaldoTabunganView withdrawalSaldoTabunganView = new WithdrawalSaldoTabunganView();
    AddGoalsDetailView addGoalsDetailView = new AddGoalsDetailView();
    AddGoalsView addGoalsView = new AddGoalsView();
    //Controller controller = new Controller(model,view);
}
