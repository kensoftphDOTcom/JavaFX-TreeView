module com.kensoftph.treeview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kensoftph.treeview to javafx.fxml;
    exports com.kensoftph.treeview;
}