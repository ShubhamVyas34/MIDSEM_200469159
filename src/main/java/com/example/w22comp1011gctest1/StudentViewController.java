package com.example.w22comp1011gctest1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeSet;

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
        studentNumCol.setCellValueFactory(new PropertyValueFactory<>("studentNum"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        telephoneCol.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("homeAddress"));
        provinceCol.setCellValueFactory(new PropertyValueFactory<>("province"));
        avgGradeCol.setCellValueFactory(new PropertyValueFactory<>("avgGrade"));
        majorCol.setCellValueFactory(new PropertyValueFactory<>("major"));
        tableView.getItems().addAll(StudentDBUtility.getLocalCodeFromDB("All","None"));
        areaCodeComboBox.getItems().addAll(getAreaFromTable());
        ontarioCheckBox.setSelected(false);
        honourRollCheckBox.setSelected(false);
        updateLabel();
        //applyFilter();
    }
    private TreeSet<String> getAreaFromTable()
    {
        TreeSet<String> area = new TreeSet<>();

        for (Student show : tableView.getItems())
            area.add(show.getPhone());

        return area;
    }

    @FXML
    void applyFilter(ActionEvent event) {

        tableView.getItems().clear();

        String province = "All";
        String grade="All";
        if(ontarioCheckBox.isSelected() && !honourRollCheckBox.isSelected()){
            province = "ON";
            System.out.println("1 method is executed");
        }
        else if(!ontarioCheckBox.isSelected() && honourRollCheckBox.isSelected() ){
            grade="Honor";

        }
        else if(ontarioCheckBox.isSelected() && honourRollCheckBox.isSelected() ){
            province="ON";
            grade="Honor";

        }

        else if(!ontarioCheckBox.isSelected() && !honourRollCheckBox.isSelected()){
            province = "All";

        }



        tableView.getItems().addAll(StudentDBUtility.getLocalCodeFromDB(province,grade));//.getNetflixShows(type,ratingSelected));
        updateLabel();
    }
    private void updateLabel()
    {
        numOfStudentsLabel.setText("Number of Students: " + tableView.getItems().size());
    }


}
