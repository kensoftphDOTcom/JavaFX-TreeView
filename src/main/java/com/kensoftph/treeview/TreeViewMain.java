package com.kensoftph.treeview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class TreeViewMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        /*TreeItem<String> root = new TreeItem<>("Root");

        TreeView<String> treeView = new TreeView<>(root);
        treeView.setShowRoot(true);

        TreeItem<String> branch1 = new TreeItem<>("Branch 1");
        TreeItem<String> branch2 = new TreeItem<>("Branch 2");

        TreeItem<String> leaf1 = new TreeItem<>("leaf 1");
        TreeItem<String> leaf2 = new TreeItem<>("leaf 2");
        TreeItem<String> leaf3 = new TreeItem<>("leaf 3");
        TreeItem<String> leaf4 = new TreeItem<>("leaf 4");

        root.getChildren().addAll(branch1, branch2);
        branch1.getChildren().addAll(leaf1, leaf2);
        branch2.getChildren().addAll(leaf3, leaf4);*/

        File filePath = new File("C:\\Users\\kenth\\Desktop\\test");
        TreeItem<String> root = createItems(filePath);

        TreeView<String> treeView = new TreeView<>(root);

        VBox layout = new VBox(treeView);
        Scene scene = new Scene(layout, 400, 400);
        stage.setScene(scene);
        stage.setTitle("JavaFX TreeView");
        stage.show();

        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue ) ->{
            String selectedItem = newValue.getValue();
            System.out.println(selectedItem);
        });
    }

    private TreeItem<String> createItems(File file){
        TreeItem<String> treeItems = new TreeItem<>(file.getName());
        if(file.isDirectory()){
            File[] files = file.listFiles();
            if(files != null){
                for(File childItem : files){
                    treeItems.getChildren().addAll(createItems(childItem));
                }
            }
        }

        return treeItems;
    }

    public static void main(String[] args) {
        launch();
    }
}