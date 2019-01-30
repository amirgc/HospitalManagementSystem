package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import bal.BookBAL;
import bal.BookCopyBAL;
import entities.Book;
import entities.BookCopy;
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

public class BookCopyController implements Initializable {

	@FXML
	public TextField copyNumber;

	@FXML
	public TableView<BookCopy> table;

	@FXML
	public ComboBox<String> cmbBoxISBN;

	public void addBookCopy() {
	BookCopyBAL copy = new BookCopyBAL();
		try {
			RuleSet rules = RuleSetFactory.getRuleSet(BookCopyController.this);
			rules.applyRules(BookCopyController.this);
			copy.addBookCopy(copyNumber.getText(), cmbBoxISBN.getValue());
			LoadCopy();
		} catch (RuleException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText("Cannot add new book copy!!!");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	void LoadCopy() {
		BookCopyBAL copy = new BookCopyBAL();
		table.getColumns().clear();
		List<BookCopy> copyLst = copy.getListOfCopy();
		// System.out.println(copyLst);
		table.setEditable(true);
		TableColumn copyNumber = new TableColumn("CopyNumber");
		copyNumber.setMinWidth(250);
		copyNumber.setCellValueFactory(new PropertyValueFactory<BookCopy, String>("copyNumber"));

		TableColumn ISBNCol = new TableColumn("ISBN");
		ISBNCol.setMinWidth(150);
		ISBNCol.setCellValueFactory(new PropertyValueFactory<BookCopy, String>("ISBN"));

		TableColumn statusCol = new TableColumn("Status");
		statusCol.setMinWidth(150);
		statusCol.setCellValueFactory(new PropertyValueFactory<BookCopy, String>("status"));

		ObservableList data = FXCollections.observableList(copyLst);

		table.setItems(data);
		table.autosize();

		table.getColumns().addAll(ISBNCol, copyNumber, statusCol);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		LoadCopy();
		// cmbBoxMaxCheckOutLength = new ComboBox<>();
		List<String> lst = new ArrayList<String>();
		lst = getListOfBookISBN();

		cmbBoxISBN.getItems().addAll(lst);

	}

	private List<String> getListOfBookISBN() {
		BookBAL bk = new BookBAL();

		List<Book> bkLst = bk.getListOfBook();
		List<String> lst = new ArrayList<String>();

		for (Book book : bkLst) {
			lst.add(book.getISBN());
		}

		return lst;
	}
}
