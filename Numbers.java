/**
 * Author: Jude Kallista-Fitzpatrick
 * @author jsk2319@email.vccs.edu
 *Purpose: Displays the Fibonacci Sequence, sum of odd numbers, and factorials in relation to what the user enters
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.List;

public class Numbers extends Application {

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Project 4.1");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Enter Any Number");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Number: ");
        grid.add(userName, 0, 1);

        TextField userField = new TextField();
        grid.add(userField, 1, 1);

        Button btn = new Button("Calculate");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                //Fibonacci
                String a = userField.getText();
                int b = Integer.parseInt(a);
                int i, count = 0;
                int pValue = 1;
                int pPValue = 0;


                List<Integer> fib = new ArrayList<>();
                do {

                    int cValue = pValue + pPValue;
                    pPValue = pValue;
                    fib.add(cValue);
                    pValue = cValue;
                    count++;

                } while (count < b);
                Label fibL = new Label("The first " + b + " numbers in the Fibonacci Sequence are: ");
                grid.add(fibL, 0, 6);
                Text fibN = new Text(fib.toString());
                grid.add(fibN, 0, 7);


                //factorial
                int c, fact = 1;
                for (c = 1; c <= b; c++) {
                    fact = fact * c;
                }

                Label whileLoop = new Label("Factorial using while: " + fact);
                grid.add(whileLoop, 0, 4);

                //sum of all odd numbers up to the entered number
                {
                    int n, sum = 0;

                    n = b;
                    for (i = 1; i <= n; i++)

                    {
                        System.out.println(2 * i - 1);
                        sum += 2 * i - 1;
                    }
                    Label forLoop = new Label("The sum the first " + b + " odd numbers is " + sum);
                    grid.add(forLoop, 0, 5);

                }

            }
        });

        grid.add(btn, 0, 3);
        Scene scene = new Scene(grid, 375, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
