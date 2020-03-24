

import Const.WordConst;
import controller.ConsoleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.BasicService;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        boolean flag = true;
        while(flag){
            String[] commandList  = ConsoleController.getInput();
            String command = commandList[0];
            if("exit".equals(command)){
                flag = false;
                System.out.println("已经退出程序！");
                return;
            }
            if (commandList.length == 2) {
                String fileName = commandList[1];
                ConsoleController.selectCommand(command, fileName);
            }
        }
    }
}
