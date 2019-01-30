package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import bal.BookBAL;
import entities.Book;
import helper.RuleException;
import helper.RuleSet;
import helper.RuleSetFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookController implements Initializable {

	@FXML
	public TextField isbnNumber;

	@FXML
	public TextField txtNumberOfCopy;

	@FXML
	public TextField authorName;

	@FXML
	public TextField bookTitle;

	@FXML
	public ComboBox<Integer> cmbBoxMaxCheckOutLength;

	@FXML
	private TableView<Book> table;

	public void addBook() {
		BookBAL book = new BookBAL();
		try {
			RuleSet rules = RuleSetFactory.getRuleSet(BookController.this);
			rules.applyRules(BookController.this);
			book.addBook(isbnNumber.getText(), authorName.getText(), bookTitle.getText(),
					cmbBoxMaxCheckOutLength.getValue().toString(), txtNumberOfCopy.getText());
			LoadBooks();
		} catch (RuleException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Error Saving book");
			alert.setHeaderText("Cannot add book");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	void LoadBooks() {
		BookBAL book = new BookBAL();
		table.getColumns().clear();

		List<Book> bookLst = book.getListOfBook();
		table.setEditable(true);

		TableColumn titleCol = new TableColumn("Title");
		titleCol.setMinWidth(350);
		titleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("Title"));

		TableColumn authorCol = new TableColumn("Author Name");
		authorCol.setMinWidth(150);
		authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("AuthorName"));

		TableColumn ISBNCol = new TableColumn("ISBN");
		ISBNCol.setMinWidth(150);
		ISBNCol.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));

		TableColumn allowedDaysCol = new TableColumn("AllowedDays");
		allowedDaysCol.setMinWidth(150);
		allowedDaysCol.setCellValueFactory(new PropertyValueFactory<Book, String>("AllowedDays"));

		TableColumn availabilityCol = new TableColumn("Availability");
		availabilityCol.setMinWidth(200);
		availabilityCol.setCellValueFactory(new PropertyValueFactory<Book, String>("Availability"));

		TableColumn nCopy = new TableColumn("Number Of Copy");
		nCopy.setMinWidth(150);
		nCopy.setCellValueFactory(new PropertyValueFactory<Book, String>("numberOfCopy"));

		ObservableList data = FXCollections.observableList(bookLst);

		table.setItems(data);
		table.autosize();

		table.getColumns().addAll(titleCol, authorCol, ISBNCol, allowedDaysCol, availabilityCol, nCopy);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		LoadBooks();
		cmbBoxMaxCheckOutLength.getItems().addAll(7, 21);
	}
}
