package com.example.w22comp1011gctest1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, Integer> studentNumCol;

    @FXML
    private TableColumn<Student, String> firstNameCol;

    @FXML
    private TableColumn<Student, String> lastNameCol;

    @FXML
    private TableColumn<Student, String> telephoneCol;

    @FXML
    private TableColumn<Student, String> addressCol;

    @FXML
    private TableColumn<Student, String> provinceCol;

    @FXML
    private TableColumn<Student, Integer> avgGradeCol;

    @FXML
    private TableColumn<Student, String> majorCol;

    @FXML
    private CheckBox ontarioCheckBox;

    @FXML
    private Label numOfStudentsLabel;

    @FXML
    private CheckBox honourRollCheckBox;

    @FXML
    private ComboBox<String> areaCodeComboBox;

    @FXML
    private void applyFilter()  {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ontarioCheckBox.setSelected(false);
        honourRollCheckBox.setSelected(false);
        areaCodeComboBox.getItems().addAll(Student.getAllPhone());
        studentNumCol.setCellValueFactory(new PropertyValueFactory<>("studentNum"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        telephoneCol.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("homeAddress"));
        provinceCol.setCellValueFactory(new PropertyValueFactory<>("province"));
        avgGradeCol.setCellValueFactory(new PropertyValueFactory<>("avgGrade"));
        majorCol.setCellValueFactory(new PropertyValueFactory<>("major"));
        applyfliter();
    }
    public void applyfliter() {
        if (ontarioCheckBox.isSelected()) {
            System.out.println("ontario ");
            ontarioCheckBox.setSelected(true);
            tableView.getItems().addAll(StudentDBUtility.getUpdatedData());
        } else if(honourRollCheckBox.isSelected()){
            System.out.println("honor");
            tableView.getItems().addAll(StudentDBUtility.getUpdatedData2());
        }
        else{
            tableView.getItems().addAll(StudentDBUtility.getLocalCodeFromDB());
        }
    }


}
